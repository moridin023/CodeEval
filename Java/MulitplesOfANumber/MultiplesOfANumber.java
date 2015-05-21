
import java.io.*;
public class MultiplesOfANumber 
{
    public static void main (String[] args) throws IOException 
    {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) 
        {
            line = line.trim();
            // Process line of input Here
			if(!line.isEmpty())
			{
				String[] lineTokens = line.split(",");
				processInput(lineTokens);
			}
        }
    }
    
    private static void processInput(String[] lineTokens)
    {
		int multiplier = 1;
		int startingNumber = Integer.parseInt(lineTokens[1]);
		int greaterThanGoal = Integer.parseInt(lineTokens[0]);
		
		while((startingNumber * multiplier) < greaterThanGoal)
		{
			multiplier++;
		}
		
		System.out.println((startingNumber * multiplier));
    }
}
