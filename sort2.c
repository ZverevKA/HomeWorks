#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <limits.h>

void printArr(unsigned a[], size_t n)
{
	for (size_t i = 0; i < n; i++)
	{
		printf("%u\n", a[i]);
	}
}	

void swap(unsigned *a, size_t x, size_t y)
{
	if (x != y)
	{
		a[x] ^= a[y];
		a[y] ^= a[x];
		a[x] ^= a[y];
	}
}

size_t minarr(unsigned a[], size_t n, size_t x)
{
	size_t k = x;
	for (size_t i = (x + 1); i < n; i++)
	{
		if (a[k] > a[i])
		{
			k = i;
		}
	}
	return k;
}

unsigned* sortN2(unsigned a[], size_t n)
{
	for (size_t i = 0; i < (n - 1); i++)
	{
		swap(a, i, minarr(a, n, i));
	}
	return a;
}



void halfSort(unsigned a[], size_t x, size_t y, unsigned b[])
{
	size_t c1, c2, count;
	if (x == y)
	{
		return;
	}
	else
	{
		size_t t = ((x + y) / 2);
		halfSort(a, x, t, b);
		halfSort(a, t + 1, y, b);
		c1 = x;
		c2 = t + 1;
		count = x;
		while (count <= y)
		{
			if (c1 <= t & c2 <= y)
			{
				if (a[c1] < a[c2])
				{
					b[count] = a[c1];
					c1++;
				}
				else 
				{
					b[count] = a[c2];
					c2++;
				}
			}
			else 
			{
				if (c1 > t)
				{
					b[count] = a[c2];
					c2++;
				}
				else 
				{
					b[count] = a[c1];
					c1++;
				}
			}
			count++;	
		}	
		for (size_t i = x; i <= y; i++) // copy new array
		{
			a[i] = b[i];
		}
	}
}

unsigned* sortNLOGN(unsigned a[], size_t n)
{
	int *b;
	b = malloc(n * sizeof(unsigned));
	if (b == NULL)
	{
		printf("Memory ERROR\n");
	}
	halfSort(a, 0, n - 1, b);
	free(b);
	return a;
}

unsigned* sortN(unsigned a[], size_t n)
{
	unsigned ARR[USHRT_MAX] = {0};
	size_t k = 0;
	for (size_t i = 0; i < n; i++)
	{
		ARR[a[i]]++;
	}
	for (size_t i = 0; i < USHRT_MAX; i++)
	{
		for (size_t j = 1; j <= ARR[i]; j++)
		{	
			a[k] = i;
			k++;
			if (k >= n)
			{
				return a;
			}
		}
	}
}




void copyArr(unsigned a[], unsigned b[], size_t n)
{
	for (size_t i = 0; i < n; i++)
	{
		b[i] = a[i];
	}
}


unsigned* randomArr(unsigned a[], size_t n)
{
	srand(274);
	for (size_t i = 0; i < n; i++)
	{
		a[i] = rand() % USHRT_MAX;
	}
	return a;
}







void main()
{
	char *o[3] = {"N", "N*logN", "N^2"};
	clock_t start, stop;
	unsigned* (*diffSorts[3])(unsigned*, size_t) = {&sortN, &sortNLOGN, &sortN2};
	size_t sizes[] = {5, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
	size_t n;
	unsigned *a;

	for (size_t j = 0; j < 3; j++)
	{
		for (size_t i = 0; i < 9; i++)
		{ 
			n = sizes[i];
			a = malloc(n * sizeof(unsigned));
			if (a == NULL)
			{
				printf("Memory ERROR\n");
			}
			randomArr(a, n);
			start = clock();
			diffSorts[j](a, n);
			stop = clock();
			printf("Sort O(%s)  size %zu   time %f\n", o[j], n, (float)(stop - start) / CLOCKS_PER_SEC);
			free(a);			
		}
	}
}




