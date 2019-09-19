// ДЗ 1, Задача 6, Зверев Константин

#include <stdio.h>

int sumOfSign(int a)
{
	int sum = 0;
	if (a == 0)
	{
		return 0;
	}
	while (a > 0)
	{
		sum += a % 10;
		a = a / 10;
			
	}
	return sum;
}


void main()
{
	const int N = 1000;
	const int C = 28;
	int n = 0;
	int A[C];
	for (int i = 0; i < C; i++)
	{
		A[i] = 0;
	}
	for (int i = 0; i < 1000; i++)
	{
		A[sumOfSign(i)]++;
	}
	for (int i = 0; i < 28; i++)
	{
		n += A[i] * A[i];
	}
	printf("Number of lucky tickets is %d", n);
}

