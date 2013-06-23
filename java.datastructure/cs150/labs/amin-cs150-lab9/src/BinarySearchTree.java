/**
 * This is the BST ADT. It should contain methods that allow it to insert new
 * nodes, delete nodes, search, etc. You'll be adding code to this class for
 * this lab.
 * 
 * @author Amin Meyghani
 * @version March.3.2011
 */
public class BinarySearchTree {
	private BSTnode root;

	public BinarySearchTree() {

		root = null;
	}
/**
 * This method adds a new string to a binary search tree.
 * @param value is a string to be added to the tree.
 */
	public void insert(String value) {

		int direction = 0;
		BSTnode runner;
		BSTnode backgroundRunner;
		runner = root;
		BSTnode newnode = new BSTnode(value);
		backgroundRunner = null;
		if (root == null) {
			root = newnode;
		} else {
			while (runner != null) {
				if (value.compareTo(runner.key) < 0) {
					backgroundRunner = runner;
					runner = runner.llink;
					direction = -1;
				} else if (value.compareTo(runner.key) > 0) {
					backgroundRunner = runner;
					runner = runner.rlink;
					direction = 1;
				} else {
					return;
				}
			}
		}

		if (direction == -1) {
			backgroundRunner.llink = newnode;
		} else if (direction == 1) {
			backgroundRunner.rlink = newnode;
		} else {
			return;
		}

	}

	/**
	 * The search method that searches for a particular string in the array.
	 * 
	 * @param target  is the string to be found in the tree.
	 * @return the node containing the target string
	 */
	public BSTnode search(String target) {
		return search(root, target);
	}

	/**
	 * The recursive search method.
	 * 
	 * @param rootNode
	 * @param target is the string to be found in the tree.
	 * @return the node containing the target string in the tree.
	 */
	private BSTnode search(BSTnode rootNode, String target) {
		if (rootNode == null) {
			return null;
		} else if (root.key.equals(target)) {
			return rootNode;
		} else if (root.key.compareTo(target) < 0) {
			return search(rootNode.llink, target);
		} else {
			return search(rootNode.rlink, target);
		}
	}

	/**
	 * This method counts the total number of nodes in a tree.
	 * @return the number of nodes in a tree.
	 */
	public int nodeCount() {
		return nodeCounter(root);
	}

	/**
	 * The recursive node counter method that recursively counts the number of
	 * nodes in the tree.
	 * 
	 * @param rootNode is the node to be added
	 * @return the number of nodes.
	 */
	private int nodeCounter(BSTnode rootNode) {
		if (rootNode == null) {
			return 0;
		} else {
			return nodeCounter(rootNode.llink) + nodeCounter(rootNode.rlink)+ 1;
		}
	}

	/**
	 * Gives a parenthesized version of the subtree, rooted at N, that shows the
	 * subtree structure. Example: (( A ) B ( C )) means B is the parent of A
	 * (left kid) and C (right kid).
	 * 
	 * @param N the (possibly null) root of a subtree of our BST
	 * @return String representation of the tree rooted at node N
	 */
	private String toString(BSTnode N) {
		String toReturn = "";

		if (N != null) {
			toReturn += "(";
			toReturn += toString(N.llink);
			toReturn += "  " + N + "  ";
			toReturn += toString(N.rlink);
			toReturn += ")";
		}

		return toReturn;
	}

	/**
	 * Gives a parenthesized version of the tree that shows the subtree
	 * structure. Example: (( A ) B ( C )) means B is the parent of A (left kid)
	 * and C (right kid).
	 * 
	 * @return String representation of the BST.
	 */
	public String toString() {
		return toString(root);
	}

}
