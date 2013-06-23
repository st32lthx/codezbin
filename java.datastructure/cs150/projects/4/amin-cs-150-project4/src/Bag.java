import java.util.Random;
/*
 * @Author: Amin Meyghani
 * @Date: Feb/9/2011
 * @Purpose: This class contains all the methods of the bag.
 */
//===============================================
public class Bag {

	private  int size;
	private  String[] items;
	 String[] newBag;

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
		size = 0;
		items = new String[capacity];
	}
	
	/**
     * @return the number of items in the bag.
     */
	public int size() {
		int sizeCounter=0;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				sizeCounter++;
			}
		}
		return sizeCounter;
	}
	
	
	/**
     * Adds a string to the bag.  If the bag's capacity has been
     * reached, the bag will expand to twice its current capacity.
     * @param value the string to add.
    **/
    public void add(String value)
    {
    	
    	if(size()==capacity()){
    		newBag = new String[capacity()*2];
    		newBag [size] = value;
    		size++;
    		copyFromOldBag();
        	items = newBag;
    	}
    	else{
    		items[size]=value;
    		size++;
    	}
    }
    
    
 
    /**
     * @return the current capacity of this bag.
     */
    public int capacity()
    {
	return items.length;
    }

    /**
     *  @return Returns all elements of this bag as a single printable String.

     */
    public String toString()
    {
    	String toReturn="{";
    	
    	for (int i = 0; i < items.length; i++) {
	        	if(items[i]!=null){
	    		 toReturn+=items[i]+",";	 
			}
    	}
    	toReturn = toReturn.substring(0,toReturn.length()-1)+"}";
		return toReturn;
    }

    /**
     * Removes all elements from this bag.
     */
    public void clear()
    {
    	int indexFollower = 0;
    	while(size()>=indexFollower)
    	{
    		items[indexFollower]=null;
    		size--;
    		indexFollower++;
    	}
    }
    
    /**
     * Removes (one copy of) a string from the bag.
     * @param value a string with the same value as the string to
     * remove from the bag.
     */
    public void remove(String value)
    {
   
   		boolean wasFound = false;
   		int itemIndex =0;
   		while(wasFound == false && itemIndex<items.length)
   		{	
   			if(size()!=0&&items[itemIndex].equals(value))
   			{
   				items[itemIndex] = null;
   				shiftElementToLeft(itemIndex);
   				items[items.length-1]=null;
   				wasFound = true;
   				size--;
   			}
   			else{
   				System.out.print("");
   			}
   			itemIndex++;
   		}		
    }
  	
    
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
       	removedString =  items[randomIndex];
    	 items[randomIndex]=null;
    	 shiftElementToLeft(randomIndex);
    	 size--;
		return removedString;
    	}
		return null;
    }
    
    /**
     * @return true, if a string with the same contents as value
     * exists in the bag, false otherwise.
     * @param value the value to search for.
     */
    public boolean contains(String value)
    {	
    	boolean doesContain = false;
    	int indexLocator = 0;
		boolean checkcontains = false;
		while(indexLocator < size()&& checkcontains == false )
		{
			if(items[indexLocator].equals(value))
			{
				doesContain = true;
				checkcontains = true;
			}
			indexLocator++;
		}
		return doesContain;
	}	
    
    /**
     * @return true, if this bag is empty, false otherwise.
     */
    public boolean isEmpty()
    {
    	return(items[0]==null);
    }

    /**
     * Trims the capacity of this bag to be the bag's current size.
     */
    public void trimToSize()
    {
		String [] tempArray = new String[size()];
		if(capacity() > size())
		{
			tempArray = items;
			items = new String[size()];
			items = tempArray;
			
		}
    	
    }
    
    /**
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
     
    public Bag union(Bag otherBag)
    {
	
    }
}
*/
//=====================================

private void shiftElementToLeft(int index){
	for(int i=index; i<items.length-1;i++)
	{
		items[1+(i-1)]=items[1+i];
		items[1+i]=items[1+(i-1)];
	}
	
}
    
private void copyFromOldBag(){
	for (int i = 0; i < items.length; i++) {
		newBag[i]=items[i];
	}
}

	 
	//
}
