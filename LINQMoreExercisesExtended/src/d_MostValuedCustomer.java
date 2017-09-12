import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class d_MostValuedCustomer {
    public static void main(String[] args) {
        
        LinkedHashMap<String, Double> productPrices = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> peopleProducts = new LinkedHashMap<>();
        LinkedHashMap<String, Double> peopleTotalSpendings = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        
        String[] productsData = scanner.nextLine().split(" ");

        while (!"Shop".equals(productsData[0]))
        {

            productPrices.put(productsData[0], Double.parseDouble(productsData[1]));

            productsData = scanner.nextLine().split(" ");
        }

        String[] peopleData = scanner.nextLine().trim().split(":");
        while (!"Print".equals(peopleData[0]))
        {
            String personName = peopleData[0];

            if (personName.equals("Discount"))
            {

                productPrices.keySet().stream()
                        .sorted((a,b) -> Double.compare(productPrices.get(b), productPrices.get(a)))
                        .limit(3)
                        .forEach(p -> {
                            productPrices.put(p, productPrices.get(p) * 0.9);
                        });


                peopleData = scanner.nextLine().trim().split(":");
                continue;
            }

            if (!peopleProducts.containsKey(personName))
            {
                peopleProducts.put(personName, new ArrayList<>());
                peopleTotalSpendings.put(personName, 0.0);
            }

            String[] productsArr = peopleData[1].trim().split(", ");

            for (int i = 0; i < productsArr.length; i++)
            {
                if (productPrices.containsKey(productsArr[i]) && productPrices.containsKey(productsArr[i]))
                {
                    peopleProducts.get(personName).add(productsArr[i]);
                }
            }
            peopleData = scanner.nextLine().trim().split(":");
        }

        for (Map.Entry<String, ArrayList<String>> personProducts : peopleProducts.entrySet()) {
            for (String personProduct : personProducts.getValue()) {
                peopleTotalSpendings.putIfAbsent(personProducts.getKey(), 0.0);
                peopleTotalSpendings.put(personProducts.getKey(), peopleTotalSpendings.get(personProducts.getKey()) + productPrices.get(personProduct));
            }
        }

        peopleTotalSpendings.entrySet()
                .stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .limit(1)
                .forEach(p -> {
                    System.out.println("Biggest spender: " + p.getKey());
                    System.out.println("^Products bought:");
                    productPrices.entrySet().stream()
                            .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                            .filter(pr -> peopleProducts.get(p.getKey()).contains(pr.getKey()))
                            .forEach(pr -> System.out.printf("^^^%s: %.2f%n", pr.getKey(), pr.getValue()));
                    System.out.printf("Total: %.2f%n", peopleTotalSpendings.get(p.getKey()));
                });
    }
}
