package Project1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

	
	//directory needed to be changed cause somehow I cannot read the text file in my directory...
	private static File file = new File("D:\\dictionary.txt");
										
 

	
	//method to write into file.
	static void getFileWriter(String input1) throws IOException
    {
		try
    	{
			//file reader
			br = new BufferedReader(new FileReader(file));
			int i = 0;
			
    		//make a text file if it does not exist. but does not work....
    		if(!file.exists())
    		{
    			file.createNewFile();
    		}
    		
    		
    		//error check to make sure the word is not in the dictionary.
    		while ((word = br.readLine()) != null)
			{
				words = word.split(splitby);
				i++;
			}
    		for(i=0;i < words.length;i++)
    		{
    			if(words[i].equals(input1))
    			{
    				JOptionPane.showMessageDialog( null, "Already have that word in dictionary");
    	   			//break method
    	    		return;
    			}
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
    			//file writers
    			FileWriter fw = new FileWriter(file,true);
    			bw = new BufferedWriter(fw);
    			bw.append(input1);
    			bw.append(",");
    			
    			//show dialog when its added successfully
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
