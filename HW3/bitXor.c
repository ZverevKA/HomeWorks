#include <stdio.h>

int bitXor(int x, int y)
{
	int z,t;
	z = ~(~x & ~y); // bit №i of z == 0 <=> bit №i of x and y == 0
	t = ~(x & y); // bit №i of t == 0 <=> bit №i of x and y == 1
	return (z & t); // bit №i ==0 <=> (bit №i of x) == (bit №i of y)
}

void main()
{
	int x, y;
	printf("Enter x and y\n");
	scanf("%d%d", &x, &y);
	printf("%d", bitXor(x, y));
} 

