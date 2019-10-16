#include <stdio.h>

void main()
{
	int a[511];
	int x, n, k = 1;
	for (int i = 0; i <= 511; i++)
	{
		a[i] = -1;
	}
	printf("Enter number of primes\n");
	scanf("%d", &n);
	printf("Enter primes\n");
	for (int i = 1; i <= n; i++)
	{
		scanf("%d", &x);
		if (a[x] == -1)
		{
			a[255+k] = x;
			k++;
			a[x] = 1;
		}
	}
	for (int i = 1; i < k; i++)
	{
		printf("%d\n", a[255+i]);
	}
} 
	
