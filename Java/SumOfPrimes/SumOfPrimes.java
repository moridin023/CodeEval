import java.util.ArrayList;
public class SumOfPrimes 
{
    public static void main (String[] args) 
    {
        int numOfPrimes = 1000;
		
        System.out.println(sumOfPrimes(numOfPrimes));
    }
    
    private static int sumOfPrimes(int numOfPrimes)
    {
        ArrayList<Integer> primes = getPrimes(numOfPrimes);
        int sum = 0;
        
		for(int prime : primes)
		{
			sum = sum + prime;
		}
		
		return sum;
    }
	
    private static ArrayList<Integer> getPrimes(int numOfPrimes)
    {
        ArrayList<Integer> primeArray = new ArrayList();

        //populate the array
        //looking for primes so start at 2
		//go up to 1000 for the first section
        for (int i = 2; i <= 1000; i++)
        {
            primeArray.add(i);
        }
        
        return processPrimes(primeArray, numOfPrimes);
    }
	
	private static ArrayList<Integer> processPrimes(ArrayList<Integer> primeArray, int numberOfPrimes)
	{
		int currentMax = primeArray.get(primeArray.size() - 1);
		
		//process list
		for(int j = 0; j < primeArray.size(); j++)
        {
            int div = primeArray.get(j);
            
            if((div * div) <= primeArray.get(primeArray.size()-1))
            {
                for(int r = primeArray.size() - 1; r > j + 1; r--)
                {
                    if((primeArray.get(r)%div) == 0)
                    {
                        primeArray.remove(r);
                    }
                }
            }
        }
		
		if(primeArray.size() == numberOfPrimes)
		{
			System.out.println("ArrayList has exact number of primes");
			return primeArray;
		}
		
		if(primeArray.size() > numberOfPrimes)
		{
			while(primeArray.size() > numberOfPrimes)
			{
				primeArray.remove(primeArray.size() - 1);
			}
			return primeArray;
		}
		
		for(int i = currentMax + 1; i <= currentMax + 1000; i++)
		{
			primeArray.add(i);
		}
			
		return processPrimes(primeArray, numberOfPrimes);
	}
}
