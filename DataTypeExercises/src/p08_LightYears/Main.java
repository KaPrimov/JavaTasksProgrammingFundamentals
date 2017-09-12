package p08_LightYears;


        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lightYear = Double.parseDouble(scanner.nextLine());
        double kilometers = lightYear*9450000000000d;
        double lightSpeed = 300000;

        double seconds = kilometers / lightSpeed;
        double minutes = seconds / 60;
        seconds %= 60;
        double hours = minutes / 60;
        minutes %= 60;
        double days = hours / 24;
        hours %= 24;
        double weeks = days / 7;
        days %= 7;

        System.out.printf("%d weeks%n", (int)weeks);
        System.out.printf("%d days%n", (int)days);
        System.out.printf("%d hours%n", (int)hours);
        System.out.printf("%d minutes%n", (int)minutes);
        System.out.printf("%d seconds%n", (int)seconds);
    }
}
