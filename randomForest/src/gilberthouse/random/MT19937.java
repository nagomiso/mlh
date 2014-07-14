package gilberthouse.random;

import java.io.Serializable;

/**
 * A Mersenne Twister generator.
 */
public class MT19937 extends AbstractGenerator implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3994587286521828385L;
    private static final int N = 624;
    private static final int M = 397;
    private static final int MATRIX_A = 0x9908b0df;
    private static final int UPPER_MASK = 0x80000000;
    private static final int LOWER_MASK = 0x7fffffff;
    private static final int[] mag01 = {0x0, MATRIX_A};
    private int[] mt = new int[N];
    private int mti = N + 1;
    
    /**
     * Creates a new generator.
     * <br>
     * This constructor sets the generator's initial state using the current time.
     */
    public MT19937() {
        int u = AtomicCounter.next();
        long nanos = System.nanoTime();
        init_by_array(u, (int)(nanos ^ (nanos >>> 32)));
    }
    
    /**
     * Creates a new generator.
     * @param seed the seed
     */
    public MT19937(int seed) {
        init_genrand(seed);
    }
    
    /**
     * Creates a new generator.
     * @param seed the seed
     * @throws NullPointerException if {@code seed == null}
     */
    public MT19937(int... seed) {
        init_by_array(seed);
    }
    
    private void init_genrand(int s) {
        mt[0] = s;
        for (mti = 1; mti < N; mti++) {
            mt[mti] = (1812433253 * (mt[mti - 1] ^ (mt[mti - 1] >>> 30)) + mti);
        }
    }
    
    private void init_by_array(int... init_key) {
        init_genrand(19650218);
        int i = 1; int j = 0;
        int k = (N > init_key.length ? N : init_key.length);
        for (; k > 0; k--) {
            mt[i] = (mt[i] ^ ((mt[i - 1] ^ (mt[i - 1] >>> 30)) * 1664525)) + init_key[j] + j;
            i++; j++;
            if (i >= N) {
                mt[0] = mt[N - 1]; i = 1;
            }
            if (j >= init_key.length) {
                j = 0;
            }
        }
        for (k = N - 1; k > 0; k--) {
            mt[i] = (mt[i] ^ ((mt[i - 1] ^ (mt[i - 1] >>> 30)) * 1566083941)) - i;
            i++;
            if (i >= N) {
                mt[0] = mt[N - 1]; i = 1;
            }
        }
        mt[0] = 0x80000000;
    }
    
    @Override
    public int nextBits() {
        int y;
        if (mti >= N) {
            int kk;
            for (kk = 0; kk < N - M; kk++) {
                y = (mt[kk] & UPPER_MASK) | (mt[kk + 1] & LOWER_MASK);
                mt[kk] = mt[kk + M] ^ (y >>> 1) ^ mag01[y & 0x1];
            }
            for (; kk < N - 1; kk++) {
                y = (mt[kk] & UPPER_MASK) | (mt[kk + 1] & LOWER_MASK);
                mt[kk] = mt[kk + (M - N)] ^ (y >>> 1) ^ mag01[y & 0x1];
            }
            y = (mt[N - 1] & UPPER_MASK) | (mt[0] & LOWER_MASK);
            mt[N - 1] = mt[M - 1] ^ (y >>> 1) ^ mag01[y & 0x1];
            mti = 0;
        }
        y = mt[mti++];
        y ^= (y >>> 11);
        y ^= (y << 7) & 0x9d2c5680;
        y ^= (y << 15) & 0xefc60000;
        y ^= (y >>> 18);
        return y;
    }
    
}
