import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class f_CottageScraper {
    public static void main(String[] args) {
        HashMap<String, List<Double>> receivedLogs = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" -> ");
        int count = 0;
        double totalLength = 0.0;

        while (!"chop chop".equals(tokens[0])) {
            count++;

            String logType = tokens[0];
            double currentLength = Double.parseDouble(tokens[1]);

            totalLength += currentLength;

            receivedLogs.putIfAbsent(logType, new ArrayList<>());
            receivedLogs.get(logType).add(currentLength);

            tokens = scanner.nextLine().split(" -> ");
        }

        String type = scanner.nextLine();
        double length = Double.parseDouble(scanner.nextLine());

        double pricePerMeter = round((totalLength / count), 2); // round to 2nd decimal place

        double usedLogs = receivedLogs.get(type)
                .stream()
                .filter(l -> l >= length)
                .mapToDouble(l -> l * pricePerMeter)
                .sum();

        double unusedLogs = receivedLogs
                .entrySet()
                .stream()
                .filter(e -> !e.getKey().equals(type))
                .mapToDouble(ie -> ie.getValue()
                        .stream()
                        .mapToDouble(il -> (il * pricePerMeter) * 0.25)
                        .sum())
                .sum();

        unusedLogs += receivedLogs.get(type)
                .stream()
                .filter(l -> l < length)
                .mapToDouble(l -> (l * pricePerMeter) * 0.25)
                .sum();

        System.out.printf("Price per meter: $%.2f%n", pricePerMeter);
        System.out.printf("Used logs price: $%.2f%n", usedLogs);
        System.out.printf("Unused logs price: $%.2f%n", (unusedLogs));
        System.out.printf("CottageScraper subtotal: $%.2f%n", (usedLogs + unusedLogs));

    }
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
