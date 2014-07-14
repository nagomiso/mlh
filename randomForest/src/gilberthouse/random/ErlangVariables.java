package gilberthouse.random;

import java.io.Serializable;

/**
 * Erlang-distributed variables.
 */
public class ErlangVariables extends AbstractVariables implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2902063050146243927L;
    /**
     * The parameter <i>k</i> (shape).
     */
    public static final int K = 0;
    private final RandomGenerator random;
    private int k = 1;
    
    /**
     * Creates new variables.
     * @param r the generator
     * @throws NullPointerException if {@code r == null}
     */
    public ErlangVariables(RandomGenerator r) {
        if (r == null) {
            throw new NullPointerException();
        }
        random = r;
    }
    
    /**
     * Generates the next random, Erlang-distributed value.
     * @return the next random, Erlang-distributed value
     */
    @Override
    public double next() {
        double product = 1.0;
        for (int i = 0; i < k; i++) {
            product *= 1.0 - random.nextUniform();
        }
        return -Math.log(product);
    }
    
    /**
     * Sets the parameter.
     * @throws IllegalArgumentException if the key/value pair is invalid.
     */
    @Override
    public void setParameter(int key, int value) {
        switch (key) {
        case K:
            if (value >= 1) {
                k = value;
                break;
            }
            throw new IllegalArgumentException();
        default:
            throw new IllegalArgumentException();
        }
    }
    
}
