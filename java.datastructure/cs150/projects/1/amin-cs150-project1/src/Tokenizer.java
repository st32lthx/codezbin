import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/** Tokenizer takes a text file and parses it into individual tokens,
 * returning each as a string.  The expected format of the text file is
 * to have comments at the top of the file, in (* ... *) format, 
 * which are ignored by the Tokenizer.  The tokens then follow, one per line.
 * 
 * @author Chris Fernandes
 * @version 7/30/08
 *
 */
public class Tokenizer
{

				private Scanner sc;
			
			/** Constructor specifying the file to tokenize.  
			 *  Anything between (* and *) at the top of the file will
			 *  be ignored, and line terminators are delimiters.
			 * 
			 * @param filename absolute or relative path to the file to be tokenized.
			 * Examples: "input.txt" or "C:/input.txt"
			 */
				public Tokenizer(String filename)
				{
							try 
							{
							sc = new Scanner(new File(filename));
							sc.useDelimiter(Pattern.compile("\\(\\*.*\\*\\)|\\n|\\r",Pattern.DOTALL));	        
							} 
								catch (FileNotFoundException e) 
								{
								System.out.println(filename + " not found");
								}
					}
			
				/** Returns the next token as long as it's not an empty string.
				  * 
			      * @return the next unread token that is not "", 
			      * or null when end-of-file is reached
				  */ 
				public String nextToken()
					{
								while (sc.hasNext(""))  //get rid of empty strings
					    		sc.next();
								if (sc.hasNext())
								return sc.next();
								else  
								return null;
					}
	}