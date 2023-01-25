import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n
        int n = sc.nextInt();
        int[] res = new int[n];
        int leftCounter = 1;
        int rightCounter = 1;
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextInt();
        }

        int currMax = res[0];

        // left
        for (int i = 1; i < res.length; i++) {
            if (res[i] > currMax) {
                leftCounter++;
                currMax = res[i];
            }
        }

        currMax = res[n - 1];

        // right 5 4 3 4
        for (int i = res.length - 2; i >= 0; i--) {
            if (res[i] > currMax) {
                currMax = res[i];
                rightCounter++;
            }
        }
        System.out.println(leftCounter);
        System.out.println(rightCounter);
    }

}
