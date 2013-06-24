/**
 * The LineReader class lets you read and parse an input file
 * one line at a time.
 * 
 * @author Chris Fernandes
 * @version 11/2/08
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineReader 
{
    private Scanner sc;
    private String delimiter;
    
    /** 
     * Constructor.
     * 
     * @param file path to file to read.  For example,
     * "C:/project7/input.txt".  Use forward slashes to
     * separate directories (folders) and don't forget the quotes.
     *
     * @param delimiter When reading lines, delimiter is used to parse the tokens.
     * For example, "," should be used for a comma-delimited file (like in 
     * a thesaurus). " " should be used where spaces separate words (like
     * in an input file to be grammar-checked).
     */
    public LineReader(String file, String delimiter) {
	try {
	    sc = new Scanner(new File(file));
	    this.delimiter = delimiter;
	} catch (FileNotFoundException e) {
	    System.out.println("file not found error");
	}
    }

    /** 
     * Returns next line of input file as an array of strings.  For a
     * thesaurus input file, the first position in the array will hold
     * the keyword and the remaining positions will be synonyms of the
     * keyword.  Returns null if end-of-file (EOF) is reached.
     *  
     * @return line of input as array of strings
     */
    public String[] getNextLine()
    {
	if (sc.hasNextLine()) {
	    return sc.nextLine().split(delimiter);
	} else {
	    return null;
	}
    }
	
    /** 
     * Closes this LineReader.
     * 
     */
    public void close()
    {
	sc.close();
    }
}