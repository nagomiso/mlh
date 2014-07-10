package nagomiso.study;

import java.util.LinkedList;
import java.util.List;

public class Node {
	private int dimension;
	private double threshold;
	private double informationGain;
	private Node parent;
	private List<Node> children;


	public Node() {
		dimension = 0;
		threshold = 0d;
		informationGain = 0d;
		children = new LinkedList<Node>();
	}
	
	public Node(Node parent){
		dimension = 0;
		threshold = 0d;
		informationGain = 0d;
		children = new LinkedList<Node>();
		this.parent = parent;
	}
	
	public void add(Node child){
		this.children.add(child);
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

}
