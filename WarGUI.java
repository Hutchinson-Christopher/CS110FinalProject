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
   private War game;                                 //the guts of the game 
   private JPanel leftPanel,middlePanel,rightPanel;  // break up regions
   private JButton endButton,battleButton;           // buttons for game play and end of game
   private JLabel title;                             // semantic title of game 
   private JLabel userScore,computerScore;           // label for the number of cards in each player's deck
   private JLabel p1,p2; 
   private JLabel battleOutcome,gameStatus;
   private final int WINDOW_WIDTH = 900;
   private final int WINDOW_HEIGHT = 500;
   public WarGUI()
   {
      setLayout(new GridLayout(1,3));
      game = new War();
      setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
      leftPanel = new JPanel(new BorderLayout());
      
      middlePanel = new JPanel(new GridLayout(5,1));
      rightPanel = new JPanel(new BorderLayout());
      
      setTitle("War: a card game");
      
      endButton = new JButton("End Game");
      endButton.addActionListener(new ButtonListener1());
      battleButton = new JButton("Battle");
      battleButton.addActionListener(new ButtonListener1());
      title = new JLabel("WAR");
      p1 = new JLabel(new ImageIcon("back.jpg"));
      p2 = new JLabel(new ImageIcon("back.jpg"));
      title.setFont(new Font("HELVETICA",Font.BOLD,20));
      userScore = new JLabel("User's Card Count: " + game.getPlayer1Cards());
      battleOutcome = new JLabel("Lets Battle");
      gameStatus = new JLabel("Game in Progress");
      userScore.setFont(new Font("ARIAL",Font.BOLD,16));
      computerScore = new JLabel("Computer's Card Count: " + game.getPlayer2Cards());
      computerScore.setFont(new Font("ARIAL",Font.BOLD,16));
      middlePanel.add(title);
      middlePanel.add(gameStatus);
      middlePanel.add(battleOutcome);
      middlePanel.add(battleButton);
      middlePanel.add(endButton);
      leftPanel.add(p2,BorderLayout.CENTER);
      rightPanel.add(p1,BorderLayout.CENTER);
      leftPanel.add(computerScore,BorderLayout.NORTH);
      rightPanel.add(userScore,BorderLayout.NORTH);
      
      add(leftPanel);
      add(middlePanel);
      add(rightPanel);
      setVisible(true); 
      
      
      
      
    }
    
    private class ButtonListener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
       
         String[] cardInfo = game.battle();
         
         
         p1.setIcon(new ImageIcon(cardInfo[0]));
         p2.setIcon(new ImageIcon(cardInfo[1]));
         
         userScore.setText("User's Card Count: " + game.getPlayer1Cards());
         computerScore.setText("Computer's Card Count: " + game.getPlayer2Cards());
         battleOutcome.setText(cardInfo[2]);
         
         while(cardInfo[2].equals("Tie: Go to War"))
         {
            cardInfo = game.goToWar();
            userScore.setText("User's Card Count: " + game.getPlayer1Cards());
            computerScore.setText("Computer's Card Count: " + game.getPlayer2Cards());
            battleOutcome.setText(cardInfo[2]);
         }
         
         if(!(cardInfo[3].equals("not done")))
         {
            battleButton.setEnabled(false);
            battleOutcome.setText(cardInfo[3]);
            gameStatus.setText("Game Over");
          }
            
            
            
            
         
                   
        }
         
      }
    
   
    public static void main(String [] args) 
    {
       new WarGUI();
       
      
   
    }
    
    
 }
      