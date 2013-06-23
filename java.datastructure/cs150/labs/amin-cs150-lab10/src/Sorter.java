
/**
 * Sorts items using a PQ.  The primary method is priorityQueueSort which takes a heap
 * for use in the PQ.
 * 
 * @author Chris Fernandes
 * @version 5/13/03
 */
public class Sorter
{
    private int[] A;  // array to store the result
    
    public Sorter()
    {
	A = new int[0];  // will be overwritten by priorityQueueSort
    }

    /**
     * Sorts the elements in the heap.  This is pretty easy
     * if you use a priority queue.  Just make a PQ out of
     * the heap and then remove all of the items (since they'll
     * come out in sorted order)!
     *
     * @param H the heap to sort.
     */
    public void priorityQueueSort(int [] array)
    {  
	A = new int[array.length];
	int n = A.length;         
	
	PriorityQueue PQ = new PriorityQueue(array); 
	
	for (int i = n - 1; i >= 0; i--) {
	    A[i] = PQ.remove();
	}
    }
    
    /** 
     *  returns the items as a printable string
     */
    public String toString()
    {
	String result = "";
	
	for (int j=0; j< A.length - 1; j++) {
	    result += A[j] + " ";
	}
	result += A[A.length - 1];
	
	return result;
    }
}
