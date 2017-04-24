package Project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BadWords {
	private static BufferedReader br;
	private static String word = "";
	private static String splitby = ",";
	private static String[] words;
	private static int counter = 0;
	
	//directory needed to be changed
	private static File file = new File("D:\\dictionary.txt");
 
	//method to check sentence length after typing sentence
	static int CheckSentenceLength(String input1)
	{
		int counter = 0;
		int SLength = input1.length();
		//average words in a formal sentences are about 27 including spaces/dot
		if(SLength < 27)
		{
			counter++;
		}

		//return value
		return counter;
	}
	
	static int CheckWordLength(String input1)
	{
		int i;
		int counter = 0;
		double avglength = 0;
		
		String[] cwords = input1.split("\\s+");
		
		//loop to check word's lengths
		for(i=0;i > cwords.length; i++)
		{
			//average word lengths = 5 so above/equals to 5 is more complex word(could be formal)
			if(cwords[i].length() >= 5)
			{
				avglength++;
			}
		}
		
		/*if average length of words counted exceeds half of the words counted. more likely to be a formal context
		/*so if it does not exceeds more likely to be a non-formal context
		 */
		if(avglength < cwords.length / 2)
		{
			counter++;
		}
		return counter;
	}
	
	//method to check the words in a sentence
	@SuppressWarnings("finally")
	static int CheckText(String input1) throws IOException
	{
		try
		{
			//file reader
			br = new BufferedReader(new FileReader(file));
			int i = 0;
			int j = 0;
			int c = 0;
			
			//Reading the dictionary file
    		while ((word = br.readLine()) != null)
			{
    			words = word.split(splitby);
				i++;
			}
    		//make input1 to an array
    		String[] cwords = input1.split("\\s+");
    		
    		//compare 2 arrays
    		for(i=0;i < cwords.length;i++)
    		{
    			for(j=0;j < words.length;j++)
    			{
    				if(words[j].equals(cwords[i]))
    				{
    					c++;
    				}
    			}
    		}
    		
    		//if more than 1 slang
    		if(c > 0)
    		{
    			counter++;
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
    			if(br!=null)
    			{
    				br.close();
    			}
    		}catch(final Exception ex)
    		{
    			System.out.println("Error in BufferedWriter"+ex);
    		}
    	//return value
		return counter;
    	}
	}
}