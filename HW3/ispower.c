#include <stdio.h>

int isPower(int x)
{
	int y;
	y = !(((~x + 1) & x) ^ x); // is x like 000...0001000..00
	z = !(!(0 ^ x)); // is x != 0 ?
	t = !((x >> 31) & 1); // is x >= 0 ?
	return (y & z & t);


}



void main()
{
	int x;
    printf("Enter x\n");
	scanf("%d",&x);
	printf("%d\n", isPower(x));
	}

}
