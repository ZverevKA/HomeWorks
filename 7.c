#include <stdio.h>
#include <stdlib.h>

int searchTwo(char A[], int N, int x)
{
	if ( A[x] != '(' )
	{
		return -1;
	}
	for (int i = x + 1; i < N; i++)
	{
		if (A[i] == ')')
		{
			return i;
		}
		if (A[i] == '(')
		{
			return -1;
		}
	}
	return -1;
} 		

int check(char A[], int N)
{
	for (int i = 0; i < N; i++)
	{
		if (A[i] != '0')
		{
			return 0;
		}
	}
	return 1;
}			

void clearTwo(char A[], int x, int y)
{
	A[x] = '0';
	A[y] = '0';
}


void main()
{
	int n;
	char *A;
	printf("Enter number of brackets\n");
	scanf("%d",&n);
	A = malloc(n * sizeof(char));
	printf("Enter bracket sequence\n");
	scanf("%s",A);
	for (int i = 1; i <= n / 2; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (searchTwo(A, n, j) > -1)
			{
				clearTwo(A, j, searchTwo(A, n, j));
			}
		}
	}
	if (check(A,n))
	{
		printf("Sequence is correct");
	}
	else printf("Sequence is incorrect");
}

