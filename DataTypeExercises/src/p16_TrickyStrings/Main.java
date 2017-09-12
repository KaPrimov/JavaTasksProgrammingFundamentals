package p16_TrickyStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String delimiter = scanner.nextLine();

        int n = Integer.parseInt(scanner.nextLine());
        String message = "";
        for (int i = 0; i < n-1; i++) {
            message += scanner.nextLine();
            message += delimiter;
        }

        message += scanner.nextLine();
        System.out.println(message);

    }
}
