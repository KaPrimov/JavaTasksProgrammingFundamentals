import java.util.Arrays;
import java.util.Scanner;

public class f_Batteries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] initialPower = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        double[] usagePerHour = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        int hours = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < initialPower.length; i++) {
            System.out.println("Battery " + (i + 1) + ": " +
                    (usagePerHour[i] * hours > initialPower[i]
                            ? String.format("dead (lasted %d hours)", (int) (Math.ceil(initialPower[i] / usagePerHour[i])))
                            : String.format("%.2f mAh (%.2f)%%", initialPower[i] - usagePerHour[i] * hours, ((initialPower[i] - usagePerHour[i] * hours) / initialPower[i]) * 100))
            );
        }
    }
}
