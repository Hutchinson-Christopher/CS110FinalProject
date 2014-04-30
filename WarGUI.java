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
   private War game;     //the guts of the game 
   private JPanel leftPanel,middlePanel,rightPanel;  // break up regions
   private JButton endButton,battleButton;           // buttons for game play and end of game
   private JLabel title;                             // semantic title of game 
   private JLabel userScore,computerScore;           // label for the number of cards in each player's deck 
   
   public WarGUI()
   {
      setLayout(new GridLayout(1,3));
      game = new War();
      leftPanel = new JPanel();
      middlePanel = new JPanel(new GridLayout(5,1));
      rightPanel = new JPanel();
      endButton = new JButton();
      endButton.addActionListener(new ButtonListener());
      battleButton = new JButton();
      battleButton.addActionListener(new ButtonListener());
      title = new JLabel("WAR");
      title.setFont(new Font("HELVETICA",Font.BOLD,20));
      userScore = new JLabel("User's Card Count: ");
      userScore.setFont(new Font("ARIAL",Font.BOLD,16));
      computerScore = new JLabel("Computer's Card Count: ");
      computerScore.setFont(new Font("ARIAL",Font.BOLD,16));
      middlePanel.add(title);
      middlePanel.add(userScore);
      middlePanel.add(computerScore);
      middlePanel.add(battleButton);
      middlePanel.add(endButton);
      
      add(leftPanel);
      add(middlePanel);
      add(rightPanel);
      
      
      
      
    }
    
    private class ButtonListener implements ActionListener
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
      