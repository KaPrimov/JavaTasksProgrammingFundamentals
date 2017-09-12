package p05_GroceryStore;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^([A-Z][a-z]+):(\\d+\\.\\d{2})$";
        Pattern pattern = Pattern.compile(regex);

        Map<String, Double> products = new HashMap<>();

        while (true) {
            String productData = scanner.nextLine();

            if (productData.equals("bill")) {
                break;
            }

            Matcher matcher = pattern.matcher(productData);
            if (matcher.find()) {
                products.put(matcher.group(1), Double.parseDouble(matcher.group(2)));
            }
        }

        products.keySet().stream().sorted(
                (a, b) -> Double.compare(products.get(b), products.get(a)))
                .forEach(p -> System.out.printf("%s costs %.2f%n", p, products.get(p)));
    }
}
