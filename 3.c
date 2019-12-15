#include <stdio.h>
#define MAX_NUMBER 256
#define UNTOUCHED_NUMBER -1

void main()
{
	int a[MAX_NUMBER];
	int b[MAX_NUMBER];
	int x, n, k = 0;
	for (int i = 0; i < MAX_NUMBER; i++)
	{
		a[i] = UNTOUCHED_NUMBER;
	}
	printf("Enter number of primes\n");
	scanf("%d", &n);
	printf("Enter primes\n");
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &x);
		if (a[x] == UNTOUCHED_NUMBER)
		{
			b[k] = x;
			k++;
			a[x] = 1;
		}
	}
	for (int i = 0; i < k; i++)
	{
		printf("%d\n", a[i]);
	}
} 
	
