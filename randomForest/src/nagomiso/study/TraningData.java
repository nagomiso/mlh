package nagomiso.study;

public class TraningData {
	private String label;
	private double[] featureVector;

	public TraningData(String label, double[] featureVector) {
		this.label = label;
		this.featureVector = featureVector;
	}

	public String getLabel() {
		return label;
	}

	public double[] getFeatureVector() {
		return featureVector;
	}

	public double getFeatureValue(int index) {
		return featureVector[index];
	}

}
