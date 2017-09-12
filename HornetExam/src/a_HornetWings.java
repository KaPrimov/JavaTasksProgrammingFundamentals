import java.util.Scanner;

public class a_HornetWings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        long wingFlaps = Long.parseLong(scanner.nextLine());
        double meters = Double.parseDouble(scanner.nextLine());
        int endurance = Integer.parseInt(scanner.nextLine());

        double distance = (wingFlaps / 1000) * meters;

        long totalSeconds = wingFlaps / 100;

        totalSeconds += ((wingFlaps / endurance) * 5);

        System.out.printf("%.2f m.%n", distance);
        System.out.printf("%d s.", totalSeconds);
    }
}
