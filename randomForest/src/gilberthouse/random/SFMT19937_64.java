package gilberthouse.random;

/**
 * A SIMD-oriented Fast Mersenne Twister generator.
 */
public class SFMT19937_64 extends SFMT19937 implements RandomGenerator64 {
    
    /**
     * 
     */
    private static final long serialVersionUID = 174888812650240335L;
    
    /**
     * Creates a new generator.
     * <br>
     * This constructor sets the generator's initial state using the current time.
     */
    public SFMT19937_64() {
        super();
    }
    
    /**
     * Creates a new generator.
     * @param seed the seed
     */
    public SFMT19937_64(int seed) {
        super(seed);
    }
    
    /**
     * Creates a new generator.
     * @param seed the seed
     * @throws NullPointerException if {@code seed == null}
     */
    public SFMT19937_64(int... seed) {
        super(seed);
    }
    
    SFMT19937_64(SFMT19937_64 r) {
        super(r);
    }
    
    public long nextLongBits() {
        readyLongBits();
        int lowBits = nextBits();
        int highBits = nextBits();
        return ((long)highBits << 32) | ((long)lowBits & 0xffffffffL);
    }
    
    public long nextLongBits(int bits) {
        readyLongBits();
        int lowBits = nextBits();
        int highBits = nextBits();
        long longBits = ((long)highBits << 32) | ((long)lowBits & 0xffffffffL);
        return longBits >>> (64 - bits);
    }
    
    /**
     * Generates the next random, uniformly distributed value.
     * <br>
     * All 2<sup>53</sup> possible values are distributed between 0 (inclusive) and 1 (exclusive).
     */
    @Override
    public double nextUniform() {
        readyLongBits();
        int lowBits = nextBits();
        int highBits = nextBits();
        long longBits = ((long)highBits << 32) | ((long)lowBits & 0xffffffffL);
        return (longBits >>> 11) * 0x1.0P-53;
    }
    
    /**
     * Returns a new jumped generator.
     * @throws NullPointerException if {@code jumpPoly == null}
     */
    @Override
    public SFMT19937_64 copyAndJump(JumpPolynomial jumpPoly) {
        SFMT19937_64 r = new SFMT19937_64(this);
        r.jump(jumpPoly);
        return r;
    }
    
}
