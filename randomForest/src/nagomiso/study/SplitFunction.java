package nagomiso.study;

import gilberthouse.random.RandomGenerator;
import gilberthouse.random.SFMT19937;

public class SplitFunction {
	private int dimension;
	private double threshold;
	private RandomGenerator rg = new SFMT19937(12345);
	
	public SplitFunction(int maxDimensionNumber) {
		dimension = (int) Math.round(rg.nextUniform() 
				* maxDimensionNumber);
		threshold = rg.nextUniform();
	}
	
	public int getDimension() {
		return dimension;
	}

	public double getThreshold() {
		return threshold;
	}

}
