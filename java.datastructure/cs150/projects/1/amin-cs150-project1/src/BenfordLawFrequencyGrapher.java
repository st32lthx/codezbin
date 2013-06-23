/*
 * @author: Amin Meyghani
 * @date: Jan.16.2011
 * This class plots a bar graph showing the relative frequency of each of the digits when they lead off a number. 
 */
public class BenfordLawFrequencyGrapher
{
BenfordLawLeadingDigitComputer counterArray ;
	

    public BenfordLawFrequencyGrapher()
    {
    	counterArray = new BenfordLawLeadingDigitComputer();
    }
   
    public void grapher(int unitStep)
    {
        int [] arrayPrinter = counterArray.makeCounterArray();
        
        
        for(int i=0; i<10; i++)      
            if(i>0)
            {
        { 
            for (int k = 0; k<(arrayPrinter[i]/unitStep); k++)
            {
                System.out.print("*");
            }
            	System.out.println(" :"+i);
        }
            }
         System.out.println("-----------------------------");
         System.out.println("Frequency of the lead digit");
         System.out.println("Each asterik represents " + unitStep + " counts.");      
    }



}