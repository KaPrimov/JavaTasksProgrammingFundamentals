import java.math.BigInteger;
import java.util.Scanner;

public class c_factorial {
    public static void main(String[] args) {

        BigInteger bigInteger = BigInteger.ONE;

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            bigInteger = bigInteger.multiply(new BigInteger("" + i));
        }

        System.out.println(bigInteger);
    }
}
