package gilberthouse.random;

/**
 * A drop-in replacement for {@code java.util.concurrent.ThreadLocalRandom}.
 * @see java.util.concurrent.ThreadLocalRandom
 */
public final class ThreadLocalRandom {
    
    private static final RandomLocal local = new RandomLocal();
    private final RandomGenerator64 random = new SFMT19937_64();
    private RandomVariables randomNormal = null;
    
    private ThreadLocalRandom() {
        // empty constructor
    }
    
    /**
     * Returns the current thread's generator.
     * @return the current thread's generator
     */
    public static ThreadLocalRandom current() {
        return local.get();
    }
    
    /**
     * Generates random bytes and stores them into the specified {@code byte} array.
     * @param output the {@code byte} array to fill with random bytes
     * @throws NullPointerException if {@code output == null}
     */
    public void nextBytes(byte[] output) {
        int count = 0, bits = 0;
        for (int i = 0; i < output.length; i++) {
            if (count == 0) {
                bits = random.nextBits();
                count = 4;
            }
            output[i] = (byte)bits;
            bits >>= 8;
            count--;
        }
    }
    
    /**
     * Generates the next random integer.
     * <br>
     * All 2<sup>32</sup> possible values are expected to appear with equal probability.
     * @return the next random integer
     */
    public int nextInt() {
        return random.nextBits();
    }
    
    /**
     * Generates the next random non-negative integer.
     * <br>
     * All {@code n} possible values are expected to appear with equal probability.
     * @param n the bound (exclusive)
     * @return the next random non-negative integer
     * @throws IllegalArgumentException unless {@code n > 0}
     */
    public int nextInt(int n) {
        if (n > 0) {
            if ((n & -n) == n) {
                return random.nextBits(31 - Integer.numberOfLeadingZeros(n));
            }
            int bits, m;
            do {
                bits = random.nextBits(31);
                m = bits % n;
            } while (bits - m + (n - 1) < 0);
            return m;
        }
        throw new IllegalArgumentException();
    }
    
    /**
     * Generates the next random integer.
     * <br>
     * All possible values are expected to appear with equal probability.
     * @param a the least value
     * @param b the upper bound (exclusive)
     * @return the next random integer
     * @throws IllegalArgumentException unless {@code a < b && (b - a) > 0}
     */
    public int nextInt(int a, int b) {
        if (a < b) {
            return nextInt(b - a) + a;
        }
        throw new IllegalArgumentException();
    }
    
    /**
     * Generates the next random integer.
     * <br>
     * All 2<sup>64</sup> possible values are expected to appear with equal probability.
     * @return the next random integer
     */
    public long nextLong() {
        return random.nextLongBits();
    }
    
    /**
     * Generates the next random non-negative integer.
     * <br>
     * All {@code n} possible values are expected to appear with equal probability.
     * @param n the bound (exclusive)
     * @return the next random non-negative integer
     * @throws IllegalArgumentException unless {@code n > 0L}
     */
    public long nextLong(long n) {
        if (n > 0L) {
            if ((n & -n) == n) {
                return random.nextLongBits(63 - Long.numberOfLeadingZeros(n));
            }
            long longBits, m;
            do {
                longBits = random.nextLongBits(63);
                m = longBits % n;
            } while (longBits - m + (n - 1L) < 0L);
            return m;
        }
        throw new IllegalArgumentException();
    }
    
    /**
     * Generates the next random integer.
     * <br>
     * All possible values are expected to appear with equal probability.
     * @param a the least value
     * @param b the upper bound (exclusive)
     * @return the next random integer
     * @throws IllegalArgumentException unless {@code a < b && (b - a) > 0L}
     */
    public long nextLong(long a, long b) {
        if (a < b) {
            return nextLong(b - a) + a;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Generates the next random {@code boolean} value.
     * @return the next random {@code boolean} value
     */
    public boolean nextBoolean() {
        return random.nextBits(1) != 0;
    }
    
    /**
     * Generates the next random, uniformly distributed value.
     * <br>
     * All 2<sup>24</sup> possible values are distributed between 0 (inclusive) and 1 (exclusive).
     * @return the next random, uniformly distributed value
     */
    public float nextFloat() {
        return random.nextBits(24) * 0x1.0P-24F;
    }
    
    /**
     * Generates the next random, uniformly distributed value.
     * <br>
     * All 2<sup>53</sup> possible values are distributed between 0 (inclusive) and 1 (exclusive).
     * @return the next random, uniformly distributed value
     */
    public double nextDouble() {
        return random.nextUniform();
    }
    
    /**
     * Generates the next random, uniformly distributed value.
     * <br>
     * All possible values are distributed between 0 (inclusive) and {@code n} (exclusive).
     * @param n the bound (exclusive)
     * @return the next random, uniformly distributed value
     * @throws IllegalArgumentException unless {@code n > 0.0}
     */
    public double nextDouble(double n) {
        if (n > 0.0) {
            return n * random.nextUniform();
        }
        throw new IllegalArgumentException();
    }
    
    /**
     * Generates the next random, uniformly distributed value.
     * <br>
     * All possible values are distributed between {@code a} (inclusive) and {@code b} (exclusive).
     * @param a the least value
     * @param b the upper bound (exclusive)
     * @return the next random, uniformly distributed value
     * @throws IllegalArgumentException unless {@code a < b && (b - a) > 0.0}
     */
    public double nextDouble(double a, double b) {
        if (a < b) {
            return nextDouble(b - a) + a;
        }
        throw new IllegalArgumentException();
    }
    
    /**
     * Generates the next random, normally distributed value.
     * @return the next random, normally distributed value
     */
    public double nextGaussian() {
        if (randomNormal == null) {
            randomNormal = new NormalVariables(random);
        }
        return randomNormal.next();
    }
    
    private static class RandomLocal extends ThreadLocal<ThreadLocalRandom> {
        
        @Override
        protected ThreadLocalRandom initialValue() {
            return new ThreadLocalRandom();
        }
        
    }
    
}
