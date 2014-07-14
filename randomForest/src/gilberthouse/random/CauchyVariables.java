package gilberthouse.random;

import java.io.Serializable;

/**
 * Cauchy-distributed variables.
 */
public class CauchyVariables extends AbstractVariables implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7558740711682506311L;
    private final RandomGenerator random;
    
    /**
     * Creates new variables.
     * @param r the generator
     * @throws NullPointerException if {@code r == null}
     */
    public CauchyVariables(RandomGenerator r) {
        if (r == null) {
            throw new NullPointerException();
        }
        random = r;
    }
    
    /**
     * Generates the next random, Cauchy-distributed value.
     * @return the next random, Cauchy-distributed value
     */
    @Override
    public double next() {
        double x, y;
        do {
            x = 2.0 * random.nextUniform() - 1.0;
            y = 1.0 - random.nextUniform();
        } while (x * x + y * y >= 1.0);
        return x / y;
    }
    
}
