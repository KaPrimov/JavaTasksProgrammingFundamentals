import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class a_DayOfTheWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        LocalDate date = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);

        System.out.println(capitalizeDay(date.getDayOfWeek()));

    }

    private static String capitalizeDay(DayOfWeek dayOfWeek) {
        return dayOfWeek.toString().substring(0,1) + dayOfWeek.toString().substring(1, dayOfWeek.name().length()).toLowerCase();
    }
}
