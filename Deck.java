import java.util.Random;
import java.util.ArrayList;
/** 
* Chris Hutchinson
* CS 110
* Prof. Horton 
* Deck - Representation of a full deck of playing cards all 52. Credit to Prof. Horton for code.
*/


public class Deck 
{
   final int CARDS_IN_DECK = 52;            //number of cards in a full deck of playing cards
   ArrayList<Card> deck;                    //initilization of arraylist of cards to hold all 52 cards to make our deck
   
   /**
   The default constructor which calls the method freshdeck.
   */
   public Deck()
   {
            freshDeck();
   }
   
   /**
   The freshDeck method accepts no arguments and returns nothing it uses for loops to create a fill the array
   list deck with the 52 cards of a playing card deck. 
   */ 
   
   public void freshDeck()
   {
      deck = new ArrayList<Card>();        //initialize arraylist 
      
      // two for loops to go through each rank of each suit and add it to the array list deck
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
           deck.add(new Card(r,s));
         }
      }
     
   
   }
   
   /**
   The dealCard method accepts no arguments, however it returns the first card in the arraylist to where the method was 
   called.
   @param c the card that was at index 0 in the arraylist deck. 
   */
   
   public Card dealCard()
   {
      Card c = deck.remove(0);  //  remove it (returns removed object)
      return c;
   }
   
   /**
   The cardsRemaining methods returns the number of cards that are in the arraylist deck.
   @return int for number of cards in deck.
   */
   
   public int cardsRemaining()
   {  
      return deck.size();
   }
   
   /**
   The shuffle method accepts no arguments and returns no values. It uses random number generation to move cards through
   out the arraylist deck to shuffle the deck.
   */
   
   public void shuffle()
   {
      int randNum;         //for the random index to which place the temp card 
      Card temp;           // holder variable for card that is being shuffled 
      Random r = new Random();  //random object r initialized 
      
      //for loop that shuffles the a random card and repeats 52 times.
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   
   /**
   The isEmpty mehtos is a method that returns a boolean value of true if the deck has a size of 0 or false otherwise.
   @return boolean true if deck is empty and false if it has even one card in it. 
   */ 
   
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
   
      

}
   


