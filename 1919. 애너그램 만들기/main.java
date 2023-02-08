import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] alpha = new int[26];
        int sum = 0;
        char[] w1 = sc.nextLine().toCharArray();
        char[] w2 = sc.nextLine().toCharArray();
        for(char ca : w1){
            alpha[ca-97]++;
        }
        for(char ca : w2){
            alpha[ca-97]--;
        }
        for(int i =0; i<alpha.length; i++){
            alpha[i] = Math.abs(alpha[i]);
            
            if(alpha[i] != 0){
                sum += alpha[i];
            }
        }
        System.out.println(sum);
    }
}
