import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        boolean[] b = new boolean[c + 1];
        Arrays.fill(b, false);
        for (int i = 0; i < n; i++) {
            int period = scan.nextInt();
            for (int j = 1; j <= c / period; j++) {
                b[j * period] = true;
            }
        }

        int cnt = 0;
        for (int i = 1; i <= c; i++) {
            if (b[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
