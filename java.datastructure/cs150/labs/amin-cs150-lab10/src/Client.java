/**
 * Be sure to test your code out with various different binary trees.
 * A sample of one is below.
 * 
 * @author Chris Fernandes, Linda Almstead, Aaron Cass
 * @version 11/8/2008
 */

public class Client
{
    public static void main(String [] args)
    {
    	Client tester = new Client();
	
    	tester.testHeap();
    	tester.testSorter();
    }

    public void testHeap()
    {
		int[] anArray = { 9, 12, 5, 1, 23, 33, 9, 21, 14, 10 };
		printResult(anArray);
		int[] Array2 = { 26, 15, 20, 30, 22, 28, 48, 1, 27, 50 };
		printResult(Array2);
		int[] Array3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		printResult(Array3);
		int[] Array4 = { 95, 51, 19, 72, 42, 74, 57, 50, 18, 57, 1, 81, 82, 79,0 };
		printResult(Array4);
        
    }

    public void testSorter()
    {
        int[] anArray = {9, 12, 5, 1, 23, 33, 9, 21, 14, 10};
        
        System.out.println("\nbefore sorting:");	
        printArray(anArray);

        Sorter mysorter = new Sorter();
        mysorter.priorityQueueSort(anArray);

        System.out.println("\nafter sorting:");
        System.out.println(mysorter);
        
      
    }
    
    private void printArray(int[] array) 
    {
    	int len = array.length;
    	for (int i = 0; i < len - 1; i++) {
	    System.out.print(array[i] + " ");
    	}
    	System.out.println(array[len-1]);
    }
    /**
     * This method prints out the result of building a heap out of a binary search tree.
     * @param anArray
     */
    private void printResult(int[] anArray){
    	 System.out.println("before building heap:");	
         printArray(anArray);
 	
         Heap sample = new Heap(anArray);

         System.out.println("\nafter building heap:");
         System.out.println(sample);
    }
}
