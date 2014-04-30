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
   final int SPLITDECK = 26; // a constant for the number of cards in a half a deck 
   private Deck deck;        //the deck of cards for the game war
   private Deck player1;   // player ones deck 
   private Deck player2;   // computer player's deck 
   private int player1Cards; // number of cards player one has
   private int player2Cards; // number of cards player two has 
   
   
   
   /**
   The default constructor- which takes no arguments and returns nothing
   */
   
   public War()
   {
      deck = new Deck();
      
      //split the deck for player one and two. 
      for(int i = 0; i < SPLITDECK; i++)
         
    
   
   
   
   
}
   
