import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int wormTurnCount = 0;
        boolean isMovingHorizontally = true;
        while (true) {
            wormTurnCount++;
            if (row <= 1 || col <= 1) {
                break;
            }
            
            if (isMovingHorizontally) {
                row--;
            } else {
                col--;
            }
            
            isMovingHorizontally = !isMovingHorizontally;
        }
        
        System.out.print(wormTurnCount);
    }
}
