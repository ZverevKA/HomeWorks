#include <stdio.h>
#include "listNode.h"
#include <stdlib.h>
#define OP_CREATE 1
#define OP_ADD_HEAD 2
#define OP_ADD_TAIL 3
#define OP_ADD_AFTER 4
#define OP_DELETE_FOR_VAL 5
#define OP_PRINT 6
#define OP_CLEAR 7
#define OP_EXIT 8

void main()
{
	int x, val;
	size_t n;
	int creation = 0;
	List* list = malloc(sizeof(List));
	if (list == NULL)
	{
		printf("Memory ERROR\n");
		return;
	}
	printf("%d. Create list\n", OP_CREATE);
	printf("%d. Add head node\n", OP_ADD_HEAD);
	printf("%d. Add tail node\n", OP_ADD_TAIL);
	printf("%d. Add after n node\n", OP_ADD_AFTER);
	printf("%d. Delete for value\n", OP_DELETE_FOR_VAL);
	printf("%d. Print list\n", OP_PRINT);
	printf("%d. Clear list\n", OP_CLEAR);
	printf("%d. Exit\n", OP_EXIT);
	while (x != OP_EXIT)
	{
		printf("Enter number of opiration\n");
		scanf("%d", &x);
		switch (x)
		{
			case OP_CREATE:
				if (creation == 0)
				{
					list = createList();
					creation = 1;
				}
				else
				{
					printf("Your list has already been created\n");
				}
				break;
			case OP_ADD_HEAD:
				if (creation != 0)
				{
					printf("Enter value of head node\n");
					scanf("%d", &val);
					addHeadNode(list, val);
				}
				else
				{
					printf("Your list hasn't been created\n");
				}
				break;
			case OP_ADD_TAIL:
				if (creation != 0)
				{
					printf("Enter value of tail node\n");
					scanf("%d", &val);
					addTailNode(list, val);
				}
				else
				{
					printf("Your list hasn't been created\n");
				}
				break;
			case OP_ADD_AFTER:
				if (creation != 0)
				{
					printf("Enter number of node and value\n");
					scanf("%d %d", &n, &val);
					addAfterNodeNumber(list, n, val);
				}
				else
				{
					printf("Your list hasn't been created\n");
				}
				break;
			case OP_DELETE_FOR_VAL:
				if (creation != 0)
				{
					printf("Enter value\n");
					scanf("%d", &val);
					deleteVal(list, val);
				}
				else
				{
					printf("Your list hasn't been created\n");
				}
				break;
			case OP_PRINT:
				if (creation != 0)
				{
					printList(list);
				}
				else
				{
					printf("Your list hasn't been created\n");
				}
				break;
			case OP_CLEAR:
				if (creation != 0)
				{
					clearList(list);
					creation = 0;
				}
				else
				{
					printf("Your list hasn't been created\n");
				}
				break;
			case OP_EXIT:
				if (creation != 0)
				{
					clearList(list);
					creation = 0;
				}
				break;
			default:
				printf("Wrong input\n");
				break;
		}
	}
}
			
					
				
