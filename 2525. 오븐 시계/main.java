import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 앞으로 br, bw는 세트로 생각하겠어요
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int howMuch = Integer.parseInt(br.readLine());
        s += howMuch;

        if (s >= 60) {
            m += s / 60;
            s -= s / 60 * 60;
        }
        if (m >= 24) {
            m -= 24;
        }
        bw.write(String.valueOf(m));
        bw.write(String.valueOf(" "));
        bw.write(String.valueOf(s));
        bw.flush();
    }
}
