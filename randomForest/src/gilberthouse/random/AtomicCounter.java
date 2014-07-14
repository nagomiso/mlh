package gilberthouse.random;

import java.util.concurrent.atomic.AtomicInteger;

final class AtomicCounter {
    
    private static final int A = 48271;
    private static final int M = 2147483647;
    private static final AtomicInteger x;
    
    static {
        long millis = System.currentTimeMillis();
        int seed = (int)(millis % (M - 1));
        if (seed < 0) {
            seed += M - 1;
        }
        seed++;
        x = new AtomicInteger(seed);
    }
    
    private AtomicCounter() {
        // empty constructor
    }
    
    static int next() {
        int oldX, newX;
        do {
            oldX = x.get();
            newX = (int)(A * (long)oldX % M);
        }
        while (!x.compareAndSet(oldX, newX));
        return newX;
    }
    
}
