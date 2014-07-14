package gilberthouse.random;

/**
 * A 64-bit random number generator.
 */
public interface RandomGenerator64 extends RandomGenerator {
    
    public int nextBits();
    
    public int nextBits(int bits);
    
    /**
     * Generates the next random bits.
     * @return the next random bits
     */
    public long nextLongBits();
    
    /**
     * Generates the next random bits.
     * @param bits the number of bits
     * @return the next random bits
     */
    public long nextLongBits(int bits);
    
    public double nextUniform();
    
    public void jump(JumpPolynomial jumpPoly);
    
    public RandomGenerator64 copyAndJump(JumpPolynomial jumpPoly);
    
}
