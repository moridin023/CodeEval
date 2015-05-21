import java.util.ArrayList;
public class PrimePalindrome 
{
    public static void main (String[] args) 
    {
        int max = 1000;
		
        System.out.println(LargestPrimePalindrome(max));
    }
    
    private static int LargestPrimePalindrome(int max)
    {
        ArrayList<Integer> primes = getPrimes(max);
        
        //find the largest palindrome
        //start at the high end and the first found is the biggest
        for(int i = primes.size() - 1; i >= 0; i--)
        {
            char[] testValue = String.valueOf(primes.get(i)).toCharArray();
            int head = 0;
            int tail = testValue.length - 1;
            
            while(head <= tail)
            {
                if(testValue[head] != testValue[tail])
                {
                    break;
                }
                
                head++;
                tail--;
            }
            
            if(tail < head)
            {
                return primes.get(i);
            }
        }
        
        return -1;
    }
	
    private static ArrayList<Integer> getPrimes(int max)
    {
        ArrayList<Long> primeArray = new ArrayList();
		// add 2 to the array to start
		primeArray.add(2l);
		
		double maxDiv = Math.sqrt(max);
		
		// Run through and test the numbers before adding to the array.
		for(long i = 3; i <= max; i++)
		{
			int primeArraySize = primeArray.size() - 1;
			
			for(int j = 0; j < primeArray.size(); j++)
			{
				Long div = primeArray.get(j);
				
				if(j == primeArraySize || div > maxDiv)
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
