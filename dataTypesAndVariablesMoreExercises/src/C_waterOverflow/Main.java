package C_waterOverflow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine());

        int capacity = 0;

        for (int i = 0; i < n; i++) {
            int toPour = Integer.parseInt(scanner.nextLine());

            if (capacity + toPour > 255) {
                System.out.println("Insufficient capacity!");
            } else {
                capacity += toPour;
            }
        }

        System.out.println(capacity);
    }
}
