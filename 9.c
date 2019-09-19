// ДЗ 1, Задача 9, Зверев Константин

#include <stdio.h>
#include <stdlib.h>

void sieve(int N, int p, int A[])
{
	
	for (int i=p*p;i<=N;i=i+p)
	{
		A[i]=1;
	}
	if (p*p>=N) return;
	else for(int i=p+1;i<=N;i++)
	{
		if (A[i]==0)
		return sieve(N,i,A);
	}
}

void main()
{
	int n, *A;
	printf("Enter N\n");
	scanf("%d", &n);
	A = malloc((n + 1) * sizeof(int));
	for (int i = 2; i <= n; i++)
	{
		A[i] = 0;
	}
	sieve(n, 2, A);
	printf("Prime numbers from 1 to %d:\n",n);
	for (int i = 2; i <= n; i++)
	{
		if (A[i] == 0)
		{
			printf("%d ",i);
		}
	}
	free(A);
}
		
