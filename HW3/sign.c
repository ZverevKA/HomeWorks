#include <stdio.h>

int sign(int x)
{
	int a, b, d;
	d = ~0; // d = -1
	a = ((x >> 31) & d); // if x < 0 then a = -1, else a = 0
	b = ((~(x + d) >> 31) & 1); // b = 1 if (x > 0 or x = minint), else b = 0   
	return (a | b); // 1)x < 0: (a | anithing) equal -1, 2)x = 0: (0 | 0) equal 0, 3)x > 0: (0 | 1) equal 1
} 

void main()
{
	int x;
	printf("Enter x\n");
	scanf("%d", &x);
	printf("%d's sign is %d", x, sign(x));
} 
