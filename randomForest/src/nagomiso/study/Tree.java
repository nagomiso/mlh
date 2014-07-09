package nagomiso.study;

public class Tree {
	/**
	 * 左部分木
	 */
	private Tree leftSubTree;
	/**
	 * 右部分木
	 */
	private Tree rightSubTree;
	/**
	 * 木の深さ
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

	/**
	 * リーフノードかどうかをチェックする
	 * @return リーフノードかどうか
	 */
	public boolean isLeafNode() {
		return (leftSubTree == null) && (rightSubTree == null);
	}

}
