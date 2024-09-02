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
    public static int palindrome(String x, int i, int j){
        int isPalindrome = 1;

        if(i < j){
            if (x.charAt(i) != x.charAt(j)) {
                isPalindrome = 0;
                return isPalindrome;
            }
            j--;
            i++;
            palindrome(x, i, j);
        }
        return isPalindrome;
    }
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String line = ler.nextLine();
        while(!test(line, "FIM")){
            int resposta = palindrome(line, 0, line.length() - 1);
            if (resposta == 1) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            line = ler.nextLine();
        }
    }
}