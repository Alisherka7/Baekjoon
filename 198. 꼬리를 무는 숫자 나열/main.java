import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int a1 = Integer.parseInt(st.nextToken());
        final int a2 = Integer.parseInt(st.nextToken());
        final int x1 = (a1 - 1) / 4 + 1;
        final int x2 = (a2 - 1) / 4 + 1;
        final int y1 = (a1 - 1) % 4;
        final int y2 = (a2 - 1) % 4;
        final int dist = (Math.abs(x2 - x1) + Math.abs(y2 - y1));
        System.out.println(dist);

        br.close();
    }
}
