import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int[] computers = new int[100];
        int counter = 0;

        for(int i =0; i<n; i++){
            int currentPlace = sc.nextInt();
            if(computers[currentPlace-1] == 0){
                computers[currentPlace-1] = 1;
            }else{
                counter++;
            }
        }
        System.out.println(counter);
    }
}
