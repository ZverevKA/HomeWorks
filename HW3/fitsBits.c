#include <stdio.h>

int fitsBits(int x, int n)
{
	int a, b, c, d, e, n1;  // we need return 1 if -(2^(n-1)) <= x <= 2^(n-1) -1
	d = ~0; // d = -1
	n1 = n + d; // n1 = n - 1
	a = !(d & (x >> n1));  // is 0 <= x <= 2^(n-1) (else we have (bit#i = 1 ), i > (n-1)) ?
	b = (~(x + d))+d; // if x < 0 b = (|x| - 1) else (bit#32 = 1)
	e = !(d & (b >> n1)); // same "a"
	c = !(n ^ 32); // c = 1 if n = 32
	return (a | c | e);
}

void main()
{
	int x, n;
	printf("Enter x and number of bits\n");
	scanf("%d%d", &x, &n);
	printf("%d", fitsBits(x, n));
} 
