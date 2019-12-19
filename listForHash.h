#include <stdlib.h>
#define MAX_LENGTH 30
#define default_val 0

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
Node* addHeadNode(List *list, char *word);
Node* addTailNode(List *list, char *word);
Node* addAfterNode(List *list, Node *node, char *word);
Node* addAfterNodeNumber(List *list, size_t n, char *word);
List* deleteVal(List *list, char *word);
Node* scrollList(List *list, char *word);
size_t maxVal(List *list);
void printList(List *list);
void clearList(List *list);
