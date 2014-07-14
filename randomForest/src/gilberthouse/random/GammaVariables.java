package gilberthouse.random;

import java.io.Serializable;

/**
 * Gamma-distributed variables.
 */
public class GammaVariables extends AbstractVariables implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1625611059446518800L;
    /**
     * The parameter <i>k</i> (shape).
     */
    public static final int K = 0;
    private final RandomVariables randomErlangK;
    private final RandomGenerator random;
    private int k = 1;
    private double d = 0.0, t = 1.0;
    
    /**
     * Creates new variables.
     * @param r the generator
     * @throws NullPointerException if {@code r == null}
     */
    public GammaVariables(RandomGenerator r) {
        randomErlangK = new ErlangVariables(r);
        random = r;
    }
    
    /**
     * Generates the next random, gamma-distributed value.
     * @return the next random, gamma-distributed value
     */
    @Override
    public double next() {
        double integerGamma = 0.0;
        if (k != 0) {
            integerGamma = randomErlangK.next();
        }
        double fractionalGamma = 0.0;
        if (d != 0.0) {
            double p;
            do {
                double uniformT = t * random.nextUniform();
                if (uniformT <= 1.0) {
                    fractionalGamma = Math.pow(uniformT, 1.0 / d);
                    p = Math.exp(-fractionalGamma);
                }
                else {
                    fractionalGamma = -Math.log((t - uniformT) / d);
                    p = Math.pow(fractionalGamma, d - 1.0);
                }
            }
            while (random.nextUniform() > p);
        }
        return integerGamma + fractionalGamma;
    }
    
    /**
     * Sets the parameter.
     * @throws IllegalArgumentException if the key/value pair is invalid.
     */
    @Override
    public void setParameter(int key, int value) {
        setParameter(key, (double)value);
    }
    
    /**
     * Sets the parameter.
     * @throws IllegalArgumentException if the key/value pair is invalid.
     */
    @Override
    public void setParameter(int key, double value) {
        switch (key) {
        case K:
            if (0.0 < value && value <= Integer.MAX_VALUE) {
                k = (int)value;
                if (k != 0) {
                    randomErlangK.setParameter(ErlangVariables.K, k);
                }
                d = value - k;
                t = (d + Math.E) / Math.E;
                break;
            }
            throw new IllegalArgumentException();
        default:
            throw new IllegalArgumentException();
        }
    }
    
}
