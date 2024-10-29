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

    public static void cesar(String x, String y, int i) {
            if (x.charAt(i) >= 32 && x.charAt(i) <= 127) {
                y += (char) (x.charAt(i) + 3);
            } else {
                y += x.charAt(i);
            }
            i++;
        if (i < x.length()) {
            cesar(x, y, i);
        } else {
            System.out.println(y);
        }
    }

    public static void main(String[] args) {
            Scanner ler = new Scanner(System.in);
            String line = ler.nextLine();
            while(!test(line, "FIM")){
                cesar(line, "", 0);
                line = ler.nextLine();
            }
    }
}