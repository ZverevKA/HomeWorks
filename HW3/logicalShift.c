#include <stdio.h>

int logicalShift(int x, int n)
{
	int a, b, c, d, n1;
	a = ((x >> 31) & 1); // a = 1 if x >= 0, else a = 0
	n1 = ~n + 1; // n1 = -n
	b = a << (32 + n1); 
	c = (x >> n) + b; // if bit#(32-n..32) were equal 1, after + b they will be 0
	return c;
}
void main()
{
	int x, n;
	printf("Enter x and number for logical right shift\n");
	scanf("%d%d", &x, &n);
	printf("%d", logicalShift(x, n));
} 
