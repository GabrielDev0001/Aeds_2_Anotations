import java.util.Scanner;
public class Main {
    public static void ordernar(int divisao, int num[], int quantidade){
        int[] tabela = new int[quantidade];
        int controle;
        for(int i = 0; i < quantidade; i++){
            tabela[i] = num[i];
            for(int j = 0; j < i; j++){
                if((tabela[i] % divisao) < (tabela[j] % divisao)){
                    controle = tabela[i];
                    tabela[i] = tabela[j];
                    tabela[j] = controle;
                } else if((tabela[i] % divisao) == (tabela[j] % divisao)){
                    if((tabela[i] % 2 == 1) && (tabela[j] % 2 == 0)){
                        controle = tabela[i];
                        tabela[i] = tabela[j];
                        tabela[j] = controle;
                    }  else if ((tabela[i] % 2 == 1) && (tabela[j] % 2 == 1)) {
                        if(tabela[i] > tabela[j]){
                            controle = tabela[i];
                            tabela[i] = tabela[j];
                            tabela[j] = controle;
                        }
                    } else if ((tabela[i] % 2 == 0) && (tabela[j] % 2 == 0)) {
                        if(tabela[i] < tabela[j]){
                            controle = tabela[i];
                            tabela[i] = tabela[j];
                            tabela[j] = controle;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < quantidade; i++){
            System.out.println(tabela[i]);
        }

    }

    public static void main(String[] args) {
        int controle = 0;
        while(controle == 0){
            Scanner ler = new Scanner(System.in);
            int quantidade = ler.nextInt();
            int divisao = ler.nextInt();
            int[] valores = new int[quantidade];
            System.out.print(quantidade + " ");
            System.out.println(divisao);
            if((quantidade != 0) || (divisao != 0)){
                for(int i = 0; i < quantidade; i++){
                    valores[i] = ler.nextInt();
                }
                ordernar(divisao, valores, quantidade);
            }else{
                ler.close();
                controle = 1;
            }
        }
    }
}