package gilberthouse.random;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.SecureRandom;
import java.util.Random;

/**
 * A collection of static utility methods.
 */
public final class Randoms {
    
    private Randoms() {
        // empty constructor
    }
    
    /**
     * Returns random seed bits.
     * <br>
     * This method may block, because it calls {@code java.security.SecureRandom#generateSeed(int)}.
     * @return random seed bits
     * @see java.security.SecureRandom#generateSeed(int)
     */
    public static int generateSeed() {
        SecureRandom r = new SecureRandom();
        ByteBuffer bytes = ByteBuffer.wrap(r.generateSeed(4));
        bytes.order(ByteOrder.nativeOrder());
        return bytes.getInt();
    }
    
    /**
     * Returns random seed bits.
     * <br>
     * This method may block, because it calls {@code java.security.SecureRandom#generateSeed(int)}.
     * @return random seed bits
     * @see java.security.SecureRandom#generateSeed(int)
     */
    public static long generateLongSeed() {
        SecureRandom r = new SecureRandom();
        ByteBuffer bytes = ByteBuffer.wrap(r.generateSeed(8));
        bytes.order(ByteOrder.nativeOrder());
        return bytes.getLong();
    }
    
    /**
     * Returns a new synchronized generator.
     * @param r the generator
     * @return  a synchronized generator
     * @throws NullPointerException if {@code r == null}
     */
    public static RandomGenerator synchronizedGenerator(RandomGenerator r) {
        return new SynchronizedGenerator(r);
    }
    
    /**
     * Returns a new synchronized generator.
     * @param r the generator
     * @return a synchronized generator
     * @throws NullPointerException if {@code r == null}
     */
    public static RandomGenerator64 synchronizedGenerator64(RandomGenerator64 r) {
        return new SynchronizedGenerator64(r);
    }
    
    /**
     * Returns new synchronized variables.
     * @param r the variables
     * @return synchronized variables
     * @throws NullPointerException if {@code r == null}
     */
    public static RandomVariables synchronizedVariables(RandomVariables r) {
        return new SynchronizedVariables(r);
    }
    
    /**
     * Returns a new {@code java.util.Random} adapter wrapping the specified generator.
     * @param r the generator
     * @param sync if {@code true}, synchronizes a new adapter.
     * @return a new adapter
     * @throws NullPointerException if {@code r == null}
     * @see java.util.Random
     */
    public static Random createAdapter(RandomGenerator r, boolean sync) {
        if (sync) {
            return new SynchronizedRandomAdapter(r);
        }
        return new RandomAdapter(r);
    }
    
    private static class SynchronizedGenerator implements RandomGenerator, Serializable {
        
        /**
         * 
         */
        private static final long serialVersionUID = 4273996132353026679L;
        private final RandomGenerator random;
        
        public SynchronizedGenerator(RandomGenerator r) {
            if (r == null) {
                throw new NullPointerException();
            }
            random = r;
        }
        
        public synchronized int nextBits() {
            return random.nextBits();
        }
        
        public synchronized int nextBits(int bits) {
            return random.nextBits(bits);
        }
        
        public synchronized double nextUniform() {
            return random.nextUniform();
        }
        
        public synchronized void jump(JumpPolynomial jumpPoly) {
            random.jump(jumpPoly);
        }
        
        public synchronized RandomGenerator copyAndJump(JumpPolynomial jumpPoly) {
            throw new UnsupportedOperationException();
        }
        
    }
    
    private static class SynchronizedGenerator64 implements RandomGenerator64, Serializable {
        
        /**
         * 
         */
        private static final long serialVersionUID = -8989850650463003317L;
        private final RandomGenerator64 random;
        
        public SynchronizedGenerator64(RandomGenerator64 r) {
            if (r == null) {
                throw new NullPointerException();
            }
            random = r;
        }
        
        public synchronized int nextBits() {
            return random.nextBits();
        }
        
        public synchronized int nextBits(int bits) {
            return random.nextBits(bits);
        }
        
        public synchronized long nextLongBits() {
            return random.nextLongBits();
        }
        
        public synchronized long nextLongBits(int bits) {
            return random.nextLongBits(bits);
        }
        
        public synchronized double nextUniform() {
            return random.nextUniform();
        }
        
        public synchronized void jump(JumpPolynomial jumpPoly) {
            random.jump(jumpPoly);
        }
        
        public synchronized RandomGenerator64 copyAndJump(JumpPolynomial jumpPoly) {
            throw new UnsupportedOperationException();
        }
        
    }
    
    private static class SynchronizedVariables implements RandomVariables, Serializable {
        
        /**
         * 
         */
        private static final long serialVersionUID = -3249538611671633654L;
        private final RandomVariables random;
        
        public SynchronizedVariables(RandomVariables r) {
            if (r == null) {
                throw new NullPointerException();
            }
            random = r;
        }
        
        public synchronized double next() {
            return random.next();
        }
        
        public synchronized void setParameter(int key, int value) {
            random.setParameter(key, value);
        }
        
        public synchronized void setParameter(int key, double value) {
            random.setParameter(key, value);
        }
        
    }
    
    private static class RandomAdapter extends Random {
        
        /**
         * 
         */
        private static final long serialVersionUID = 1559295220502533681L;
        private final RandomGenerator random;
        private boolean initialized = false;
        
        public RandomAdapter(RandomGenerator r) {
            super(0L);
            if (r == null) {
                throw new NullPointerException();
            }
            random = r;
            initialized = true;
        }
        
        @Override
        public void setSeed(long seed) {
            if (initialized) {
                throw new UnsupportedOperationException();
            }
        }
        
        @Override
        protected int next(int bits) {
            return random.nextBits(bits);
        }
        
    }
    
    private static class SynchronizedRandomAdapter extends Random {
        
        /**
         * 
         */
        private static final long serialVersionUID = 7772025863837719303L;
        private final RandomGenerator random;
        private boolean initialized = false;
        
        public SynchronizedRandomAdapter(RandomGenerator r) {
            super(0L);
            if (r == null) {
                throw new NullPointerException();
            }
            random = r;
            initialized = true;
        }
        
        @Override
        public synchronized void setSeed(long seed) {
            if (initialized) {
                throw new UnsupportedOperationException();
            }
        }
        
        @Override
        protected synchronized int next(int bits) {
            return random.nextBits(bits);
        }
        
    }
    
}
