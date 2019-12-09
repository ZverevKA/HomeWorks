#include <stdio.h>
#include "listNode.h"
#include <stdlib.h>

void main()
{
	int x, val;
	size_t n;
	int creation = 0;
	List* list = malloc(sizeof(List));
	printf("1. Create list\n");
	printf("2. Add head node\n");
	printf("3. Add tail node\n");
	printf("4. Add after n node\n");
	printf("5. Delete for value\n");
	printf("6. Print list\n");
	printf("7. Clear list\n");
	printf("8. Exit\n");
	while (x != 8)
	{
		printf("Enter number of opiration\n");
		scanf("%d", &x);
		switch (x)
		{
			case 1:
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
			case 2:
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
			case 3:
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
			case 4:
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
			case 5:
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
			case 6:
				if (creation != 0)
				{
					printList(list);
				}
				else
				{
					printf("Your list hasn't been created\n");
				}
				break;
			case 7:
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
			case 8:
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
			
					
				
