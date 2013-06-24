/**
 * The StringWriter class lets you write strings to an output file.
 * 
 * @author Chris Fernandes
 * @version 10/30/08
 */

import java.io.*;

public class StringWriter
{ 
    final int CR = 13;          //Carriage Return
    final int LF = 10;          //Line Feed
	
    private FileWriter out;     //file descriptor
    
    /** 
     * Creates a StringWriter to write to a file.  
     * 
     *  @param out the name of the file to be written to.  Once again,
     *   use forward slashes between directories.  For example,
     *   "src/output.txt"
     */
    public StringWriter(String out)
    {
        super();
        try {
            File outputFile = new File(out);
            this.out = new FileWriter(outputFile);
        } catch (IOException e) {
	    System.out.println("I/O error in constructor");
	}
    }

    /** 
     * Appends the given char c to the output file.  
     * 
     * @param c the int (ASCII) value of the char to be written.  If you
     * have an actual char to write out, explicitly cast it to an int
     * before calling this method.
     */
    private void writeNextChar(int c)
    {
        try {
            out.write(c);           
        } catch (IOException e) {
	    System.out.println("error during write");
	}
    }
    
    /** 
     * Brings cursor to start of next line in the output file.
     */
    public void goToNextLine() 
    {
    	writeNextChar(CR);
    	writeNextChar(LF);
    }
    
    /** 
     * Writes given string s to the output file.
     * 
     * @param s string to write out
     */
    public void write(String s)
    {
    	for (int i=0; i<s.length(); i++) {
	    writeNextChar((int)s.charAt(i));
    	}
    }

    /** 
     * Closes the output file.  WARNING: nothing will be written to
     * your output file until you close it!  So be sure to call this
     * method once you are completely done writing to the file.
     */
    public void closeFile()
    {
        try {
            out.close();
        } catch (IOException e) {
	    System.out.println("I/O error in closing");
	}
    }
}
