import java.util.ArrayList;
/** 
* Chris Hutchinson
* CS 110
* Prof. Horton 
* Pile - is an arraylist that represents the pile of cards that each player has during a game of war. 
*/

public class Pile 
{
   private ArrayList<Cards> pile;  //the pile of cards a player has 
   
   /**
   The default constructor for pile initializes an arraylist of cards.
   */
    
   public Pile()
   {
      pile = new ArrayList<Cards>();
      
   }
   
   /**
   The add method takes a card argument and adds the card to the bottom of the pile. 
   @param c is the card object that is added to the bottom of the pile.
   */
   
   public add(Card c)
   {
      pile.add(c);
      
   }
   
   
   
} 
   
      