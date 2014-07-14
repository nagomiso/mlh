package nagomiso.study;

import gilberthouse.random.RandomGenerator;
import gilberthouse.random.SFMT19937;


public class Main {

	public static void main(String[] args) {
		RandomGenerator r = new SFMT19937(123);
		
		for(int i=0; i < 1000; ++i) {
			System.out.println(r.nextBits());
		}
		System.out.print("");

	}

}
