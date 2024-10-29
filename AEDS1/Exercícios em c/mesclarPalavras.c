#include <stdio.h>
#include <stdbool.h>
#include <string.h>
/*Contexo: Código para mesclar duas strings
sem poder utiizar qualquer biblioteca além das
já presentes no código e sem poder usar funções
como strcpy*/
void mergestrings(char a[], char b[]) {
	char c[200];
	int control = 0;
	int cControlA = 0;
	int cControlB = 0;
	
	while (a[cControlA] != '\0' || b[cControlB] != '\0') {
		while (a[cControlA] == ' ') {
			cControlA++;
		}
		
		while (b[cControlB] == ' ') {
			cControlB++;
		}
		
		if (a[cControlA] != '\0') {
			c[control] = a[cControlA];
			cControlA++;
			control++;
		}
		
		if (b[cControlB] != '\0') {
			c[control] = b[cControlB];
			cControlB++;
			control++;
		}
	}
	c[control] = '\0';
	
	printf("%s\n", c);
}

bool fim(char x[], char y[]) {
	bool resposta = false;
	if (strlen(x) == strlen(y)) {
		resposta = true;
		for (int i = 0; i < strlen(x); i++) {
			if (x[i] != y[i]) {
				resposta = false;
				i = strlen(x);
			}
		}
	}
	return resposta;
}

int main() {
	char a[100] = "";
	char b[100] = "";
	while (!fim(a, "FIM\n") || !fim(b, "FIM\n")) {
		fgets(a, sizeof(a), stdin);
		fgets(b, sizeof(b), stdin);
		mergestrings(a, b);
	}
	
	return 0;
}
