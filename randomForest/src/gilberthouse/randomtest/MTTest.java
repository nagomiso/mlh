package gilberthouse.randomtest;

import gilberthouse.random.*;

public class MTTest {
    
    public static void main(String[] args) {
        RandomGenerator r = new MT19937(0x123, 0x234, 0x345, 0x456);
        System.out.println("1000 outputs of genrand_int32()");
        for (int i = 0; i < 1000; i++) {
            System.out.printf("%10d ", (long)r.nextBits() & 0xffffffffL);
            if (i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("1000 outputs of genrand_real2()");
        for (int i = 0; i < 1000; i++) {
            System.out.printf("%10.8f ", r.nextUniform());
            if (i % 5 == 4) {
                System.out.println();
            }
        }
    }
    
}
