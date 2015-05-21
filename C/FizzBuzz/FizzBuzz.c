#include <stdio.h>
#include <string.h>

void processLineWithScan(char line[])
{
	int x, y, count;
	sscanf(line, "%d %d %d", &x, &y, &count);

	for(int i = 1; i <= count; i++)
	{
		int printNum = 1;

		if((i%x) == 0)
		{
			printNum = 0;
			printf("F");
		}
		if((i%y) == 0)
		{
			printNum = 0;
			printf("B");
		}
		if(printNum)
		{
			printf("%d", i);
		}

		if(i != count)
		{
			printf(" ");
		}
	}

	printf("\n");
}

int main(int argc, const char * argv[]) 
{
    FILE *file = fopen(argv[1], "r");
    char line[1024];
    while (fgets(line, 1024, file)) 
    {
        processLineWithScan(line);
    }
    return 0;
}