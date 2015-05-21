
import java.io.*;
public class Lowercase 
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
				processInput(line);
			}
        }
    }
    
    private static void processInput(String line)
    {
		System.out.println(line.toLowerCase());
    }
}
