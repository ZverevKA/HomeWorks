#include "hashTable.h"
#include <limits.h>
#include <stdlib.h>
#include <stdio.h>


HashTable *creatHashTable(size_t (*func)(char*), size_t n)
{
	HashTable *table = malloc(sizeof(HashTable));
	if (table == NULL)
	{
		return NULL;
	}
	table->size = n;
	table->func = func;
	table->elements_number = 0;
	table->not_empty_cells = 0;
	table->cells = malloc(n * sizeof(List*));
	if (table->cells == NULL)
	{
		return NULL;
	}
	for (size_t i = 0; i < n; i++)
	{
		table->cells[i] = createList();
		if (table->cells[i] == NULL)
		{
			return NULL;
		}
	}
}

HashTable *deleteHashTable(HashTable *table)
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
	size_t max = 0;
	size_t min = INT_MAX;
	size_t size;
	printf("Number of elements %d\n", table->elements_number);
	printf("Number of not empty cells %d\n", table->not_empty_cells);
	for (size_t i = 0; i < table->size; i++)
	{
		size = (table->cells[i])->size;
		allLength += size;
		if (max < size)
		{
			max = size;
		}
		if ((min > size) && (size != 0))
		{
			min = size;
		}
	}
	printf("Average length %d\n", (allLength / table->size));
	printf("Max length %d\n", max);
	printf("Min length %d\n", min); 
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
