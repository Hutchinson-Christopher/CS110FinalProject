/** 
* Chris Hutchinson
* CS 110
* Prof. Horton 
* War - A class that represents the card game war where two players split a deck of cards.
* Then with both players having a their stack of cards face down pull their top card and play
* it face up. This is a battle and the player with the higher card takes both cards played and
* adds them to the bottom of their deck. If the players battle and their cards are of equal 
* value then there is a war, which each player takes the top card of their deck and places it
* face down and then plays the next top card face up. Which ever player wins this battle takes
* the 6 cards previously played and adds them to the bottom of their deck. If during a war the 
* cards played face up are of equal value you follow the same protocal and war again until their
* is a defined winner. If a player runs out of cards in his deck he immediatly loses.  
*/

public class War
{
   final int SPLITDECK = 26;    // a constant for the number of cards in a half a deck 
   private Deck deck;           //the deck of cards for the game war
   private Pile player1Deck;    // player ones deck 
   private Pile player2Deck;    // computer player's deck 
   private int player1Cards;    // number of cards player one has
   private int player2Cards;    // number of cards player two has 
   
   
   
   /**
   The default constructor- which takes no arguments and returns nothing
   */
   
   public War()
   {
      deck = new Deck();
      deck.shuffle();
      
      //split the deck for player one and two. 
      for(int i = 0; i < SPLITDECK; i++)
      {
         player1Deck.add(deck.dealCard());
         player2Deck.add(deck.dealCard());
      }
      
    }
    
    /**
    The battle method is a method that draws the top card from each players pile and compares them, the player
    with the higer card adds both his card that was drawn and the other players card that was drawn to the bottem
    of his pile.It returns a int value of 1 if the user wins, a -1 if the computer wins and a 0 if the cards are 
    equal in rank. 
    @return outcome is a int value that is 1 if the user wins, -1 if the computer wins, and 0 if the cards are 
    equivalent in rank. 
    */ 
    
    public int battle()
    {
      Card player1;         //the top card of player 1's pile
      Card player2;         //the top card of player 2's pile
      int outcome;          // the outcome of the battle 
      
      player1 = player1Deck.topCard();
      player2 = player2Deck.topCard();
      
      outcome = player1.compareTo(player2);
      
      if(outcome == 1)
      {
         player1Deck.add(player1);
         player1Deck.add(player2);
      }
      
      else if(outcome == -1)
      {
         player2Deck.add(player2);
         player2Deck.add(player1);
      }
      
      else if(outcome == 0)
         War.goToWar(player1,player2);
      
      
      player1Cards = player1Deck.size();
      player2Cards = player2Deck.size();
      
      War.winner();
      
    }
      
      
      
      
      
      
     
         
         
         
    
   
   
   
   
}
   
