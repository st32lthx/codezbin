/**
 * Driver for expression tree lab.
 * 
 * @author Chris Fernandes 
 * @version 10/26/08
 */

import java.io.*;

public class Client
{
    public void run() throws IOException
    {
	String infileName = "src/lab8input.txt";  //input file (prefix notation)
	String expectedFileName = "src/lab8expected.txt"; // expected outputs (infix notation)
	
	System.out.println("Test file: " + infileName);
	System.out.println("Expected outputs file: " + expectedFileName);
	
	
	CharReader infile = new CharReader(infileName);
        BufferedReader expectedFile = new BufferedReader(new FileReader(expectedFileName));
        BufferedReader inputFile = new BufferedReader(new FileReader(infileName));
        
        do {
	    System.out.println("--------");
	    
	    ExpressionTree test = new ExpressionTree();
	    test.build(infile);
            
	    String correctPrefix = inputFile.readLine();
	    System.out.println("Expected prefix: " + correctPrefix);
	    System.out.println("Prefix:          " + test.prefixString());
	    
	    String correctInfix = expectedFile.readLine();
	    System.out.println("Expected infix:  " + correctInfix);
	    System.out.println("Infix:           " + test.infixString());
	    
	    if (correctInfix.equals(test.infixString()) 
		&& correctPrefix.equals(test.prefixString())) {
		System.out.println("                 Passed");
	    } else {
		System.out.println("                 ***FAILED");
	    }
	    
	    infile.consumeEndOfLine();
	    
	    System.out.println("--------");
	    System.out.println();
        } while (! infile.atEOF());
        
        infile.closeFile();
    }
	
    public static void main(String[] args)
    {
    	Client c = new Client();
    	try {
	    c.run();
    	} catch (IOException e) {
	    throw new RuntimeException(e);
    	}
    }
}
