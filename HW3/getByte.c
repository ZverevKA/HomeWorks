#include <stdio.h>

int getByte(int x, int n)
{
	int y,z;
	z = n + n; // z=2n
	z = z + z; // z=4n
	z = z + z; // z=8n
	y = x >> z;
	return (y & 255);
}

void main()
{
	int x, n;
	printf("Enter x and number of byte\n");
	scanf("%d%d", &x, &n);
	printf("%d", getByte(x, n));
} 
