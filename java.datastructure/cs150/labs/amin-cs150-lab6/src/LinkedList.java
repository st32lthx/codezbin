/**
 * Linked List is a collection of data nodes.  All methods here relate to
 * how one can manipulate those nodes.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedList
{
    private int length;         // number of nodes
    private ListNode firstNode; // pointer to first node
    private ListNode runner;
    private ListNode nextRunner;
    private ListNode newNodex;
    public LinkedList()
    {
        length=0;
        firstNode=null;
    }
    
    /** getter
     * 
     * @return number of nodes in the list
     */
    public int getLength() {return length;}
    
    /** getter
     * 
     * @return pointer to first node in the list
     */
    public ListNode getFirstNode() {return firstNode;}

    
    /**
     * insert given node at head of list
     * @param newnode the node to add
     */
    public void insertAtHead(ListNode newnode)
    {
        if (length == 0)
        {
            firstNode=newnode;
        }
        else
        {
            newnode.next=firstNode;
            firstNode=newnode;
        }
        length++;
    }
  
    /**
     * @return a string representation of the list and its contents.
     */
    public String toString() 
    {
    	String toReturn="(";
    	ListNode n;
    	n=firstNode;
    	while (n!=null)
    	{
    		//toReturn = toReturn + n.student.getName(); //not reusable
    		toReturn = toReturn + n;  //call node's toString automatically
    		n=n.next;
    		if (n!=null)
    		{
    			toReturn = toReturn + ",\n";
    		}
    	}
    	toReturn = toReturn + ")";
    	return toReturn;
    }
    
    /**
     * insert newNode into sorted position in LL
     *
     * @param newNode the node to insert
     */
    public void insertSorted(ListNode newNode)
    {
    	newNodex = newNode;
        ListNode nodeBefore = this.findPosition(newNode);
        if (nodeBefore == null) {
            insertAtHead(newNode);
	} else {
            insertAfter(nodeBefore, newNode);
	}
    }

    /**
     * Given a new node (containing a new event) to be inserted in the
     * list, finds the correct position for it.
     *
     * @param newNode a node containing an event to be inserted in the list
     *
     * @return a pointer to the node in the linked list that will
     * immediately precede newNode once newNode gets inserted.
     * Returns null if no such node exists.
     */
    public ListNode findPosition(ListNode newNode)
    {
    	runner=firstNode;
    	 if(runner==null || runner.data.compareTo(newNode.data)==1)
    	{
    		 return null;
    	}
    	nextRunner = firstNode.next;
    	while(nextRunner!=null&& isNextEventEarlierThanNewEvent())
			{
    		runner = runner.next;
    		nextRunner = nextRunner.next;
			}
		return runner;
    }
		private boolean isNextEventEarlierThanNewEvent()
		{
		return (nextRunner.data.compareTo(newNodex.data)==-1);
		}		

    /**
     * Given a pointer to a node to insert and a pointer to the node
     * that should come before it, insert the new node after the other
     * one.
     *
     * @param beforeNode the node (already in the list) that should
     * immediately precede newNode
     * @param newNode the new node to be inserted after beforeNode
     */
    public void insertAfter (ListNode beforeNode, ListNode newNode)
    {
    	newNode.next = beforeNode.next;
    	beforeNode.next = newNode;	
    }
 }
