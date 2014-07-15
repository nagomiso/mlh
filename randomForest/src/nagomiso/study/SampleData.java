package nagomiso.study;

public class SampleData {
	/**
	 * 特徴ベクター
	 */
	private double[] featureVector;
	
	/**
	 * 教師データ
	 */
	private int label;

	public SampleData(double[] featureVector, int label) {
		this.featureVector = featureVector;
		this.label = label;
	}

	public double[] getFeatureVector() {
		return featureVector;
	}

	public int getLabel() {
		return label;
	}

}
