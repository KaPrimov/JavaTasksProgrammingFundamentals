import java.util.Arrays;
import java.util.Scanner;

public class e_RadioFrequencies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            int[] tokens = Arrays.stream(input[i].split("\\.")).mapToInt(Integer::parseInt).toArray();

            String firstChar = "" + (char)tokens[0];
            String secondChar = "" + (char)tokens[1];

            if (tokens[0] != 0) {
                sb.insert(i, firstChar);
            }

            if (tokens[1] != 0) {
                sb.reverse().insert(i, secondChar).reverse();
            }

        }
        System.out.println(sb.toString());
    }
}
