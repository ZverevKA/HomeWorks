#include <stdio.h>

int thirdBits()
{
	int x = 0, y = 146; // 146 = (10010010)2
	y = y << 1; // 100100100
	x += y;
	x = x << 9;
	x += y;
	x = x << 9;
	x += y;
	x = x << 3;
	x += 4; // 4 = (100)2
	return x;
}

void main()
{
	printf("%d is number, which has 1 int every third bit", thirdBits());
} 

	
