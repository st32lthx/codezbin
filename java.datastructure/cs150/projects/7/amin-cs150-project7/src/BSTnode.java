/** What a node in a Binary Search Tree looks like.  This particular
 *  node is good for implementing a table, where each key has
 *  some associated data with it.
 *  
 *  @author Chris Fernandes
 *  @version 11/1/08
 */
public class BSTnode 
{
    //just like ListNodes, this class is the only place where I'll let
    //you use public instance variables.
	
    /** 
     * node's key must be comparable to be in a BST
     */
    public Comparable key;
    
    /** 
     * node holds other data that BST doesn't need to know about
     */
    public Object data;
    
    /**
     * left kid
     */
    public BSTnode llink; 
    
    /** 
     * right kid
     */
    public BSTnode rlink;   
    
    /**
     *  default constructor
     */
    public BSTnode()
    {
        super();
        key=null;
        data=null;
        llink=null;
        rlink=null;
    } 

    /**
     * non-default constructor: key only
     *
     * @param value key of this node
     */
    public BSTnode(Comparable value)
    {
        super();
        key = value;
        data=null;
        llink=null;
        rlink=null;
    }
    
    /**
     * non-default constructor: key and data
     * 
     * @param value key of this node
     * @param newData associated data in this node
     */
    public BSTnode(Comparable value, Object newData)
    {
        super();
        key = value;
        data=newData;
        llink=null;
        rlink=null;
    }

    /** 
     * @return this node as a printable string.  It does this by
     * calling toString of the Comparable key (which must exist since
     * toString is in the interface) and toString of the Object (which
     * is a method of Object, but should be overridden by the actual
     * data object that is being stored).
     */
    public String toString()
    {
    	return key.toString() + " - " + data.toString();
    }

    /** 
     * @return true iff this node is a leaf node
     */
    public boolean isLeaf()
    {
        return (llink==null && rlink==null);
    }

}
