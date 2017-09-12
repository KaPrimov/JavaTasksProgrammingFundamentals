package H_houseBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long firstPrice = Long.valueOf(scanner.nextLine());
        long secondPrice = Long.valueOf(scanner.nextLine());

        long totalPrice = firstPrice > secondPrice ? firstPrice * 10 + secondPrice * 4
                : firstPrice * 4 + secondPrice * 10;

        System.out.println(totalPrice);
    }
}