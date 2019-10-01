#include <stdio.h>

size_t newStrlen(char str[])
{
	size_t k = 0;
	while (str[k]!='\0')
	{
		k++;
	}
	return k;
}

void newStrcpy(char outstr[], char instr[])
{
	int k = 0;
	while (instr[k]!='\0')
	{
		outstr[k] = instr[k];
		k++;	
	}
	outstr[k] = instr[k];
}	

void newStrcat(char outstr[], char instr[])
{
	int k = newStrlen(outstr);
	for (int i = 0; i <= newStrlen(instr); i++)
	{
		outstr[k+i] = instr[i];
	}
}

int newStrcmp(char str1[], char str2[])
{
	int k,t = newStrlen(str1);
	if (newStrlen(str1) < newStrlen(str2))
	{
		t = newStrlen(str2);
	}
	for (int i = 0; i <= t; i++)
	{
		k = str1[i] - str2[i];
		if (k != 0)
		{
			break;
		} 
	}
return k;
}

void main()
{
}