/*
ENUNCIADO:
Alguém deixou o quadro de medalhas das olimpíadas fora de ordem. Seu programa deve colocá-lo na ordem correta. A ordem dos países no quadro de medalhas é dada pelo número de medalhas de ouro. Se há empate em medalhas de ouro, a nação que tiver mais medalhas de prata fica a frente. Havendo empate em medalhas de ouro e prata, fica mais bem colocado o país com mais medalhas de bronze. Se dois ou mais países empatarem nos três tipos de medalhas, seu programa deve mostrá-los em ordem alfabética.
Entrada
A entrada é dada pelo número de países participantes N (0 ≤ N ≤ 500) seguido pela lista dos países, com suas medalhas de ouro O (0 ≤ O ≤ 10000), prata P (0 ≤ P ≤ 10000) e bronze B (0 ≤ B ≤ 10000).
Saída
A saída deve ser a lista de países, com suas medalhas de ouro, prata e bronze, na ordem correta do quadro de medalhas, com as nações mais premiadas aparecendo primeiro.
 */

import java.util.*;
public class Main {
    public static void ordenar(String country[], int ouro[], int prata[], int bronze[], int quantidade){
        int controleposouro;
        int controle;
        String controles;
        for(int i = 0; i < quantidade; i++){
            controleposouro = i;
            for(int j = i + 1; j < quantidade; j++){ // identifica a posição correta dos países
                if(ouro[controleposouro] < ouro[j]) {
                    controleposouro = j;
                } else if ((ouro[controleposouro] == ouro[j]) && prata[controleposouro] < prata[j]) {
                    controleposouro = j;
                } else if ((ouro[controleposouro] == ouro[j]) && (prata[controleposouro] == prata[j]) && bronze[controleposouro] < bronze[j]) {
                    controleposouro = j;
                } else if ((ouro[controleposouro] == ouro[j]) && (prata[controleposouro] == prata[j]) && (bronze[controleposouro] == bronze[j]) && country[j].charAt(0) < country[controleposouro].charAt(0)) {
                    controleposouro = j;
                }
            }
                controle = ouro[controleposouro]; //ordena de acordo com o algoritmo de seleção
                ouro[controleposouro] = ouro[i];
                ouro[i] = controle;
                controle = prata[controleposouro];
                prata[controleposouro] = prata[i];
                prata[i] = controle;
                controle = bronze[controleposouro];
                bronze[controleposouro] = bronze[i];
                bronze[i] = controle;
                controles = country[controleposouro];
                country[controleposouro] = country[i];
                country[i] = controles;
        }

        for (int i = 0; i < quantidade; i++){ // Printar os países em ordem de medalha
            System.out.print(country[i] + " ");
            System.out.print(ouro[i]+ " ");
            System.out.print(prata[i]+ " ");
            System.out.println(bronze[i]);
        }
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int quantidade;
        quantidade= ler.nextInt();
        String[] country = new String[quantidade];
        int[] ouro = new int[quantidade];
        int[] prata= new int[quantidade];
        int[] bronze= new int[quantidade];
        for(int i=0; i<quantidade; i++){
            country[i] = ler.next(); // Ler o nome do país
            ouro[i] = ler.nextInt(); // Ler a quantidade de ouro
            prata[i] = ler.nextInt(); // Ler a quantidade de prata
            bronze[i] = ler.nextInt(); // Ler a quantidade de bronze
        }
        ordenar(country, ouro, prata, bronze, quantidade); // Ordenar os países
    }
}