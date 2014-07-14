package gilberthouse.random;

/**
 * A random number generator.
 */
public abstract class AbstractGenerator implements RandomGenerator {
    
    public abstract int nextBits();
    
    public int nextBits(int bits) {
        return nextBits() >>> (32 - bits);
    }
    
    /**
     * Generates the next random, uniformly distributed value.
     * <br>
     * All 2<sup>32</sup> possible values are distributed between 0 (inclusive) and 1 (exclusive).
     */
    public double nextUniform() {
        return ((long)nextBits() & 0xffffffffL) * 0x1.0P-32;
    }
    
    /**
     * Advances this generator's state with a small amount of calculation.
     * <br>
     * Always throws an {@code UnsupportedOperationException}.
     * @throws UnsupportedOperationException always
     */
    public void jump(JumpPolynomial jumpPoly) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Returns a new jumped generator.
     * <br>
     * Always throws an {@code UnsupportedOperationException}.
     * @throws UnsupportedOperationException always
     */
    public RandomGenerator copyAndJump(JumpPolynomial jumpPoly) {
        throw new UnsupportedOperationException();
    }
    
}
