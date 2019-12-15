#include <stdlib.h>
#define MAX_LENGTH 30

typedef struct Node1
{
	size_t val;
	char word[MAX_LENGTH];
	struct Node1 *next;
} Node;

typedef struct List1
{
	size_t size;
	Node *head;
	Node *tail;
} List;


List* createList();
List* addHeadNode(List *list, size_t val, char *word);
List* addTailNode(List *list, size_t val, char *word);
List* addAfterNode(List *list, Node *node, size_t val, char *word);
List* addAfterNodeNumber(List *list, size_t n, size_t val, char *word);
List* deleteVal(List *list, char *word);
Node* scrollList(List *list, char *word);
void printList(List *list);
void clearList(List *list);


