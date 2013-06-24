/**
 * ListNode is a building block for a linked list of data items
 * 
 * This is the only class where I'll let you use public instance variables.
 * It's so we can reference information in the nodes using cascading dot
 * notation, like 
 *          N.next.data instead of 
 *          N.getNext().getData()
 * 
 * @author C. Fernandes, G. Marten, and A. Cass
 * @date February 2009
 */
public class ListNode
{
    public Event data;      // a "reservation" of the conference room
    public ListNode next;   // pointer to next node
    
    /**
     * Creates a node that can store an Event.
     *
     * @param event the event to store.
     */
    public ListNode(Event event)
    {
        this.data = event;
        this.next = null;
    }
    
    /**
     * @return a string represenation of the node's data.
     */
    public String toString()
    {
        return data.toString();
    }
}
    