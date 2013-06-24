/**
 * The Heap ADT. This is a max heap.
 * 
 * @author Amin Meyghani 
 * @version March 10 2011
 */
public class Heap
{
    private int[] itemArray; // binary tree of ints in array form (element 0 not used)
    private int nodes; // number of nodes in the tree

    /**
     * Builds a heap from an array of ints.
     * 
     * @param items
     *            an array of ints(starting at index 0), which will be
     *            interpreted as a binary tree.
     */
    public Heap(int[] items)
    {
	itemArray = new int[items.length + 1];
	nodes = items.length;
	
	for (int i = 0; i < nodes; i++) {
	    itemArray[i + 1] = items[i];
	}
	
	buildAHeap();
    }
    
    /**
     * @return number of nodes in the heap.
     */
    public int size()
    {
	return nodes;
    }
    
    /**
     * Constructs a heap from the given binary tree (given as an array).
     * Heapifies each internal node in reverse level-by-level order.
     */
    public void buildAHeap()
    {
	for (int i = nodes / 2; i >= 1; i--) {
	    heapify(i);
	}
    }
    
    /**
     * @return string representation of the heap (in level-by-level order)
     */
    public String toString()
    {
	String result = "";
	int lastNodeOnLevel = 1;
	
	for (int i = 1; i < nodes; i++) {
	    result += itemArray[i];
	    if (i == lastNodeOnLevel) {
		result += "\n";
		lastNodeOnLevel = lastNodeOnLevel * 2 + 1;
	    } else {
		result += " ";
	    }
	}
	result += itemArray[nodes];
	
	return result;
    }

    /**
     * Turns a subtree into a heap, assuming that only the root of
     * that subtree violates the heap property.  
     *
     * Will only be called if the subtrees of the given root are already heaps. 
     * 
     * @param startingNode
     *            the index of the node to start with. This node is the root of
     *            a subtree which must be turned into a heap.
     */
	public void heapify(int startingNode) {
		int currentNode = startingNode;

		while (!isLeaf(currentNode)) {

			int largestChildIndex = getLargestChild(currentNode);
			if (itemArray[largestChildIndex] > itemArray[currentNode]) {
				int theLargestChild = itemArray[largestChildIndex];
				itemArray[largestChildIndex] = itemArray[currentNode];
				itemArray[currentNode] = theLargestChild;

				currentNode = largestChildIndex;
			} else {
				return;
			}

		}
	}
/**
 * This method get the index of the largest child of a node.
 * @param currentNode is the node for which we will find the largest child.
 * @return the index of the largest child of a node. 
 */
	private int getLargestChild(int currentNode) {
		int largestChildIndex;

		if (2 * (currentNode) + 1 <= size()) {
			int left = itemArray[2 * currentNode];
			int right = itemArray[2 * currentNode + 1];
			if (left > right) {
				largestChildIndex = 2 * currentNode;
				return largestChildIndex;
			} else {
				largestChildIndex = 2 * currentNode + 1;
				return largestChildIndex;
			}
		} else {
			largestChildIndex = 2 * currentNode;
			return largestChildIndex;
		}
	}

	/**
     * Removes the root from the heap, returning it. The resulting array is then
     * turned back into a heap.
     * 
     * @return the root value.
     */
    public int deleteRoot()
    {
	 int root = itemArray[1];
    itemArray[1] = itemArray[size()];
    nodes--;
    heapify(1);
    return root;   
}
/**
 * This method checks if a given node is leaf or not.
 * @param i is the index of a given node.
 * @return true if the node is leaf and false otherwise
 */
	private boolean isLeaf(int i) // if left child exists
	{
		return (2 * i > size());
	}
    

}
