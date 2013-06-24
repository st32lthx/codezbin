/*
 * @Author: Amin Meyghani
 * @Date: Feb/15/2011
 * @Purpose: This class defines a LinkedList for the Bag class.
 */
//===============================================
public class BagLinkedList {
	
	private int length;
    private BagListNode firstNode;
    private String candidateString;
    private boolean removed;
    private BagListNode currentNode = firstNode;
    private BagListNode previousNode = currentNode;

	
    public BagLinkedList()
    {
        length=0;
        firstNode=null;
    }
 //===============================================  
	/**
	 * This method adds a new node to the LinkedList
	 */
    public void add(BagListNode newNode)
    {
        if (length == 0)
        {
            firstNode=newNode;
        }
        else
        {
        	BagListNode currentNode;
        	BagListNode previousNode = null;
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
//===============================================	
    /**
	 * This method Inserts node into a specific index in the LinkedList.
	 */
	public void insertAtIndex(BagListNode newNode, int intendedIndex) {
		if (length == 0) {
			newNode.next = firstNode.next;
			firstNode = newNode;
		} else if (intendedIndex != 0) {
			BagListNode currentNode; BagListNode previousNode;
			currentNode = this.getNodeAtIndex(intendedIndex);
			BagListNode after = currentNode;
			previousNode = this.getNodeAtIndex(intendedIndex - 1);
			if (previousNode != null) {
				currentNode = newNode;
				previousNode.next = currentNode;
				currentNode.next = after;
			} else {
				System.out.println("Index is not valid!");
			}
		} else if (intendedIndex == 0) {
			BagListNode after;
			after = this.getNodeAtIndex(intendedIndex);
			firstNode = newNode;
			firstNode.next = after;
		}
		length++;
	}
 //===============================================	
    /**
	 * This method returns true if the LinkedList is empty,  false
	 *  otherwise.
	 */
    public boolean isLinkedListEmpty()
    {
    	return(firstNode==null);
    }
//===============================================	
    /**
	 * This method removes the node that contains the given string.
     *@param candidateString to check if the item exists
	 */
	public void remove(String candidateString) {
		BagListNode currentNode = null;
		
		while (currentNode != null && removed == false) {
			returnifInTheFirstNode();
			returnIfInTheCurrentNode();
		}
	
	}
	
//===============================================	
    /**
	 * This method clears the linkedList 
	 */
    public void clearLinkedList()
    {
    	firstNode = null;
    	length = 0;
    }
//===============================================
    /**
	 * This method returns true if any of the nodes in the LinkedList
	 *  contains "string" for their data.
     //Otherwise return false.
      * @param candidateString if any of the nodes contain this string.
	 */
    public boolean contains(String candidateString)
 {
		BagListNode currentNode;
		currentNode = firstNode;
		while (currentNode != null) {
			if (currentNode.data.equals(candidateString)) {
				return true;
			} else {
				currentNode = currentNode.next;
			}
		}
		return false;
	}
 //===============================================
    /**LinkedLIst getter method
      * @return  the size of the LinkedList.
	 */
    public int returnSize()
    {
    	return length;
    }
//===============================================
    /**This method returns the data of a node at a given index
	 */
	public BagListNode getNodeAtIndex(int linkedListIndex) {
		int indexRunner = 0;
		int index = linkedListIndex;
		BagListNode runner = firstNode;

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
