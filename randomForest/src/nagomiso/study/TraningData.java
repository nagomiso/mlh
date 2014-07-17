package nagomiso.study;

public class TraningData {
	/**
	 * 特徴ベクター
	 */
	private double[] featureVector;
	
	/**
	 * 教師データ
	 */
	private int label;

	public TraningData(double[] featureVector, int label) {
		this.featureVector = featureVector;
		this.label = label;
	}
	
	/**
	 * 特徴ベクターの成分の値を返す
	 * @param dimensionNumber 次元数
	 * @return 成分
	 */
	public double component(int dimensionNumber) {
		return featureVector[dimensionNumber];
	}

	public double[] getFeatureVector() {
		return featureVector;
	}

	public int getLabel() {
		return label;
	}

}
