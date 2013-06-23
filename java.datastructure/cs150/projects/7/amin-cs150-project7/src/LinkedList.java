/**
 * @Author: Amin Meyghani
 * @Date: Feb/15/2011 modified on March.06.2011
 * @Purpose: This class defines a LinkedList for the Bag class and contains 
 * the methods that a LinkedList could implement such as add, remove, contains, etc.
 */
public class LinkedList {
	
	private int length;
    private ListNode firstNode;
    private String candidateString;
    private boolean removed;
    private ListNode currentNode = firstNode;
    private ListNode previousNode = currentNode;

	
    public LinkedList()
    {
        length=0;
        firstNode=null;
    }

    /**
	 * This method adds a new node to the LinkedList
	 */
    public void add(ListNode newNode)
    {
        if (length == 0)
        {
            firstNode=newNode;
        }
        else
        {
        	ListNode currentNode;
        	ListNode previousNode = null;
        	currentNode = firstNode;
        	
        	while(currentNode!=null)
        	{
        		previousNode = currentNode;
        		currentNode = currentNode.next;
        	}
            currentNode = newNode;
            previousNode.next = currentNode;
        }
        length++;
    }

    /**
	 * This method Inserts node into a specific index in the LinkedList.
	 */
	public void insertAtIndex(ListNode newNode, int intendedIndex) {
		if (length == 0) {
			newNode.next = firstNode.next;
			firstNode = newNode;
		} else if (intendedIndex != 0) {
			ListNode currentNode; ListNode previousNode;
			currentNode = this.getNodeAtIndex(intendedIndex);
			ListNode after = currentNode;
			previousNode = this.getNodeAtIndex(intendedIndex - 1);
			if (previousNode != null) {
				currentNode = newNode;
				previousNode.next = currentNode;
				currentNode.next = after;
			} else {
				System.out.println("Index is not valid!");
			}
		} else if (intendedIndex == 0) {
			ListNode after;
			after = this.getNodeAtIndex(intendedIndex);
			firstNode = newNode;
			firstNode.next = after;
		}
		length++;
	}


	/**
	 * This method checks if the LinkedList is emtpy.
	 * It returns true if the bag is empty and false otherwise.
	 */
    public boolean isLinkedListEmpty()
    {
    	return(firstNode==null);
    }
    /**
	 * This method removes the node that contains the given "Storable" object.
     *@param removedString is the object to be removed from the LinkedList.
	 */
	public void remove(Comparable removedString) {
		ListNode currentNode = null;
		
		while (currentNode != null && removed == false) {
			returnifInTheFirstNode();
			returnIfInTheCurrentNode();
		}
	
	}
	
    /**
	 * This method clears the linkedList 
	 */
    public void clearLinkedList()
    {
    	firstNode = null;
    	length = 0;
    }
    /**
	 * This method returns true if any of the nodes in the LinkedList
	 *  contains "value" for their data.
     *Otherwise return false.
      * @param value if any of the nodes contain this "Storable" object.
	 */
    public boolean contains(Comparable value)
 {
		ListNode currentNode;
		currentNode = firstNode;
		while (currentNode != null) {
			if (currentNode.data.equals(value)) {
				return true;
			} else {
				currentNode = currentNode.next;
			}
		}
		return false;
	}
    
    
    /**
     *getter method that gets the size of the LinkedList.
      * @return  the size of the LinkedList.
	 */
    public int returnSize()
    {
    	return length;
    }

    /**
     * This method returns the data of a node at a given index
	 */
	public ListNode getNodeAtIndex(int linkedListIndex) {
		int indexRunner = 0;
		int index = linkedListIndex;
		ListNode runner = firstNode;

		while (indexRunner < index && runner != null) {
			indexRunner++;
			runner = runner.next;
		}
		if (runner != null) {
			return runner;
		} else {
			return null;
		}
	}
//===============================================
	private boolean returnifInTheFirstNode(){
		if (firstNode.data.equals(candidateString)) {
			firstNode = firstNode.next;
			length--;
			removed = true;
		} 
		return true;
	}
	private boolean returnIfInTheCurrentNode(){
		if (currentNode.data.equals(candidateString)) {
			this.candidateString=candidateString;
			previousNode.next = currentNode.next;
			currentNode = null;
			length--;
			removed = true;
		}
		else {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		return true;
	}
}
