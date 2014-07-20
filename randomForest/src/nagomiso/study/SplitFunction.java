package nagomiso.study;

public class SplitFunction {
	private int featureDimensin;
	private double threshold;
	private double emtropy = 0;

	public SplitFunction(int featureDimension, double threshold){
		this.featureDimensin = featureDimension;
		this.threshold = threshold;
	}
	
	public int getFeatureDimensin() {
		return featureDimensin;
	}

	public void setFeatureDimensin(int featureDimensin) {
		this.featureDimensin = featureDimensin;
	}

	public double getThreshold() {
		return threshold;
	}

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	public double getEmtropy() {
		return emtropy;
	}

	public void setEmtropy(double emtropy) {
		this.emtropy = emtropy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(emtropy);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + featureDimensin;
		temp = Double.doubleToLongBits(threshold);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SplitFunction other = (SplitFunction) obj;
		if (Double.doubleToLongBits(emtropy) != Double
				.doubleToLongBits(other.emtropy))
			return false;
		if (featureDimensin != other.featureDimensin)
			return false;
		if (Double.doubleToLongBits(threshold) != Double
				.doubleToLongBits(other.threshold))
			return false;
		return true;
	}

}
