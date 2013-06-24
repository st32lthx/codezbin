import java.util.Random;
/*
 * @Author: Amin Meyghani
 * @Date: Feb/9/2011
 * @Purpose: This class contains all the methods of the bag.
 */
//===============================================
public class Bag {

	private  int size;
	 private BagLinkedList bag;
	public int bagCapacity;

	/**
	 * Creates a new bag.
	 * 
	 * @param capacity
	 *            the initial capacity of the bag.
	 */
	public Bag(int capacity) {
		if(capacity==0)
		{
			System.out.println("Set capacity at least to 1");
		}
		bag = new BagLinkedList();
		this.bagCapacity = capacity;
	}
//===============================================
	/**Getter method for the number of items in the bag.
     * @return the number of items in the bag.
     */
	public int size() {
		return bag.returnSize();
	}
//===============================================	
	/**
     * Adds a string to the bag.  If the bag's capacity has been
     * reached, the bag will expand to twice its current capacity.
     * @param value the string to add.
     **/
	public void add(String value)
	{
		BagListNode bagItem;
		bagItem = new BagListNode(value);
		bag.add(bagItem);
		if(this.size() > bagCapacity)
		{
			bagCapacity = bagCapacity * 2;
		}
	}
//===============================================
    /**Getter method for capacity .
     * @return the current capacity of this bag.
     */
    public int capacity()
    {
    	return bagCapacity;
    }
 //===============================================
    /**
     *  @return Returns all elements of this bag as a single printable String.
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
  //===============================================
    /**
     * This method returns the string at a given index
     */
    public String getItemAtIndex(int linkedListIndex)
	{
		if(bag.getNodeAtIndex(linkedListIndex)!=null)
		{
			BagListNode node = bag.getNodeAtIndex(linkedListIndex);
			return node.data;
		}
		else
		{
			return "";
		}
	}
 //===============================================
    /**
     * Removes all elements from this bag.
     */
    public void clear()
    {
    	bag.clearLinkedList();
    }
//===============================================
    /**
     * Removes (one copy of) a string from the bag.
     * @param value a string with the same value as the string to
     * remove from the bag.
     */
    public void remove(String value)
    {
		bag.remove(value);
    }
//===============================================
    /**
     * Removes a random element from the bag.
     * @return the removed element, or null if the bag is empty.
     */
    public String removeRandom()
    {
    	if(size!=0){
    	String removedString;
    	Random randomNumberMaker = new Random();
    	 int randomIndex = randomNumberMaker.nextInt(size);
       	removedString =  getItemAtIndex(randomIndex);
    	 bag.remove(removedString);
    	 size--;
		return removedString;
    	}
		return null;
    }
    //===============================================
    /**
     * @return true, if a string with the same contents as value
     * exists in the bag, false otherwise.
     * @param  the value to search for.
     */
    public boolean contains(String value)
    {	
		return bag.contains(value);
	}	
//===============================================
    /**A method that checks if the bag is empty or not.
     * @return true, if this bag is empty, false otherwise.
     */
    public boolean isEmpty()
    {
    	return bag.isLinkedListEmpty();
    }
    //===============================================
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
 //===============================================
    /**This method duplicates this bag without destroying the current bag.
     * @return an exact duplicate of this bag.
     */
    public Bag copy()
    {
    	Bag copiedBag = new Bag(5);
    	return copiedBag;
    }
 //===============================================
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
//===============================================
}
