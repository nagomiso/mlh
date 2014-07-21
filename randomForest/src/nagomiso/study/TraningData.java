package nagomiso.study;

import java.util.List;

public class TraningData {
	private String label;
	private double[] featureVector;

	public TraningData(String label, double[] featureVector) {
		this.label = label;
		this.featureVector = featureVector;
	}

	public TraningData(String label, List<Double> featureVector) {
		this.label = label;
		this.featureVector = new double[featureVector.size()];
		for (int i = 0; i < this.featureVector.length; ++i) {
			this.featureVector[i] = featureVector.get(i);
		}
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
