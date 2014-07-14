package gilberthouse.random;

/**
 * A random number generator.
 */
public interface RandomGenerator {
    
    /**
     * Generates the next random bits.
     * @return the next random bits
     */
    public int nextBits();
    
    /**
     * Generates the next random bits.
     * @param bits the number of bits
     * @return the next random bits
     */
    public int nextBits(int bits);
    
    /**
     * Generates the next random, uniformly distributed value.
     * @return the next random, uniformly distributed value
     */
    public double nextUniform();
    
    /**
     * Advances this generator's state with a small amount of calculation.
     * @param jumpPoly the jump polynomial
     * @throws UnsupportedOperationException if the jump operation is not supported.
     * @throws NullPointerException if {@code jumpPoly == null}
     */
    public void jump(JumpPolynomial jumpPoly);
    
    /**
     * Returns a new jumped generator.
     * @param jumpPoly the jump polynomial
     * @return a new generator
     * @throws UnsupportedOperationException if the jump operation is not supported.
     * @throws NullPointerException if {@code jumpPoly == null}
     */
    public RandomGenerator copyAndJump(JumpPolynomial jumpPoly);
    
}
