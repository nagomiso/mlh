package gilberthouse.random;

import java.io.Serializable;

/**
 * A WELL (Well Equidistributed Long-period Linear) generator.
 */
public class WELL1024a extends AbstractGenerator implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2197228597489207969L;
    private static final int A = 1812433253;
    private static final int R = 32;
    private static final int M1 = 3;
    private static final int M2 = 24;
    private static final int M3 = 10;
    private int idx = 0;
    private int[] w = new int[R];
    
    /**
     * Creates a new generator.
     * <br>
     * This constructor sets the generator's initial state using the current time.
     */
    public WELL1024a() {
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
    public WELL1024a(int... seed) {
        System.arraycopy(seed, 0, w, 0, Math.min(seed.length, R));
        for (int i = seed.length; i < R; i++) {
            w[i] = A * (w[i - seed.length] ^ (w[i - seed.length] >>> 30)) + i;
        }
    }
    
    @Override
    public int nextBits() {
        int idx_31 = (idx + 31) & 0x1f;
        int z0 = w[idx_31];
        int idx_m1 = (idx + M1) & 0x1f;
        int z1 = w[idx] ^ (w[idx_m1] ^ (w[idx_m1] >>> 8));
        int idx_m2 = (idx + M2) & 0x1f;
        int idx_m3 = (idx + M3) & 0x1f;
        int z2 = (w[idx_m2] ^ (w[idx_m2] << 19)) ^ (w[idx_m3] ^ (w[idx_m3] << 14));
        w[idx] = z1 ^ z2;
        w[idx_31] = (z0 ^ (z0 << 11)) ^ (z1 ^ (z1 << 7)) ^ (z2 ^ (z2 << 13));
        idx = idx_31;
        return w[idx];
    }
    
}
