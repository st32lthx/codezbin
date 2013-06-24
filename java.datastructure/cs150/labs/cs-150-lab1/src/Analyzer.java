/* Class to analyze simulated purchase trends from a department store.
 * 
 */
public class Analyzer {
	
public void numberCruncher()
{
		//defining the variables
		
		int polygon = 14;
		double totalSaving = 3400.45;
		char subWay = 'E';
		boolean isMarried = false;
		
		//Printing out
		
		System.out.println("The parameter of the polygon is " + polygon); 
		System.out.println("Total Savings = "+ totalSaving); 
		System.out.println("The Subway Line is " + subWay); 
		if (isMarried)
		{
			System.out.println("They are not married");
		}
		else 	
		{
			System.out.println("They are married");
		}
	
}	
public void purchaseAnalyzer(double[] purchase, double min, double max)
{
	
		//comparing purcahse values to min / max values

		if (purchase[0] > max && purchase[1] > max && purchase[2] > max )	
		{
			System.out.println("We had a great morning!!! The three purchases were " + purchase[0] + " , " + purchase[1] + " and "  + purchase[2]);
		}
		else if (purchase[0] <= min || purchase[1] <= min || purchase[2] <= min)
		{
			System.out.println("We had a bad morning!!!!!");	
		}
}

	public void inDepthAnalyzer(double[] purchase, double min, double max)
{		
		//Job#1: Finding the first purcahse that is larger than the max.
		
		int i=0;
		while (i<purchase.length && purchase[i]<=max)
		{
			i++;  
		}
		if(i<purchase.length && purchase[i]>max)
		{	
			System.out.println("The amount of the purchase is "+ purchase[i] + " and the index number is " + i);
		}
		else
		{
			System.out.println("The first good purchase of the day does not exist");
		}
		
		//Job#2: Finding the number of good purchase greater than max before the first bad purchase.
		
		int k=0;
		int counter = 0;
		while(k<purchase.length && purchase[k]>min)
		{
			if(purchase[k]>max)
			{
				counter++;
			}
			
			k++;	
		}
		
		System.out.println("There are  " + counter + " good purchase(s).");		
}

	/** a really dumb way of printing the entire array
	 * 
	 *  purchase is a chronological collection of purchases
	 */
	public void printer(double[] purchase)
	{
		System.out.println();
		System.out.println("purchase[0]: " + purchase[0]);
		System.out.println("purchase[1]: " + purchase[1]);
		System.out.println("purchase[2]: " + purchase[2]);
		System.out.println("purchase[3]: " + purchase[3]);
		System.out.println("purchase[4]: " + purchase[4]);
		System.out.println("purchase[5]: " + purchase[5]);
		System.out.println("purchase[6]: " + purchase[6]);
		System.out.println("purchase[7]: " + purchase[7]);
		System.out.println("purchase[8]: " + purchase[8]);
		System.out.println("purchase[9]: " + purchase[9]);
	}
	
}
