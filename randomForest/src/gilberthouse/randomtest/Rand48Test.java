package gilberthouse.randomtest;

import gilberthouse.random.*;
import java.util.Random;

public class Rand48Test {
    
    public static void main(String[] args) {
        Random jrand = new Random(0xabcdefL);
        RandomGenerator rand48 = new Rand48(0xabcdefL);
        RandomVariables randomNormal = new NormalVariables(rand48);
        
        // java.util.Random
        System.out.println("java.util.Random:");
        
        for (int j = 0; j < 100000; j++) {
            jrand.nextInt();
        }
        System.out.println(jrand.nextInt());
        
        for (int j = 0; j < 100000; j++) {
            jrand.nextDouble();
        }
        System.out.println(jrand.nextDouble());
        
        for (int j = 0; j < 100000; j++) {
            jrand.nextGaussian();
        }
        System.out.println(jrand.nextGaussian());
        
        System.out.println();
        
        // gilberthouse.random.Rand48
        System.out.println("gilberthouse.random.Rand48:");
        
        for (int j = 0; j < 100000; j++) {
            rand48.nextBits();
        }
        System.out.println(rand48.nextBits());
        
        for (int j = 0; j < 100000; j++) {
            rand48.nextUniform();
        }
        System.out.println(rand48.nextUniform());
        
        for (int j = 0; j < 100000; j++) {
            randomNormal.next();
        }
        System.out.println(randomNormal.next());
    }
    
}
