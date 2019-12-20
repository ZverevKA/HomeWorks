#include "mman.h"
#include <sys/stat.h>
#include <stdlib.h>
#include <fcntl.h>
#include <stdio.h>
#include "hashTable.h"
#include <string.h>
#define HASH_FUNC_NUMBER 31
#define HASH_SIZE 10000
#include <time.h>


char capitalLetter(char *x)
{
	if (*x <= 'Z' && *x >= 'A')
	{
		return (*x + 'a' - 'A');
	}
	return *x;
}

int punctuation(char *x)
{
	size_t i = 0;
	if (*(x + i) < 'A' || *(x + i) > 'z')
	{
		return 1;
	} 
}


size_t separatingWord(char *text, char *word)
{
	size_t i = 0;
	while (*(text + i) >= 'A' && *(text + i) <= 'z')
	{
		*(word + i) = capitalLetter(text + i);
		i++;
	}
	*(word + i) = '\0';
	return i;
}

size_t func1(char *word)
{
	return 0;
}

size_t func2(char *word)
{
	return strlen(word);
}

size_t func3(char *word)
{
	size_t hash = 0;
	size_t len = strlen(word);
	for (size_t i = 0; i < len; i++)
	{
		hash = (hash * HASH_FUNC_NUMBER + word[i]) % HASH_SIZE;
	}
	return hash;
}
	


int main(int argc, char *argv[])
{
	clock_t start, stop;
	HashTable *table;
	size_t (*hashFunc[])(char*) = {func1, func2, func3};
	size_t numFunc = sizeof(hashFunc) / sizeof(hashFunc[0]);
	size_t tableSize[] = {1, MAX_LENGTH, HASH_SIZE};
	int fdin;
	void *src;
	struct stat statbuf;
	if (argc != 2)
	{
		printf("Using: %s <fromfile> <tofile>", argv[0]);
		return -1;
	}
	if ((fdin = open(argv[1], O_RDONLY)) < 0 )
    {
		printf("Impossible to open %s for reading", argv[1]);
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
	char word[MAX_LENGTH];
	for (size_t j = 0; j < numFunc; j++)
	{
		start = clock();
		table = createHashTable(hashFunc[j], tableSize[j]);
		if (table == NULL)
		{
			printf("Table isn't created\n");
			return -1;
		}
		size_t i = 0;
		while (i < size)
		{
			while (punctuation(text + i) == 1 && i < size)
			{
				i++;
			}
			if (i < size)
			{
				i += separatingWord(text + i, word);		
				addElement(table, word);
				setVal(table, word, findVal(table, word) + 1);
			}	 
		}
		hashTableStatistics(table);
		deleteHashTable(table);
		stop = clock();
		printf("Time %f\n", (float)(stop - start) / CLOCKS_PER_SEC);
	}


	munmap((void *)src, statbuf.st_size);
	close(fdin);
}
