import java.util.Scanner;
public class Main {
    public static boolean test(String x, String y) {
        boolean a = false;
        if (x.length() == y.length()) {
            a = true;
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) != y.charAt(i)) {
                    a = false;
                    i = x.length();
                }
            }
        }
        return a ;
    }

    public static void vogal(String x, int vogal, int consoante, int inteiro, int real, int i) {
            if(x.charAt(i)=='a' || x.charAt(i)== 'e' || x.charAt(i)== 'i' || x.charAt(i)== 'o' || x.charAt(i)== 'u' || x.charAt(i)== 'A' || x.charAt(i)== 'E' || x.charAt(i)== 'I' || x.charAt(i)== 'O' || x.charAt(i)== 'U') {
                vogal++;
            }
            else if ((x.charAt(i) > 64 && x.charAt(i) < 91) || (x.charAt(i) > 96 && x.charAt(i) < 123)){
                consoante++;
            }
            else if ((x.charAt(i) > 47 && x.charAt(i) < 58) && (x.charAt(i) != 46 || x.charAt(i) != 44)){
                inteiro++;
            }
            if (i > 0){
                if ((x.charAt(i) > 47 && x.charAt(i) < 58) && (x.charAt(i -1) == 46 || x.charAt(i - 1) == 44)){
                    real ++;
                }
            }
            i++;
            if (i < x.length()){
                vogal(x, vogal, consoante, inteiro, real, i);
            }
            else{
                print(vogal, consoante, inteiro, real);
            }
    }
    public static void print(int vogal, int consoante, int inteiro, int real){
        if(consoante > 0 && vogal < 0 && inteiro < 0 && real < 0){
            System.out.println("SIM NAO NAO NAO");
        } else if (consoante < 0 && vogal > 0 && inteiro < 0 && real < 0) {
            System.out.println("NAO SIM NAO NAO");
        } else if (consoante < 0 && vogal < 0 && inteiro > 0 && real < 0) {
            System.out.println("NAO NAO SIM SIM");
        } else if (consoante < 0 && vogal < 0 && inteiro < 0 && real > 0) {
            System.out.println("NAO NAO NAO SIM");
        }else{
            System.out.println("NAO NAO NAO NAO");
        }
    }
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String x = ler.nextLine();
        while(!test(x, "FIM")){
            vogal(x, 0, 0, 0, 0, 0);
            x = ler.nextLine();
        }
    }

} // testar true só vogal
//testar true só consoante
//testar true numero inteiro
//testar true numero real