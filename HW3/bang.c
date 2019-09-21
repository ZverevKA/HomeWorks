#include <stdio.h>

int bang(int x)
{
	int y, x1, y1, a, b;
	y = ~x + 1; // y = -x
	x1 = (x >> 31) & 1;
	y1 = (y >> 31) & 1; // bit#32(x) = bit#32(-x) only if x = 0 or x = minint
	a = x1 | y1; // a = 0 <=> x = 0; else a = 1
	b = a ^ 1; // swap 1 and 0
	return b;
}

void main()
{
	int x;
	printf("Enter x\n");
	scanf("%d", &x);
	printf("!%d = %d", x, bang(x));
}	
	
