#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>


bool fim(const char* x, const char* y) {
	bool res = true;
	int i = 0;
	
	while (x[i] != '\0' && y[i] != '\0') {
		if (x[i] != y[i]) {
			res = false;
		}
		i++;
	}
	
	if (x[i] != '\0' || y[i] != '\0') {
		res = false;
	}
	
	return res;
}

void alteracao(char input[], char letra1, char letra2, int len, int i)
{
	if(i < len)
	{
		if(input[i] == letra1)
		{
			input[i] = letra2;
		}
		
		alteracao(input, letra1, letra2, len, ++i);
	}
	
}
int main() {
	char input[1000];
	
	scanf(" %1000[^\n]", input);

	while (!fim(input, "FIM")) {
		char letra1 = 'a' + rand()%26;
		char letra2 = 'a' + rand()%26;
		
		int len = strlen(input);
		
		alteracao(input, letra1, letra2, len, 0);
		
		printf(" %s \n", input);
		
		scanf(" %1000[^\n]", input);
		
	}
	
	return 0;
}

