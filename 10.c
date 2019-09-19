// ДЗ 1, Задача 10, Зверев Константин

#include <stdio.h>
#include <stdlib.h>

void main()
{
	int n, s = 0;
	int *A;
	printf("Enter size of array\n");
	scanf("%d",&n);
	A = malloc(n * sizeof(int));
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
} 
