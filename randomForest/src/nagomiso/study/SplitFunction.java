package nagomiso.study;

import  nagomiso.study.random.Random;
/**
 * 分割関数クラス
 * @author なごみそ
 *
 */
public class SplitFunction {
	/**
	 * 分割に用いる特徴量の次元
	 */
	private int dimension;
	
	/**
	 * 分割に用いる閾値
	 */
	private double threshold;
	
	/**
	 * 分割関数生成
	 * @param maxDimensionNumber 特徴ベクターの次元数
	 */
	public SplitFunction(int maxDimensionNumber) {
		dimension = Random.nextInt(maxDimensionNumber);
		threshold = Random.nextUniform();
	}
	
	
	public int getDimension() {
		return dimension;
	}

	public double getThreshold() {
		return threshold;
	}

}
