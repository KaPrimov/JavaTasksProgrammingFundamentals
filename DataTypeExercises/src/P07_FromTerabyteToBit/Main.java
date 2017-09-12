package P07_FromTerabyteToBit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double terabytes = Double.parseDouble(scanner.nextLine());

        double bits = terabytes * 1024 * 1024 * 1024 * 1024 * 8;

        System.out.println(Math.round(bits));
    }
}
