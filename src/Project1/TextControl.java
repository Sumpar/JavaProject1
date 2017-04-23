package Project1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.BufferedWriter;


public class TextControl 
{
	private static BufferedWriter bw;
	private static BufferedReader br;
	private static String word = "";
	private static String splitby = ",";
	private static String[] words;
	private static ArrayList<String> ar1 = new ArrayList<String>();

	
	//directory needed to be changed
	private static File file = new File("D:\\Programs\\JAVA\\Myproject\\JavaProject1\\src\\JavaAssignment\\dictionary.txt");
 

	
	//method to write into file.
	static void getFileWriter(String input1) throws IOException
    {
		try
    	{
			//file reader
			br = new BufferedReader(new FileReader(file));
			int i = 0;
			
    		//make a text file if it does not exist.
    		if(!file.exists())
    		{
    			file.createNewFile();
    		}
    		
    		
    		//error check to make sure the word is not in the dictionary.
    		while ((word = br.readLine()) != null) //need a better file reader than this
			{
				words = word.split(splitby);
				i++;
			}
    		for(i=0;i < words.length;i++)
    		{
    			ar1.add(words[i]);
    			System.out.println(words[i]);
    		}
    		
    		boolean valid = ar1.contains(i); 
	    	if(valid == true)
			{
				JOptionPane.showMessageDialog( null, "Already have that word");
	   			//break method
	    		return;
			}
    		//error check to make sure its not empty
    		if(input1.isEmpty())
    		{
    			JOptionPane.showMessageDialog( null, "Empty Tect Detected");
    			//break method
    			return;
    		}
    		else
    		{
    			FileWriter fw = new FileWriter(file,true);
    			bw = new BufferedWriter(fw);
    			bw.append(input1);
    			bw.append(",");
		
    			JOptionPane.showMessageDialog(null, "Following text has been added ="+input1, "Successful", JOptionPane.INFORMATION_MESSAGE);
    		}
    	}catch (IOException ioe)
  		{
  			ioe.printStackTrace();
  		}
		
		//empty
    	finally
    	{
    		try
    		{
    			if(bw!=null)
    			{
    				bw.close();
    			}
    		}catch(Exception ex)
    		{
    			System.out.println("Error in BufferedWriter"+ex);
    		}
    		if(br != null)
    		{
    			br.close();
    		}
    	}
    	
    }
}
