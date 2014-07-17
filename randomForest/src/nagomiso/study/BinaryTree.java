package nagomiso.study;

public class BinaryTree extends Node {
	protected BinaryTree left;
	protected BinaryTree right;
	protected Node parents;

	public BinaryTree() {
	}

	public BinaryTree(Node parents) {
		this.parents = parents;
		this.depth = parents.depth + 1;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}

	public Node getParents() {
		return parents;
	}

}
