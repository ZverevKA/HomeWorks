//Задача 3, Зверев Константин

#include <stdio.h>

void main()
{
int a, b;
printf("Print 2 numbers(a and b)\n");
scanf("%d%d", &a, &b);
a ^= b ^= a ^= b;
printf("a=%d,b=%d", a, b);
}
