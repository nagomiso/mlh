package nagomiso.study;

import java.util.ArrayList;
import java.util.List;

import static nagomiso.study.calculation.EmtropyCalculator.*;

public class Tree {
	/**
	 * rootノード
	 */
	private Node root;

	/**
	 * Tree生成
	 * @param data 学習用データ
	 * @param currentNode 今のノード
	 * @param splitFunctions 分割関数
	 */
	public void createTree(List<TraningData> data, Node currentNode,
			List<SplitFunction> splitFunctions) {

		// エントロピーが0になるか分割関数がなくなったら何もしない
		if (getEmtropy(data) == 0d || splitFunctions.size() == 0) {
			return;
		}

		SplitFunction betterSplitFunction = null;

		// エントロピーが最小になる分割関数を選択
		for (SplitFunction sf : splitFunctions) {
			for (Node child : split(data, sf)) {
				sf.setEmtropy(sf.getEmtropy() + getEmtropy(child.getData()));
			}
			if (betterSplitFunction != null) {
				if (sf.getEmtropy() < betterSplitFunction.getEmtropy()) {
					betterSplitFunction = sf;
				}
			} else {
				betterSplitFunction = sf;
			}
		}

		// 子ノードを設定
		currentNode.setChildren(split(data, betterSplitFunction));
		currentNode.setSpritFunction(betterSplitFunction);

		// すでに使用した分割関数を削除する
		List<SplitFunction> deletedSplitFunctions = deleteSplitFunction(
				splitFunctions, betterSplitFunction);

		// 孫ノード以降を再帰的に設定
		for (Node child : currentNode.getChildren()) {
			child.setParent(currentNode);
			child.setSpritFunction(betterSplitFunction);
			createTree(child.getData(), child, deletedSplitFunctions);
		}
	}

	/**
	 * 指定した分割関数を削除した分割関数集合を返す
	 * @param splitFunctions 分割関数集合
	 * @param splitFunction 削除する分割関数
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
	 * @param data 分割対象
	 * @param splitFunction 分割関数
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
}
