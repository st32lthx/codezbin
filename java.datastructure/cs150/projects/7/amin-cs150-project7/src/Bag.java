import java.util.Random;
/**
 * @author: Amin Meyghani
 * @version: Feb/9/2011 modified on March.6.2011 to hold any "containable" object.
 * @purpose: This class contains all the methods that a Bag could 
 * implement such as add, remove, contains, etc. The Bag has been implemented using 
 * a LinkedList. 
 */
public class Bag {

	private  int size;
	 private LinkedList bag;
	public int bagCapacity;

	/**
	 * The no-default constructor for the bag. 
	 * This Creates a new bag.
	 * @param capacity is the initial capacity of the bag.
	 */
	public Bag(int capacity) {
		if(capacity==0)
		{
			System.out.println("Set capacity at least to 1");
		}
		bag = new LinkedList();
		this.bagCapacity = capacity;
	}

	/**Getter method for the number of items in the bag.
     * @return the number of items in the bag.
     */
	public int size() {
		return bag.returnSize();
	}

	/**
     * This method adds a "containable" object to the bag.  If the bag's capacity has been
     * reached, the bag will expand to twice its current capacity.
     * @param toBeAdded is the "containable" object to be added to the Bag.
     **/
	public void add(Comparable toBeAdded)
	{
		ListNode bagItem;
		bagItem = new ListNode(toBeAdded);
		bag.add(bagItem);
		if(this.size() > bagCapacity)
		{
			bagCapacity = bagCapacity * 2;
		}
	}

	/**Getter method for capacity .
     * @return the current capacity of this bag.
     */
    public int capacity()
    {
    	return bagCapacity;
    }

    /**The toString method.
     *  @return all elements of this bag as a single printable String.
     */
    public String toString()
    {
    	String content="{";   int i=0;
		while(i<size()-1)
		{
			content += getItemAtIndex(i) + ", ";   i++;
		}	
			content+=getItemAtIndex(i);
		content += "}";
		return content; 
    }

    
  /**
   * This method gets an element from the Bag at a given index.
   * @param linkedListIndex is the index from which the element is to be retrieved.
   * @return the element at a particular index in the LinkedList.
   */
    public Comparable getItemAtIndex(int linkedListIndex)
	{
		if(bag.getNodeAtIndex(linkedListIndex)!=null)
		{
			ListNode node = bag.getNodeAtIndex(linkedListIndex);
			return node.data;
		}
		else
		{
			return null;
		}
	}
    
    /**
     * This method gets a random element from the bag.
     * @param linkedListIndex is the random index in the linkedList
     * @return a random comparable element from the bag.
     */
    public Comparable getItemAtIRandomndex(int linkedListIndex)
	{
    	Random randomNumberMaker = new Random();
      	 int randomIndex = randomNumberMaker.nextInt(this.size());
		if(bag.getNodeAtIndex(linkedListIndex)!=null)
		{
			ListNode node = bag.getNodeAtIndex(linkedListIndex*randomIndex);
			return node.data;
		}
		else
		{
			return null;
		}
	}

    
   /**
    * This method removes all the elements from the Bag.
    */
    public void clear()
    {
    	bag.clearLinkedList();
    }

    /**
     * This method removes (one copy of) a "Stroable" object from the bag.
     * @param value is a containable object with the same value as the containable to
     * remove from the bag.
     */
    public void remove(Comparable value)
    {
		bag.remove(value);
    }

    
    /**
     * This method removes a random element from the bag.
     * @return the removed element, or null if the bag is empty.
     */
    public Comparable removeRandom()
    {
    	Random randomNumberMaker = new Random();
   	 int randomIndex = randomNumberMaker.nextInt(size-2);
		return getItemAtIndex(randomIndex);

    	
    }

    /**This method checks if a given element exists in the Bag.
     * @return true, if an element with the same contents as value
     * exists in the bag, false otherwise.
     * @param value is the containable object to search for.
     */
    public boolean contains(Comparable value)
    {	
		return bag.contains(value);
	}	

    
    /**A method that checks if the bag is empty or not.
     * @return true, if this bag is empty, false otherwise.
     */
    public boolean isEmpty()
    {
    	return bag.isLinkedListEmpty();
    }

    
    /**
     * This method trims the capacity of this bag to be the bag's current size.
     */
    public void trimToSize()
    {
		if(this.capacity() > this.size())
		{
			bagCapacity = this.size();
		}	
    }

    
    /**This method duplicates this bag without destroying the current bag.
     * @return an exact duplicate of this bag.
     */
    public Bag copy()
    {
    	Bag copiedBag = new Bag(5);
    	return copiedBag;
    }

    
    /**
     * Creates the union of this bag and another bag.
     * 
     * @param otherBag the other bag to union with this one.
     * @return a new Bag containing all of the elements from this bag
     * and otherBag.
     **/
    public Bag union(Bag otherBag)
    {
		int newcapacity = capacity() * 2;
		Bag newBag = new Bag(newcapacity);

		for (int b = 0; b < size(); b++) {
			newBag.add(getItemAtIndex(b));
		}
		for (int i = 0; i < otherBag.size(); i++) {
			newBag.add(otherBag.getItemAtIndex(i));
		}
		return newBag;
    }
}
