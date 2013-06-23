/**
 * Linked List is a collection of data nodes.  All methods here relate to
 * how one can manipulate those nodes.
 */
public class LinkedList
{
    private int length;          // number of nodes
    private ListNode firstNode;  // pointer to first node

    public LinkedList()
    {
        length=0;
        firstNode=null;
    }

    /**
     * insert newNode at linked list's head.
     *
     * @param newNode the node to insert.  Cannot be null.
     */ 
    public void insertAtHead(ListNode newNode)
    {
        if (length == 0) {
            firstNode=newNode;
        } else {
            newNode.next=firstNode;
            firstNode=newNode;
        }
        length++;
    }
        
    /**
     * @return linked list as printable string
     */
    public String toString() 
    {
    	String toReturn="(";
    	ListNode runner;
    	runner=firstNode;
    	while (runner != null) {
    		toReturn = toReturn + runner;
    		runner = runner.next;
    		if (runner != null) {
    			toReturn = toReturn + ",\n";
    		}
    	}
    	toReturn = toReturn + ")";

    	return toReturn;
    }
    
    public int getLength() 
    {
    	return length;
    }

    public ListNode getFirstNode() 
    {
    	return firstNode;
    }
 //========================================
   public void removeHead()
    {
    	if(length != 0)
    	{
    		ListNode runner=firstNode;
    		runner = null;
    		firstNode = firstNode.next;
    	}
    	
    }
//========================================
/*
 * insertAtTail method that adds an event to the end of the List.
 */
	public void insertAtTail(ListNode TailNode) {
		if (length == 0) {
			firstNode = TailNode;
		} else {
			ListNode runner = firstNode;
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next =TailNode;

		}
//========================================
/*
 * Search method that returns the starting time of given event.
 */
    }
    public int search(String eventName)
    {
    	ListNode runner= firstNode;
    	while (runner != null)
        {   
    		if(runner.data.getName().contains(eventName))
    		{
    			return runner.data.getStart();
    		}
    		runner = runner.next;
        }
    	return -1;
    }
//=================END=======================
   
}