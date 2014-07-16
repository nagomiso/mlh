package nagomiso.study;

public class BinaryTree extends Node {
	private Node left;
	private Node right;
	private Node parents;

	public BinaryTree(Node parents) {
		this.parents = parents;
		this.depth = parents.depth + 1;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getParents() {
		return parents;
	}

}
