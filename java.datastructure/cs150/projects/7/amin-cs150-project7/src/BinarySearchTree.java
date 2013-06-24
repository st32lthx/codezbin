/**
 * @author Amin Meyghani with consultation from the following website:
 * http://cslibrary.stanford.edu/110/BinaryTrees.html
 * @version March.05.2011
 *@purpose This class represents a Binary Search Tree. It contains methods that 
 * a BST can use such as insert, delete and search.
 */

public class BinarySearchTree {

	private BSTnode root;
	
	/**
	 * The default constructor for the Binary Search Tree. 
	 * (Makes a pointer for the root)
	 */
	public BinarySearchTree(){
		root = null;

	}
	/**
	 * The the insert method that inserts a node to the tree.
	 * @param node is the node to be inserted into the tree. The node  should
	 * be of type BSTnode in order to be added to the tree. 
	 */
	public void insert(Comparable key, Object data) 
	   {
	      root = insert(root, key, data);
	   }
	/**
	 * This is the method that removes an object from the tree.
	 * @param key is the object that is to be removed from the tree.
	 */
	 public void remove( Comparable key ) {
	        root = remove( key, root );
	    }
	 
		/**
		 * This is the search method that looks for a particular object in the tree.
		 * @param key is the string to be found.
		 * @return the matching string if found and null if not found.
		 */
	 
	  public BSTnode search(String key) {
	        return find(new StringMaker(key));
	      }
	 
	/**
	 * This is the method that prints the keys of the tree only.
	 */
	public void printTreeKeysOnly() {

		print(root);
		System.out.println();
	}
		 
	
/**
 * The toString method that returns the elements in the tree as a single printable string.
 * The method uses inorder traversal to traverse the tree.
 */
	public String toString() {
		return toString(root);
	}
	//=============RECURSIVE INTERNAL HELPER METHODS============\\
	
	//-----INSERT METHOD HELPERS------\\
	/**
	 * This is the internal recursive insert method that adds new nodes to the tree.
	 * @param treeRoot is the node that roots the tree.
	 * @param key is the object that is to be added to the node in the tree.
	 * @return the new root.
	 */
	private BSTnode insert(BSTnode treeRoot, Comparable key, Object data) 
	   {
		if (treeRoot == null) {
			BSTnode newNode = new BSTnode(key,data);
			return newNode;
		} else if (key.compareThisTo(treeRoot.key) < 0) {
			treeRoot.llink = insert(treeRoot.llink, key,data);
			return treeRoot;
		} else if (key.compareThisTo(treeRoot.key) > 0) {
			treeRoot.rlink = insert(treeRoot.rlink, key,data);
			return treeRoot;
		} else {
			return treeRoot;
		}
	}

	//-----SEARCH METHOD HELPERS------\\

	/**
	 * This is the internal method to find an object in the a subtree.
	 * @param key is the object to be found.
	 * @param treeRoot is node that roots the tree.
	 * @return the node that contains the matching object.
	 */

      public BSTnode find(Comparable key) {   
		BSTnode treeRoot = root;
		int direction;

		while (treeRoot != null) {
			if ((direction = key.compareThisTo(treeRoot.key)) < 0) {
				treeRoot = treeRoot.llink;
			} else if (direction == 0) {
				return treeRoot;
			} else {
				treeRoot = treeRoot.rlink;
			}
		}
		return treeRoot; 
	}
	
	//-----REMOVE METHOD  HELPERS------\\
	/**
	 * This is the internal recursive method that removes an object from the tree.
	 * @param key is the object to be removed from the tree.
	 * @param treeRoot is the node that roots the tree.
	 * @return the new root.
	 */
		
	private BSTnode remove(Comparable key, BSTnode treeRoot) {
		if (treeRoot == null) {
			return treeRoot;
		} else if (key.compareThisTo(treeRoot.key) < 0) {
			treeRoot.llink = remove(key, treeRoot.llink);
		} else if (key.compareThisTo(treeRoot.key) > 0) {
			treeRoot.rlink = remove(key, treeRoot.rlink);
		} else if (treeRoot.llink != null && treeRoot.rlink != null) {
			treeRoot.key = findMin(treeRoot.rlink).key;
			treeRoot.rlink = removeMin(treeRoot.rlink);
		} else {
			treeRoot = (treeRoot.llink != null) ? treeRoot.llink
					: treeRoot.rlink;
			return treeRoot;
		}
		return treeRoot;
	}

		 /**
		  * This is the method that removes the smallest object in the tree.
		  * @param treeRoot is the node that roots the tree.
		  * @return the new root.
		  */
	private BSTnode removeMin(BSTnode treeRoot) {
		if (treeRoot == null) {
			return treeRoot;
		} else if (treeRoot.llink != null) {
			treeRoot.llink = removeMin(treeRoot.llink);
			return treeRoot;
		} else {
			return treeRoot.rlink;
		}
	}
		
		/**
		 * This is the method that finds the smallest object in the tree.
		 * @param treeRoot is the node that roots the tree.
		 * @return the node that contains the smallest object in the tree.
		 */
	private BSTnode findMin(BSTnode treeRoot) {
		if (treeRoot != null) {
			while (treeRoot.llink != null) {
				treeRoot = treeRoot.llink;
			}
		}
		return treeRoot;
	}

	 //-----------toString() helper-------------\\
	
    /**
     * The toString method that returns the Binary Search Tree as a single printable string.
     * The entries are returned in  inorder traversal method.
     */
    public String toString(BSTnode N) {
		String toBeReturned = "";
		if (N == null) {
			return "";
		} else {
			toBeReturned += toString(N.llink)+"\n"+N.data+ N.key+toString(N.rlink)+"\n" ;
			return toBeReturned;
		}
	}
	
	//------------PRINT Helper----------\\
	private void print(BSTnode rootNode) {

		if (rootNode != null) {
			System.out.print("(");
			print(rootNode.llink);
			System.out.print("  " + rootNode.key + "  ");
			print(rootNode.rlink);
			System.out.print(")");
		}

	}

}
