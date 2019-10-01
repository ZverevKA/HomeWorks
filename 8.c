// ДЗ 1, Задача 8, Зверев Константин

#include <stdio.h>
#include <stdlib.h>

int includingCheck(char S[], char S1[], int N1, int x)
{
	for (int i = 0; i < N1; i++)
	{
		if (S1[i] != S[i+x])
		{
			return 0;
		}
	}
	return 1;
}




void main()
{
	char *S, *S1;
	int N, N1, k = 0;
	printf("Enter number of signs in \"long\" string(S)\n");
	scanf("%d", &N);
	printf("Enter \"long\" string(S)\n");
	S = (char *)malloc(N * sizeof(char));
	if (S == NULL)
	{
		printf("Memory ERROR");
		return -1;
	}
	scanf("%s", S);
	printf("Enter number of signs in \"short\" string(S1)\n");
	scanf("%d", &N1);
	printf("Enter \"short\" string(S1)\n");
	S1 = (char *)malloc(N1 * sizeof(char));
	if (S1 == NULL)
	{
		printf("Memory ERROR");
		return -1;
	}
	scanf("%s", S1);
	for (int i = 0; i <= N - N1; i++)
	{
		k += includingCheck(S, S1, N1, i);
	}
	printf("S1 include in S %d times", k);
	free(S);
	free(S1);
}	
	
