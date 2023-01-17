import java.util.Scanner;

public class Main{
    public static int[] arrN = new int[101];
    public static int[] arrQ = new int[1001];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();

        for(int i =0; i<n; i++){
            arrN[i] = sc.nextInt();
        }
        for(int i =0; i<q; i++){
            arrQ[i] = sc.nextInt();
        }
        for(int i =0; i<q; i++){
            int s = -1;
            int temp = arrQ[i];
            for(int j =0; j<n; j++){
                s = s + arrN[j];
                if(s >= temp){
                    System.out.println(j+1);
                    break;
                }
            }
        }

    }
}
