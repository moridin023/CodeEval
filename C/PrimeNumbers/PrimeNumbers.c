#include <stdio.h>

void getPrimes(int max)
{
	if(max < 2)
	{
		//return an empty array
	}

	//add 2 to the base array as the first entry

	for(int i = 3; i <= max; i += 2)
	{
		//get the sqrt of 'i' value

		//replace somelegth with the length of the array that is storing the values in
		for(int j = 0; j < somelength; j++)
		{
			//pull out the Jth element from the array

			if(divisor > maxDivisor)
			{
				//add 'i' value to storage array
				break;
			}

			if((i%divisor) == 0)
			{
				break;
			}
		}
	}

	//possibly return array or just end if using pointers
}

void processLine(char line[])
{
	int max;
	sscanf(line, "%d", &max);

	getPrimes(max);

	//somehow print out the list of primes
}

int main(int argc, const char * argv[]) 
{
    FILE *file = fopen(argv[1], "r");
    char line[1024];
    while (fgets(line, 1024, file)) 
    {
        processLine(line);
    }
    return 0;
}