package O_decryptMessage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.valueOf(scanner.nextLine());
        int n = Integer.valueOf(scanner.nextLine());
        String message = "";
        for (int i = 0; i < n; i++) {
            char character = scanner.nextLine().charAt(0);
            message += (char)(character + key);
        }

        System.out.println(message);
    }
}
