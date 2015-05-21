import java.util.ArrayList;
import java.io.*;
public class PrimeNumbers
{
    public static void main (String[] args) throws IOException
    {
    	long startTime = System.nanoTime();

        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null)
        {
            line = line.trim();
            // Process line of input Here
                        PrintPrimes(Long.parseLong(line));
        }

        long elapsedTime = System.nanoTime() - startTime;
        double elapsedTimeSeconds = elapsedTime/1000000000.0;
        System.out.printf("Time taken to caculate: %.3f seconds\n", elapsedTimeSeconds);
    }
   
    private static void PrintPrimes(Long max)
    {
        ArrayList<Long> primes = getPrimes(max - 1);
                StringBuffer sb = new StringBuffer();
       
        for(int i = 0; i < primes.size(); i++)
                {
                        if(i > 0)
                        {
                                sb.append(",");
                        }
                       
                        sb.append(primes.get(i));
                }
               
                System.out.println(sb);
    }
       
    private static ArrayList<Long> getPrimes(Long max)
    {
        ArrayList<Long> primeArray = new ArrayList();
               
                if(max < 2)
                {
                        return primeArray;
                }
               
                // add 2 to the array to start
                primeArray.add(2l);
               
                // Run through and test the numbers before adding to the array.
                for(long i = 3; i <= max; i += 2)
                {
                        double maxDiv = Math.sqrt(i);
                                               
                        for(int j = 0; j < primeArray.size(); j++)
                        {
                                Long div = primeArray.get(j);
                               
                                if(div > maxDiv)
                                {
                                        primeArray.add(i);
                                        break;
                                }
                               
                                if((i%div) == 0)
                                {
                                        break;
                                }
                        }
        }
               
        return primeArray;
    }
}