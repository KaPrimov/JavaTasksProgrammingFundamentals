package p08HouseBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long price1 = Long.parseLong(scanner.nextLine());
        long price2 = Long.parseLong(scanner.nextLine());

        byte bytePrice  = 0;
        long intPrice = 0;

        if (price1 > price2) {
            intPrice = price1;
            bytePrice = (byte) price2;
        } else {
            intPrice = price2;
            bytePrice =(byte) price1;
        }

        System.out.println(bytePrice * 4 + intPrice * 10);
    }
}
