package nagomiso.study;

import static nagomiso.study.random.Random.nextInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Forest {
	private List<RandomForestTree> trees = new ArrayList<RandomForestTree>();

	/**
	 * 学習する
	 * @param data 学習用データ
	 * @param treeNumber 木の本数
	 * @param subsetSize 学習用部分集合のサイズ
	 */
	public void learn(List<TraningData> data, int treeNumber, int subsetSize) {
		for (List<TraningData> traningDataSubset : getTraningDataSubsets(data,
				treeNumber, subsetSize)) {
			trees.add(new RandomForestTree(traningDataSubset, 5));
		}
	}

	/**
	 * 学習用データの部分集合の集合を取得する
	 * @param data 元となる学習用データ
	 * @param subsetNumber 部分集合数
	 * @param subsetSize 部分集合のサイズ
	 * @return
	 */
	private List<ArrayList<TraningData>> getTraningDataSubsets(
			List<TraningData> data, int subsetNumber, int subsetSize) {
		List<ArrayList<TraningData>> traningDataSubsets = new ArrayList<ArrayList<TraningData>>();
		for (int i = 0; i < subsetNumber; ++i) {
			ArrayList<TraningData> traningDataSubset = new ArrayList<TraningData>();
			for (int j = 0; j < subsetSize; ++j) {
				traningDataSubset.add(data.get(nextInt(data.size() - 1)));
			}
			traningDataSubsets.add(traningDataSubset);
		}
		return traningDataSubsets;
	}

	/**
	 * 多数決をとって特徴量ベクターからクラスを推定する
	 * @param featureVector 特徴ベクター
	 * @return クラスの推定値
	 */
	public String predict(double[] featureVector) {
		HashMap<String, Integer> distribution = new HashMap<String, Integer>();
		for (RandomForestTree tree : trees) {
			String predict = tree.predict(featureVector);
			if (distribution.containsKey(predict)) {
				distribution.put(predict, distribution.get(predict) + 1);
			} else {
				distribution.put(predict, 1);
			}
		}
		int max = 0;
		String representativeValue = "";
		for (String key : distribution.keySet()) {
			if (max < distribution.get(key)) {
				max = distribution.get(key);
				representativeValue = key;
			}
		}
		return representativeValue;
	}
}
