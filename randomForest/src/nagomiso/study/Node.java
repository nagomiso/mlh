package nagomiso.study;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private Node parent;
	private List<Node> children;
	private List<TraningData> data;
	private SplitFunction spritFunction;

	public Node() {
		data = new ArrayList<TraningData>();
	}
	
	public void addData(TraningData td){
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
	
	

}
