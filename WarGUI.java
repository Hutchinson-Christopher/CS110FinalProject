import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** 
* Chris Hutchinson
* CS 110
* Prof. Horton 
* WarGUI - GUI for card game War. 
*/

public class WarGUI extends JFrame
{
   private War game;                                               //the guts of the game 
   private JPanel leftPanel,middlePanel,rightPanel;                // break up regions
   private JButton endButton,battleButton;                         // buttons for game play and end of game
   private JLabel title;                                           // semantic title of game 
   private JLabel userScore,computerScore;                         // label for the number of cards in each player's deck
   private JLabel p1,p2;                                           // labels for putting image of cards that are being played
   private JLabel battleOutcome,gameStatus;                        // labels to update user on status of game
   private final int WINDOW_WIDTH = 900;                           // constant width for window of GUI
   private final int WINDOW_HEIGHT = 500;                          // constant height for window of GUI
   
   
   public WarGUI()
   {         
      setLayout(new GridLayout(1,3));                               //set layout of entire window to one row three colums 
      
      game = new War();                                             //initialize a instance of the War class 
      
      setSize(WINDOW_WIDTH,WINDOW_HEIGHT);                          // set the window size of the GUI to 900*500
      
      leftPanel = new JPanel(new BorderLayout());                   //left panel set to border layout 
      middlePanel = new JPanel(new GridLayout(5,1));                //middle panel to gris layout of 5 rown one column for button and labels 
      rightPanel = new JPanel(new BorderLayout());                  //right panel set to border layout 
      
      setTitle("War: a card game by Christopher Hutchinson");       //set title of GUI to War 
      
      endButton = new JButton("End Game");                          //initialize end button
      endButton.addActionListener(new ButtonListener2());           //add action lister to end button 
       
      battleButton = new JButton("Battle");                         //initialize battle button 
      battleButton.addActionListener(new ButtonListener1());        //add action listner to battle button 
      
      title = new JLabel("WAR");                                    //initialize Jlabel for title in gui
      title.setFont(new Font("HELVETICA",Font.BOLD,30));            //set the font of the title JLabel 
      
      p1 = new JLabel(new ImageIcon("back.jpg"));                   //set users panel to backside of card image initially
      p2 = new JLabel(new ImageIcon("back.jpg"));                   //set users panel to backside of card image initially
      
      battleOutcome = new JLabel("Lets Battle");                    //initialize battle outcome label to inform user of battle outcomes
      gameStatus = new JLabel("Game in Progress");                  //initialize game status label to ahow user the status of the game
      
      userScore = new JLabel("User's Card Count: " + game.getPlayer1Cards());   //users score shows the number of cards in the users deck
      userScore.setFont(new Font("ARIAL",Font.BOLD,16));                        //set font of user score label 
      
      computerScore = new JLabel("Computer's Card Count: " + game.getPlayer2Cards()); //computer score label shows how many cards are in the computers deck 
      computerScore.setFont(new Font("ARIAL",Font.BOLD,16));                          //set font for computer score label 
      
      middlePanel.add(title);                               //add title to first row of middle panel
      middlePanel.add(gameStatus);                          //add game status label to second row of middle panel
      middlePanel.add(battleOutcome);                       //add battle outcome label to third row of middle panel
      middlePanel.add(battleButton);                        //add battle button to fourth row of middle panel
      middlePanel.add(endButton);                           //add end button to last row of middle panel
      
      leftPanel.add(p2,BorderLayout.CENTER);                //add card label to center of left panel for computer's cards 
      leftPanel.add(computerScore,BorderLayout.NORTH);      //add computer score label to north section of border layout left panel
      
      rightPanel.add(p1,BorderLayout.CENTER);               //add card label to center of right panel for user's cards
      rightPanel.add(userScore,BorderLayout.NORTH);         //add user score label to north section of border layout right panel
      
      add(leftPanel);                                       //add left panel to overall layout of window column 1
      add(middlePanel);                                     //add middle panel to overall layout of window column 2
      add(rightPanel);                                      //add right panel to overall layout of window column 3
       
      setVisible(true);                                     //set visible to true so we can see window 
      
      
      
      
    }
    
    //action listener class for battle button 
    private class ButtonListener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
       
         String[] cardInfo = game.battle();          //recieve important info from battle through arrray of string objects
         
         
         p1.setIcon(new ImageIcon(cardInfo[0]));     //first string object is the filename of the player 1's card image
         p2.setIcon(new ImageIcon(cardInfo[1]));     //second string object is the filename of the player 2's card image
         
         userScore.setText("User's Card Count: " + game.getPlayer1Cards());             //reset the card counter of the deck for player one user score label 
         computerScore.setText("Computer's Card Count: " + game.getPlayer2Cards());     //reset the card counter of the deck for player two computer score label 
         battleOutcome.setText(cardInfo[2]);                                            //set battle outcome label to the 3rd string object returned from the battle method 
         
         
         //while loop for incase their is a tie during a battle then the method war is called and the appropriate labels are updated 
         while(cardInfo[2].equals("Tie: Go to War"))
         {
            cardInfo = game.goToWar();                                                     //call go to war method 
            userScore.setText("User's Card Count: " + game.getPlayer1Cards());             //set user score label to the string objects returned from the go to war method
            computerScore.setText("Computer's Card Count: " + game.getPlayer2Cards());     //set computer score label to the string objects returned from the go to war method
            battleOutcome.setText(cardInfo[2]);                                            //set battle outcome label to the outcome returned by the got to war method 
         }
         
         
         //if statement for if winner method return anything besides not done then game is over and appropriate labels are updated 
         if(!(cardInfo[3].equals("not done")))
         {
            battleButton.setEnabled(false);      //disable the battle button 
            battleOutcome.setText(cardInfo[3]);  //set battle outcome to who ever won the game 
            gameStatus.setText("Game Over");     // set game status to game over 
          }
                      
        }
         
    }
    
    
    //action listener class for end button
    private class ButtonListener2 implements ActionListener
    {
      public void actionPerformed(ActionEvent e)
      {
         String win;                                   //initialize string varaible for string object returned from winner class
         game.setEndGame(true);                        //set the field in war class of endGame to true to end the game and report who won
         win = game.winner();                          //call winner class after changing the flag variable
         gameStatus.setText("Game Over");              //set game staus to game over         
         battleOutcome.setText(win);                   //set battle outcome label to whoever won game 
         battleButton.setEnabled(false);               // disable battle button 
       
      }
    }
      
   
    public static void main(String [] args) 
    {
      //start the GUI and program 
       new WarGUI();
       
      
   
    }
    
    
 }
      