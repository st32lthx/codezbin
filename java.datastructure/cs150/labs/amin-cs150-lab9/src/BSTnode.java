/** 
 *  A not-very-reusable node class, since it only holds a String.
 *  But good enough for this lab.
 * 
 * @author Chris Fernandes
 * @version 11/5/08
 */
public class BSTnode {

    public String key;
    public BSTnode llink;
    public BSTnode rlink;
	
    // non-default constructor
    public BSTnode(String newKey)
    {
	key = newKey;
	llink = null;
	rlink = null;
    }
	
    // returns node as a printable string
    public String toString()
    {
	return key;
    }
}
