package p05WeatherForecast;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try
        {
            long weather = Long.valueOf(scanner.nextLine());
            if (weather >= Byte.MIN_VALUE && weather <= Byte.MAX_VALUE)
            {
                System.out.println("Sunny");
            }
            else if (weather >= Integer.MIN_VALUE && weather <= Integer.MAX_VALUE)
            {
                System.out.println("Cloudy");
            }
            else
            {
                System.out.println("Windy");
            }
        }
        catch (Exception e)
        {
            System.out.println("Rainy");
        }
    }
}
