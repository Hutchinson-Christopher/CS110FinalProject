/** 
* Chris Hutchinson
* CS 110
* Prof. Horton 
* Card - Representation of a single playing card from a standard 52 card deck. 
* A card consists of a suit value and a rank value.  Once instantiated, the
* Card object cannot change.
*/



public class Card 
{     
    // Constants     
    // suits
    public final static int SPADES = 0,      
                            HEARTS = 1,
                            DIAMONDS = 2,
                            CLUBS = 3;
    // Constants
    // ranks, cards 2 through 9 have face value
    public final static int ACE = 1,          
                            JACK = 11,        
                            QUEEN = 12,       
                            KING = 13;
                            
    
    private int suit;         // The suit of this card, one of the constants SPADES, HEARTS, DIAMONDS, CLUBS.
                              
    private int rank;         // The rank of this card, from 1 to 13.
                             
   /**
   This constructor accepts two arguments both ints. The first sets the rank of the card, and the second sets the 
   suit of the card.
   @param suit the suit value of this card.
   @param rank the rank rank of this card.
   */
    public Card(int rank, int suit) 
    {
        this.rank = rank;
        this.suit = suit;
    }
    
   /**
   This constructor accepts one argument of the type card, and creates a copy of the parameter card by setting the
   the field rank of the new card to the same as the parameter card and the same for the field suit. 
   @param otherCar the card to be copied.
   */
    public Card(Card otherCard) 
    {
         this.rank = otherCard.rank;
         this.suit = otherCard.suit;
    }
    
   /**
   The getSuit method returns the suit of the card.
   @return a Suit constant representing the suit value of the card.
   */
  
    public int getSuit() 
    {
      return suit;
    }
    
   /**
   The getRank method returns the rank of the card. 
   @return a Rank constant representing the rank value of the card.
   */

    public int getRank() 
    {
            // Return the int that codes for this card's rank.
        return rank;
    }
    
   /**
   The getSuitAsString method returns the name of the suit of the card as a string. 
   @return the suit value of the card as a string.
   */
   
    public String getSuitAsString() 
    {
            // Return a String representing the card's suit.
            // (If the card's suit is invalid, "??" is returned.)
        switch ( suit ) {
           case SPADES:   return "Spades";
           case HEARTS:   return "Hearts";
           case DIAMONDS: return "Diamonds";
           case CLUBS:    return "Clubs";
           default:       return "Invalid";
        }
    }
   /**
   The getRankAsString method returns the name of the rank of the card as a string. 
   @return the rank value of the card as a string.
   */
   
   public String getRankAsString() 
   {
        switch ( rank ) {
           case 1:   return "Ace";
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "Jack";
           case 12:  return "Queen";
           case 13:  return "King";
           default:  return "??";
        }
    }
   /**
   The toString method returns a description of the card so the name of the rank and suit of the card as a string.
   @return the name of the card.
   */

    public String toString() 
    {
        return getRankAsString() + " of " + getSuitAsString();
    }
    
   /**
   The equals method returns the boolean value indicating true if the cards that are being compared have the same
   rank and suit. If the cards being compared do not have the same rank and suit then the method returns a boolean
   value of false. 
   @param othercard the other card
   @return true if the two cards have the same rank and suitvalues, false otherwise.
   */
   
   public boolean equals(Card otherCard ) 
   {
      if ( ( rank != otherCard.rank ) || ( suit != otherCard.suit ) )
         return false;
      else
         return true;
   }
   
   /**
    The compareTo method Compares two cards to determine if they have the same rank.
   * @param c the other card.
   * @return outcome is the int that is returned. 1 if the card that calls the method is larger,
   * -1 if the parameter card is larger and 0 if the cards are equal in rank. 
   */
   
   public int compareTo(Card c)
   {
      int outcome = 2;   //varaible for return int value 
      
      if(this.rank > c.rank)
         outcome = 1;
      else if(this.rank < c.rank)
         outcome = -1;
      else if(this.rank == c.rank)
         outcome = 0; 
         
      return outcome; 
    }
    
    public static void main(String [] args) 
   {
      Card c1 = new Card(3,1);
      Card c2 = new Card(2,2);
      System.out.println(c1.compareTo(c2));
      
   
   }

}
    


