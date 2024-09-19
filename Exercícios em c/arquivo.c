#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
void archiveread(char *string, FILE *arquivo){
	fputs(string, arquivo);
	fputs("\n", arquivo);
}

void archivewrite( FILE *arquivo, int quantidade){
	char string[quantidade][100];
	for(int i=0;i<quantidade;i++){
		fscanf(arquivo, "%s", string[i]);
	}
	for(int i=quantidade -1;i>=0;i--){
		printf("%s\n", string[i]);
	}
	
}

int main(){
	FILE *arquivo = fopen("arquivo.txt", "w" );
	char string[100];
	int quantidade = 0;
	scanf("%d", &quantidade);
	int controle = quantidade;
	while(controle !=0){
		scanf("%s", string);
		archiveread(string, arquivo);
		controle--;
	}
	fclose(arquivo);
	FILE *arquivo1 = fopen("arquivo.txt", "r");
	archivewrite(arquivo1, quantidade);
	fclose(arquivo1);
}
