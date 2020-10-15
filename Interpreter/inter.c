#include <stdio.h>
#include <string.h>
#include "hashTable.h"
#include <stdint.h>
#define MEMORY_SIZE 1024 * 1024
#define MAX_STACK 1024
#define MAX_ADDR MEMORY_SIZE / sizeof(int32_t)
#define MAX_LINE_SIZE 80
#define MAX_LINES 200

enum OpCodes
{
	ld,
	st,
	ldc,
	add,
	sub,
	cmp,
	jmp,
	br,
	ret,
	noCommand
};

size_t hashF(char *s)
{
	return 0;
}



int32_t getCommandCode(char* str) {
	if (strstr(str, "ld") && !strstr(str, "ldc"))
	{ 
		return ld;
	}
	if (strstr(str, "st")) 
	{
		return st;
	}
	if (strstr(str, "ldc"))
	{
		return ldc;
	}
	if (strstr(str, "add"))
	{
		return add;
	}
	if (strstr(str, "sub"))
	{
		return sub;
	}
	if (strstr(str, "cmp"))
	{
		return cmp;
	}
	if (strstr(str, "jmp")) 
	{
		return jmp;
	}
	if (strstr(str, "br"))  
	{
		return br;
	}
	if (strstr(str, "ret"))
	{
		return ret;
	}
	return noCommand;
}


struct Command
{
	int32_t opCode;
	int32_t arg;
};


struct Program
{
	struct Command *command;
	HashTable *label;
};

struct Stack
{
	int32_t data[MAX_STACK];
	size_t size;
};

struct State
{
	struct Stack stack;
	int32_t *memory;
};


struct Interpreter
{
	struct Program program;
	struct State state;
};












void pushStack(struct Stack *stack, int32_t x)
{
	if (stack->size >= MAX_STACK)
	{
		printf("Stack is full\n");
	}
	stack->data[stack->size] = x;
	stack->size++;
}
	
int32_t getStack(struct Stack *stack)
{
	if (stack->size == 0)
	{
		printf("Stack is empty\n");
		exit(1);
	}
	return stack->data[stack->size - 1];
}
	


void ldStack(struct Stack *stack, int32_t *memory, int32_t n)
{
	pushStack(stack, memory[n]);
}

void stStack(struct Stack *stack, int32_t *memory, int32_t n)
{
	memory[n] = stack->data[stack->size - 1];
}

void ldcStack(struct Stack *stack, int32_t c)
{
	pushStack(stack, c);
}

void addStack(struct Stack *stack)
{
	if (stack->size < 2)
	{
		printf("Not enough operands\n");
		return;
	}
	stack->data[stack->size] = stack->data[stack->size - 1] + stack->data[stack->size - 2];
	stack->size ++;
}

void subStack(struct Stack *stack)
{
	if (stack->size < 2)
	{
		printf("Not enough operands\n");
		return;
	}
	stack->data[stack->size] = stack->data[stack->size - 1] - stack->data[stack->size - 2];
	stack->size ++;
}

void cmpStack(struct Stack *stack)
{
	if (stack->size < 2)
	{
		printf("Not enough operands\n");
		return;
	}
	if (stack->data[stack->size - 1] > stack->data[stack->size - 2])
	{
		stack->data[stack->size] = 1;
		stack->size ++;
		return;
	}
	if (stack->data[stack->size -1] < stack->data[stack->size - 2])
	{
		stack->data[stack->size] = -1;
		stack->size ++;
		return;
	}
	stack->data[stack->size] = 0;
	stack->size ++;
}





int32_t findArg(char *str, size_t i)
{
	size_t j = 0;
	int32_t arg = 0; 
	if (str[i] == '-')
	{
		j = 1;
		while((str[i + j] >= '0') && (str[i + j] <= '9'))
		{
			arg = arg * 10 + (int32_t)(str[i + j] - '0');
			j++;
		}
		arg = 0 - arg;
		return arg;
	}
	while((str[i + j] >= '0') && (str[i + j] <= '9'))
	{
		arg = arg * 10 + (int32_t)(str[i + j] - '0');
		j++;
	}
	return arg;
}

void collectLabels(FILE* file, struct Interpreter* interpreter)
{
	if (file == NULL)
	{
		printf("Can't open file\n");
		exit(1);
	}
	size_t nameSize;
	char str[MAX_LINE_SIZE];
	char label[MAX_LINE_SIZE] = {0};
	size_t i = 0;
	while (fgets(str, MAX_LINE_SIZE, file))
	{
		if (getCommandCode(str) == noCommand)
		{
			continue;
		}
		if (strchr(str, ':'))
		{
			nameSize = strcspn(str, ":");
			for (size_t j = 0; j < nameSize; j++)
			{
				label[j] = str[j];
			}
			label[nameSize] = '\0';
			addElement(interpreter->program.label, label);
			setVal(interpreter->program.label, label, i);
		}
		i++;
	}
}
	
void collectCommands(FILE* file, struct Interpreter* interpreter)
{
	if (file == NULL)
	{
		printf("Can't open file\n");
		exit(1);
	}
	size_t i = 0;
	int32_t code;
	size_t argPosition;
	char* argChar;
	char str[MAX_LINE_SIZE];
	while (fgets(str, MAX_LINE_SIZE, file))
	{
		code = getCommandCode(str);
		if (code == noCommand)
		{
			continue;
		}
		interpreter->program.command[i].opCode = code;
		if (code == ld)
		{
			argPosition = strstr(str, "ld") - str + 3;
			interpreter->program.command[i].arg = findArg(str, argPosition);
		}
		if (code == st)
		{
			argPosition = strstr(str, "st") - str + 3;
			interpreter->program.command[i].arg = findArg(str, argPosition);
		}
		if (code == ldc)
		{
			argPosition = strstr(str, "ldc") - str + 4;
			interpreter->program.command[i].arg = findArg(str, argPosition);
		}
		if (code == jmp)
		{
			char label[MAX_LINE_SIZE];
			size_t f = 0;
			argPosition = strstr(str, "jmp") - str + 4;
			argChar = str + argPosition;
			while (argChar[f] != 10)
			{
				label[f] = argChar[f];
				f++;
			}
			label[f] = '\0';
			interpreter->program.command[i].arg = (int32_t)findVal(interpreter->program.label, label);
		}
		if (code == br)
		{
			char label[MAX_LINE_SIZE];
			size_t f = 0;
			argPosition = strstr(str, "br") - str + 3;
			argChar = str + argPosition;
			while (argChar[f] != 10)
			{
				label[f] = argChar[f];
				f++;
			}
			label[f] = '\0';
			interpreter->program.command[i].arg = (int32_t)findVal(interpreter->program.label, label);
		}
		i++;
	}
}

void interpreterCode(struct Interpreter* interpreter)
{
	size_t i = 0;
	while (1)
	{
		struct Stack* stack = &(interpreter->state.stack);
		int32_t* memory = interpreter->state.memory;
		int32_t opCode = interpreter->program.command[i].opCode;
		int32_t arg = interpreter->program.command[i].arg;
		if (opCode == ld)
		{
			ldStack(stack, memory, arg);
			i++;
		}
		if (opCode == st)
		{
			stStack(stack, memory, arg);
			i++;
		}
		if (opCode == ldc)
		{
			ldcStack(stack, arg);
			i++;
		}
		if (opCode == add)
		{
			addStack(stack);
			i++;
		}
		if (opCode == sub)
		{
			subStack(stack);
			i++;
		}
		if (opCode == cmp)
		{
			cmpStack(stack);
			i++;
		}
		if (opCode == jmp)
		{
			i = arg;
		}
		if (opCode == br)
		{
			if (getStack(stack) != 0)
			{
				i = arg;
			}
			else
			{
				i++;
			}
		}
		if (opCode == ret)
		{
			printf("Successful completion of the program\n");
			break;
		}
	}
}

void createInterpreter(struct Interpreter *interpreter)
{
	interpreter->program.command = (struct Command*)malloc(sizeof(struct Command) * MAX_LINES);
    interpreter->state.stack.size = 0;
    interpreter->program.label = createHashTable(*hashF, MAX_LINES);
    interpreter->state.memory = (int32_t*)malloc(sizeof(int32_t) * MEMORY_SIZE);
	
}
void freeInterpreter(struct Interpreter* interpreter)
{
	printf("%d", getStack(&(interpreter->state.stack))); 
	free(interpreter->program.command);
    free(interpreter->state.memory);
    deleteHashTable(interpreter->program.label);
}

void main()
{
	struct Interpreter interpreter;
	createInterpreter(&interpreter);
	FILE* file = fopen("program.txt", "rt");
	if (!file)
	{
		printf("File error\n");
	}
	collectLabels(file, &interpreter);
	fclose(file);
	file = fopen("program.txt", "rt");
	if (!file)
	{
		printf("File error\n");
	}
	collectCommands(file, &interpreter);
	fclose(file);
	interpreterCode(&interpreter);
	freeInterpreter(&interpreter);
	
	
}
	


