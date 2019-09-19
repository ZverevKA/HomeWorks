// ДЗ 1, Задача 5, Зверев Константин

#include <stdio.h>
#include <stdlib.h>

void inversion(int A[], int start, int end)
{
	int length;
	length = end - start + 1;
	for (int i = 0; i <= length / 2 - 1; i++)
	{
		A[i + start] ^= A[end - i] ^= A[i + start] ^= A[end - i];
	}
}

void main()
{
	int *A;
	int N, n, m;
	printf("Enter length of first part\n");
	scanf("%d", &n);
	printf("Enter length of second part\n");
	scanf("%d", &m);
	A = malloc((n + m + 1) * sizeof(int));
	printf("Enter array's elements\n");
	for (int i = 1; i <= n + m; i++)
	{
		scanf("%d", &A[i]);
	}
	inversion(A, 1, n);
	inversion(A, n + 1, n + m);
	inversion(A, 1, n + m);
	printf("Received array:\n");
	for (int i = 1; i <= m + n; i++)
	{
		printf("%d ", A[i]);
	}
	free(A);
}
