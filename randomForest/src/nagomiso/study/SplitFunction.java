package nagomiso.study;

public class SplitFunction {
	private int featureDimension;
	private double threshold;
	private double emtropy = 0;

	public SplitFunction(int featureDimension, double threshold){
		this.featureDimension = featureDimension;
		this.threshold = threshold;
	}
	
	public int getFeatureDimension() {
		return featureDimension;
	}

	public void setFeatureDimensin(int featureDimensin) {
		this.featureDimension = featureDimensin;
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
		result = prime * result + featureDimension;
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
		if (featureDimension != other.featureDimension)
			return false;
		if (Double.doubleToLongBits(threshold) != Double
				.doubleToLongBits(other.threshold))
			return false;
		return true;
	}

}
