package M_stringConcatenation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String delimiter = scanner.nextLine();
        int rowCheck = scanner.nextLine().toLowerCase().equals("even") ? 0 : 1;
        int n = Integer.valueOf(scanner.nextLine());
        String message = "";
        for (int i = 1; i <= n; i++) {
            String row = scanner.nextLine();
            if (i % 2 == rowCheck) {
                message += row;
                message += delimiter;
            }
        }

        System.out.println(message.substring(0, message.length() - 1));
    }
}
