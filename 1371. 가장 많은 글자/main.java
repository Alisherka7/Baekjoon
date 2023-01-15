import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str;
		int alpha[] = new int[26];
		int max = 0;
		
		while((str = br.readLine()) != null) {
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) != ' '){
					alpha[str.charAt(i) - 'a']++;

					if(max < alpha[str.charAt(i) - 'a']){
						max = alpha[str.charAt(i) - 'a'];
					}
				}
			}
		}
		
		for(int i = 0; i < 26; i++){
			if(alpha[i] == max) bw.write((char)(i + 'a'));
		}
		
		br.close();
		bw.close();
	}
}
