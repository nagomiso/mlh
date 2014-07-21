package nagomiso.study;

import java.util.ArrayList;
import java.util.List;

import static nagomiso.study.util.EmtropyCalculator.*;

public class Tree {
	/**
	 * rootノード
	 */
	private Node root;

	/**
	 * デフォルトコンストラクタ
	 */
	public Tree() {
	}

	/**
	 * 実体化と同時に木を生成する
	 * 
	 * @param data
	 *            学習用データ
	 * @param splitFunctions
	 *            分割関数集合
	 */
	public Tree(List<TraningData> data, List<SplitFunction> splitFunctions) {
		this.root = new Node();
		root.setData(data);
		createTree(data, splitFunctions);
	}

	/**
	 * Tree生成
	 * 
	 * @param data
	 *            学習用データ
	 * @param splitFunctions
	 *            分割関数集合
	 */
	public void createTree(List<TraningData> data,
			List<SplitFunction> splitFunctions) {
		createTree(data, root, splitFunctions);
	}

	/**
	 * Tree生成
	 * 
	 * @param data
	 *            学習用データ
	 * @param current
	 *            今のノード
	 * @param splitFunctions
	 *            分割関数集合
	 */
	private void createTree(List<TraningData> data, Node current,
			List<SplitFunction> splitFunctions) {

		// エントロピーが0になるか分割関数がなくなったら何もしない
		if (getEmtropy(data) == 0d || splitFunctions.size() == 0) {
			return;
		}

		SplitFunction betterSplitFunction = new SplitFunction(-1,
				Double.MAX_VALUE);
		betterSplitFunction.setEmtropy(Double.MAX_VALUE);

		// エントロピーが最小になる分割関数を選択
		for (SplitFunction sf : splitFunctions) {
			double emtropy;
			emtropy = 0d;
			for (Node child : split(data, sf)) {
				emtropy += getProbability(current, child)
						* getEmtropy(child.getData());
			}
			if (emtropy < betterSplitFunction.getEmtropy()) {
				betterSplitFunction = sf;
				betterSplitFunction.setEmtropy(emtropy);
			}
		}

		// 子ノードを設定
		current.setChildren(split(data, betterSplitFunction));
		current.setSpritFunction(betterSplitFunction);
		if (current.getParent() != null) {
			current.setDepth(current.getParent().getDepth() + 1);
		} 

		// すでに使用した分割関数を削除する
		List<SplitFunction> deletedSplitFunctions = deleteSplitFunction(
				splitFunctions, betterSplitFunction);

		// 孫ノード以降を再帰的に設定
		for (Node child : current.getChildren()) {
			child.setParent(current);
			createTree(child.getData(), child, deletedSplitFunctions);
		}
	}

	/**
	 * 指定した分割関数を削除した分割関数集合を返す
	 * 
	 * @param splitFunctions
	 *            分割関数集合
	 * @param splitFunction
	 *            削除する分割関数
	 * @return 分割関数集合＼削除する分割関数
	 */
	private List<SplitFunction> deleteSplitFunction(
			List<SplitFunction> splitFunctions, SplitFunction splitFunction) {

		ArrayList<SplitFunction> deletedSplitFunctions = new ArrayList<SplitFunction>(
				splitFunctions);
		for (int i = 0; i < splitFunctions.size(); ++i) {
			if (splitFunction.equals(splitFunctions.get(i))) {
				deletedSplitFunctions.remove(i);
			}
		}
		return deletedSplitFunctions;
	}

	/**
	 * 分割する
	 * 
	 * @param data
	 *            分割対象
	 * @param splitFunction
	 *            分割関数
	 * @return 分割後のデータ
	 */
	private List<Node> split(List<TraningData> data, SplitFunction splitFunction) {
		List<Node> splitedData = new ArrayList<Node>();

		Node left = new Node();
		Node right = new Node();

		for (TraningData td : data) {
			if (td.getFeatureValue(splitFunction.getFeatureDimensin()) < splitFunction
					.getThreshold()) {

				left.addData(td);
			} else {

				right.addData(td);
			}
		}

		splitedData.add(left);
		splitedData.add(right);

		return splitedData;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * 特徴ベクターからクラスを推定する
	 * 
	 * @param featureVector
	 *            特徴量ベクター
	 * @return クラスの推定値
	 */
	public String predict(double[] featureVector) {
		return predict(featureVector, root);
	}

	/**
	 * 特徴ベクターからクラスを推定する
	 * 
	 * @param featureVector
	 *            特徴量ベクター
	 * @param current
	 *            現在のノード
	 * @return クラスの推定値
	 */
	private String predict(double[] featureVector, Node current) {
		if (current.getChildren() == null) {
			return current.getRepresentativeValue();
		}
		if (featureVector[current.getSpritFunction().getFeatureDimensin()] < current
				.getSpritFunction().getThreshold()) {
			return predict(featureVector, current.getChildren().get(0));
		} else {
			return predict(featureVector, current.getChildren().get(1));
		}
	}
}
