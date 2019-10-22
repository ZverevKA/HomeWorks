#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int g1 = 1, g2 = 2, g3 = 3, g4 = 4, g5 = 5;
char c1 = 10, c2 = 11;
float f1 = 1., f2 = 2.;



int summa (int x, int y)
{
	return (x+y);
}

int difference(int x, int y)
{
	int k = 0;
	printf("pointer k = %p", &k);
	return (x-y);
}

int multiplication(int x, int y)
{
	return (x * y);
}

int divison(int x, int y)
{
	return(x / y);
}


int main()
{
	int a1 = 1, a2 = 2, a3 = 3, n;
	static int s1 = 1, s2 = 2;
	char b1 = 1, b2 = 2;
	int *arr1;
	int *arr2;
	int *arr3;
	int arr4[1], arr5[2], arr6[3];
	printf("Enter size of array\n");
	scanf("%d", &n);
	arr1 = malloc(n * sizeof(int));
	if (arr1 == NULL)
	{
		printf("Memory error");
		return -1;
	}

	arr2 = malloc ((n + 1) * sizeof(int));	
	if (arr2 == NULL)
	{
		printf("Memory error");
		return -1;
	}	

	arr3 = malloc((n + 2) * sizeof(int));
	if (arr1 == NULL)
	{
		printf("Memory error");
		return -1;
	}


	printf("1) Global int pointer 1 %p\n", &g1);
	printf("2) Global int pointer 2 %p\n", &g2);
	printf("3) Global int pointer 3 %p\n", &g3);
	printf("4) Static int pointer 1 %p\n", &s1);
	printf("5) Static int pointer 2 %p\n", &s2);
	printf("6) Local int pointer 1 %p\n", &a1);
	printf("7) Local int pointer 2 %p\n", &a2);
	printf("8) Local int pointer 3 %p\n", &a3);
	printf("9) Local int pointer 4 %p\n", &n);

	printf("10) Dinamic array's pointer 1 %p\n", arr1);
	printf("11) Dinamic array's pointer 2 %p\n", arr2);
	printf("12) Dinamic array's pointer 3 %p\n", arr3);
	printf("13) Static array's pointer 1 %p\n", arr4);
	printf("14) Static array's pointer 2 %p\n", arr5);
	printf("15) Static array's pointer 3 %p\n", arr6);
	
	printf("16) Custom function's pointer 1 %p\n", summa);
	printf("17) Custom function's pointer 2 %p\n", difference); 
	printf("18) Custom function's pointer 3 %p\n", multiplication);
	printf("19) Custom function's pointer 4 %p\n", divison);
	printf("20) System function's pointer 1 %p\n", printf);
	printf("21) System function's pointer 2 %p\n", scanf);
	printf("22) System function's pointer 3 %p\n", malloc);
	printf("23) System function's pointer 4 %p\n", abs);
	printf("24) System function's pointer 5 %p\n", getchar);
	printf("25) Global char pointer 1 %p\n", &c1);
	printf("26) Global char pointer 2 %p\n", &c2);
	printf("27) Global float pointer 1 %p\n", &f1);
	printf("28) Global float pointer 2 %p\n", &f2);
	printf("29) Local char pointer 1 %p\n", &b1);
	printf("30) Local char pointer 2 %p\n", &b2);
	free(arr1);
	free(arr2);
	free(arr3);
}
