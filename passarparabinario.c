#include <stdio.h>
#include <stdlib.h>
/*Contexto:
Código que fiz logo no início da faculdade para
testar os meus conhecimentos com programação
e sistema de numeração binária*/
int pergunta(){
	int num = 0;
	printf("Digite o numero:");
	scanf("%d", &num);
	return num;
}

int divisao(int num){
	int bin[100];
	int i = 0;
	while(num>0){
		bin[i] = num %2;
		num = num/2;
		i++;
	}
	for(int j = i - 1; j >= 0; j--){
		printf("%d", bin[j]);
	}
	printf("\n");

}


int main (){
	int num = pergunta();
	divisao(num);	
	
}
