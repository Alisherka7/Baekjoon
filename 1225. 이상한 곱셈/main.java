import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num[] = br.readLine().split(" ");
		long res = 0;
		
		for(int i = 0; i < num[0].length(); i++) {
			for(int j = 0; j < num[1].length(); j++) {
				res += Integer.parseInt(num[0].charAt(i)+"")*Integer.parseInt(num[1].charAt(j)+"");
			}
		}
		System.out.println(res);
	}
}
