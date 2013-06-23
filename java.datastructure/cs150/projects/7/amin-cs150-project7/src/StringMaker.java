/**
*@author Amin Meyghani
*@version March.05.2011
*@purpose This makes the Binary Search Tree and its subclasses to be able to hold String 
as the their contents.
 */
public class StringMaker implements Comparable
{
    
	private String key; 
   
      
    public StringMaker(String value) //setting the key to StringMaker's argument.
    {
        key = value.toLowerCase(); 
    }
    
      /**
       * This is the toString method that returns a StringKey as a
       * printable string.
       */
    public String toString() 
    {
        return key;  
    }

    /**
     * This method compares two keys. It returns 0 if both are equal, -1 if the first key is smaller 
     * and 1 if the first key is larger than the second key.
     */
	public int compareThisTo(Comparable otherKey) {
		
		String firstKey = this.key;
        String secondKey = ((StringMaker)otherKey).key;
        return firstKey.compareTo(secondKey);
	}
}
