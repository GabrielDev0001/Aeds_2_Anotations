import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static boolean hasFractionalPart(double number) {
        return number % 1 != 0;
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        RandomAccessFile file = new RandomAccessFile("numeros.txt", "rw");

        for (int i = 0; i < n; i++) {
            double num = scanner.nextDouble();
            file.writeDouble(num);
        }

        file.close();

        file = new RandomAccessFile("numeros.txt", "r");
        long position = file.length();
        while (position > 0) {
            position -= 8;
            file.seek(position);
            double resposta = file.readDouble();
            if(!hasFractionalPart(resposta))
                System.out.println((int)resposta);
            else
                System.out.println(resposta);
        }

        file.close();
    }
}
