package gilberthouse.random;

import java.io.Serializable;

/**
 * Normally distributed variables.
 */
public class NormalVariables extends AbstractVariables implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6901276034334155459L;
    private final RandomGenerator random;
    private boolean stockAvailable = false;
    private double stock;
    
    /**
     * Creates new variables.
     * @param r the generator
     * @throws NullPointerException if {@code r == null}
     */
    public NormalVariables(RandomGenerator r) {
        if (r == null) {
            throw new NullPointerException();
        }
        random = r;
    }
    
    /**
     * Generates the next random, normally distributed value.
     * @return the next random, normally distributed value
     */
    @Override
    public double next() {
        if (stockAvailable) {
            stockAvailable = false;
            return stock;
        }
        double x, y, s;
        do {
            x = 2.0 * random.nextUniform() - 1.0;
            y = 2.0 * random.nextUniform() - 1.0;
            s = x * x + y * y;
        } while (s >= 1.0 || s == 0.0);
        double t = Math.sqrt(-2.0 * Math.log(s) / s);
        stock = t * y;
        stockAvailable = true;
        return t * x;
    }
    
}
