#include <stdio.h>
#include <string.h>
#include <stdbool.h>
/*Contexto:
Código que fiz no início da faculdade para 
exibir quantas letras maiúculas existem em uma palavra
utilizando apenas essas bilbiotecas já presentes no código,
nenhuma além e sem utilizar funções como strcpy*/
bool fim(char x[], char y[]){
	bool resposta = false;
	if(strlen(x) == strlen(y)){
		resposta = true;
		for(int i=0;i < strlen(x);i++){
			if(x[i] != y[i]){
				resposta = false;
				i = strlen(x);
			}
		}
	}
	return resposta;
}

int maiusculas(char string[], int posicao, int contador){
	int length = strlen(string);
	if(string[posicao] > 64 && string[posicao] < 91){
		contador++;
	}
	if(posicao <= length){
		maiusculas(string, posicao +1, contador);
	}
	else{
		return(contador);
	}
}


int main(){
	char string[500] = "";
	scanf(" %[^\r\n]", string);
	while(!fim(string, "FIM")){
		int a = maiusculas(string, 0, 0);
		printf("%d\n", a);
		scanf(" %[^\r\n]", string);
	}
	
	
}
