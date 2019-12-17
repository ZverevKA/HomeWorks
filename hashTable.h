#include "listForHash.h"

typedef struct HashTable1
{
	size_t (*func) (char*);
	List **cells;
	size_t size;
} HashTable;

HashTable *createHashTable(size_t (*func)(char*), size_t n);
void deleteHashTable(HashTable *table);
void hashTableStatistics(HashTable *table);
HashTable *addElement(HashTable *table, char *word);
HashTable *deleteElement(HashTable *table, char *word);
size_t findVal(HashTable *table, char *word);

