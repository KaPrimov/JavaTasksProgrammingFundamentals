package E_weatherForecast;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            long num = Long.parseLong(scanner.nextLine());

            if (num <= Byte.MAX_VALUE && num >= Byte.MIN_VALUE) {
                System.out.println("Sunny");
            } else if (num <= Integer.MAX_VALUE && num >= Integer.MIN_VALUE) {
                System.out.println("Cloudy");
            } else if (num <= Long.MAX_VALUE && num >= Long.MIN_VALUE) {
                System.out.println("Windy");
            }
        } catch (Exception e) {
            System.out.println("Rainy");
        }
    }
}
