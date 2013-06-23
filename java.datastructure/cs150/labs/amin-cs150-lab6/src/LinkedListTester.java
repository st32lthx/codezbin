/**
 * Tests new (and old?) LinkedList methods.
 * 
 * @author Chris Fernandes, Aaron Cass, and you
 * @version 10/12/08
 */
public class LinkedListTester
{
	public static void main(String[] args)
	{
	LinkedListTester tester = new LinkedListTester();
	tester.test231();
	tester.test0();
	tester.test21();
	tester.test21x();
	tester.test231y();
	}
//===================================================
    /**
     * adds events in the order 1, 2, 3 that should end up in the order 2, 3, 1
     */
    public void test231()
    {
	LinkedList list = new LinkedList();
	
	ListNode N1 = new ListNode(new Event("chess", 2009, 1, 25, 1900, 1930));
	ListNode N2 = new ListNode(new Event("boy scouts", 2009, 1, 23, 900, 1000));
	ListNode N3 = new ListNode(new Event("book club", 2009, 1, 25, 800, 830));
	
	list.insertSorted(N1);
	list.insertSorted(N2);
	list.insertSorted(N3);
	
	ListNode[] expected = new ListNode[]{N2, N3, N1};
	printPassedOrFailed(expected, list);
    }
//================================================ 
    /**
     *Inserting into an empty list using insertSorted.
     */
	public void test0(){
	LinkedList list = new LinkedList();
	ListNode N1 = new ListNode(new Event("world around u", 2011, 2, 12, 1800, 1900));
	
	list.insertSorted(N1);
	
	ListNode[] expected = new ListNode[] { N1 };
	printPassedOrFailed(expected, list);
	}
//===================================================
    /**
     *  
 		Testing if node is added before another node. 
 		adds events in the order 1, 2 that should end up in the order 2, 1
     */
	public void test21(){
	LinkedList list = new LinkedList();
	ListNode N1 = new ListNode(new Event("world around u", 2011, 2, 12, 1800, 1900));
	ListNode N2 = new ListNode(new Event("movie night", 2011, 2, 11, 1800,1900));
	
	list.insertAtHead(N1); 
	list.insertSorted(N2);
	
	ListNode[] expected = new ListNode[] { N2, N1 };
	printPassedOrFailed(expected, list);
	}
//=================================================
    /**
     * Testing if node is added after another node.
		 adds events in the order 2, 1 that should end up in the order 2, 1
     */
	public void test21x(){
	LinkedList list = new LinkedList();
	ListNode N1 = new ListNode(new Event("world around u", 2011, 2, 12, 1800, 1900));
	ListNode N2 = new ListNode(new Event("movie night", 2011, 2, 11, 1800,1900));
	
	list.insertAtHead(N2); 
	list.insertSorted(N1);
	
	ListNode[] expected = new ListNode[] { N2, N1 };
	printPassedOrFailed(expected, list);
	}
 //================================================== 
    /**
     *  Testing outside of the while loop with only one node present.
     */
	public void test231y(){
	LinkedList list = new LinkedList();
	ListNode N3 = new ListNode(new Event("world around u", 2011, 2, 12, 1800, 1900));
	ListNode N1 = new ListNode(new Event("movie night", 2011, 2, 11, 830,	9000));
	ListNode N2 = new ListNode(new Event("bbq night", 2011, 2, 12, 700, 800));
	
	list.insertAtHead(N1);
	list.insertSorted(N2);
	list.insertSorted(N3);
	
	ListNode[] expected = new ListNode[] { N1, N2, N3 };
	printPassedOrFailed(expected, list);
	}
    //=============================================
    private void printPassedOrFailed(ListNode[] expected, LinkedList list)
    {
	String expectedString = arrayToString(expected);
	
	System.out.println("List should look like:    " + expectedString);
	System.out.println("List actually looks like: " + list);
	if (expectedString.equals(list.toString())) {
	    System.out.println("PASS\n");	
	} else {
	    System.out.println("\n*** Test FAILED.\n\n");	
	}
    }
   //===========================================	
    private String arrayToString(ListNode[] array)
    {
	String result = "(";
	int size = array.length;
		
	for(int i = 0; i < size - 1; i++) {
	    result += array[i].toString() + ",\n"; 
	}
	result += array[size-1] + ")";
	return result;
    }
 //===========================================	
}
