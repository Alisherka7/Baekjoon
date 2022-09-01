import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int starCol = scanner.nextInt();
        for (int i = 0; i < starCol; i++) {
            for (int j = 1; j <= i + 1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
