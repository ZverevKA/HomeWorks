//ДЗ 1, Задача 4, Зверев Константин

#include <stdio.h>

void main()
{
	int a, b, c=0, A;
	printf("Enter dividend\n");
	scanf("%d", &a);
	printf("Enter divider\n");
	scanf("%d", &b); 
	A = a;
	while (a >= b)
	{
		a = a - b;
		c++;
	}
	printf("%d div %d = %d", A, b, c);
}
	
