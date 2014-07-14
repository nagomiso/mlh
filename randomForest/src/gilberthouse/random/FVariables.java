package gilberthouse.random;

import java.io.Serializable;

/**
 * <i>F</i>-distributed variables.
 */
public class FVariables extends AbstractVariables implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6493536279968226643L;
    /**
     * The parameter <i>m</i> (degrees of freedom).
     */
    public static final int M = 0;
    /**
     * The parameter <i>n</i> (degrees of freedom).
     */
    public static final int N = 1;
    private final RandomVariables randomChiSquaredM;
    private final RandomVariables randomChiSquaredN;
    private int m = 1, n = 1;
    
    /**
     * Creates new variables.
     * @param r the generator
     * @throws NullPointerException if {@code r == null}
     */
    public FVariables(RandomGenerator r) {
        randomChiSquaredM = new ChiSquaredVariables(r);
        randomChiSquaredN = new ChiSquaredVariables(r);
    }
    
    /**
     * Generates the next random, <i>F</i>-distributed value.
     * @return the next random, <i>F</i>-distributed value
     */
    @Override
    public double next() {
        double chiSquaredM = randomChiSquaredM.next();
        double chiSquaredN;
        do {
            chiSquaredN = randomChiSquaredN.next();
        } while (chiSquaredN == 0.0);
        return (chiSquaredM / m) * (n / chiSquaredN);
    }
    
    /**
     * Sets the parameter.
     * @throws IllegalArgumentException if the key/value pair is invalid.
     */
    @Override
    public void setParameter(int key, int value) {
        switch (key) {
        case M:
            if (value >= 1) {
                m = value;
                randomChiSquaredM.setParameter(ChiSquaredVariables.N, m);
                break;
            }
            throw new IllegalArgumentException();
        case N:
            if (value >= 1) {
                n = value;
                randomChiSquaredN.setParameter(ChiSquaredVariables.N, n);
                break;
            }
            throw new IllegalArgumentException();
        default:
            throw new IllegalArgumentException();
        }
    }
    
}
