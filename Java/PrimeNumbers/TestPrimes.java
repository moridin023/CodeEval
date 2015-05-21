import java.util.ArrayList;
import java.io.*;
public class TestPrimes 
{
    public static void main (String[] args) throws IOException
    {
        File primesFile = new File("./primesTo10000");
        BufferedReader primesBuffer = new BufferedReader(new FileReader(primesFile));
        String[] primesList;
        String primesLine;
        if((primesLine = primesBuffer.readLine()) != null)
        {
            primesLine = primesLine.trim();
            primesList = primesLine.split(",");
        }
        else
        {
            System.out.println("Failed to load primes list");
            return;
        }

		File testFile = new File(args[0]);
        BufferedReader testBuffer = new BufferedReader(new FileReader(testFile));
        String line;
        int lineNum = 1;
        while ((line = testBuffer.readLine()) != null) 
        {
            System.out.println("Testing line " + lineNum);
            line = line.trim();
            // Process line of input Here
            //System.out.println(primesLine);
            //System.out.println(line);
            String[] listOfTestPrimes = line.split(",");
            //System.out.println(primesList.length);
            //System.out.println(listOfTestPrimes.length);
			ProcessValues(primesList, listOfTestPrimes);
            lineNum++;
        }
    }

    private static void ProcessValues(String[] primes, String[] testList)
    {
        for(int i = 0; i < testList.length; i++)
        {
            if(!testList[i].equals(primes[i]))
            {
                System.out.println("\t" + testList[i] + " is not contained in the list of primes!");
            }
        }
    }
}