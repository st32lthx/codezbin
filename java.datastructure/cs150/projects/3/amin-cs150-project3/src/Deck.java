/*
 * ********************************************************************************************************
 * @Author: Amin Meyghani
 * 	@Date: Jan.24.2011
 * Purpose: This class creates a deck of paying cards.
 *                                                       
 * ********************************************************************************************************
 */
import java.util.Random;
	public class Deck 
	{
		private Card[] cardDeck;
		protected int deckTracker;
		
		public Deck(int num)
		{
			deckTracker = 0;
			cardDeck = new Card[num*52];
			this.makeDeckOfCards(num);
		}	
/*
 * ********************************************************************************************************
 *                                                   Methods
 *                                                       
 * ********************************************************************************************************
 */
	
//----------------------------------------------------------------------------------------------------- 	
		public int getDeckTracker()
		{
			return deckTracker;
		}
//----------------------------------------------------------------------------------------------------- 	
		public void getNamesOfCurrentCards()
		{
			getCurrentCards();
		}
//----------------------------------------------------------------------------------------------------- 	
		public Card dealCards()
		{
			return dealCard();
		}
//----------------------------------------------------------------------------------------------------- 	
		public void shuffleDeck()
		{
			shuffleCards();
		}
/*
 * ********************************************************************************************************
 *                                                    Method Definitions
 *                                                       
 * ********************************************************************************************************
 */ 	
/*A method to make a deck of cards.
 * The card objects are stored in the array called cardDeck.
 */
		private void makeDeckOfCards(int num)
		{
			for(int j = 0; j < num; j++)
			{
				for (int i=0; i<13; i++)
				{
					for(int k=0;k<4;k++)
					{
					Card card = new Card(i+1 ,k);
					cardDeck[(i + (13 * k)) + (j*52)]=card;
					}
				}
			}
		}
//*************************************************************************************		
/*The to String method
 * The toString method that prints all the cards in the deck
 */
		public String toString()
		{
			String cardNames = "";
			for(int i=0;i<cardDeck.length; i++)
			{
				cardNames+=cardDeck[i].toString()+"\n"; 
			}
			return cardNames;
		}
//*************************************************************************************		

/*A method that prints the current available cards in the deck.
 * @return: cardNames;
 */
		private String getCurrentCards()
		{
			String cardNames = "";
			for(int i=deckTracker;i<cardDeck.length; i++)
			{
				cardNames+=cardDeck[i].toString()+"\n"; 
			}
			return cardNames;
		}
//*************************************************************************************		

/*A method that deals a card
 * @return: currentCard.
 */	
		private Card dealCard()
		{	
					
				Card currentCard  = cardDeck[deckTracker];
				deckTracker++;
				return currentCard;
					
		}
		
//*************************************************************************************		
/*A method that shuffles the card deck
 * The array of cards are shuffled when this method is called.
 */	
		private void shuffleCards()
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
//*************************************************************************************		

/*A method to check if the deck is empty.
		 * 
		 */
				public boolean isDeckEmpty()
				{
					return(checkDeckTracker()!=51);
				}
				
				private int checkDeckTracker()
				{
					return deckTracker;
				}
//************************************END********************************************
}
