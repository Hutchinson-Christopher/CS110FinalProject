import java.util.ArrayList;
/** 
* Chris Hutchinson
* CS 110
* Prof. Horton 
* Pile - is an arraylist that represents the pile of cards that each player has during a game of war. 
*/

public class Pile extends ArrayList 
{
   private ArrayList<Card> pile;  //the pile of cards a player has 
   
   /**
   The default constructor for pile initializes an arraylist of cards.
   */
    
   public Pile()
   {
      pile = new ArrayList<Card>();
      
   }
   
   /**
   The add method takes a card argument and adds the card to the bottom of the pile. 
   @param c is the card object that is added to the bottom of the pile.
   */
   
   public void add(Card c)
   {
      pile.add(c);
      
   }
   
   /**
   The topCard method takes the top card from the deck removes it and returns it to the method that called it. 
   @return top is the top card of the pile. 
   */
   
   public Card topCard()
   {
      Card top;                    //variable for the top card of the pile  
      
      top = pile.remove(0);        // remove the top card of the pile and refrence it by the variabel top 
      
      return top;                  // return top to the method that called it. 
      
   }
   
   /**
   The size method uses a arraylist method to get the int value of the number of objects or card in the pile and
   then returns the int value back to the method that called it. 
   @return num is the int value of the number of cards in the pile. 
   */
   
   public int size()
   {
      return pile.size();
   }
   
   /**
   The empty method uses an arraylist method to clear the entire arraylist so essential empties the pile. 
   */
   
   public void empty()
   {
      pile.clear();
   }
   
   /**
   The is empty method is a method that returns a boolean value of true if the pile is empty and false otherwise.
   @return empty is the boolean value if a pile is empty. 
   */
   
   public boolean isEmpty()
   {
      boolean empty = false;     // assume pile is not empty
      
      if(pile.size()==0)         //if pile size is 0 then empty 
         empty = true; 
         
      return empty;              //return boolean value 
      
    }
   
   
    
    
   
   
   
} 
   
      