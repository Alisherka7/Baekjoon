import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println(".enter number");
		int N = in.nextInt();
		String a = in.next();
		in.close();

		int sum = 0;

		for(int i = 0; i < N; i++) {
			sum += a.charAt(i)-'0';
		}
		System.out.print(sum);
	}
}
