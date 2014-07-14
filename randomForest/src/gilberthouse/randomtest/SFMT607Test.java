package gilberthouse.randomtest;

import gilberthouse.random.*;

public class SFMT607Test {
    
    public static void main(String[] args) {
        RandomGenerator r1 = new SFMT607(1234);
        RandomGenerator r2 = new SFMT607(0x1234, 0x5678, 0x9abc, 0xdef0);
        System.out.println("32 bit generated randoms");
        System.out.println("init_gen_rand__________");
        for (int i = 0; i < 1000; i++) {
            System.out.printf("%10d ", (long)r1.nextBits() & 0xffffffffL);
            if (i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("init_by_array__________");
        for (int i = 0; i < 1000; i++) {
            System.out.printf("%10d ", (long)r2.nextBits() & 0xffffffffL);
            if (i % 5 == 4) {
                System.out.println();
            }
        }
    }
    
}
