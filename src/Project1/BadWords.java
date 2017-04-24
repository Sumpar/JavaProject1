package Project1;

/* SUMIN PARK
 * 
 * This class contains all the methods that is being used by language checker .
 * Returns variables to be used to validate language style.
 */
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
	
	//method to check word length
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
		double sentence = cwords.length;
		if(avglength < sentence / 2)
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
    	br.close();
		return counter;
    	}
	}
	
	//method to check sentence length after typing sentence
	static int CheckTextLength(File file1) throws IOException
	{
		int counter = 0;
		int i = 0;
		int SLength = 0;
		int avglength = 0;
		//file reader
		br = new BufferedReader(new FileReader(file1));		
			
		while ((word = br.readLine()) != null)
		{
			words = word.split("\n");
		}
		
		for(i=0; i < words.length; i++)
		{
			//paragraph's length
			SLength = words[i].length();
			//average words in a formal text/paragraph are about 69 - 190 including spaces/dot so if it exceeds 170 more likely to be a formal text.
			if(SLength < 140)
			{
				avglength++;
			}
		}
		
		double paragraphs = words.length;
		//if average length is higher than 3/1 = more likely to be a formal text
		if(avglength < paragraphs / 3)
		{
			counter++;
		}
		
		//close file reader
		br.close();
		//return value
		return counter;
	}
	
	//method to return file's content as string
	static String FileCheck(File file1) throws IOException
	{
		//file reader
		br = new BufferedReader(new FileReader(file1));		
		StringBuilder sb = new StringBuilder();
			
		String line = br.readLine();
		//loop to read in line by line
		while(line != null)
		{
			sb.append(line);
			sb.append(System.lineSeparator());
			line = br.readLine();
		}
		String input1 = sb.toString();
		
		br.close();
		//return file's content as string.
		return input1;
	}
	
	
}