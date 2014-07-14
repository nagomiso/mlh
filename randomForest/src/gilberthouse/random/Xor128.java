package gilberthouse.random;

import java.io.Serializable;

/**
 * An Xorshift generator.
 */
public class Xor128 extends AbstractGenerator implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2387249904915232376L;
    private static final int A = 1812433253;
    private int x, y, z, w;
    
    /**
     * Creates a new generator.
     * <br>
     * This constructor sets the generator's initial state using the current time.
     */
    public Xor128() {
        int u = AtomicCounter.next();
        long nanos = System.nanoTime();
        x = A * u;
        y = A * (int)(nanos ^ (nanos >>> 32));
        z = A * (x ^ (x >>> 30)) + 2;
        w = A * (y ^ (y >>> 30)) + 3;
    }
    
    /**
     * Creates a new generator.
     * @param seed the seed
     */
    public Xor128(int seed) {
        x = seed;
        y = A * (x ^ (x >>> 30)) + 1;
        z = A * (y ^ (y >>> 30)) + 2;
        w = A * (z ^ (z >>> 30)) + 3;
    }
    
    /**
     * Creates a new generator.
     * @param seedX the seed
     * @param seedY the seed
     */
    public Xor128(int seedX, int seedY) {
        x = seedX; y = seedY;
        z = A * (x ^ (x >>> 30)) + 2;
        w = A * (y ^ (y >>> 30)) + 3;
    }
    
    /**
     * Creates a new generator.
     * @param seedX the seed
     * @param seedY the seed
     * @param seedZ the seed
     * @param seedW the seed
     */
    public Xor128(int seedX, int seedY, int seedZ, int seedW) {
        x = seedX; y = seedY; z = seedZ; w = seedW;
    }
    
    @Override
    public int nextBits() {
        int t = x ^ (x << 11);
        x = y; y = z; z = w;
        return w = w ^ (w >>> 19) ^ (t ^ (t >>> 8));
    }
    
}
