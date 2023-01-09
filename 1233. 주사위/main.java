import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s3 = sc.nextInt();
        int[] s1Arr = new int[s1];
        int[] s2Arr = new int[s2];
        int[] s3Arr = new int[s3];
        for (int i = 0; i < 40; i++) { 
            if (s1Arr.length >= i + 1) s1Arr[i] = i + 1;
            if (s2Arr.length >= i + 1) s2Arr[i] = i + 1;
            if (s3Arr.length >= i + 1) s3Arr[i] = i + 1;
        }

        int sum = 0;
        int[] sArr = new int[s1 * s2 * s3];
        int p = 0;
        for (int i = 0; i < s1Arr.length; i++) {
            for (int j = 0; j < s2Arr.length; j++) {
                for (int k = 0; k < s3Arr.length; k++) {
                    sum = s1Arr[i] + s2Arr[j] + s3Arr[k];
                    sArr[p] = sum;
                    p++;
                }
            }
        }
        int[] sArr2 = new int[sArr.length];
        for (int i = 0; i < sArr2.length; i++) {
            sArr2[sArr[i]]++;
        }
        int r = 0;
        int q = 0;
        for (int i = 0; i < sArr2.length; i++) {
            q = Math.max(q, sArr2[i]);
        }

        for (int i = 0; i < sArr2.length; i++) {
            if (q == sArr2[i]) {
                r = i;
                break;
            }
        }

        System.out.println(r);
        sc.close();
    }
}
