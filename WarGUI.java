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
   private Jbutton endButton,battleButton;           // buttons for game play and end of game
   private Jlabel title;                             // semantic title of game 
   private Jlabel userScore,computerScore;           // label for the number of cards in each player's deck 
   
   public WarGUI()
   {
      setLayout(new GridLayout(1,3));
      game = new War();
      leftPanel = new JPanel();
      middlePanel = new JPanel(new GridLayout(5,1));
      rightPanel = new JPanel();
      endButton = new JButton();
      battleButton = new JButton;
      title = new JLabel("WAR");
      title.setFont(new Font("HELVETICA",Font.BOLD,20));
      
    }
    
    
 }
      