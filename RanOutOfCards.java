/** 
* Chris Hutchinson
* CS 110
* Prof. Horton 
* RanOutOfCards exception are thrown when a player runs out of cards in his deck during a war.
*/

public class RanOutOfCards extends IndexOutOfBoundsException
{
   /**
   This Constructor shows a generic error message telling the players that the game is over someone ran
   out of cards. 
   */
   public RanOutOfCards()
   {
      super("Player ran out of cards during a War. This is a automatic loss.");
      
   }
   
}