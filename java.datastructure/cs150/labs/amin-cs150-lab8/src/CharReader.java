/**
 * The CharReader class lets you read in characters from an input file.
 * Characters are returned as their integer values.
 * 
 * @author Chris Fernandes with mods by Aaron Cass
 * @version 2/14/08
 */

import java.io.*;

public class CharReader
{
    
    private BufferedReader in;

    //Give the name of the input file as a String during construction.
    public CharReader(String in)
    {
        super();
        try {
            File inputFile = new File(in);
            this.in = new BufferedReader(new FileReader(inputFile));
        } catch (IOException e) {
        	System.out.println("I/O error in constructor");
        }
    }
    
    /**
     * Reads a character from the input file, returning it as an int.
     * (if you want a char, use an explicit cast)
     *
     * @return the next character in the file.  If the end of file has
     * been reached, returns -1.
     */
    public int readNextChar()
    {
        int c=-1;
        try {
            c = in.read();           
        } catch (IOException e) {
    	    System.out.println("error during read");
        }

        return c;
    }

    /**
     * Consumes characters until the end of the current line.  The
     * next character read with readNextChar will be the first one on
     * the next line.
     */
    public void consumeEndOfLine()
    {
    	int c;
    	try {
	    in.readLine();
    	} catch (IOException e) {
    	}
    }
    
    /**
     * @returns true iff the file has reached the end of file marker.
     */
    public boolean atEOF()
    {
    	try {
	    in.mark(1);
	    int c = in.read();
	    if (c == -1) {
		return true;
	    } else {
		in.reset();
		return false;
	    }
    	} catch (IOException e) {
    	    return true;
    	}
    }

    /**
     * Closes the file.
     */
    public void closeFile()
    {
        try {
            in.close();
        } catch (IOException e) {
	    System.out.println("I/O error in closing");
	}
    }
}
