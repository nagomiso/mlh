package nagomiso.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Node {
	private Node parent;
	private List<Node> children;
	private List<TraningData> data;
	private SplitFunction spritFunction;

	public Node() {
		data = new ArrayList<TraningData>();
	}

	public void addData(TraningData td) {
		data.add(td);
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public List<TraningData> getData() {
		return data;
	}

	public void setData(List<TraningData> data) {
		this.data = data;
	}

	public SplitFunction getSpritFunction() {
		return spritFunction;
	}

	public void setSpritFunction(SplitFunction spritFunction) {
		this.spritFunction = spritFunction;
	}

	/**
	 * ノードの代表値を取得する
	 * @return ノードの代表値
	 */
	public String getRepresentativeValue() {
		HashMap<String, Integer> distribution = new HashMap<String, Integer>();
		for (TraningData td : data) {
			if (distribution.containsKey(td.getLabel())) {
				distribution.put(td.getLabel(),
						distribution.get(td.getLabel()) + 1);
			} else {
				distribution.put(td.getLabel(), 1);
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
