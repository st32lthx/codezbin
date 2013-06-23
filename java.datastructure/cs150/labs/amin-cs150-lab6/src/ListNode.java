/**
 * ListNode is a building block for a linked list of data items
 * 
 * This is the only class where I'll let you use public instance variables.
 * It's so we can reference information in the nodes using cascading dot
 * notation, like 
 *          N.next.data instead of 
 *          N.getNext().getData()
 * 
 * @author C. Fernandes and G. Marten
 * @date December 2002
 */
public class ListNode
{
    public Event data;      // a "reservation" of the conference room
    public ListNode next;   // pointer to next node
    
    public ListNode(Event event)
    {
        this.data = event;
        this.next = null;
    }
    
    // if you say "System.out.println(N)" where N is a ListNode, the
    // compiler will call this method automatically to print the contents
    // of the node.  It's the same as saying "System.out.println(N.toString())"
    public String toString()
    {
        return data.toString();  // call the toString() method in Event class
    }
}
    