import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] res = new int[5];
        int finalInt = 0;
        for (int i = 0; i < 5; i++) {
            int currentNum = scanner.nextInt();
            int sqrt = currentNum * currentNum;
            res[i] = sqrt;
        }
        for (int sum : res) {
            finalInt += sum;
        }
        System.out.println(finalInt % 10);
    }
}
