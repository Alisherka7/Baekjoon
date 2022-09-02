import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] res = new int[6];
        int[] fullNum = new int[] { 1, 1, 2, 2, 2, 8 };
        for (int i = 0; i < 6; i++) {
            res[i] = scanner.nextInt();
            res[i] = fullNum[i] - res[i];
            System.out.print(res[i] + " ");
        }
    }
}
