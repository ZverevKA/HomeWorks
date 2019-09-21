#include <stdio.h>

int addOK(int x, int y)
{
	int x1, y1, z, z1, a;
	x1 = ((x >> 31) & 1);
	y1 = ((y >> 31) & 1);
	z = x + y;
	z1 = ((z >> 31) & 1); // we have overflow if x and y have same sign, but x and z have different sign
	a = ((x1 ^ y1) | !(x1 ^ z1)); // z = 0 <=> (x1 = y1) and (x1 != z1)
	return a;
} 	 



void main()
{
	int x, y;
	printf("Enter x and y\n");
	scanf("%d%d", &x, &y);
	printf("%d", addOK(x, y));
} 
