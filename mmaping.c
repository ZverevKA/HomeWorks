#include "mman.h"
#include <sys/stat.h>
#include <stdlib.h>
#include <fcntl.h>
#include <stdio.h>


int comparator(char *a, char *b)
{
	char end = '\n';
	size_t j = 0;
	while (a[j] != end)
	{
		j++;
	}
	size_t i = 0;
	while (b[i] != end)
	{
		i++;
	}
	if (j > i)
	{
		return 1;
	}
	if (j < i)
	{
		return -1;
	}
	if (i = j)
	{
		return 0;
	}

}

void swap(char **strings, size_t a, size_t b)
{
	char *c = strings[a];
	strings[a] = strings[b];
	strings[b] = c;
}

void sort(char **strings, size_t n)
{
	for (size_t i = 0; i < n; i++)
	{
		for (size_t j = 0; j < n - 1; j++)
		{
			if (comparator(strings[j], strings[j + 1]) < 0)
			{
				swap(strings, j, j + 1);
			}
		}
	}
}


int main(int argc, char *argv[])
{
	int fdin, fdout;
	void *src;
	struct stat statbuf;
	if (argc != 3)
	{
		printf("Using: %s <fromfile> <tofile>", argv[0]);
		return -1;
	}
	if ((fdin = open(argv[1], O_RDONLY)) < 0 )
    {
		printf("Impossible to open %s for reading", argv[1]);
		return -1;
	}
    if ((fdout = open(argv[2], O_RDWR | O_CREAT | O_TRUNC)) < 0)
	{
    	printf("Impossible to create %s for writing", argv[2]);
		return -1;
	}
    if (fstat(fdin, &statbuf) < 0 )
    {
		printf("fstat error");
		return -1;
	}
	if ((src = mmap(0, statbuf.st_size, PROT_READ, MAP_SHARED, fdin, 0)) == MAP_FAILED)
	{
    	printf("Error of function mmap");
		return -1;
	}
	
	
	size_t size = statbuf.st_size / sizeof(char);
	printf("%lu\n", size);
	char *text = src;
	printf("%d", text[5]);
	size_t n = 0;
	char end = '\n';
	char end1 = 13;
	for (size_t i = 0; i < size; i++)
	{
		if (text[i] == end1)
		{
			n++;
		}
	}
	char **strings = (char**)malloc(n * sizeof(char*));
	if (strings == NULL)
	{
		printf("Memory ERROR\n");
		return -1;
	}
	size_t j = 0;
	for (size_t i = 0; i < n; i++)
	{
		strings[i] = &text[j];
		while (text[j] != end1)
		{
			j++;
		}
		j+= 2;
	}
	sort(strings, n);
	for (size_t i = 0; i < n; i++)
	{
		j = 0;
		write(fdout, (strings[i] + j), sizeof(char));
		while (*(strings[i] + j) != end1)
		{
			j++;
			write(fdout, (strings[i] + j), sizeof(char));
		}
	}
	munmap((void *)src, statbuf.st_size);
	free(strings);
	close(fdout);
	close(fdin);
}
