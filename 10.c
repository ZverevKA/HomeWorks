// ДЗ 1, Задача 10, Зверев Константин

#include <stdio.h>
#include <stdlib.h>

void main()
{
	int n, s = 0;
	int *A;
	printf("Enter size of array\n");
	scanf("%d",&n);
	A = (int *)malloc(n * sizeof(int));
	if (A == NULL)
	{
		printf("Memory ERROR");
		return -1
	}
	printf("Enter array's elements\n");
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &A[i]);
		if (A[i] == 0)
		{
			s++;
		}
	}
	printf("In array there are %d zero elements", s);
	free(A);
} 
