#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

int symbol(char t)
{
	for (int i = 0; i <= 9; i++)
	{
		if ((t - i - '0') == 0)
		{
			return i;
		}
		if ((t - i - '-') == 0)
		{
			return -1;
		}
	}
		return -2;
	
}

void main()
{
	char s[50];
	int x = 0, len, z, m, k = 1;
	
	m = INT_MAX / 10;
	printf("Enter number\n");
	scanf("%s", s);
	len = strlen(s);
	z = symbol(s[0]);
	if (z == -1)
	{
		k = -1;
	}
	if (z == -2)
	{
			printf("ERROR Unknown symbol(number 1) %s\n", s[0]);
			return;
	}
	if (z >= 0)
	{
		x = z;
	}	

	for (int i = 1; i <= (len - 1); i++)
	{
		z = symbol(s[i]);
		if (z < 0)
		{
			printf("ERROR Unknown symbol(number %d) %c\n", (i + 1), s[i]);
			return;
		}
		
		if (k == 1 && (((INT_MAX - z) / 10 ) < x))
		{
			printf("ERROR Overflow\n");
			return;	
		}
		if (k == -1 && (((INT_MIN + z) / 10 ) > x))
		{
			printf("ERROR Overflow\n");
			return;	
		}

		x = x * 10 + z * k;
	}
	printf("%d", x);
}
