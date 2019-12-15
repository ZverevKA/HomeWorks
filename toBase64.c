#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int take3Bait(size_t k, char in[])
{
	int x1, x2, x3;
	x1 = (int)in[3 * k];
	x2 = (int)in[3 * k + 1];
	x3 = (int)in[3 * k + 2];
	return (x1 * 256 * 256 + x2 * 256 + x3);
}



void main()
{
	char a[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	char *in;
	char *out;
	int str3[3];
	int  x, y;
	size_t n, n1;	
	
	printf("Enter length of string\n");
	scanf("%zu", &n);
	n1 = n + ((((2 * n) % 3) + 3) % 3);
	in = malloc((n1 + 1) * sizeof(char));
	if (in == NULL)
	{
		printf("Memory ERROR\n");
		return;
	}
	printf("Enter string\n");
	fgets(in, n + 1, stdin);
	fgets(in, n + 1, stdin);
	if (in == NULL)
	{
		printf("Reading ERROR\n");
		return;
	}
	for (size_t i = n; i < n1; i++)
	{
		in[i] = 0;
	}
	in[n1] = '\0';
 
	out = malloc(((n1 * 4 / 3) + 1) * sizeof(char));
	if (out == NULL)
	{
		printf("Memory ERROR\n");
		return;
	}
	for (size_t i = 0; i < n1 / 3; i++)
	{
		x = take3Bait(i, in);
		for (int j = 3; j >= 0; j--)
		{
			y = x;
			y = (y >> (6 * j)) & 63;
			out[4 * i + (3 - j)] = a[y];
		}
	}
	for (size_t i = 1; i <= n1 - n; i++)
	{
		out[(n1 * 4 / 3) - i] = '=';
	}
	out[n1 * 4 / 3] = '\0';
	printf("%s", out);
	free(in);
	free(out);
}				 		
	
