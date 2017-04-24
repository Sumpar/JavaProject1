package Project1;

//class for text language checker.
import java.io.IOException;

import javax.swing.JOptionPane;

public class LanguageChecker {
	private static int badcounter = 0;
	private static int badlength = 0;
	private static int wordcount = 0;
	private static int factors = 0;
	
	
	static void checktext(String input1) throws IOException
	{
		try
		{
			//bad words counter(calling method) if there is more than 1 its highly likely to be a informal text.
			badcounter = BadWords.CheckText(input1);
			if(badcounter > 0)
			{
				factors++;
			}
			
			//length method if returns 0 means the length of the sentence is long enough to be formal context.
			badlength = BadWords.CheckSentenceLength(input1);
			if(badlength > 0)
			{
				factors++;
			}
			
			//word alphabet counts method if return is 0 means there are more longer words than shorter ones
			wordcount = BadWords.CheckWordLength(input1);
			if(wordcount > 0)
			{
				factors++;
			}
			
			//if the factor has more than/equals to 2 value
			if(factors >= 2)
			{
				JOptionPane.showMessageDialog( null, "This sentence is informal/slang sentence");
			}
			else
			{
				JOptionPane.showMessageDialog( null, "This sentence is formal/business sentence");
			}
			
		}catch (IOException ioe)
  		{
  			ioe.printStackTrace();
  		}
	}
}
