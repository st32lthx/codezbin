/**
 * @Author: Amin Meyghani
 * @Date: Feb/15/2011
 * @Purpose: This class defines a ListNode for the Bag class and contains variables 
 * that control the properties of a node in the LinkedList
 */

public class ListNode {

	public Comparable data;
	public ListNode next;
	
	public ListNode(Comparable value)
	{
		this.data = value;
	    this.next=null; 
	}	
}
