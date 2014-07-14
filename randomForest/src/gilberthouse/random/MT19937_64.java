package gilberthouse.random;

import java.io.Serializable;

/**
 * A 64-bit Mersenne Twister generator.
 */
public class MT19937_64 extends AbstractGenerator64 implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7473531315962005891L;
    private static final int NN = 312;
    private static final int MM = 156;
    private static final long MATRIX_A = 0xB5026F5AA96619E9L;
    private static final long UM = 0xFFFFFFFF80000000L;
    private static final long LM = 0x7FFFFFFFL;
    private static final long[] mag01 = {0L, MATRIX_A};
    private long[] mt = new long[NN];
    private int mti = NN + 1;
    
    /**
     * Creates a new generator.
     * <br>
     * This constructor sets the generator's initial state using the current time.
     */
    public MT19937_64() {
        int u = AtomicCounter.next();
        long nanos = System.nanoTime();
        init_by_array64(u, nanos);
    }
    
    /**
     * Creates a new generator.
     * @param seed the seed
     */
    public MT19937_64(long seed) {
        init_genrand64(seed);
    }
    
    /**
     * Creates a new generator.
     * @param seed the seed
     * @throws NullPointerException if {@code seed == null}
     */
    public MT19937_64(long... seed) {
        init_by_array64(seed);
    }
    
    private void init_genrand64(long seed) {
        mt[0] = seed;
        for (mti = 1; mti < NN; mti++) {
            mt[mti] = (6364136223846793005L * (mt[mti - 1] ^ (mt[mti - 1] >>> 62)) + mti);
        }
    }
    
    private void init_by_array64(long... init_key) {
        init_genrand64(19650218L);
        int i = 1; int j = 0;
        int k = (NN > init_key.length ? NN : init_key.length);
        for (; k > 0; k--) {
            mt[i] = (mt[i] ^ ((mt[i - 1] ^ (mt[i - 1] >>> 62)) * 3935559000370003845L)) + init_key[j] + j;
            i++; j++;
            if (i >= NN) {
                mt[0] = mt[NN - 1]; i = 1;
            }
            if (j >= init_key.length) {
                j = 0;
            }
        }
        for (k = NN - 1; k > 0; k--) {
            mt[i] = (mt[i] ^ ((mt[i - 1] ^ (mt[i - 1] >>> 62)) * 2862933555777941757L)) - i;
            i++;
            if (i >= NN) {
                mt[0] = mt[NN - 1]; i = 1;
            }
        }
        mt[0] = 1L << 63;
    }
    
    @Override
    public long nextLongBits() {
        long x;
        if (mti >= NN) {
            int i;
            for (i = 0; i < NN - MM; i++) {
                x = (mt[i] & UM) | (mt[i + 1] & LM);
                mt[i] = mt[i + MM] ^ (x >>> 1) ^ mag01[(int)(x & 1L)];
            }
            for (; i < NN - 1; i++) {
                x = (mt[i] & UM) | (mt[i + 1] & LM);
                mt[i] = mt[i + (MM - NN)] ^ (x >>> 1) ^ mag01[(int)(x & 1L)];
            }
            x = (mt[NN - 1] & UM) | (mt[0] & LM);
            mt[NN - 1] = mt[MM - 1] ^ (x >>> 1) ^ mag01[(int)(x & 1L)];
            mti = 0;
        }
        x = mt[mti++];
        x ^= (x >>> 29) & 0x5555555555555555L;
        x ^= (x << 17) & 0x71D67FFFEDA60000L;
        x ^= (x << 37) & 0xFFF7EEE000000000L;
        x ^= (x >>> 43);
        return x;
    }
    
}
