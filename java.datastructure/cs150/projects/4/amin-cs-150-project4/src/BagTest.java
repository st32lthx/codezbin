/*
 * @Author: Amin Meyghani
 * @Date: Feb/9/2011
 * @Purpose: This class tests all the methods of the bag class.
 */
//===============================================
public class BagTest {
private static Bag bag = new Bag(2);
private static Bag bag2=new Bag(2);
private static Bag bag3=new Bag(2);
private static Bag bag4 = new Bag(4);
private static Bag bag5 = new Bag(10);
private static Bag emptyBag=new Bag(1);


private static int originalCapacity=0;
private static int originalSize=0;
public static void main(String[] args) {
		testAddMethod();
		testSizeMethod();
		testCapacityMethod();
		testToStringMethod();
		testRemoveMethod();
		testRemoveRandomMethod();
		testContainsMethod();
		testEqualsMethod();
		testIsEmptyMethod();
		testTrimToSizeMethod();
		testCopyMethod();
		testUnionMethod();
		testClearMethod();
	}

//================Test Method Definitions===============
	
	public static void testAddMethod() {
		testTitle("'add'");
		System.out.println("This tests if the method adds a string to the bag.");
		originalCapacity = bag2.capacity();
		System.out.println("Bag with room:");
		bag2.add("Alan");
		printExpectedOutcome("{Alan}");System.out.println(" Capacity = 2");
		printActualOutcome();System.out.print(bag2.toString());printCapacity(bag2.capacity());
		bag2.add("Mays");
		bag2.add("Amin");
		System.out.println("Bag without room:");
		printExpectedOutcome("{Alan,Mays,Amin}");System.out.println(" Capacity = 4");
		printActualOutcome();System.out.print(bag2.toString()); printCapacity(bag2.capacity());
		printPassOrFail( isCapacityDoubled()&&areNamesPrintedCorrectly());
		addRule();
	}
	private static boolean isCapacityDoubled(){
		return(bag2.capacity()/2==originalCapacity);
	}
	private static boolean areNamesPrintedCorrectly(){
		return(bag2.toString().equals("{Alan,Mays,Amin}"));
	}
	//---------------------------------------------------
	public static void testSizeMethod() {
		testTitle("'size'");
		System.out.println("This tests if the method returns the number of items in the bag.");
		printExpectedOutcome("0");
		printActualOutcome();printSize(bag.size());printCapacity(bag.capacity());
		printPassOrFail( bag.size()==0);
		System.out.println("Add an item");
		bag.add("X");
		printExpectedOutcome("1");
		printActualOutcome();printSize(bag.size());printCapacity(bag.capacity());
		System.out.println("Add 7 more");
		for(int i=0; i<7;i++){
		bag.add("i");
		}
		printExpectedOutcome("8");
		printActualOutcome();printSize(bag.size());printCapacity(bag.capacity());
		printPassOrFail( bag.size()==8);
		addRule();
	}
	
//------------------------------------------------
	public static void testCapacityMethod() {
		testTitle("'capacity'");
		System.out.println(bag.capacity());
		originalCapacity=bag.capacity();
		System.out.println("This tests if the method returns the current capacity of this bag.");
		printExpectedOutcome("8");
		printActualOutcome();System.out.println(bag.capacity());
		printPassOrFail( isCapacitySame());
		addRule();
	}
	private static boolean isCapacitySame(){
		return(bag.capacity()==originalCapacity);
	}
//-------------------------------------------------
	public static void testToStringMethod() {
		testTitle("'toString'");
		System.out.println("This tests if the method returns all elements of this bag as a single printable String.");
		bag3.add("Mahta");
		bag3.add("Rahim");
		printExpectedOutcome("{Mahta,Rahim}");
		printActualOutcome();System.out.println(bag3.toString());
		printPassOrFail(areStringsEqual());
		addRule();
	}
	private static boolean areStringsEqual(){
		return(bag3.toString().equals("{Mahta,Rahim}"));
	}
//-------------------------------------------------
	public static void testRemoveMethod() {
		testTitle("'remove'");
		System.out.println("This tests if the method removes (one copy of) a string from the bag.");
		bag4.add("A");bag4.add("B");bag4.add("C");bag4.add("A");bag4.add("D");bag4.add("E");bag4.add("F");
		bag4.remove("A");
		printExpectedOutcome("{B,C,A,D,E,F}");
		printActualOutcome(); System.out.println(bag4.toString());
		bag4.remove("A");
		printExpectedOutcome("{B,C,D,E,F}");printActualOutcome();
		 System.out.println(bag4.toString());
		bag4.remove("F");
		printExpectedOutcome("{B,C,D,E}");printActualOutcome();
		 System.out.println(bag4.toString());
		bag4.remove("E");
		printExpectedOutcome("{B,C,D}");printActualOutcome();
		 System.out.println(bag4.toString());
		bag4.remove("C");
		printExpectedOutcome("{B,D}");printActualOutcome();
		 System.out.println(bag4.toString());
		
		printPassOrFail(bag4.toString().equals("{B,D}"));
		System.out.println("Testing if bag is empty");
		bag4.clear();
		bag4.remove("C");
		printPassOrFail(bag4.removeRandom()==null);
		addRule();
	}
	
//------------------------------------------------------
	public static void testRemoveRandomMethod() {
		testTitle("'remove random'");		
		System.out.println("This tests if the method removes a random element from the bag.");
		System.out.println("Add 5 elements: ");
		bag5.add("A");bag5.add("B");bag5.add("C");bag5.add("D");bag5.add("E");
		originalCapacity=bag5.size();
		System.out.println(originalCapacity);

		System.out.println(bag5.toString());
		System.out.println("The removed item is: "+bag5.removeRandom());
		System.out.println(bag5.size());

		System.out.println(bag5.toString());
		printExpectedOutcome("that one of the letters is removed and returned");
		printActualOutcome();System.out.println(bag5.toString());
		printPassOrFail(bag5.size()==originalCapacity-1);
		addRule();
	}
	//------------------------------------------------------
	public static void testContainsMethod() {
		Bag bag6 = new Bag(6);
		testTitle("'contains'");
		System.out.println("This tests if the method returns true, if a string with the same contents as value exists in the bag and false otherwise.");
		printBag(bag2.toString());
		bag6.add("AMIN");bag6.add("ALAN");bag6.add("MAYS");
		System.out.println("Looking for Mays: ");
		boolean test = bag6.contains("MAYS");
		printExpectedOutcome("TRUE");
		printActualOutcome();System.out.println(test);
		printPassOrFail(test);
		System.out.println("If it does not exist: ");
		System.out.println("(Looking for 'JOE')");
		boolean test2 = bag6.contains("JOE");
		printExpectedOutcome("FALSE");
		printActualOutcome();System.out.println(test2);
		printPassOrFail(test2);
		System.out.println("test if bag is empty:");
		boolean test3 = emptyBag.contains("MIKE");
		printExpectedOutcome("false");
		printActualOutcome();System.out.println(test3);
		printPassOrFail(!test3);
		addRule();
	}
	//------------------------------------------------------
	public static void testEqualsMethod() {
		testTitle("'equals'");
		System.out.println("This tests if the method returns true, if this bag and otherBag are equal and false otherwise.");
		//printExpectedOutcome();
		printActualOutcome();
		//printPassOrFail();
		addRule();
	}
//------------------
	public static void testIsEmptyMethod() {
		testTitle("'isEmpty'");
		System.out.println("This tests if the method returns true, if this bag is empty and false otherwise.");
		
		printExpectedOutcome("FALSE");
		printActualOutcome(); System.out.println(bag2.isEmpty());
		printPassOrFail(!bag2.isEmpty());
		System.out.println("if bag is empty");
		printExpectedOutcome("TRUE");
		printActualOutcome(); System.out.println(emptyBag.isEmpty());
		printPassOrFail(emptyBag.isEmpty());
		addRule();
	}
	
//---------------------

	public static void testTrimToSizeMethod() {
		Bag bag8 = new Bag(8);
		bag8.add("a");bag8.add("b");bag8.add("c");
		testTitle("'trimToSize'");
		System.out.println("This tests if the method trims the capacity of this bag to be the bag's current size.");
		printBag(bag8.toString());
		bag8.trimToSize();
		printExpectedOutcome("size=3, capacity=3");
		printActualOutcome();printSize(bag8.size());printCapacity(bag8.capacity());
		printPassOrFail(bag8.size()==3&&bag8.capacity()==3);
		addRule();
	}
	//-------------------------------
	public static void testCopyMethod() {
		Bag bag9 =  new Bag(3);
		bag9.add("x");bag9.add("y");bag9.add("z");
		testTitle("'copy'");
		System.out.println("This tests if the method returns an exact duplicate of this bag.");
		bag9.copy();
		printExpectedOutcome("{x,y,z}");
		printActualOutcome();System.out.println("bag9.copy().toString()");
		printPassOrFail(bag9.copy().toString().equals("{x,y,z}"));
		addRule();
	}
	//-------------------------------
	public static void testUnionMethod() {
		testTitle("'union'");
		System.out.println("This tests if the method creates the union of this bag and another bag.");
		//printExpectedOutcome();
		printActualOutcome();
		//printPassOrFail();
		addRule();
	}
	//--------------------------------
	public static void testClearMethod() {
		testTitle("'clear'");
		bag3.clear();
		System.out.println("This tests if the method removes all elements from this bag.");
		printExpectedOutcome("}");
		printActualOutcome();System.out.println(bag3.toString());
		printPassOrFail("}".equals(bag3.toString()));
		addRule();
	}
	
//--------------------------
	
	// ==================================

	private static void printPassOrFail(boolean condition) {
		if (condition == true ) {
			System.out.println("This test PASSED.");
		} else {
			System.out.println("This test FAILED.");
		}
	}

	private static void testTitle(String method) {
		System.out.print("Testing the " + method + " method: ");
	}

	private static void addRule() {
		System.out.println("---------------------------------------");
	}

	private static void printExpectedOutcome(String expected) {
		System.out.print("Expected outcome: "+expected);
	}

	private static void printActualOutcome() {
		System.out.print("  Actual outcome : ");
	}
	//==========================================
private static void printSize(int theSize){
	System.out.println("The bag size is: " + theSize);
}
private static void printCapacity(int theCapacity){
	System.out.println(" Capacity =  "+ theCapacity);
}
private static void printBag(String bag	){
	System.out.println(bag);

}
}
