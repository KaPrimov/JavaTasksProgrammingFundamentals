package p06_IncrementVariable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int overflowed = n / 256;
        System.out.println(n % 256);
        if (overflowed > 0) {
            System.out.printf("Overflowed %d times", overflowed);
        }
    }
}
