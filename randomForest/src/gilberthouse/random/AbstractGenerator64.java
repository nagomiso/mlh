package gilberthouse.random;

/**
 * A 64-bit random number generator.
 */
public abstract class AbstractGenerator64 implements RandomGenerator64 {
    
    public int nextBits() {
        return (int)(nextLongBits() >>> 32);
    }
    
    public int nextBits(int bits) {
        return (int)(nextLongBits() >>> (64 - bits));
    }
    
    public abstract long nextLongBits();
    
    public long nextLongBits(int bits) {
        return nextLongBits() >>> (64 - bits);
    }
    
    /**
     * Generates the next random, uniformly distributed value.
     * <br>
     * All 2<sup>53</sup> possible values are distributed between 0 (inclusive) and 1 (exclusive).
     */
    public double nextUniform() {
        return (nextLongBits() >>> 11) * 0x1.0P-53;
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
    public RandomGenerator64 copyAndJump(JumpPolynomial jumpPoly) {
        throw new UnsupportedOperationException();
    }
    
}
