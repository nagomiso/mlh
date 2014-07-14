package gilberthouse.random;

import java.io.Serializable;

/**
 * Beta-distributed variables.
 */
public class BetaVariables extends AbstractVariables implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8600910278996720694L;
    /**
     * The parameter <i>a</i> (shape).
     */
    public static final int A = 0;
    /**
     * The parameter <i>b</i> (shape).
     */
    public static final int B = 1;
    private final RandomVariables randomGammaA;
    private final RandomVariables randomGammaB;
    private final RandomGenerator random;
    private boolean useJohnkAlgorithm = true;
    private double a = 1.0, b = 1.0;
    
    /**
     * Creates new variables.
     * @param r the generator
     * @throws NullPointerException if {@code r == null}
     */
    public BetaVariables(RandomGenerator r) {
        randomGammaA = new GammaVariables(r);
        randomGammaB = new GammaVariables(r);
        random = r;
    }
    
    /**
     * Generates the next random, beta-distributed value.
     * @return the next random, beta-distributed value
     */
    @Override
    public double next() {
        if (useJohnkAlgorithm) {
            double x, y, s;
            do {
                x = Math.pow(random.nextUniform(), 1.0 / a);
                y = Math.pow(random.nextUniform(), 1.0 / b);
                s = x + y;
            }
            while (s > 1.0 || s == 0.0);
            return x / s;
        }
        double gammaA, gammaB, sum;
        do {
            gammaA = randomGammaA.next();
            gammaB = randomGammaB.next();
            sum = gammaA + gammaB;
        }
        while (sum == 0.0);
        return gammaA / sum;
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
        case A:
            if (0.0 < value && value <= Integer.MAX_VALUE) {
                a = value;
                randomGammaA.setParameter(GammaVariables.K, a);
                useJohnkAlgorithm = (a <= 1.0 && b <= 1.0);
                break;
            }
            throw new IllegalArgumentException();
        case B:
            if (0.0 < value && value <= Integer.MAX_VALUE) {
                b = value;
                randomGammaB.setParameter(GammaVariables.K, b);
                useJohnkAlgorithm = (a <= 1.0 && b <= 1.0);
                break;
            }
            throw new IllegalArgumentException();
        default:
            throw new IllegalArgumentException();
        }
    }
    
}
