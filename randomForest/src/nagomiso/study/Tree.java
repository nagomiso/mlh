package nagomiso.study;

public class Tree {
	/**
	 * �����̎q
	 */
	private Tree leftSubTree;
	/**
	 * �E���̎q
	 */
	private Tree rightSubTree;
	/**
	 * �؂̐[��
	 */
	private int depth;

	public Tree getLeftSubTree() {
		return leftSubTree;
	}

	public Tree getRightSubTree() {
		return rightSubTree;
	}

	public int getDepth() {
		return depth;
	}

	public boolean isLeaf() {
		return (leftSubTree == null) && (rightSubTree == null);
	}

}
