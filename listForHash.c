#include "listForHash.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

List* createList()
{
	List *list = malloc(sizeof(List));
	if (list == NULL)
	{
		printf("Imposibility to create list \n");
		exit(1);
	}
	list->size = 0;
	list->head = NULL;
	list->tail = NULL;
	return list;
}

List* addHeadNode(List *list, size_t val, char *word)
{
	Node *node = malloc(sizeof(Node));
	if (node == NULL)
	{
		printf("Imposibility to create node\n");
		exit(1);
	}
	node->next = list->head;
	node->val = val;
	strcpy(node->word, word);
	list->size++;
	list->head = node;
	if (list->tail == NULL)
	{
		list->tail = node;
	}
	
	return list;
}

List* addTailNode(List *list, size_t val, char *word)
{
	Node *node = malloc(sizeof(Node));
	if (node == NULL)
	{
		printf("Imposibility to create node \n");
		exit(1);
	}
	node->next = NULL;
	node->val = val;
	strcpy(node->word, word);
	list->size++;
	if (list->head == NULL)
	{
		list->head = node;
	}
	else
	{
		list->tail->next = node;
	}
	list->tail = node;
	return list;
}

List* addAfterNode(List *list, Node *node, size_t val, char *word)
{
	Node *newNode = malloc(sizeof(Node));
	if (newNode == NULL)
	{
		printf("Imposibility to create node \n");
		exit(1);
	}
	newNode->val = val;
	strcpy(newNode->word, word);
	newNode->next = node->next;
	node->next = newNode;
	list->size++;
	if (list->tail == node)
	{
		list->tail = newNode;
	}
	return list;
}

List* addAfterNodeNumber(List *list, size_t n, size_t val, char *word)
{
	if (list->size < n)
	{
		printf("List is smaller than %d\n", n);
		return list;
	}
	Node *lastNode = list->head;
	for (size_t i = 2; i <= n; i++)
	{
		lastNode = lastNode->next;
	}
	addAfterNode(list, lastNode, val, word);
	return list;
}



Node* deleteHead(List *list)
{
	Node *node = list->head;
	if (list->tail == node)
	{
		list->tail = NULL;
	}
	list->head = node->next;
	list->size--;
	free(node);
	return list->head;
}

Node* deleteNoHead(List *list, Node *lastNode)
{
	Node *node = lastNode->next;
	if (list->tail = node)
	{
		list->tail = lastNode;
	}
	lastNode->next = node->next;
	list->size--;
	free(node);
	return lastNode->next;
}

List* deleteVal(List *list, char *word)
{
	
	Node *node = list->head;
	Node *lastNode = NULL;
	while (node != NULL)
	{
		if (strcmp(node->word, word) == 0)
		{
			if (list->head == node)
			{
				node = deleteHead(list);
				lastNode = node;
			}
			else 
			{
				node = deleteNoHead(list, lastNode);
			}
		}
		else 
		{
			lastNode = node;
			node = node->next;
		}
	}
	return list;
}

Node* scrollList(List *list, char *word)
{
	Node *node = list->head;
	while (node != NULL)
	{
		if (strcmp(node->word, word) == 0)
		{
			return node;
		}
		else
		{
			node = node->next;
		}					
	}
	return node;
}

size_t maxVal(List *list)
{
	size_t val = 0;
	Node *node = list->head;
	while (node != NULL)
	{
		if (node->val > val)
		{
			val = node->val;
		}
		node = node->next;
	}
	return val;
}
	
void printList(List *list)
{
	Node *node = list->head;
	if (list->head == NULL)
	{
		printf("List is clear\n");
	}
	else
	{
		while (node != NULL)
		{
			printf("%d %s\n", node->val, node->word);
			node = node->next;
		}
	}
}

void clearList(List *list)
{
	Node *node = list->head;
	Node *node1 = list->head;
	while (node != NULL)
	{
		node1 = node;
		node = node1->next;
		free(node1);
	}
	free(list);
}


