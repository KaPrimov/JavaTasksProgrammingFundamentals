import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class g_SalesReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Sale> sales = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            sales.add(Sale.parseSale(scanner.nextLine()));
        }

        List<String> towns = sales.stream().map(Sale::getTown)
                .sorted(String::compareTo)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));

        for (String town : towns) {
            double totalSum = sales
                    .stream()
                    .filter(s -> s.getTown().equals(town))
                    .mapToDouble(s -> s.getPrice() * s.getQuantity())
                    .sum();

            System.out.println(String.format("%s -> %.2f", town, totalSum));
        }
    }
}

class Sale {
    private double price;
    private double quantity;
    private String town;
    private Product product;

    public static Sale parseSale(String data) {
        String[] tokens = data.split("\\s+");

        String town = tokens[0];
        double price = Double.parseDouble(tokens[2]);
        double qty = Double.parseDouble(tokens[3]);

        return new Sale(price, qty, town);
    }

    public Sale(double price, double quantity, String town) {
        this.price = price;
        this.quantity = quantity;
        this.town = town;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getTown() {
        return town;
    }
}

class Product {

}