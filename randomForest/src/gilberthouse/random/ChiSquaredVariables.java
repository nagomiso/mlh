package gilberthouse.random;

import java.io.Serializable;

/**
 * Chi-squared distributed variables.
 */
public class ChiSquaredVariables extends AbstractVariables implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6433108339097944342L;
    /**
     * The parameter <i>n</i> (degrees of freedom).
     */
    public static final int N = 0;
    private final RandomGenerator random;
    private boolean squaredNormalStockAvailable = false;
    private double squaredNormalStock;
    private int n = 1;
    
    /**
     * Creates new variables.
     * @param r the generator
     * @throws NullPointerException if {@code r == null}
     */
    public ChiSquaredVariables(RandomGenerator r) {
        if (r == null) {
            throw new NullPointerException();
        }
        random = r;
    }
    
    /**
     * Generates the next random, chi-squared distributed value.
     * @return the next random, chi-squared distributed value
     */
    @Override
    public double next() {
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            if (squaredNormalStockAvailable) {
                squaredNormalStockAvailable = false;
                sum += squaredNormalStock;
                continue;
            }
            double x, y, s;
            do {
                x = random.nextUniform();
                x *= x;
                y = random.nextUniform();
                y *= y;
                s = x + y;
            } while (s >= 1.0 || s == 0.0);
            double t = -2.0 * Math.log(s) / s;
            squaredNormalStock = t * y;
            squaredNormalStockAvailable = true;
            sum += t * x;
        }
        return sum;
    }
    
    /**
     * Sets the parameter.
     * @throws IllegalArgumentException if the key/value pair is invalid.
     */
    @Override
    public void setParameter(int key, int value) {
        switch (key) {
        case N:
            if (value >= 1) {
                n = value;
                break;
            }
            throw new IllegalArgumentException();
        default:
            throw new IllegalArgumentException();
        }
    }
    
}
