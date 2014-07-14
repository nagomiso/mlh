package gilberthouse.random;

import java.io.Serializable;

/**
 * A WELL (Well Equidistributed Long-period Linear) generator.
 */
public class WELL512a extends AbstractGenerator implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4407045510411688438L;
    private static final int A = 1812433253;
    private static final int R = 16;
    private static final int M1 = 13;
    private static final int M2 = 9;
    private int idx = 0;
    private int[] w = new int[R];
    
    /**
     * Creates a new generator.
     * <br>
     * This constructor sets the generator's initial state using the current time.
     */
    public WELL512a() {
        int u = AtomicCounter.next();
        long nanos = System.nanoTime();
        w[0] = A * u;
        w[1] = A * (int)(nanos ^ (nanos >>> 32));
        for (int i = 2; i < R; i++) {
            w[i] = A * (w[i - 2] ^ (w[i - 2] >>> 30)) + i;
        }
    }
    
    /**
     * Creates a new generator.
     * @param seed the seed
     * @throws NullPointerException if {@code seed == null}
     */
    public WELL512a(int... seed) {
        System.arraycopy(seed, 0, w, 0, Math.min(seed.length, R));
        for (int i = seed.length; i < R; i++) {
            w[i] = A * (w[i - seed.length] ^ (w[i - seed.length] >>> 30)) + i;
        }
    }
    
    @Override
    public int nextBits() {
        int idx_15 = (idx + 15) & 0xf;
        int z0 = w[idx_15];
        int idx_m1 = (idx + M1) & 0xf;
        int z1 = (w[idx] ^ (w[idx] << 16)) ^ (w[idx_m1] ^ (w[idx_m1] << 15));
        int idx_m2 = (idx + M2) & 0xf;
        int z2 = w[idx_m2] ^ (w[idx_m2] >>> 11);
        w[idx] = z1 ^ z2;
        w[idx_15] = (z0 ^ (z0 << 2)) ^ (z1 ^ (z1 << 18)) ^ (z2 << 28) ^ (w[idx] ^ ((w[idx] << 5) & 0xda442d24));
        idx = idx_15;
        return w[idx];
    }
    
}
