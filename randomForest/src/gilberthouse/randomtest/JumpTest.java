package gilberthouse.randomtest;

import gilberthouse.random.*;

public class JumpTest {
    
    public static void main(String[] args) {
        RandomGenerator r0 = new SFMT607(1234);
        RandomGenerator r1 = r0.copyAndJump(SFMT607.JUMP_EXP2_32);
        for (int i = 0; i < 20; i++) {
            System.out.printf("%10d ", (long)r1.nextBits() & 0xffffffffL);
            if (i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println();
        for (long i = 0; i < 0x1L << 32; i++) {
            r0.nextBits();
        }
        for (int i = 0; i < 20; i++) {
            System.out.printf("%10d ", (long)r0.nextBits() & 0xffffffffL);
            if (i % 5 == 4) {
                System.out.println();
            }
        }
    }
    
}
