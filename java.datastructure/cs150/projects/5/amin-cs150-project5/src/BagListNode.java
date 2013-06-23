/*
 * @Author: Amin Meyghani
 * @Date: Feb/15/2011
 * @Purpose: This class defines a ListNode for the Bag class.
 */
//===============================================
public class BagListNode {

	public String data;
	public BagListNode next;
	
	public BagListNode(String inputString)
	{
		this.data = new String(inputString);
	    this.next=null; 
	}	
}
