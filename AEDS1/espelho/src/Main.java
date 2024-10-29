import java.util.Scanner;
public class Main {

    public static String espelho(int a, int b) {
        String c = " ";
        for (int i = a; i <= b; i++) {
            c = c +i;
        }
        for(int i = c.length() - 1; i>= 0; i--){
            c = c + c.charAt(i);
        }
        return c;
    }


    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int a =0;
        int b =0;
        while(ler.hasNext()){
            a = ler.nextInt();
            b = ler.nextInt();
            String c = espelho(a,b);
            System.out.println(c);
        }
    }
}