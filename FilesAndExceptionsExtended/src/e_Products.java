import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class e_Products {
    public static void main(String[] args) {
        ArrayList<Product> activeProducts = new ArrayList<>();
        ArrayList<Product> stockedProducts = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        String path = "./stocked.txt";

        while (true)
        {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("exit"))
            {
                break;
            }
            switch (input[0]) {
                case "stock":
                    try(PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
                        for (Product product : activeProducts) {
                            writer.append(String.format("%s %s %f %d%n",
                                    product.name, product.type, product.price, product.quantity));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    activeProducts.clear();
                    break;
                case "analyze":
                    ArrayList<Product> toPrint = new ArrayList<>();
                    try(Scanner in = new Scanner(new FileInputStream(path))) {
                        while (in.hasNext()) {
                            String[] tokens = in.nextLine().split(" ");

                            Product product = new Product();
                            product.name = tokens[0];
                            product.type = tokens[1];
                            product.price = Double.parseDouble(tokens[2]);
                            product.quantity = Integer.parseInt(tokens[3]);

                            toPrint.add(product);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (toPrint.size() == 0){
                        System.out.println("No products stocked");
                    } else {
                        toPrint.stream()
                                .sorted(Comparator.comparing(a -> a.type))
                                .forEach(p -> {
                                    System.out.printf("%s, Product %s%n", p.type, p.name);
                                    System.out.printf("Price: %.2f, Amount Left: %d%n", p.price, p.quantity);
                                });
                    }

                break;
                case "sales":
                    activeProducts
                            .stream()
                            .collect(Collectors.groupingBy(Product::getType))
                            .entrySet()
                            .stream()
                            .sorted((a, b) -> {
                                return Double.compare(
                                        b.getValue().stream().mapToDouble(p -> p.quantity * p.price).sum(),
                                        a.getValue().stream().mapToDouble(p -> p.quantity * p.price).sum()
                                    );
                            })
                            .forEach(kvp -> {
                                System.out.println(kvp.getKey() + ": $" + kvp
                                        .getValue()
                                        .stream()
                                        .mapToDouble(p -> p.quantity * p.price)
                                        .sum());
                            });
                break;
                default:
                    Product product = new Product();
                    product.name = input[0];
                    product.type = input[1];
                    product.price = Double.parseDouble(input[2]);
                    product.quantity = Integer.parseInt(input[3]);
                    activeProducts.add(product);
                    break;
            }
        }

    }
}

class Product {

    public String type;
    public String name;
    public double price;
    public int quantity;

    public String getType() {
        return type;
    }
}
