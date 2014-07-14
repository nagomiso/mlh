package gilberthouse.random;

import java.io.Serializable;

/**
 * Logistically distributed variables.
 */
public class LogisticVariables extends AbstractVariables implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8092678647995550545L;
    private final RandomGenerator random;
    
    /**
     * Creates new variables.
     * @param r the generator
     * @throws NullPointerException if {@code r == null}
     */
    public LogisticVariables(RandomGenerator r) {
        if (r == null) {
            throw new NullPointerException();
        }
        random = r;
    }
    
    /**
     * Generates the next random, logistically distributed value.
     * @return the next random, logistically distributed value
     */
    @Override
    public double next() {
        double x;
        do {
            x = random.nextUniform();
        } while (x == 0.0);
        return Math.log(x) - Math.log(1.0 - x);
    }
    
}
