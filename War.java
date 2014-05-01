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
   final int SPLITDECK = 26;         // a constant for the number of cards in a half a deck 
   private Deck deck;                //the deck of cards for the game war
   private Pile player1Deck;         // user's deck 
   private Pile player2Deck;         // computer player's deck 
   private Pile warPile;             // pile of cards that are to be won during a war from past battles. 
   private int player1Cards;         // number of cards player one has
   private int player2Cards;         // number of cards player two has
   private int warPileCards;         // number of cards player two has
   private boolean endGame = false;  //a boolean value flag that ends the game if set to true
   
   
   
   
   /**
   The default constructor- which takes no arguments and returns nothing
   */
   
   public War()
   {
      deck = new Deck();
      deck.shuffle();
      player1Deck = new Pile();
      player2Deck = new Pile();
      warPile = new Pile();
      
      //split the deck for player one and two. 
      for(int i = 0; i <26 ; i++)
      {
         player1Deck.add(deck.dealCard());
         player2Deck.add(deck.dealCard());
         
      }
      
      player1Cards = player1Deck.size();
      player2Cards = player2Deck.size();
      warPileCards = warPile.size();
      
    }
    
    /**
    The battle method is a method that draws the top card from each players pile and compares them, the player
    with the higer card adds both his card that was drawn and the other players card that was drawn to the bottem
    of his pile.It returns a int value of 1 if the user wins, a -1 if the computer wins and a 0 if the cards are 
    equal in rank. 
    @return outcome is a int value that is 1 if the user wins, -1 if the computer wins, and 0 if the cards are 
    equivalent in rank. 
    */ 
    
    public String[] battle()
    {
      
      String boutcome = "";      // string name of who won battle
      String win= " ";           //string holds value of which player won the game if ended
      Card player1;              //the top card of player 1's pile
      Card player2;              //the top card of player 2's pile
      int outcome;               // the outcome of the battle 
      
      player1 = player1Deck.topCard();          //draw top card from player 1's deck for battle 
      player2 = player2Deck.topCard();          //draw top card from player 2's deck for battle
      
      outcome = player1.compareTo(player2);     //Compare the two cards to see if player 1 wins, player 2 wins , or Tie.
      
      // if statement for player 1 win 
      if(outcome == 1)
      {
         //add both cards used in battle to player 1's deck
         player1Deck.add(player1);
         player1Deck.add(player2);
         boutcome = "User Wins Battle";
      }
      
      // if statement for player 2 win 
      else if(outcome == -1)
      {
         //add both cards used in battle to player 2's deck
         player2Deck.add(player2);
         player2Deck.add(player1);
         boutcome = "Computer Wins Battle";
      }
      
      // if statement for if the two cards have the same rank and its a tie. 
      else if(outcome == 0)
      {
         // call go to war method and pass the two cards used in the battle as arguments.
         warPile = new Pile();
         warPile.add(player1);
         warPile.add(player2);
         boutcome = "Tie: Go to War";
         
         
       }
      
      
      player1Cards = player1Deck.size();         // set the field player1Cards to the number of cards that are in player1's deck
      player2Cards = player2Deck.size();         // set the field player2Cards to the number of cards that are in player2's deck
      warPileCards = warPile.size();             // set the field warPileCards to the number of cards that are in the warPile deck
      System.out.println("Battle Total Deck: " + (player1Deck.size()+player2Deck.size()));
      
      win = winner();   //call the winner method to see if a player has lost the game at the end of the battle.
      
      String[] info = {player1.getCardImage(), player2.getCardImage(), boutcome, win}; 
      
      return info;   // return the int value outcome of the battle.
      
    }
    
    /**
    The goToWar method accepts no arguments. This method deals out the top card of each players 
    deck and leaves it face down and then draws another card from the top of each players deck and the compares the
    second set of cards that are drawn to battle. Whichever player wins gets the first two cards that were equal in 
    rank which are in the war pile, plus the two cards drawn that were left face down and then the two cards the 
    battled the war.If there is another tie during a war then we go throught the same process again and add the prize
    cards to the war pile plus the two cards that were equal in rank again.returns the int value of the outcome of the war.
    @return outcome is a int value that is 1 if the user wins, -1 if the computer wins, and 0 if the cards are 
    equivalent in rank.
    */
    
    public String[] goToWar()
    {
      Card prize1;          //the top card on player1's deck that is played face down 
      Card prize2;          //the top card on player2's deck that is played face down
      Card player1;         //the top card of player 1's pile
      Card player2;         //the top card of player 2's pile
      int outcome = 2;          // the outcome of the battle 
      String boutcome = "";      // string for winner status
      String win= " ";           //string holds value of which player won the game if ended 
      
      
      try
      {
         prize1 = player1Deck.topCard();          //draw top card from player 1's deck for prize 
         prize2 = player2Deck.topCard();          //draw top card from player 2's deck for prize
         warPile.add(prize1);                     //add the prize card for player 1 to the war pile 
         warPile.add(prize2);                     //add the prize card for player 2 to the war pile
         player1 = player1Deck.topCard();         //draw top card from player 1's deck for battle 
         player2 = player2Deck.topCard();         //draw top card from player 2's deck for battle
         
         outcome = player1.compareTo(player2);     //Compare the two cards to see if player 1 wins, player 2 wins , or Tie.
         System.out.println("Total Deck: " + (player1Deck.size()+player2Deck.size()));
         System.out.println("Before War: " + warPile.size());
       
       
         // if statement for player 1 win 
         if(outcome == 1)
         {
            // add the cards from the war pile to player1's deck
            while(!(warPile.isEmpty()))
               player1Deck.add(warPile.topCard());
               
            //add both cards used in battle to player 1's deck
            player1Deck.add(player1);
            player1Deck.add(player2);
            boutcome = "User Wins Battle";
            System.out.println("User After War: " + warPile.size());
            System.out.println("Total Deck: " + (player1Deck.size()+player2Deck.size())); 
         }
         
         // if statement for player 2 win 
         else if(outcome == -1)
         {
             // add the cards from the war pile to player1's deck
            while(!(warPile.isEmpty()))
               player2Deck.add(warPile.topCard());
               
            //add both cards used in battle to player 2's deck
            player2Deck.add(player2);
            player2Deck.add(player1);
            boutcome = "Computer Wins Battle";
            System.out.println("Computer After War: " + warPile.size());
            System.out.println("Total Deck: " + (player1Deck.size()+player2Deck.size()));
         }
         
         // if statement for if the two cards have the same rank and its a tie. 
         else if(outcome == 0)
         {
            // call go to war method and pass the two cards used in the battle as arguments.
            warPile.add(player1);
            warPile.add(player2);
            boutcome = "Tie: Go to War";
            System.out.println("Tied War: " + warPile.size());
            System.out.println("Total Deck: " + (player1Deck.size()+player2Deck.size()));
            
         }
        
         
         player1Cards = player1Deck.size();         // set the field player1Cards to the number of cards that are in player1's deck
         player2Cards = player2Deck.size();         // set the field player2Cards to the number of cards that are in player2's deck
         
         win = winner();   //call the winner method to see if a player has lost the game at the end of the battle.
         
         String[] info = {player1.getCardImage(), player2.getCardImage(), boutcome, win}; 
         
         return info;   // return the int value outcome of the battle.
       }
       catch(Exception e)
       {
         System.out.println("A player ran out of cards the game is over");
         win = winner();
         String[] failed = {"back.jpg","back.jpg","Player ran out of cards",win} ;
         return failed;
       }
       
       
    }
    
    /**
    The winner method is a method that accepts no arguments. It checks to see if any player's deck is empty since
    this is a automatic lose for that player. it returns the string value of the winner if there is one.
    @return win the string value of the winner. 
    */
    
    public String winner() 
    {
      String win = "not done" ;       // set variable for string name of winner of war 
      
      // if statement that checks to see if either player is out of cards or the endGame flag has been set to true 
      if((player1Cards == 0 || player2Cards == 0) || endGame == true)
      {
         // if player one is out of cards computer wins 
         if(player1Cards == 0)
         {
            win = "Computer Wins";
            
         }
            
         
         // if player two is out of cards the user wins 
         else if(player2Cards == 0)
         {
            win = "User Wins";
            
         }
         
         // if player one has more cards then player two when end game flag is hit user wins
         else if(player1Cards > player2Cards)
         {
            win = "User Wins";
            
         }
         
         // if player two has more cards then player one when end game flag is hit computer wins
         else if(player1Cards < player2Cards)
         {
            win = "Computer Wins";
            
         }
         
         // if player one and player two have the same amount of cards in their decks when the end game flag is activated they tie.
         else if(player1Cards == player2Cards)
         {
            win = "Tied";
            
         }
         
         
       }
       
       return win;         // return the string value of whoever won
     }
     
     /**
     The getPlayer1Cards method returns the int value for the number of cards in Player 1's deck.
     @return num the number of cards in player 1's deck. 
     */ 
     public int getPlayer1Cards()
     {
        int num = player1Cards;
        return num;
      
     }
     
     /**
     The getPlayer2Cards method returns the int value for the number of cards in Player 2's deck.
     @return num the number of cards in player 2's deck. 
     */ 
     public int getPlayer2Cards()
     {
        int num = player2Cards;
        return num;
      
     }
     
     /**
     The getWarPileCards method returns the int value for the number of cards in the War Pile deck.
     @return num the number of cards in the war pile deck. 
     */ 
     public int getWarPileCards()
     {
        int num = player2Cards;
        return num;
      
     }
       
            
            
      

      
      
    
      
      
      
      
      
      
     
         
         
         
    
   
   
   
   
}
   
