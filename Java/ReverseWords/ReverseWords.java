
import java.io.*;
public class ReverseWords 
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
				String[] lineTokens = line.split(" ");
				processInput(lineTokens);
			}
        }
    }
    
    private static void processInput(String[] lineTokens)
    {
		StringBuilder sb = new StringBuilder();
		
		for(int i = lineTokens.length - 1; i >= 0; i--)
		{
			sb.append(lineTokens[i]);
			
			if(i != 0)
			{
				sb.append(" ");
			}
		}
		
		System.out.println(sb.toString());
    }
}
