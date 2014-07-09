package nagomiso.study;

public class Tree {
	/**
	 * ¶‘¤‚Ìq
	 */
	private Tree leftSubTree;
	/**
	 * ‰E‘¤‚Ìq
	 */
	private Tree rightSubTree;
	/**
	 * –Ø‚Ì[‚³
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
