/**
 * ExpressionTree is a binary expression tree supporting the operators
 * +, -, *, and /.  Only 1-digit operands are allowed.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class ExpressionTree
{
    private TreeNode root;    // pointer to the root node

    /**
     * Creates an expression tree (for a blank expression).
     */
    public ExpressionTree()
    {
        root = null;
    }
    
    /**
     * Builds a tree from an expression in a file.  The expression
     * input is in PREFIX notation.
     * 
     * @param filename the name of a file containing the expression
     * (in prefix notation)
     */
    public void build(CharReader infile)
    {
        root = buildSubtree(infile);
    }

    /**
     * Takes a pointer to the input file and builds an expression tree 
     * starting with the first character it reads in. 
     * Precondition: the prefix expression read by infile must be valid
     *
     * @param infile a pointer to the input file.
     * @return a pointer to the root of the subtree it builds.
     */
    private TreeNode buildSubtree(CharReader infile)
    {
int readToken = infile.readNextChar();
TreeNode node = new TreeNode((char)readToken);
if(node.value =='+'|| node.value == '-'|| node.value=='/' || node.value=='*'){
	node.llink = buildSubtree(infile);
	node.rlink =  buildSubtree(infile);
}
return node;
    }
    
    /**
     * Performs an inorder traversal, creating a string version of the
     * expression.
     *
     * @param N the root of a mathematical expression
     * @return a String with the mathematical expression for the expression 
     * starting at node N in infix notation (fully parenthesized)  
     */
    private String infixString(TreeNode N)
    {
    	String result = "";
        if (N != null) {   
	    if (!N.isLeaf()) {
		result += "(";
	    }
	    
	    result += infixString(N.llink);
	    result += N.toString();
	    result += infixString(N.rlink);
	    
	    if (!N.isLeaf()) {
		result += ")";
	    }
        }
        return result;
    }
    
    /**
     * Performs an inorder traversal, creating a string version of the
     * expression.
     *
     * @return a String with the mathematical expression in infix notation
     * (fully parenthesized)
     */
    public String infixString()
    {      
        return infixString(root);
    }
      
    /**
     * Performs a preorder traversal, creating a string version of the
     * expression.
     *
     * @param N the root of a mathematical expression
     * @return a String with the mathematical expression in prefix notation
     */
    private String prefixString(TreeNode N)
    {
    	String result = "";
        if (N != null) {    
	    result += N.toString();
	    result += prefixString(N.llink);
	    result += prefixString(N.rlink);
        }
        return result;
    }
       
    /**
     * Performs a preorder traversal, creating a string version of the
     * expression.
     *
     * @return a String with the mathematical expression in prefix notation
     */
    public String prefixString() 
    {   
        return prefixString(root);
    }
}
