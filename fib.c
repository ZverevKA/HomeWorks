#include <stdio.h>

void main()
{
	unsigned long x = 0, y = 1;
	int n;
	printf("Enter n\n");
	scanf("%d", &n);
	for (int i = 2; i <= n; i++)
	{
		x = x + y;
		x ^= y;
		y ^= x;
		x ^= y;
	}
	printf("F(%d) = %llu", n, y);
} 
