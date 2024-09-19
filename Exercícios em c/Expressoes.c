#include <stdio.h>
#include <stdbool.h>

char detect(char expressao[100000]){
	bool a = true;	
	int counta = 0;
	int countb = 0;
	int countc = 0;
	char resp;
	if(expressao[0] == ')' || expressao[0] == ']' || expressao[0] == '}'){
		a = false;
	}
	if(a == true){
		for(int i=0;i<100000;i++){
			if(expressao[i] == '('){
				counta++;
			}else if(expressao[i] == '['){
				countb++;
			}else if(expressao[i] == '{'){
				countc++;
			}else if(expressao[i] == ')'){
				counta--;
			}else if(expressao[i] == ']'){
				countb--;
			}else if(expressao[i] == '}'){
				countc--;
			}
			if(counta < 0 || countb < 0 || countc < 0){
				a = false;
			} if(expressao[i] == '\0'){
				i = 100000;
			}
		}
	}
	if(a == true){
		resp = 'S';
	}else{
		resp = 'N';
	}
	return resp;
}


int main(){
	int quantidade;
	char expressao[100000];
	scanf("%d", &quantidade);
	for(int i=0;i<quantidade;i++){
		scanf("%s", expressao);
		printf("%c\n", detect(expressao));
	}
	
	
}
