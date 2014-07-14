package gilberthouse.random;

/**
 * Random variables.
 */
public abstract class AbstractVariables implements RandomVariables {
    
    public abstract double next();
    
    /**
     * Sets the parameter.
     * <br>
     * Always throws an {@code UnsupportedOperationException}.
     * @throws UnsupportedOperationException always
     */
    public void setParameter(int key, int value) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Sets the parameter.
     * <br>
     * Always throws an {@code UnsupportedOperationException}.
     * @throws UnsupportedOperationException always
     */
    public void setParameter(int key, double value) {
        throw new UnsupportedOperationException();
    }
    
}
