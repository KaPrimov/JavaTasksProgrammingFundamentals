package B_numberChecker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            long num = Long.valueOf(scanner.nextLine());
            System.out.println("integer");
        } catch (NumberFormatException nfe) {
            System.out.println("floating-point");
        }
    }
}
