#include <stdio.h>
#include <string.h>

/* Contexto:
Código que fiz logo no início da faculdade para
testar os meus conhecimentos com programação
e testar se uma palavra é um palíndromo */

void clasificarPalindromo(char palavra[], int i, int j, int *isPalindrome) {
	if (i < j) {
		if (palavra[i] == palavra[j]) {
			j--;
			i++;
			clasificarPalindromo(palavra, i, j, isPalindrome);
		} else {
			*isPalindrome = 0;  
		}
	}
	if (i >= j) {  
		if (*isPalindrome == 1) {
			printf("SIM\n");
		} else {
			printf("NAO\n");
		}
	}
}

int main() {
	char palavra[500];
	int j = 0;
	int isPalindrome = 1;
	
	scanf(" %s", palavra);
	j = strlen(palavra) - 1;  
	
	while (strcmp(palavra, "FIM") != 0) {
		isPalindrome = 1;  
		clasificarPalindromo(palavra, 0, j, &isPalindrome);
		scanf(" %s", palavra);
		j = strlen(palavra) - 1;  
	}
	
	return 0;
}
