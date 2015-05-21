
import java.io.*;
public class FizzBuzz 
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
			String[] lineTokens = line.split(" ");
			System.out.println(processInput(Integer.parseInt(lineTokens[0]), Integer.parseInt(lineTokens[1]), Integer.parseInt(lineTokens[2])));
        }
    }
    
    private static String processInput(int fDiv, int bDiv, int count)
    {
		
        boolean printCount = true;
        StringBuilder sb = new StringBuilder();
        
        if((count%fDiv) == 0)
        {
            sb.append("F");
            printCount = false;
        }
        
        if((count%bDiv) == 0)
        {
            sb.append("B");
            printCount = false;
        }
        
        if(printCount)
        {
            sb.append(count);
        }
        
        if(count == 1)
        {
            return sb.toString();
        }
        
        return processInput(fDiv, bDiv, (count - 1)) + " " + sb.toString();
    }
}
