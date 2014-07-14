package gilberthouse.random;

/**
 * Random variables.
 */
public interface RandomVariables {
    
    /**
     * Generates the next random value.
     * @return the next random value
     */
    public double next();
    
    /**
     * Sets the parameter.
     * @param key the key
     * @param value the value
     * @throws UnsupportedOperationException if setting the parameter is not supported.
     * @throws IllegalArgumentException if the key/value pair is invalid.
     */
    public void setParameter(int key, int value);
    
    /**
     * Sets the parameter.
     * @param key the key
     * @param value the value
     * @throws UnsupportedOperationException if setting the parameter is not supported.
     * @throws IllegalArgumentException if the key/value pair is invalid.
     */
    public void setParameter(int key, double value);
    
}
