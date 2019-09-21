#include <stdio.h>

int bitAnd(int x, int y)
{
	int z;
	z = (~x | ~y); // (bit №i of z) == 0 if (bit №i of x and bit №i of y == 1);
	return ~z;
}

void main()
{
	int x, y;
	printf("Enter x and y\n");
	scanf("%d%d", &x, &y);
	printf("%d", bitAnd(x, y));
} 
