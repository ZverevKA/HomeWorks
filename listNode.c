#include "listNode.h"
#include <stdio.h>
#include <stdlib.h>

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

List* addHeadNode(List *list, int val)
{
	Node *node = malloc(sizeof(Node));
	if (node == NULL)
	{
		printf("Imposible to create node\n");
		exit(1);
	}
	node->next = list->head;
	node->val = val;
	list->size++;
	list->head = node;
	if (list->tail == NULL)
	{
		list->tail = node;
	}
	
	return list;
}

List* addTailNode(List *list, int val)
{
	Node *node = malloc(sizeof(Node));
	if (node == NULL)
	{
		printf("Imposible to create node\n");
		exit(1);
	}
	node->next = NULL;
	node->val = val;
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

List* addAfterNode(List *list, Node *node, int val)
{
	Node *newNode = malloc(sizeof(Node));
	if (newNode == NULL)
	{
		printf("Imposible to create node\n");
		exit(1);
	}
	newNode->val = val;
	newNode->next = node->next;
	node->next = newNode;
	list->size++;
	if (list->tail == node)
	{
		list->tail = newNode;
	}
	return list;
}

List* addAfterNodeNumber(List *list, size_t n, int val)
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
	addAfterNode(list, lastNode, val);
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

List* deleteVal(List *list, int val)
{
	
	Node *node = list->head;
	Node *lastNode = NULL;
	while(node != NULL)
	{
		if (node->val == val)
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


Node *createCycle(Node *node)
{
	Node *node1 = node;
	if (checkForCycle(node) != NULL)
	{
		printf("Your list has cycle\n");
		return node;
	}
	while (node1->next != NULL)
	{
		node1 = node1->next;
	}
	node1->next = node;
	return node;
}
		

node *checkForCycle(Node *node)
{
	Node element_of_cycle = NULL;
	flag = 0;
	Node *node1 = node;
	Node *node2 = node;
	while (node1 != NULL && node2 != NULL)
	{
		node1 = node1->next;
		if (node2->next == NULL)
		{
			break;
		}
		else
		{
			node2 = node2->next-next;
		}
		if (node1 == node2)
		{
			element_of_cycle = node1;
			break;
		}
	}
	return element_of_cycle;
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
			printf("%d\n", node->val);
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
	free(node);
}


