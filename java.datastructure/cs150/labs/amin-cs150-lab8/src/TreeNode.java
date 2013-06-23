/**
 * A node for an expression tree
 * 
 * @author Chris Fernandes and Aaron Cass
 * @version 10/22/2008
 */
public class TreeNode
{
    //just like ListNodes, this class and its subclasses 
    //are the only places in the Tree structure
    //where I'll let you use public instance variables.
    public char value;          //the operator or 1-digit operand
    public TreeNode llink;      //left kid
    public TreeNode rlink;      //right kid
    
    /**
     * Creates a TreeNode.
     *
     * @param newValue the value to be contained in the new node.
     */
    public TreeNode(char newValue)
    {
        super();
        value=newValue;
        llink=null;
        rlink=null;
    } 

    /**
     * @return a String representation of the node.
     */
    public String toString()
    {
        return "" + value;  //shortcut way to turn something into a String
    }
    
    /**
     * @return true iff the node is a leaf (i.e. has no children).
     */
    public boolean isLeaf()
    {
	    return ( (this.rlink == null) && (this.llink == null) );
    }
}
