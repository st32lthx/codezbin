/*
 * @Author: Amin Meyghani
 * CS150-Lab5
 * @date: February/3/2011
 * @purpose: This class tests the LinkedList class methods.
 */
public class LinkedListTester 
{
	static Event event1,event2,event3,event4,event5;
	static ListNode node1, node2, node3,  node4, node5;
	static LinkedList linkedList;	
	
	public static void main(String[] args)
	{
		makeEventsAndNodes();
		addEventsToLinkedList();
		testSearchMethod();
		testRemoveAtHeadMethod();
		testInsertAtTailMethod();

	}
	
//=======================================================
/*
 * Adding events to the LinkedList
 */
public static void addEventsToLinkedList()
{
	linkedList.insertAtHead(node1);
	linkedList.insertAtHead(node2);
	linkedList.insertAtHead(node3);
	linkedList.insertAtHead(node4);
	linkedList.insertAtHead(node5);
}	
//=======================================================
/*
 * Create Events and nodes
 */
public static void makeEventsAndNodes()
{
		event1 = new Event("World Around U meeting", 2011, 2, 4, 830, 1200);
		event2 = new Event("Igloo Café", 2011, 2, 4, 930, 1200);
		event3 = new Event("Green House Jams", 2011, 2, 4, 930, 1200);
		event4 = new Event("Friday BBQ", 2011, 2, 5, 700, 1200);
		event5 = new Event("Handwriting Analysis", 2011, 2, 4, 1700, 1830);
		node1 = new ListNode(event1);
		node2 = new ListNode(event2);
		node3 = new ListNode(event3);
		node4 = new ListNode(event4);
		node5 = new ListNode(event5);
		linkedList = new LinkedList();
}
//=======================================================
/*
 * Testing the search method
 */
public static void testSearchMethod()
{
		System.out.println("Testing the Search method:");
		int linkedListStartTime = linkedList.search("World Around U meeting");
		System.out.println(event1 + " starts at: " + linkedListStartTime);
		if (event1.getStart() == linkedListStartTime) {
			System.out.println("TEST PASSED");
			System.out.println("-----------------------------------------");

		} else {
			System.out.println("TEST FAILED");
			System.out.println("-----------------------------------------");

		}
	
}
//========================================================
/*
 * Print the events that are in pointed by the next pointers of each node
 */
public static void printLinkedList()
{
	System.out.println(linkedList.toString());
}
//========================================================
/*
 * Test removeAtHeadMethod
 */
public static void testRemoveAtHeadMethod()
{
	
	System.out.println("Testing removeAtHead method"+"\n"+"Before removing the head: "+"\n");
	printLinkedList();
	linkedList.removeHead();
	System.out.println("\n"+"After removing the head: "+"\n");
	printLinkedList();	
	if(node1.next==null)
	{
		System.out.println("TEST PASSED");
		System.out.println("-----------------------------------------");
	}
	else
	{
		System.out.println("TEST FAILED");
		System.out.println("-----------------------------------------");
	}
}
//========================================================
/*
 * Test insertAtTailMethod
 */	

public static void testInsertAtTailMethod()
{
	System.out.println("Testing insertAtTail method"+"\n"+"Before adding to tail: "+"\n");
	printLinkedList();
	linkedList.insertAtHead(node5);
	System.out.println("\n"+"After adding to tail: "+"\n");
	printLinkedList();	
	
}

	
}
