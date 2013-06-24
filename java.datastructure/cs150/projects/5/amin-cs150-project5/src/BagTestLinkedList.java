/*
 * @Author: Amin Meyghani
 * @Date: Feb/15/2011
 * @Purpose: This class tests all the methods of the bag class.
 */
//===============================================
public class BagTestLinkedList {
public static void main(String[] args) {
//=============***************===============
//																									|
//										Test Methods							     	|	
//																									|
//=============****************===============
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
//===============================================
private static Bag bag = new Bag(2);
private static Bag bag2=new Bag(2);
private static Bag bag3=new Bag(2);
private static Bag bag4 = new Bag(4);
private static Bag bag5 = new Bag(10);
private static Bag bag6 = new Bag(6);
private static Bag bag8 = new Bag(8);
private static Bag bag9 =  new Bag(3);
private static Bag emptyBag=new Bag(1);
private static Bag thisBag=new Bag(2);
private static Bag otherBag=new Bag(3);
private static int originalCapacity=0;
private static int originalSize=0;


	public static void testAddMethod() {
		printTestTitle("'add'");
		testIfBagHasRoom();
		testIfBagHasNoRoom();
	}

	public static void testSizeMethod() {
		printTestTitle("'size'");
		testIfThereAreNoItemsInTheBag();
		testIfThereIsOneItemsInTheBag();
		testIfThereAreMoreThanTwoItemsInTheBag();
	}
	
	public static void testCapacityMethod() {
		printTestTitle("'capacity'");
		testIfBagCapacityIsEight();
	}
	
	public static void testToStringMethod() {
		testIfToStringMethodPrintsCorrectly();
	}
	
	public static void testRemoveMethod() {
		printTestTitle("'remove'");
		testIfOnlyOneCopyIsRemovedOnly();
		testIfOnlyOneCopyIsRemovedFromMiddle();
		 testIfOnlyOneCopyIsRemovedFromTail();
		 testIfOnlyOneCopyIsRemovedFromMiddleAgain();
		 testRemovingFromEmptyList();
	}
	
	public static void testRemoveRandomMethod() {
		printTestTitle("'remove random'");		
		testIfCapacityHasBeenDecreasedByOne();
	}

	public static void testContainsMethod() {
		
		printTestTitle("'contains'");
		lookForItemThatExistsInTheBag();
		lookForItemThatDoesNotExistsInTheBag();
		lookForItemIfBagIsEmpty();
	}
	
	public static void testEqualsMethod() {
		printTestTitle("'equals'");
		System.out.println("This tests if the method returns true, if this bag and otherBag are equal and false otherwise.");
		//printExpectedOutcome();
		printActualOutcome();
		//printPassOrFail();
		addRule();
	}

	public static void testIsEmptyMethod() {
		printTestTitle("'isEmpty'");
		testIfBagIsEmpty();
	}
	
	public static void testTrimToSizeMethod() {
		testTrimmingBagSizeFrom8to4();
	}
	
	public static void testCopyMethod() {
		testCopyingTheBag();
	}

	public static void testUnionMethod() {
		testCombiningTwoBagsOfDifferentSized();
	}
	
	public static void testClearMethod() {
		testingEmptyingTheBag();
	}
//=============***************===============
//	
//									HelperMethods										
//	
//=============****************===============
// ==================================	
//Test size helper methods:
// ==================================
	private static  void testIfThereAreNoItemsInTheBag(){
		System.out.println
		("This tests if the method returns the number of items in the bag."); 
		printExpectedOutcome("0");
		printActualOutcome(); printSize(bag.size()); 
		printCapacity(bag.capacity());
		printPassOrFail( bag.size()==0);
	}
	private static  void testIfThereIsOneItemsInTheBag(){
		System.out.println("Add an item");
		bag.add("AnItem");
		printExpectedOutcome("1");
		printActualOutcome();printSize(bag.size());
		printCapacity(bag.capacity());
	}	
	private static  void testIfThereAreMoreThanTwoItemsInTheBag(){
	System.out.println("Add 7 more");
	for(int i=0; i<7;i++){
	bag.add("item");
	}
	printExpectedOutcome("8");
	printActualOutcome();printSize(bag.size());
	printCapacity(bag.capacity());
	printPassOrFail( bag.size()==8);
	addRule();
	}
// ==================================	
//testAdd helper methods:
// ==================================
	private static void testIfBagHasRoom(){
		System.out.println("This tests if the method adds a string to the bag.");
		originalCapacity = bag2.capacity();
		System.out.println("Bag with room:");
		bag2.add("Alan");
		printExpectedOutcome("{Alan}"); 
		System.out.println(" Capacity = 2");
		printActualOutcome();
		System.out.print(bag2.toString()); 
		printCapacity(bag2.capacity());
		bag2.add("Mays"); bag2.add("Amin");
	}
	
	private static void testIfBagHasNoRoom(){
	System.out.println("Bag without room:");
	printExpectedOutcome("{Alan, Mays, Amin}"); 
	System.out.println(" Capacity = 4");
	printActualOutcome();System.out.print(bag2.toString()); 
	printCapacity(bag2.capacity());
	printPassOrFail( isCapacityDoubled()&&areNamesPrintedCorrectly());
	addRule();
	}
		private static boolean isCapacityDoubled(){
			return(bag2.capacity()/2==originalCapacity);
		}
		private static boolean areNamesPrintedCorrectly(){
			return(bag2.toString().equals("{Alan, Mays, Amin}"));
		}
// ==================================	
//testCapacity helper methods:
// ==================================
	private static boolean isCapacitySame(){
		return(bag.capacity()==originalCapacity);
	}
	
	private static void testIfBagCapacityIsEight(){
		System.out.println(bag.capacity());
		originalCapacity=bag.capacity();
		System.out.println("This tests if the method returns the current capacity of this bag.");
		printExpectedOutcome("8");
		printActualOutcome(); System.out.println(bag.capacity());
		printPassOrFail( isCapacitySame());
		addRule();
	}
	// ==================================	
	//testoString helper methods:
	// ==================================
	private static void testIfToStringMethodPrintsCorrectly() {
		printTestTitle("'toString'");
		System.out.println("This tests if the method returns all elements of this bag as a single printable String.");
		bag3.add("Mahta");
		bag3.add("Rahim");
		printExpectedOutcome("{Mahta,Rahim}");
		printActualOutcome();System.out.println(bag3.toString());
		printPassOrFail(areStringsEqual());
		addRule();
	}
	private static boolean areStringsEqual(){
		return(bag3.toString().equals("{Mahta, Rahim}"));
	}
// ==================================	
//testRemove helper methods:
// ==================================
	private static void testIfOnlyOneCopyIsRemovedOnly() {
		System.out.println("This tests if the method removes (one copy of) a string from the bag.");
		System.out.println("Removing 'A' from list:");
		bag4.add("A");bag4.add("B");bag4.add("C");bag4.add("A");bag4.add("D");bag4.add("E");bag4.add("F");
		System.out.println("Bag initially has: " + bag4.toString());
		bag4.remove("A");
		printExpectedOutcome("{B, C ,A, D, E, F}");
		printActualOutcome(); System.out.println(bag4.toString());
	}
	private static void testIfOnlyOneCopyIsRemovedFromMiddle() {
		System.out.println("Removing 'A' from list:");
		bag4.remove("A");
		printExpectedOutcome("{B, C, D, E, F}");printActualOutcome();
		 System.out.println(bag4.toString());
		 printPassOrFail("{B, C, D, E, F}".equals(bag4.toString()));
	}
	private static void testIfOnlyOneCopyIsRemovedFromTail() {
		System.out.println("Removing 'F' from the list:");
		bag4.remove("F");
		printExpectedOutcome("{B, C, D, E}");printActualOutcome();
		 System.out.println(bag4.toString());
		 System.out.println("Removing 'E' from the list:");
		bag4.remove("E");
		printExpectedOutcome("{B, C, D}");
		printActualOutcome();
		 System.out.println(bag4.toString());
		 printPassOrFail("{B, C, D}".equals(bag4.toString()));
	}
	private static void testIfOnlyOneCopyIsRemovedFromMiddleAgain() {
		System.out.println("Removing 'C' from the list:");
		bag4.remove("C");
		printExpectedOutcome("{B, D}");printActualOutcome();
		 System.out.println(bag4.toString());
		printPassOrFail(bag4.toString().equals("{B, D}"));
	}
	private static void testRemovingFromEmptyList() {
		System.out.println("Removing from empty list:");
		bag4.clear();
		System.out.println("Bag currently has: "+bag4.toString());
		System.out.println("Removing 'D' from the list:");
		bag4.remove("D");
		printExpectedOutcome("{}");
		printActualOutcome();System.out.println(bag4.toString());
		printPassOrFail(bag4.toString().equals("{}"));
		addRule();	
	}
// ==================================	
//testRemoveRandom helper methods:
// ==================================
	private static void testIfCapacityHasBeenDecreasedByOne() {
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
		printPassOrFail(bag5.size()==originalSize-1);
		addRule();
	}
// ==================================	
//testContains helper methods:
// ==================================
	private static void lookForItemThatExistsInTheBag() {
		System.out.println("This tests if the method returns true, if a string with the same contents as value exists in the bag and false otherwise.");
		printBag("Bag currently has: "+bag2.toString());
		bag6.add("AMIN");bag6.add("ALAN");bag6.add("MAYS");
		System.out.println("Looking for Mays: ");
		boolean test = bag6.contains("MAYS");
		printExpectedOutcome("TRUE");
		printActualOutcome();System.out.println(test);
		printPassOrFail(test);
	}
	
	private static void lookForItemThatDoesNotExistsInTheBag() {
		System.out.println("Look for something that does not exist: ");
		System.out.println("(Looking for 'JOE')");
		boolean test2 = bag6.contains("JOE");
		printExpectedOutcome("FALSE");
		printActualOutcome();System.out.println(test2);
		printPassOrFail(!test2);
	}
	
	private static void lookForItemIfBagIsEmpty() {
		System.out.println("test if bag is empty:");
		boolean test3 = emptyBag.contains("MIKE");
		printExpectedOutcome("false");
		printActualOutcome();System.out.println(test3);
		printPassOrFail(!test3);
		addRule();
	}
	
// ==================================	
//testIsEmpty helper methods:
// ==================================
	private static void testIfBagIsEmpty() {
System.out.println("This tests if the method returns true, if this bag is empty and false otherwise.");
		System.out.println("The bag currently has: "+bag.toString());
		printExpectedOutcome("FALSE");
		printActualOutcome(); System.out.println(bag2.isEmpty());
		printPassOrFail(!bag2.isEmpty());
		System.out.println("if bag is empty");
		printExpectedOutcome("TRUE");
		printActualOutcome(); System.out.println(emptyBag.isEmpty());
		printPassOrFail(emptyBag.isEmpty());
		addRule();
	}
	
// ==================================	
//testTrimToSize helper methods:
// ==================================
	private static void testTrimmingBagSizeFrom8to4() {
		printTestTitle("'trimToSize'");
		System.out.println("This tests if the method trims the capacity of this bag to be the bag's current size.");
		bag8.add("a");bag8.add("b");bag8.add("c");bag8.add("d");
		System.out.println("Bag currently has: "+ bag8.toString());
		System.out.println("Bag's current size is: "+ bag8.size()+" and bag's current capacity is: "+ bag8.capacity());
		System.out.println("Trimming the bag:");
		bag8.trimToSize();
		printExpectedOutcome("size=4, capacity=4");
		printActualOutcome();printSize(bag8.size());
		printCapacity(bag8.capacity());
		printPassOrFail(bag8.size()==4&&bag8.capacity()==4);
		addRule();
	}
// ==================================	
//testClear helper methods:
// ==================================
	private static void testingEmptyingTheBag() {
		printTestTitle("'clear'");
		bag3.clear();
		System.out.println("This tests if the method removes all elements from this bag.");
		printExpectedOutcome("{}");
		printActualOutcome();System.out.println(bag3.toString());
		printPassOrFail("{}".equals(bag3.toString()));
		addRule();
	}
// ==================================	
//testCopy helper methods:
// ==================================
	private static void testCopyingTheBag() {
		bag9.add("x");bag9.add("y");bag9.add("z");
		printTestTitle("'copy'");
		System.out.println("This tests if the method returns an exact duplicate of this bag.");
		bag9.copy();
		printExpectedOutcome("{x,y,z}");
		printActualOutcome();System.out.println("bag9.copy().toString()");
		Bag copiedBag = bag9.copy();
		printPassOrFail(copiedBag.toString().equals("{x,y,z}"));
		addRule();
	}
// ==================================	
//testUnion helper methods:
// ==================================	
	private static void testCombiningTwoBagsOfDifferentSized() {
		
		thisBag.add("Amin");thisBag.add("Ali");
		
		otherBag.add("Meysam");otherBag.add("Rahim"); otherBag.add("Mahta");
		printTestTitle("'union'");
		System.out.println("This tests if the method creates the union of this bag and another bag.");
		System.out.println("This bag has: "+ thisBag.toString());
		System.out.println("Other bag has: "+ otherBag.toString());
		String expectedOutcome = "{Amin, Ali, Meysam, Rahim, Mahta}";
		printExpectedOutcome(expectedOutcome);
		printActualOutcome(); System.out.println(thisBag.union(otherBag).toString());
		printPassOrFail(areTwoBagsEqual());
		addRule();
	}
	private static boolean areTwoBagsEqual()
	{
		return("{Amin, Ali, Meysam, Rahim, Mahta}" .equals(thisBag.union(otherBag).toString()));
	}
	
// ==================================	
//testEquals helper methods:
// ==================================
	
	
	
// ==================================	
//Other helper methods:
// ==================================
	private static void printPassOrFail(boolean condition) {
		if (condition == true ) {
			System.out.println("This test PASSED.");
		} else {
			System.out.println("This test FAILED.");
		}
	}

	private static void printTestTitle(String method) {
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
