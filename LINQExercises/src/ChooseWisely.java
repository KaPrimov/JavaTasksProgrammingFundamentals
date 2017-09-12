import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChooseWisely {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double peshoBudget = Double.parseDouble(scanner.nextLine());
        Map<String, Double> products = new HashMap<>();
        String line = scanner.nextLine();

        while (!line.equals("end")) {

            String[] tokens = line.split(" ");

            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);

            if (products.containsKey(name) && products.get(name) > price) {
                products.put(name, price);
            }

            products.putIfAbsent(name, price);

            line = scanner.nextLine();
        }

        double sum = products.values().stream().mapToDouble(Double::valueOf).sum();

        if (sum > peshoBudget) {
            System.out.println("Need more money... Just buy banichka");
        } else {
            products.entrySet().stream().sorted((a, b) -> {

                int index = b.getValue().compareTo(a.getValue());

                if (index == 0) {
                    index = a.getKey().length() - b.getKey().length();
                }

                return index;
            }).forEach(e -> System.out.println(e.getKey() + " costs " + String.format("%.2f", e.getValue())));
        }

    }
}
