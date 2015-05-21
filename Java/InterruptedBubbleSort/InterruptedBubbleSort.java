import java.io.*;
public class InterruptedBubbleSort 
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
		String[] splitLine = line.split(" \\| ");
		long runTime = Long.parseLong(splitLine[1].trim());
		long[] longArray = getIntegers(splitLine[0]);
		
		for(int j = 0; j < runTime; j++)
		{
			if(runSort(longArray))
			{
				break;
			}
		}
		
		System.out.println(arrayToString(longArray));
    }
	
	private static long[] getIntegers(String longList)
	{
		String[] stringlongArray = longList.trim().split(" ");
		long[] longArray = new long[stringlongArray.length];
		
		for(int i = 0; i < stringlongArray.length; i++)
		{
			longArray[i] = Long.parseLong(stringlongArray[i]);
		}
		
		return longArray;
	}
	
	private static boolean runSort(long[] longArray)
	{
		boolean sorted = true;
		
		for(int k = 1; k < longArray.length; k++)
		{
			if(longArray[k-1] > longArray[k])
			{
				sorted = false;
				long holding = longArray[k-1];
				longArray[k-1] = longArray[k];
				longArray[k] = holding;
			}
		}
		
		return sorted;
	}
	
	private static String arrayToString(long[] longArray)
	{
		String output = String.valueOf(longArray[0]);
		
		for(int i = 1; i < longArray.length; i++)
		{
			output = output.concat(" " + String.valueOf(longArray[i]));
		}
		
		return output;
	}
}
