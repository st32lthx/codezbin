/**
 * An extremely scaled-down version of a PQ.  A "real" PQ would have a default
 * constructor to create an empty PQ and an insert method.  In this version,
 * a PQ can only be created by giving it a ready-made heap.  This PQ only 
 * handles ints.
 * 
 * @author Chris Fernandes
 * @version 5/13/03
 */

public class PriorityQueue
{
    private Heap PQHeap;    // the heap that holds PQ items
    
    public PriorityQueue(int [] initialValues) 
    {    
	PQHeap = new Heap(initialValues);
    }                                                 

    /**
     * @return number of ints in the PriorityQueue.
     */
    public int size() 
    {
	return PQHeap.size();
    }
    
    /**
     * Removes and returns the largest element in the PriorityQueue.
     *
     * @return the largest element.
     */
    public int remove() 
    {
        return PQHeap.deleteRoot();
    }
}
