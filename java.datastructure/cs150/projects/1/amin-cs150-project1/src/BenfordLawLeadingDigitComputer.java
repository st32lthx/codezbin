/*
 * @author: Amin Meyghani
 * @date: Jan.16.2011
 * This class takes a file of statistics as input, computes how many of the numbers have x as a leading
 *  digit for all x 1-9. 
 */
public class BenfordLawLeadingDigitComputer
{
		
Tokenizer tokeniser;
private int[] counters;

public BenfordLawLeadingDigitComputer()
{
    tokeniser = new Tokenizer("grass.txt");
    counters = new int[10];
}


	    public  int getFirstDigit()
	    {
	        String data = tokeniser.nextToken();
	        int firstDigit = -1;
	        if(data!=null)
	        {
	        char firstCharacter = data.charAt(0);
	        String firstCharacterString = Character.toString(firstCharacter);
	        firstDigit = Integer.parseInt(firstCharacterString);
	        }
	        return firstDigit;
	    }

	    
	    public int [] makeCounterArray()
	    {       
            int firstDigit = getFirstDigit();  
            while(firstDigit!=-1)
	            {
                counters[firstDigit]++;
                firstDigit = getFirstDigit();       
	            }               
	        return counters;
	    }
	  
	    
}