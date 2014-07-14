package gilberthouse.random;

import java.io.Serializable;

/**
 * Student's <i>t</i>-distributed variables.
 */
public class StudentTVariables extends AbstractVariables implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 460592142619515663L;
    /**
     * The parameter <i>n</i> (degrees of freedom).
     */
    public static final int N = 0;
    private final RandomVariables randomNormal;
    private final RandomVariables randomChiSquaredN;
    private int n = 1;
    
    /**
     * Creates new variables.
     * @param r the generator
     * @throws NullPointerException if {@code r == null}
     */
    public StudentTVariables(RandomGenerator r) {
        randomNormal = new NormalVariables(r);
        randomChiSquaredN = new ChiSquaredVariables(r);
    }
    
    /**
     * Generates the next random, Student's <i>t</i>-distributed value.
     * @return the next random, Student's <i>t</i>-distributed value
     */
    @Override
    public double next() {
        double normal = randomNormal.next();
        double chiSquaredN;
        do {
            chiSquaredN = randomChiSquaredN.next();
        } while (chiSquaredN == 0.0);
        return normal * Math.sqrt(n / chiSquaredN);
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
                randomChiSquaredN.setParameter(ChiSquaredVariables.N, n);
                break;
            }
            throw new IllegalArgumentException();
        default:
            throw new IllegalArgumentException();
        }
    }
    
}
