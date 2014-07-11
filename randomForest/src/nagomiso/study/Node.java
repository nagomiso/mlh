package nagomiso.study;

import java.util.LinkedList;
import java.util.List;

public class Node {
	private int dimension;
	private double threshold;
	private double informationGain;
	private List<SampleData> preSplitSet;
	private Node parent;
	private int depth;
	private List<Node> children;

	public Node() {
		dimension = 0;
		threshold = 0d;
		informationGain = 0d;
		depth = 0;
		children = new LinkedList<Node>();
	}

	public Node(Node parent) {
		dimension = 0;
		threshold = 0d;
		informationGain = 0d;
		children = new LinkedList<Node>();
		this.parent = parent;
	}

	public void addNode(Node child) {
		this.children.add(child);
	}

	public void addPreSplitSet(SampleData sampleData) {
		parent.addPreSplitSet(sampleData);
	}

	public int getDimension() {
		return dimension;
	}

	public double getThreshold() {
		return threshold;
	}

	public Node getParent() {
		return parent;
	}

	public List<Node> getChildren() {
		return children;
	}

	public double getInformationGain() {
		return informationGain;
	}

	public List<SampleData> getPreSplitSet() {
		return preSplitSet;
	}

	public void setPreSplitSet(List<SampleData> preSplitSet) {
		this.preSplitSet = preSplitSet;
	}

	public int getDepth() {
		return depth;
	}

}
