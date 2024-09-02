import java.util.Scanner;

public class Main {


    public static boolean fim(String x, String y) {
        if (x.length() == y.length()) {
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) != y.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void maiusculas(String string) {
        int contador = 0;
        int length = string.length();
        for (int i = 0; i < length; i++) {
            if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
                contador++;
            }
        }
        System.out.println(contador);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;

        string = scanner.nextLine();


        while (!fim(string, "FIM")) {
            maiusculas(string);
            string = scanner.nextLine();
        }

        scanner.close();
    }
}