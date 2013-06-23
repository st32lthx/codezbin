import java.util.Scanner;
/*
 * *******************************************************************************************************************
 * @Author: Amin Meyghani
 * 	@Date: Jan.24.2011
 * 	Purpose:  This class models the whole game 
 *                                                       
 * *********************************************************************************************************************
 */	
public class GameModel 
{
		protected int columnTrackerOfPlayerHandMatrix;
		protected int rowTrackerOfPlayerHandMatrix;
		protected int  totalNumberOfCards;
		protected int numberOfPlayers;
		protected int userInput;
		protected int noOfCardsInPlayerHands;
		protected Scanner scanner;
		protected Deck deck;
		protected Object[][] playerHandMatrix;
		protected final  int POSSIBLE_NUMBER_OF_CARDS = 52;

		public GameModel ()
		{
			scanner = new Scanner(System.in) ;
			deck = new Deck(2);
			columnTrackerOfPlayerHandMatrix=0;
			rowTrackerOfPlayerHandMatrix=0;
			totalNumberOfCards=0;
		}
/*
 * ********************************************************************************************************
 *                                                   Methods
 *                                                       
 * ********************************************************************************************************
 */
		public void callThePlayerName()
		{
			callPlayer(rowTrackerOfPlayerHandMatrix);
		}
//----------------------------------------------------------------------------------------------------- 	
	
//----------------------------------------------------------------------------------------------------- 	
		public void printGameInstructions()
		{
			GameInstructions();
		}
//----------------------------------------------------------------------------------------------------- 	
		public void drawFromDeckAndAddToHand()
		{
			drawFromDeckAddtoHand();
		}	
//----------------------------------------------------------------------------------------------------- 	
		public String seekCardInHand(int row, int column)
		{
			return seekCard(row, column);
		}	
//----------------------------------------------------------------------------------------------------- 	
		public void displayCurrentPlayerCards()
		{
			getCardNamesThatAreToBePlayed(rowTrackerOfPlayerHandMatrix);
		}
//----------------------------------------------------------------------------------------------------- 	
	
/*
 * ********************************************************************************************************
 *                                                    Method Definitions
 *                                                       
 * ********************************************************************************************************
 */
		
/*A method to get the information before starting the game.
 * It asks for the number of players and their names.
 */
		protected  void askNoOfPlayersAndTheirNames()
		{
			System.out.println("Enter the number of players:");
			numberOfPlayers=scanner.nextInt();
			playerHandMatrix = new Object[numberOfPlayers][POSSIBLE_NUMBER_OF_CARDS];
			for(int i=0;i<numberOfPlayers; i++)
				{
					System.out.println("Enter name of player "+(i+1));
					playerHandMatrix[i][0] = scanner.next();
				}
		}
		
//*************************************************************************************		
/*A method to print the game instructions.
 * 
 */	
	private  void GameInstructions()
	{
		System.out.println(getPlayerNames()+": Welcome to the game of Crazy eights."+"\n"+"The following is the game instructions:"+"\n");
		System.out.println("On your turn, place down a card of the same number of suit as the face up card. You can also play an 8 card at any time.");
		System.out.println(" When you place down an 8 card, you can select which ever suit you want it to be.  ");
		System.out.println(" If you cannot place a card down, draw a card from the  deck until you have a playable card.");
		System.out.println("The first player to discard all their cards wil."+"\n");
	}
//*************************************************************************************		
	/*A method to return  names of ALL players.
 * @return:  name of players are returned.
 */
		private String  getPlayerNames()
		{
			String playerName="";
			for(int i=0; i<numberOfPlayers; i++)
			{
			Object names = playerHandMatrix[i][0];
			playerName+= names.toString()+",";
			}
			return  playerName;
		}
//*************************************************************************************		
/*A method to deal cards to ALL  player's hands.
 * This method is used in the beginning of the game to deal seven cards to the players.
 */	
		public void dealCardsToEachPlayer(int number)
		{
			deck.deckTracker++;
			deck.shuffleDeck();
			totalNumberOfCards=number;
			int i=0, j=1;
			while(i<numberOfPlayers)
			{
				while(j<=totalNumberOfCards)
				{
					playerHandMatrix[i][j]=deck.dealCards();
					columnTrackerOfPlayerHandMatrix++;
					j++; 
				}
				j=1; i++;
			}
			columnTrackerOfPlayerHandMatrix-=totalNumberOfCards;
		}
//*************************************************************************************		
/*A method to print the cards of the player that is to play.
 * 
 */	
			private void  getCardNamesThatAreToBePlayed(int number)
			{	
				int noOfCards = countNumberOfCardsInPlayerHand();
				rowTrackerOfPlayerHandMatrix=number;
				int  j=1;
				int handPosition=0;
					System.out.println(playerHandMatrix[rowTrackerOfPlayerHandMatrix][0].toString() + " has:" +"\n"+"--------------------------");
					while(j<=noOfCards)
					{
						System.out.println(j+")"+playerHandMatrix[rowTrackerOfPlayerHandMatrix][j].toString());
						j++; 
						handPosition++;	
					}
					System.out.println("-----------------------------------------------");
					System.out.println(playerHandMatrix[rowTrackerOfPlayerHandMatrix][0].toString()+"'s"+" move?"+" You can choose a number to move or use '0' to draw card from deck");	
			}
//*************************************************************************************		
/*A method to print all the cards in ALL player's hands.
 * 
 */	
		protected void  getCardsInAllPlayerHand()
		{
			int i=0, j=1;
			while(i<numberOfPlayers)
			{
				System.out.println(playerHandMatrix[i][0].toString() + " has:" +"\n"+"----");
				while(j<=totalNumberOfCards)
				{
					System.out.println(playerHandMatrix[i][j].toString());
					j++; 
				}
				j=1; i++;
			}
		}

//*************************************************************************************		
/*
 * A method to call a the next player that is to play.
 */
			private void callPlayer(int row)
			{
				rowTrackerOfPlayerHandMatrix =row;
				System.out.println(playerHandMatrix[row][0].toString()+" :it is your turn");
			}
//*************************************************************************************		
/*A method to add card from the deck to the players hand
*The card is removed from the deck  and added to player's hands.
*
*
*/
			private void drawFromDeckAddtoHand()
			{
				totalNumberOfCards++;
				int col = countNumberOfCardsInPlayerHand();
				 playerHandMatrix[rowTrackerOfPlayerHandMatrix][col+1]=deck.dealCards();
				System.out.println("we drew from hand and added to the pokayer shand");
			}

//*************************************************************************************		
/*A method to seek a specific card in the player's hand
*@return: removed Card
*/
			private String seekCard(int row, int column)
			{
				String cardName = "";
				cardName+=playerHandMatrix[row][column].toString();
				 return cardName;
			}
//*************************************************************************************		
	/*A method to count the number of current card in player hand.
	*@return: int cardCounter
	*/
						protected int countNumberOfCardsInPlayerHand()
						{
							noOfCardsInPlayerHands=0;
							for(int i=1;i<51;i++)
							{
								if(playerHandMatrix[rowTrackerOfPlayerHandMatrix][i]!=null)
								{
									noOfCardsInPlayerHands++;
								}
								
							}
							return noOfCardsInPlayerHands;
						}
//*************************************************************************************	
		
//************************************END********************************************
	
}
