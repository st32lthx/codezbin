/**
 * Driver for Lab 9
 * 
 * @author Chris Fernandes with mods by Aaron Cass
 * @version 3/2/2011
 */
public class Client {
	public static void main(String[] args) {
		Client c = new Client();
		c.insertTests();
		c.searchTests();
		c.nodeCountTests();
	}

	// tests insert method
	public void insertTests() {
	

		printTestTitle("insert", "with no node");
		BinarySearchTree noNodeTree = new BinarySearchTree();
		printExpectedValue(" ");
		printActualValue(" ");
		System.out.println(noNodeTree);

		printTestTitle("insert","with 1 node");
		BinarySearchTree oneNodeTree = new BinarySearchTree();
		oneNodeTree.insert("ab");
		System.out.println(oneNodeTree);
		
		printTestTitle("Insert","with 4 nodes");
		BinarySearchTree testTree = new BinarySearchTree();
		testTree.insert("buy");
		testTree.insert("and");
		testTree.insert("the");
		testTree.insert("but");
		System.out.println(testTree);
		
		printTestTitle("insert", "with 10 nodes");
		BinarySearchTree tenNodeTree = make10NodeTree();
		System.out.println(tenNodeTree + "\n");
		
		printTestTitle("insert","with already existing node");
		BinarySearchTree newTestTree = new BinarySearchTree();

		newTestTree.insert("the");
		newTestTree.insert("but");
		newTestTree.insert("but");

		System.out.println(newTestTree+"\n");
		

//		printTestTitle("insert", "with 10000 nodes");
//		BinarySearchTree tenThousandNodeTree = make10000NodeTree();
//		System.out.println(tenThousandNodeTree + "\n");

		
	}

	// tests search method
	public void searchTests() {
		BinarySearchTree testTree = new BinarySearchTree();
		printTestTitle("search");
		testTree.insert("buy");
		testTree.insert("and");
		testTree.insert("the");
		testTree.insert("but");
		System.out.println(testTree.search("buy"));
		System.out.println(testTree.search("the"));
		System.out.println("search method failed for nodes after the root");

	}

	public void nodeCountTests() {

		BinarySearchTree noNodeTree = new BinarySearchTree();
		printTestTitle("nodeCount", "with no nodes");
		printExpectedValue("0");
		printActualValue(noNodeTree.nodeCount());

		BinarySearchTree treeWithOneNode = new BinarySearchTree();
		treeWithOneNode.insert("firstNode");
		printTestTitle("nodeCount", "with one node");
		printExpectedValue("1");
		printActualValue(treeWithOneNode.nodeCount());

		BinarySearchTree fourNodeTree = new BinarySearchTree();
		fourNodeTree.insert("AB");
		fourNodeTree.insert("AC");
		fourNodeTree.insert("AD");
		fourNodeTree.insert("AE");
		printTestTitle("nodeCount", "with four nodes");
		printExpectedValue("4");
		printActualValue(fourNodeTree.nodeCount());

		BinarySearchTree tenThousandNodeTree = make10000NodeTree();
		printTestTitle("nodeCount", "with 10000 nodes");
		printExpectedValue("10000");
		printActualValue(tenThousandNodeTree.nodeCount());

	}

	// ---------------------------------------------------------
	private void printExpectedValue(String expected) {
		System.out.println("The expected value is " + expected);
	}

	private void printTestTitle(String title, String treeCase) {
		System.out.println("Testing the " + title + " method " + treeCase
				+ " :");
	}

	private void printTestTitle(String title) {
		System.out.println("Testing the " + title + " method:" + "\n");
	}

	private void printActualValue(int actualValue) {
		System.out.println("Actual value is " + actualValue + "\n");
	}

	private void printActualValue(String actualValue) {
		System.out.println("Actual value is " + actualValue + "\n");
	}

	private BinarySearchTree make10NodeTree() {
		BinarySearchTree tenNodeTree = new BinarySearchTree();
		String[] arrayOfStrings = new String[10];
		for (int i = 0; i < arrayOfStrings.length; i++) {
			arrayOfStrings[i] = "A" + i;
		}
		for (int i = 0; i < 10; i++) {
			tenNodeTree.insert(arrayOfStrings[i]);
		}
		return tenNodeTree;
	}

	private BinarySearchTree make10000NodeTree() {
		BinarySearchTree tenThousandNodeTree = new BinarySearchTree();
		String[] arrayOfStrings = new String[10000];
		for (int i = 0; i < arrayOfStrings.length; i++) {
			arrayOfStrings[i] = "x" + i;
		}
		for (int i = 0; i < 10000; i++) {
			tenThousandNodeTree.insert(arrayOfStrings[i]);
		}
		return tenThousandNodeTree;
	}
}
