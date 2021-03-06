package Project1;

/* SUMIN PARK
 *
 * This is the screen part of the project. 
 * Have all the variables of screen and button interactions(Menu)
 */
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Screen extends JFrame implements ActionListener 
{
   private JFrame frame = new JFrame("Java project");
   private JPanel panelCont = new JPanel();
   private JPanel panel1 = new JPanel();
   private JPanel panel2 = new JPanel();
   private JPanel panel3 = new JPanel();
   private JPanel panel4 = new JPanel();
   private JTextField text1 = new JTextField();
   private JTextField text2 = new JTextField();
   private CardLayout c1 = new CardLayout();
   private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
   private JLabel label1;
   
   private static File file = new File("D:/");
   private static FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File","txt");

      
   // constructor
   public Screen(String title)
   {
	   super(title);
	   
	   //variables
	   label1 = new JLabel("Choose between following options");
	   button1 = new JButton("Type in your own text");
	   button2 = new JButton("Choose from the file");
	   button3 = new JButton("Add in your own bad language");
	   button4 = new JButton("Main Menu");
	   button5 = new JButton("Main Menu");
	   button6 = new JButton("Main Menu");
	   button7 = new JButton("Confirm");
	   button8 = new JButton("Confirm");
	   button9 = new JButton("Attach");
	   
	   panelCont.setLayout(c1);
	   c1.show(panelCont, "1");

	   
	   //add to panel 1
	   panel1.add(label1);
	   panel1.add(button1);
	   panel1.add(button2);
	   panel1.add(button3);
	   
	   //add to panel 2
	   panel2.add(text1);
	   panel2.add(button7);
	   panel2.add(button4);
	   
	   //add to panel 3
	   panel3.add(button9);
	   panel3.add(button5);
	   
	   //add to panel 4
	   panel4.add(text2);
	   panel4.add(button8);
	   panel4.add(button6);
	   
	   //add panels to card
	   panelCont.add(panel1, "1");
	   panelCont.add(panel2, "2");
	   panelCont.add(panel3, "3");
	   panelCont.add(panel4, "4");
	   
	   
	   //custom sizes set
	   Dimension panels = new Dimension(400,200);
	   Dimension mainbuttons = new Dimension(250,30);
	   Dimension exitbuttons = new Dimension(130,30);
	   Dimension textfield = new Dimension(400,30);
	   
	   
	   //panel sizes
	   panel1.setPreferredSize(panels);
	   panel2.setPreferredSize(panels);
	   panel3.setPreferredSize(panels);
	   panel4.setPreferredSize(panels);
	   
	   
	   //button sizes
	   button1.setPreferredSize(mainbuttons);
	   button2.setPreferredSize(mainbuttons);
	   button3.setPreferredSize(mainbuttons);
	   button4.setPreferredSize(exitbuttons);
	   button5.setPreferredSize(exitbuttons);
	   button6.setPreferredSize(exitbuttons);
	   button7.setPreferredSize(exitbuttons);
	   button8.setPreferredSize(exitbuttons);
	   button9.setPreferredSize(exitbuttons);
	   
	   
	   //text field sizes
	   text1.setPreferredSize(textfield);
	   text2.setPreferredSize(textfield);
	   
	   
	   //action Listeners
	   button1.addActionListener(this);
	   button2.addActionListener(this);
	   button3.addActionListener(this);
	   button4.addActionListener(this);
	   button5.addActionListener(this);
	   button6.addActionListener(this);
	   button7.addActionListener(this);
	   button8.addActionListener(this);
	   button9.addActionListener(this);
	   
	   frame.add(panelCont);
	   frame.pack();
	   frame.setVisible(true);
	   frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
   
   public void actionPerformed(ActionEvent e){
	   JButton src = (JButton) e.getSource();
	   
	   
	   //navigation buttons
	   if(src.equals(button1))
	   {
		   //switch to option 2
		   c1.show(panelCont, "2");
	   }
	   else if(src.equals(button2))
	   {
		   //switch to option 3
		   c1.show(panelCont, "3");
	   }
	   else if(src.equals(button3))
	   {
		   //switch to option 4
		   c1.show(panelCont, "4");
	   }
	   else if(src.equals(button4))
	   {
		   //switch to main menu
		   c1.show(panelCont, "1");
	   }
	   else if(src.equals(button5))
	   {
		   //switch to main menu
		   c1.show(panelCont, "1");
	   }
	   else if(src.equals(button6))
	   {
		   //switch to main menu
		   c1.show(panelCont, "1");
	   }
	   //end of navigation buttons
	   //confirm on check user's input 
	   else if(src.equals(button7))
	   {
		   String input1 = text1.getText();
		   try 
		   {
			   LanguageChecker.CheckText(input1);
		   }catch (IOException e1) 
		   {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		   }
	   }
	   
	   //confirm on add new word on dictionary
	   else if(src.equals(button8))
	   {
		   String input1 = text2.getText();
		   try
		   {
			   TextControl.getFileWriter(input1);
		   }catch (IOException e1) 
		   {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
		   }
	   }
	   
	   //file chooser button (when pressed attach)
	   else if(src.equals(button9))
	   {
		   	//variables for JFileChooser
		   	JButton open = new JButton();
		   	JFileChooser fs = new JFileChooser();
		   	
	 		//fs.setDialogTitle("Choose a text file");
	 		//fs.setCurrentDirectory(file);
	 		//fs.showOpenDialog(null);
		   	
	 		fs.setFileFilter(filter);
	 		if(fs.showOpenDialog(open) == JFileChooser.APPROVE_OPTION)
	 		{
	 			File f = fs.getSelectedFile();
	 			try 
	 			{
					LanguageChecker.CheckFile(f);
	 			}catch (IOException e1) 
	 			{
	 				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	 		}
	   }
	   
   }

}
