/*
 * ********************************************************************************************************
 * @Author: Amin Meyghani
 * 	@Date: Jan.24.2011
 * Purpose:This class represents a playing card.
 *                                                       
 * ********************************************************************************************************
 */
public class Card
{
			private  int valuePosition;
			private  int suitPosition;
			private  static String[] cardSuit =  {"clubs", "diamonds", "hearts", "spades"};
			private  static String[] cardValue = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
			
			public Card(int valueFinder, int suitFinder)
			{
				valuePosition = valueFinder;
				suitPosition = suitFinder; 
			}
/*
 * ********************************************************************************************************
 *                                                   Methods
 *                                                       
 * ********************************************************************************************************
 */	
	public String toString( )
	{
		return cardValue[valuePosition-1] + " of " +cardSuit[suitPosition];
	}
//----------------------------------------------------------------------------------------------------- 	
	public String getCardSuit( )
	{
		return cardSuit[suitPosition];
	}
//************************************END********************************************
	
}