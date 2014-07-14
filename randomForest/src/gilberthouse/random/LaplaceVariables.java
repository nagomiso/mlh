package gilberthouse.random;

import java.io.Serializable;

/**
 * Laplace-distributed variables.
 */
public class LaplaceVariables extends AbstractVariables implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3775766139874172311L;
    private final RandomGenerator random;
    
    /**
     * Creates new variables.
     * @param r the generator
     * @throws NullPointerException if {@code r == null}
     */
    public LaplaceVariables(RandomGenerator r) {
        if (r == null) {
            throw new NullPointerException();
        }
        random = r;
    }
    
    /**
     * Generates the next random, Laplace-distributed value.
     * @return the next random, Laplace-distributed value
     */
    @Override
    public double next() {
        double x = Math.log(1.0 - random.nextUniform());
        double y = Math.log(1.0 - random.nextUniform());
        return y - x;
    }
    
}
