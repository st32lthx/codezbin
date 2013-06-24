/*
 * @Author: Amin Meyghani
 * @Date: Jan.24.2011
 * Purpose: This class  plays simulates the game.
 */
//-------------------------------------------------------------------------------------------------  	
public class SolitaireSimulator 
{
	private   Deck cardDeck;
	private   Card[] cardsOnTable;
	private   int numberOfCardsOnTable;
//---------------------------------------------------------------------------------------------------  	
	public SolitaireSimulator ()
     	{
     		cardDeck= new Deck();	
     		cardsOnTable = new Card[52];
     		numberOfCardsOnTable = 0;
     	}
//----------------------------------------------------------------------------------------------------  			
     	public void playGame()
     	{
     		cardDeck.shuffleCards();
     			 checkCondition();
		} 
//----------------------------Deal Methods--------------------------------------------------------	
     	public  void dealOneCard()
    	{
     		cardsOnTable[numberOfCardsOnTable]=cardDeck.dealCard();
     		if(cardsOnTable[numberOfCardsOnTable]==null)
     		{
     			System.out.println("check");
     		}
     		
    	}
     	public void dealTwoCards()
    	{
     		cardsOnTable[numberOfCardsOnTable]=cardDeck.dealCard();
          	numberOfCardsOnTable++;
     		cardsOnTable[numberOfCardsOnTable]=cardDeck.dealCard();
    	}
     	
     	public  void dealThreeCards()
    	{
     		cardsOnTable[numberOfCardsOnTable]=cardDeck.dealCard();
          	numberOfCardsOnTable++;
     		cardsOnTable[numberOfCardsOnTable]=cardDeck.dealCard();
          	numberOfCardsOnTable++;
     		cardsOnTable[numberOfCardsOnTable]=cardDeck.dealCard();
    	}
     	
    	public  void dealFourCards() 
     	 {
    		cardsOnTable[numberOfCardsOnTable]=cardDeck.dealCard();
          	numberOfCardsOnTable++;
     		cardsOnTable[numberOfCardsOnTable]=cardDeck.dealCard();
          	numberOfCardsOnTable++;
     		cardsOnTable[numberOfCardsOnTable]=cardDeck.dealCard();
          	numberOfCardsOnTable++;
     		cardsOnTable[numberOfCardsOnTable]=cardDeck.dealCard();
     	 }
    	
//-------------------------------Conditions----------------------------------------------------------------  	
	public  void  checkCondition()
    	{
		   	Card lastFourth = cardsOnTable[numberOfCardsOnTable];
        	Card lastThird = cardsOnTable[numberOfCardsOnTable-1];
         	Card lastSecond = cardsOnTable[numberOfCardsOnTable-2];
         	Card lastFirst = cardsOnTable[numberOfCardsOnTable-3];
             
             if(lastFourth.getCardSuit() == lastThird.getCardSuit()&&lastThird.getCardSuit()==lastSecond.getCardSuit()&&lastSecond.getCardSuit()==lastFirst.getCardSuit() )
             	{
            	 removeLastFourCards();
            	 checkToSeeIfThereAre4Cards();
            	 checkCondition();
             	}
             else 
             {
            	checkCondition2(); 
             }
    	}	
//------------------------------------------------------------------------------------------------------  	
public void checkCondition2()
{
	
   	Card lastFourth = cardsOnTable[numberOfCardsOnTable];
 	Card lastFirst = cardsOnTable[numberOfCardsOnTable-3];

 	if(lastFourth.getCardSuit() == lastFirst.getCardSuit())
 	{
	 removeTwoInBetween();
	 checkToSeeIfThereAre4CardsForCase2();
	 checkCondition();
 	}
 	else
 	{
 		numberOfCardsOnTable++;
 		dealOneCard();
 		checkCondition();
 	}
}
    	public  void checkToSeeIfThereAre4Cards()
    	{
    		while(numberOfCardsOnTable<4)
    		{
    			dealOneCard();
    			numberOfCardsOnTable++;
    		}
    	}
    	
    	public  void checkToSeeIfThereAre4CardsForCase2()
    	{
    		if (numberOfCardsOnTable-2>=2 )
    	   	{
    	   		dealOneCard();
    	   	}
    		else if(numberOfCardsOnTable-2==1)
    		{
    	   		dealTwoCards();
    		}
    	}
	//Remove Cards:
    	public  void removeLastFourCards()
    	{
    		 cardsOnTable[numberOfCardsOnTable]=null;
        	cardsOnTable[numberOfCardsOnTable-1]=null;
         	cardsOnTable[numberOfCardsOnTable-2]=null;
         	cardsOnTable[numberOfCardsOnTable-3]=null;

    		numberOfCardsOnTable -=3;
    	}
    	
    	
    	public  void removeTwoInBetween()
    	{
    		cardsOnTable[numberOfCardsOnTable-2]=cardsOnTable[numberOfCardsOnTable];
         	cardsOnTable[numberOfCardsOnTable-1]=null;
         	cardsOnTable[numberOfCardsOnTable]=null;
         	numberOfCardsOnTable=-2;
    	}

	

		
		
		
		
		

 
		
		
		
		
		
		
		
		
		
	
}