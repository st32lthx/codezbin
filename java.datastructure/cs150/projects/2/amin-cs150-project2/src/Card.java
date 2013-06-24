/*
 * @Author: Amin Meyghani
 * @Date: Jan.24.2011
 * Purpose: This class creates a playing card as a Java object.
 */
//--------------------------------------------------------------------------------------------------------------------  	
public class Card
{
	private  int valuePosition;
	private  int suitPosition;
	private  static String[] cardSuit =  {"clubs", "diamonds", "hearts", "spades"};
	private  static String[] cardValue = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "ten", "jack", "queen", "king"}; 
//---------------------------------------------------------------------------------------------------------------------  	
	public Card(int valueFinder, int suitFinder)
	{
		valuePosition = valueFinder;
		suitPosition = suitFinder; 
	}
//----------------------------------------------------------------------------------------------------------  		
	public String toString( )
	{
		return cardValue[valuePosition-1] + " of " +cardSuit[suitPosition];
	}
//--------------------------------------------------------------------------------------------------------------  		
	public String getCardSuit( )
	{
		return cardSuit[suitPosition];
	}
//----------------------------------------------------------------------------------------------------------  		

}