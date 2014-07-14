package gilberthouse.random;

import java.io.Serializable;

/**
 * A linear congruential generator.
 */
public class Rand48 extends AbstractGenerator implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 86912736480679418L;
    private static final long A = 0x5DEECE66DL;
    private static final long C = 0xBL;
    private long x;
    
    /**
     * Creates a new generator.
     * @param seed the seed
     */
    public Rand48(long seed) {
        x = (seed ^ A) & 0xffffffffffffL;
    }
    
    @Override
    public int nextBits() {
        x = A * x + C & 0xffffffffffffL;
        return (int)(x >>> 16);
    }
    
    @Override
    public int nextBits(int bits) {
        x = A * x + C & 0xffffffffffffL;
        return (int)(x >>> (48 - bits));
    }
    
    /**
     * Generates the next random, uniformly distributed value.
     * <br>
     * This method is implemented in the same way as {@code java.util.Random#nextDouble()}.
     * @see java.util.Random#nextDouble()
     */
    @Override
    public double nextUniform() {
        int highBits = nextBits(26);
        int lowBits = nextBits(27);
        return (((long)highBits << 27) + lowBits) * 0x1.0P-53;
    }
    
}
