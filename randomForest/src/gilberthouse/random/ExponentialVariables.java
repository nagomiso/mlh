package gilberthouse.random;

import java.io.Serializable;

/**
 * Exponentially distributed variables.
 */
public class ExponentialVariables extends AbstractVariables implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -218144036459149817L;
    private final RandomGenerator random;
    
    /**
     * Creates new variables.
     * @param r the generator
     * @throws NullPointerException if {@code r == null}
     */
    public ExponentialVariables(RandomGenerator r) {
        if (r == null) {
            throw new NullPointerException();
        }
        random = r;
    }
    
    /**
     * Generates the next random, exponentially distributed value.
     * @return the next random, exponentially distributed value
     */
    @Override
    public double next() {
        return -Math.log(1.0 - random.nextUniform());
    }
    
}
