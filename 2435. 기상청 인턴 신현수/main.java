import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] T = new int[N];

        for(int i = 0; i < N; i++){
            T[i] = sc.nextInt();
        }

        int top = -1000000000;
        int res = 0;
        int i = 0;
        int temp = 0;
        int temp2 = 0;

        for(int f = 0; f < N - K +1; f++){
            i = temp;
            while(temp2 != K){
                res += T[i];
                i++;
                temp2++;
            }
            if(res > top){
                top = res;
            }
            temp++;
            temp2 = 0;
            res = 0;
        }
        System.out.println(top);
        sc.close();
    }
}
