package gilberthouse.randomtest;

import gilberthouse.random.*;
import java.math.BigInteger;

public class MT64Test {
    
    static final BigInteger M = BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE);
    
    public static void main(String[] args) {
        RandomGenerator64 r = new MT19937_64(0x12345L, 0x23456L, 0x34567L, 0x45678L);
        System.out.println("1000 outputs of genrand64_int64()");
        for (int i = 0; i < 1000; i++) {
            System.out.printf("%20d ", BigInteger.valueOf(r.nextLongBits()).and(M));
            if (i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("1000 outputs of genrand64_real2()");
        for (int i = 0; i < 1000; i++) {
            System.out.printf("%10.8f ", r.nextUniform());
            if (i % 5 == 4) {
                System.out.println();
            }
        }
    }
    
}
