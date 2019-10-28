#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int toASCII(int x)
{
	if (x >= 'A' && x <='Z')
	{
		return (x - 'A');
	}
	if (x >= 'a' && x <= 'z')
	{
		return (x - 71);
	}
	if (x == '+')
	{
		return 62;
	}
	if (x >= '0' && x <= '9')
	{
		return (x + 4);
	}
	if (x == 47)
	{
		return 63;
	}
	if (x == '=')
	{
		return 0;
	}

}




int take4Sign(size_t k, char in[])
{
	int x1, x2, x3, x4;
	x1 = (int)toASCII(in[4 * k]);
	x2 = (int)toASCII(in[4 * k + 1]);
	x3 = (int)toASCII(in[4 * k + 2]);
	x4 = (int)toASCII(in[4 * k + 3]);
	return (x1 * 64 * 64 * 64 + x2 * 64 * 64 + x3 * 64 + x4);
}



void main()
{
	char *in;
	char *out;
	int x, t = 0;
	size_t n;

	printf("Enter length of string\n");
	scanf("%zu", &n);
	printf("Enter string\n");
	in = malloc((n + 1) * sizeof(char));
	if (in == NULL)
	{
		printf("Memory ERROR\n");
		return;
	}
	fgets(in, n + 1, stdin);
	fgets(in, n + 1, stdin);
	if (in == NULL)
	{
		printf("Reading ERROR\n");
		return;
	}
	if (in[n - 1] == '=')
	{
		t = 1;
	}
	if (in[n - 2] == '=')
	{
		t = 2;
	}
	out = malloc(((n * 3 / 4) + 1) * sizeof(char));
	if (out == NULL)
	{
		printf("Memory ERROR\n");
		return;
	}
	
		


	for (size_t i = 0; i < (n / 4); i++)
	{
		x = take4Sign(i, in);
		for (int j = 0; j <= 2; j++)
		{
			out[i * 3 + j] = (char)((x >> (8 * (2 - j))) & 255);
		}
	}

	out[(n * 3 / 4) - t] = '\0'; 
	printf("%s", out);
	free(in);
	free(out);
}
