package gilberthouse.random;

import java.io.Serializable;

/**
 * Triangularly distributed variables.
 */
public class TriangularVariables extends AbstractVariables implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7465901199828176325L;
    private final RandomGenerator random;
    
    /**
     * Creates new variables.
     * @param r the generator
     * @throws NullPointerException if {@code r == null}
     */
    public TriangularVariables(RandomGenerator r) {
        if (r == null) {
            throw new NullPointerException();
        }
        random = r;
    }
    
    /**
     * Generates the next random, triangularly distributed value.
     * @return the next random, triangularly distributed value
     */
    @Override
    public double next() {
        double x = random.nextUniform();
        double y = random.nextUniform();
        return x - y;
    }
    
}
