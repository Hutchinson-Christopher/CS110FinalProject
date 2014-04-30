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
   private final int WINDOW_WIDTH = 900;
   private final int WINDOW_HEIGHT = 500;
   public WarGUI()
   {
      setLayout(new GridLayout(1,3));
      game = new War();
      setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
      leftPanel = new JPanel();
      middlePanel = new JPanel(new GridLayout(5,1));
      rightPanel = new JPanel();
      endButton = new JButton("End Game");
      endButton.addActionListener(new ButtonListener1());
      battleButton = new JButton("Battle");
      battleButton.addActionListener(new ButtonListener1());
      title = new JLabel("WAR");
      title.setFont(new Font("HELVETICA",Font.BOLD,20));
      userScore = new JLabel("User's Card Count: " + game.getPlayer1Cards());
      userScore.setFont(new Font("ARIAL",Font.BOLD,16));
      computerScore = new JLabel("Computer's Card Count: " + game.getPlayer2Cards());
      computerScore.setFont(new Font("ARIAL",Font.BOLD,16));
      middlePanel.add(title);
      middlePanel.add(userScore);
      middlePanel.add(computerScore);
      middlePanel.add(battleButton);
      middlePanel.add(endButton);
      
      add(leftPanel);
      add(middlePanel);
      add(rightPanel);
      setVisible(true); 
      
      
      
      
    }
    
    private class ButtonListener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
      
      
      
      
      }
    }
   
    public static void main(String [] args) 
    {
       new WarGUI();
       
      
   
    }
    
    
 }
      