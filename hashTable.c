#include "hashTable.h"
#include <limits.h>
#include <stdlib.h>
#include <stdio.h>


HashTable *createHashTable(size_t (*func)(char*), size_t n)
{
	HashTable *table = malloc(sizeof(HashTable));
	if (table == NULL)
	{
		return NULL;
	}
	table->size = n;
	table->func = func;
	table->cells = malloc(n * sizeof(List*));
	if (table->cells == NULL)
	{
		printf("Imposibility to create Hash Table\n");
		exit(1);
	}
	for (size_t i = 0; i < n; i++)
	{
		table->cells[i] = createList();
		if (table->cells[i] == NULL)
		{
			printf("Imposibility to create Hash Table \n");
			exit(1);
		
		}
	}
	return table;
}

void deleteHashTable(HashTable *table)
{
	for (size_t i = 0; i < table->size; i++)
	{
		clearList(table->cells[i]);
	}
	free(table->cells);
	free(table);
}



void hashTableStatistics(HashTable *table)
{
	size_t allLength = 0;
	size_t elements_number = 0;
	size_t max_val = 0;
	size_t val;
	size_t max = 0;
	size_t min = INT_MAX;
	size_t size;
	size_t not_empty_cells = 0;
	for (size_t i = 0; i < table->size; i++)
	{
		size = (table->cells[i])->size;
		if (size > 0)
		{
			not_empty_cells++;
			elements_number += size;
			if (max < size)
			{
				max = size;
			}
			if ((min > size) && (size != 0))
			{
				min = size;
			}
			val = maxVal(table->cells[i]);
			if (val > max_val)
			{
				max_val = val;
			}
		}
	}
	printf("Elements number %d\n", elements_number);
	printf("Number of not empty cells %d\n", not_empty_cells);
	printf("Average length %d\n", (elements_number / not_empty_cells));
	printf("Max length %d\n", max);
	printf("Min length %d\n", min);
	printf("Max value %d\n", max_val); 
}


HashTable *addElement(HashTable *table, char *word)
{
	size_t hash = (table->func)(word);
	Node *node = scrollList(table->cells[hash], word);
	if (node == NULL)
	{
		addTailNode(table->cells[hash], 1, word);
		
	}
	else 
	{
		node->val++;
	}
	return table;
}

HashTable *deleteElement(HashTable *table, char *word)
{
	size_t hash = (table->func)(word);
	deleteVal(table->cells[hash], word);
	return table;
}

size_t findVal(HashTable *table, char *word)
{
	size_t hash = (table->func)(word);
	Node *node = scrollList(table->cells[hash], word);
	if (node == NULL)
	{
		return 0;
	}
	else
	{
		return node->val;
	}
}
