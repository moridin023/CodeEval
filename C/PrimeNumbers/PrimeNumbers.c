#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct 
{
	int *array;
	size_t used;
	size_t size;
} Array;

void initArray(Array *a, size_t initialSize)
{
	a->array = (int *)malloc(initialSize * sizeof(int));
	a->used = 0;
	a->size = initialSize;
}

void insertArray(Array *a, int element)
{
	if(a->used == a->size)
	{
		a->size *= 2;
		a->array = (int *)realloc(a->array, a->size * sizeof(int));
	}
	a->array[a->used++] = element;
}

void freeArray(Array *a)
{
	free(a->array);
	a->array = NULL;
	a->used = a->size = 0;
}

void getPrimes(int max, Array *primes)
{
	//array is null if input is less than 2
	if(max >= 2)
	{
		insertArray(primes, 2);

		for(int i = 3; i < max; i += 2)
		{
			double maxDivisor = sqrt(i);

			for(int j = 0; j < primes->used; j++)
			{
				int divisor = primes->array[j];

				if(divisor > maxDivisor)
				{
					insertArray(primes, i);
					break;
				}

				if((i%divisor) == 0)
				{
					break;
				}
			}
		}
	}
}

void processLine(char line[])
{
	int max;
	Array primes;
	initArray(&primes, 10);

	sscanf(line, "%d", &max);

	getPrimes(max, &primes);

	if(primes.used > 0)
	{
		printf("%d", primes.array[0]);

		for(int i = 1; i < primes.used; i++)
		{
			printf(",%d", primes.array[i]);
		}

		printf("\n");
	}

	freeArray(&primes);
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