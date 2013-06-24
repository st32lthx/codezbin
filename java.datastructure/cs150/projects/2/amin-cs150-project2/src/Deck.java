/*
 * @Author: Amin Meyghani
 * @Date: Jan.24.2011
 * Purpose: This class creates a deck of paying cards.
 */
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  	
import java.util.Random;
public class Deck 
{
	private Card[] cardDeck;
	private int deckTracker;
//-----------------------------------------------------------------------------------------------  	
	public Deck()
	{
		deckTracker = 0;
		cardDeck = new Card[52];
		this.makeDeckOfCards();
	}	
//------------------------------------------------------------------------------------------  	
	public void makeDeckOfCards()
	{
		for (int i=0; i<13; i++)
		{
				for(int k=0;k<4;k++)
				{
				Card card = new Card(i+1 ,k);
				cardDeck[i + (13 * k)]=card;
				}
		}
	}
//----------------------------------------------------------------------------------------------------  	
	public String toString()
	{
		String cardNames = "";
		for(int i=0;i<cardDeck.length; i++)
		{
		cardNames+=cardDeck[i].toString()+"\n"; 
		}
		return cardNames;
	}
//----------------------------------------------------------------------------------------------------  	
	public String getCurrentAvailabeCardsInDeck()
	{
		String cardNames = "";
		for(int i=deckTracker;i<cardDeck.length; i++)
		{
		cardNames+=cardDeck[i].toString()+"\n"; 
		}
		return cardNames;
	}

//--------------------------------------------------------------------------------------------------------  
public int getDeckTracker()
{
	return deckTracker;
}
//--------------------------------------------------------------------------------------------------------  

	public Card dealCard()
	{
		if(deckTracker<52)
		{
		Card currentCard  = cardDeck[deckTracker];
		deckTracker++;
		return currentCard;
		}
		else
			return null;
	}
//--------------------------------------------------------------------------------------------------------  	
	public void shuffleCards()
	{
		Random randomizer = new Random();  
		for (int i=0; i<cardDeck.length; i++) 
			{
			    int randomIndex = randomizer.nextInt(cardDeck.length);
			    Card temporaryValueHolder = cardDeck[i];
			    cardDeck[i] = cardDeck[randomIndex];
			    cardDeck[randomIndex] = temporaryValueHolder;
			}		
	}
//-----------------------------------------------------------------------------------------------------------  	

}
