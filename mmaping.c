#include "mman.h"
#include <sys/stat.h>
#include <stdlib.h>
#include <fcntl.h>
#include <stdio.h>


int comparator(const void *x, const void *y)
{
	char *a, *b;
	a = *(char**)x;
	b = *(char**)y;
	size_t j = 0;
	char end = '\n';
	while (a[j] != end)
	{
		j++;
	}
	size_t i = 0;
	while (b[i] != end)
	{
		i++;
	}
	return (i - j);
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
	char *text = src;
	size_t n = 0;
	char end = '\n';
	for (size_t i = 0; i < size; i++)
	{
		if (text[i] == end)
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
		while (text[j] != end)
		{
			j++;
		}
		j++;
	}
	int (*comparator1)(const void*, const void*) = comparator; 
	qsort(strings, n, sizeof(char*), comparator1);
	for (size_t i = 0; i < n; i++)
	{
		j = 0;
		write(fdout, (strings[i] + j), sizeof(char));
		while (*(strings[i] + j) != end)
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
