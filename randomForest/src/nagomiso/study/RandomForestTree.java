package nagomiso.study;

import java.util.ArrayList;
import java.util.List;

import static nagomiso.study.random.Random.*;
import static nagomiso.study.util.EmtropyCalculator.getEmtropy;
import static nagomiso.study.util.EmtropyCalculator.getProbability;

public class RandomForestTree extends Tree {
	private int limitDepth;
	private int featureVectorDimension;

	/**
	 * RandomForestナイズしたTreeのコンストラクタ
	 * @param data 学習用データ
	 * @param limitDepth 木の深さ制限値
	 */
	public RandomForestTree(List<TraningData> data, int limitDepth) {
		root = new Node();
		root.setData(data);
		featureVectorDimension = data.get(0).getFeatureVector().length;
		this.limitDepth = limitDepth;
		
		this.createTree(data, root, getRandomSplitFunctions());
	}

	/**
	 * ランダムに生成した分割関数集合を取得する
	 * @return ランダムに生成した分割関数集合
	 */
	private List<SplitFunction> getRandomSplitFunctions() {
		ArrayList<SplitFunction> splitFunctions = new ArrayList<SplitFunction>();
		int numberOfSplitFunctions = (int) Math.ceil(Math
				.sqrt(featureVectorDimension));
		for (int i = 0; i < numberOfSplitFunctions; ++i) {
			splitFunctions.add(new SplitFunction(
					nextInt(featureVectorDimension - 1), nextUniform()));
		}
		return splitFunctions;
	}

	@Override
	protected void createTree(List<TraningData> data, Node current,
			List<SplitFunction> splitFunctions) {
		
		// エントロピーが0になるか指定の深さまで学習をしたら学習をやめる
		if (getEmtropy(data) == 0d || current.getDepth() > limitDepth) {
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

		// 新しい分割関数集合をランダムに取得
		List<SplitFunction> newSplitFunctions = getRandomSplitFunctions();

		// 孫ノード以降を再帰的に設定
		for (Node child : current.getChildren()) {
			child.setParent(current);
			createTree(child.getData(), child, newSplitFunctions);
		}
	}
	
	
}
