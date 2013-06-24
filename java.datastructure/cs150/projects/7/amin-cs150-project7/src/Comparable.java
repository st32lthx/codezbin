/**
*@author Amin Meyghani 
*@version March.05.2011
*@purpose This interface represents a general object that can be compared and what 
*a tree node can hold.
 */
public interface Comparable
{
/**
 * This method compares this object with the other object.
 * @return 0 if this key is equal to the other one, -1 if smaller and 1 if this key 
 * is larger than the other one.
 */
    public int compareThisTo(Comparable otherKey);

	/**
	 * This method makes comparison between Comparables possible. 
	 * @param otherComparable is the object that this Comparable object 
	 * is compared to.
	 * @return true if the two objects are equal and false otherwise.
	 */

    public boolean equals(Object otherComparable);
/**
 * This is the toString method that converts a Comparable object 
 * to a printable string.
 * @return the string representing the Comparable object.
 */
    public String toString();
}
