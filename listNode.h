#include <stdlib.h>

typedef struct Node1
{
	int val;
	struct Node1 *next;
} Node;

typedef struct List1
{
	size_t size;
	Node *head;
	Node *tail;
} List;


List* createList();
List* addHeadNode(List *list, int val);
List* addTailNode(List *list, int val);
List* addAfterNode(List *list, Node *node, int val);
List* addAfterNodeNumber(List *list, size_t n, int val);
List* deleteVal(List *list, int val);
void printList(List *list);
void clearList(List *list);


