import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger firstNum = new BigInteger(br.readLine());
        String operator = br.readLine();
        BigInteger secondNum = new BigInteger(br.readLine());
        if (operator.equals("+")) {
            System.out.println(firstNum.add(secondNum));
        } else if (operator.equals("*")) {
            System.out.println(firstNum.multiply(secondNum));
        }

    }
}
