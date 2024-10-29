import java.util.*;
public class Main {
    public static Boolean fim(String x, String y) {
        Boolean res = true;
        if(x.length() == y.length()){
            for(int i = 0; i < x.length(); i++){
                if(x.charAt(i) != y.charAt(i)){
                    res = false;
                }
            }
        }
        else{
            res = false;
        }
        return res;
    }
    public static void alteracao(String x){
        Random gerador = new Random();
        gerador.setSeed(4);
        String resposta = "";
        char aleatorio1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        char aleatorio2;
        do {
            aleatorio2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        } while (aleatorio1 == aleatorio2);
        for(int i = 0; i < x.length(); i++){
            if(x.charAt(i) == aleatorio1){
                resposta += aleatorio2;
            }
            else{
                resposta += x.charAt(i);
            }
        }
        System.out.println(resposta);
    }
    public static void main(String[] args) {
        String string;
        Scanner ler = new Scanner(System.in);
        string = ler.nextLine();
        while(!fim(string, "FIM")){
            alteracao(string);
            string = ler.nextLine();
        }
    }
}