#include "listForHash.h"

typedef struct HashTable1
{
	size_t (*func) (char*);
	size_t elements_number;
	List **cells;
	size_t not_empty_cells;
	size_t size;
} HashTable;

HashTable *createHashTable(size_t (*func)(char*), size_t n);
HashTable *deleteHashTable(HashTable *table);
void hashTableStatistics(HashTable *table);
HashTable *addElement(HashTable *table, char *word);
HashTable *deleteElement(HashTable *table, char *word);
size_t findVal(HashTable *table, char *word);

