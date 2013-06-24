/*
 * ********************************************************************************************************
 * @Author: Amin Meyghani
 * 	@Date: Jan.24.2011
 * 	Purpose: This class contains rules of the Crazy Eights and allows 2 or more players play the game.
 *                                                       
 * ********************************************************************************************************
 */
public class CrazyEights extends GameModel                                                                                             
	{	
			private String cardToBePlayed;
			private String cardToBePlayedValue;
			private String [] table;
			private String crazyEightSuitHolder;
			private final  int TABLE_TRACKER = 0;

		public CrazyEights()
		{
			cardToBePlayed="";
			cardToBePlayedValue="";
			table = new String[1];
			crazyEightSuitHolder = "";
		}
	
/*
 * ********************************************************************************************************
 *                                                   		 Game
 *                                                       
 * ********************************************************************************************************
 */
			public void playGame()
			{
				
				askNoOfPlayersAndTheirNames();
				printGameInstructions();
				deck.shuffleDeck();
				addCardFromDeckToTable();
				dealCardsToEachPlayer(7);
				 play();
				 while( deck.isDeckEmpty())
				 {
				 checkGameConditions();
				 }
				 
				
					gameOver();	
				
			}
			
/*
 * ********************************************************************************************************
 *                                                   		 Game
 *                                                       
 * ********************************************************************************************************
 */		

			
			
			
			
			
			
/*
 * ********************************************************************************************************
 *                                                       Method Definitions                                                                                
 *                                                                																				 
 * ********************************************************************************************************
/*A method that governs the game.
 * 
 */
			private void play()
			{
				displayCurrentPlayerCards();
				getFaceUpCard();
				userInput = scanner.nextInt();
			}
//*************************************************************************************		
/*
 * A method to print the card on table
 */
			private void getFaceUpCard()
			{
			String faceUpCard = "";
			faceUpCard+=table[TABLE_TRACKER].toString();
			System.out.println("The card on table is " + faceUpCard); 
			}
//*************************************************************************************		
/*A method to check if the card is eight 
 * 
 */
			private boolean isEight()
			{
				return seekCardInHand(rowTrackerOfPlayerHandMatrix,userInput).contains("8");
			}
//*************************************************************************************		
/* a method to evaluate the candidate card in terms of value 
 * 
 */
			private void evaluateTheCandidateCard()
			{
				getCardThatToBePlayed();
				getCardValueToBePlayed();
			}
//*************************************************************************************					
/*A method that compares the suit of the face up card and the players choice 
 * 
 */
			private boolean isSuitEqual()
			{
				return (cardToBePlayed.contains(table[TABLE_TRACKER].toString().substring(4)));				
			}
//*************************************************************************************		
/*A method that compares the value of the face up card and the players choice 
 * 
 */
			private boolean isValueEqual()
			{
				return (cardToBePlayedValue.contentEquals(table[TABLE_TRACKER].toString().substring(0,2)));
			}
//*************************************************************************************		
/*A method that gets the user's chosen card. 
 * 
 */
			private void getCardThatToBePlayed()
			{
			cardToBePlayed = (seekCardInHand(rowTrackerOfPlayerHandMatrix, userInput));
			}
//*************************************************************************************		
/*A method  that gets the value of the chosen card that is the player's hand.. 
 * 
 */
						private void getCardValueToBePlayed()
						{
						cardToBePlayedValue = (seekCardInHand(rowTrackerOfPlayerHandMatrix, userInput)).substring(0,2);
						}
//*************************************************************************************		
/*A method to remove a card from the player's hand and return it.
*
*/
						private String removeCardFromHand(int thePlayedCard)
						{
							Object theRemovedCardFromHand = playerHandMatrix[rowTrackerOfPlayerHandMatrix][userInput];
							playerHandMatrix[rowTrackerOfPlayerHandMatrix][userInput]=null;
							return theRemovedCardFromHand.toString();
						}
//*************************************************************************************		
/*A method to add cards from the current position of the card deck to the table as a face up card.
*
*/
						private void  addCardFromDeckToTable()
						{
						table[TABLE_TRACKER] = deck.dealCards().toString();
						}
//*************************************************************************************				
/*A method that shifts all the cards in the player hand to the right.
*
*/
						private void shiftCardInHandsToRight()
						{
							if(playerHandMatrix[rowTrackerOfPlayerHandMatrix][userInput]==null)
								for(int j=1; j<=Math.abs(userInput-noOfCardsInPlayerHands)+2; j++)
								{
									playerHandMatrix[rowTrackerOfPlayerHandMatrix][userInput+(j-1)]=playerHandMatrix[rowTrackerOfPlayerHandMatrix][userInput+j];
									playerHandMatrix[rowTrackerOfPlayerHandMatrix][userInput+j]=playerHandMatrix[rowTrackerOfPlayerHandMatrix][userInput+(j-1)];
								}
						}
//*************************************************************************************	
/*A method that evaluates either the suite or the value of the card to be true
*
*/
						private void checkTheSuitOrTheValueOfTheCandidateCard()
						{
							if(isValueEqual() || isSuitEqual() )
							{
								table[TABLE_TRACKER]=null;
								table[TABLE_TRACKER] = cardToBePlayed;
								playerHandMatrix[rowTrackerOfPlayerHandMatrix][userInput]=null;
								shiftCardInHandsToRight();
							}
							else
							{
								System.out.println("Your card is invalid, try again");
								play();
							}
						}
//*************************************************************************************				
/*A method that checks if the next play can be called the next player
*
*/
						private void callTheNextPlayer()
						{
							if(rowTrackerOfPlayerHandMatrix!=numberOfPlayers-1)
							{
								rowTrackerOfPlayerHandMatrix++;
								shiftCardInHandsToRight();
							}
							else
							{
								rowTrackerOfPlayerHandMatrix--;
								columnTrackerOfPlayerHandMatrix=1;
							}
							callThePlayerName();
						}
//*************************************************************************************				
/*The method that checks for all the rules of the game
*
*/
							private void checkGameConditions()
							{
										int n=countNumberOfCardsInPlayerHand();
										if(n-1!=0)
										{
													if(userInput==0)
													{
														drawFromDeckAndAddToHand();
														play();
													}
													else if(isEight())
													{
														System.out.println("###CRAZY EIGHT###");
														System.out.println("which suit to play:  clubs, diamonds, hearts ,spades" );
														crazyEightSuitHolder = scanner.next();
														table[TABLE_TRACKER]="8"+" of "+ crazyEightSuitHolder;
														playerHandMatrix[rowTrackerOfPlayerHandMatrix][userInput]=null;
														shiftCardInHandsToRight();
														callTheNextPlayer();
														columnTrackerOfPlayerHandMatrix=1;
														play();
													}
													else if(userInput !=0) 
													{
														evaluateTheCandidateCard();
														checkTheSuitOrTheValueOfTheCandidateCard();
														callTheNextPlayer();
														columnTrackerOfPlayerHandMatrix=1;
														play();
													}	
										}
										else
										{
											gameOver();
										}
							
							}
//*************************************************************************************				
/*A method that announces if the game is over
 * 
 */
						private void gameOver()
						{
							
							System.out.println("Game is over, there are no cards to draw.");
							System.out.println("Results:---------------------------------------------------");
							System.out.println("The Winner is:__ ");
							getWinner();
						}
//*************************************************************************************				

/*A method that announces the winner 
 */					
						private String getWinner()
						{
							return playerHandMatrix[rowTrackerOfPlayerHandMatrix][0].toString();
						}
//************************************END********************************************
}
