#include <stdio.h>

int conditional(int x, int y, int z)
{
	int a, b, c; 
	a = ~(!!(x ^ 0)) + 1; // if x != 0 then a = (11111..11)2, else a = 0
	b = ~(!(x^0)) + 1; // if x != 0 then a = 0, else a = (1111..11)2
	c = (a & y) + (b & z); // one of bracets equals 0, another equals y or z(that we need)
	return c;
}

void main()
{
	int x, y, z;
	printf("We want to know value of x ? y : z\n");
	printf("Enter x, y and z\n");
	scanf("%d%d%d", &x, &y, &z);
	printf("%d ? %d : %d = %d", x, y, z, conditional(x, y, z));
}
