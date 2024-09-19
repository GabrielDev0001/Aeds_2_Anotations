#include <stdlib.h>
#include <stdio.h>
#include <string.h>
/*Contexto:
código que fiz logo no início da faculdade
para testar os meus conhecimentos com strings e
fazer um programa que teste se as senhas coincidem*/
void metodo(char x[], char y[]){
	do {
		printf("Senha incorreta, digite a senha novamente:");
		scanf("%s", y);
	} while (strcmp(x, y) != 0);
	printf("Senha correta");
}

int main() {
	char senha[100];
	char rsenha[100];
	
	printf("Digite a sua senha:\n");
	scanf("%s", senha);
	printf("Digite a sua senha novamente:\n");
	scanf("%s", rsenha);
	
	if (strcmp(senha, rsenha) != 0) {
		metodo(senha, rsenha);
	} else {
		printf("Senha correta");
	}
	
	return 0;
}
