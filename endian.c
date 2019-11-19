#include <stdio.h>

void main()
{
	signed short *a;
	signed short b = 1; // b = 000..0001
	char *c;
	char x;
	a = &b;
	c = (char *)a;
	x = *c; // => x = 0000..00 or x = 000..001
	if (x == 1)
	{
		printf("Little-endian\n");
	}
	else
	{
		printf("Big-endian\n");
	}
	
}
