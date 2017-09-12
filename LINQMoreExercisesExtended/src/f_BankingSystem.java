import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class f_BankingSystem {
    public static void main(String[] args) {
        LinkedHashMap<String, LinkedHashMap<String, BigDecimal>> customers =
                new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" -> ");
        while (!"end".equals(tokens[0])) {

            String bank = tokens[0];
            String account = tokens[1];
            BigDecimal balance = new BigDecimal(tokens[2]);

            customers.putIfAbsent(bank, new LinkedHashMap<>());
            customers.get(bank).putIfAbsent(account, BigDecimal.ZERO);
            customers.get(bank).put(account, customers.get(bank).get(account).add(balance));
            tokens = scanner.nextLine().split(" -> ");
        }

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(20);

        customers.entrySet().stream()
                .sorted((a, b) -> {
                    BigDecimal aValue = a.getValue().entrySet()
                            .stream()
                            .map(Map.Entry::getValue)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    BigDecimal bValue = b.getValue().entrySet()
                            .stream()
                            .map(Map.Entry::getValue)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    int index = bValue.compareTo(aValue);

                    if (index == 0) {
                        BigDecimal maxAValue = a.getValue().entrySet()
                                .stream()
                                .map(Map.Entry::getValue)
                                .max(BigDecimal::compareTo).get();

                        BigDecimal maxBValue = b.getValue().entrySet()
                                .stream()
                                .map(Map.Entry::getValue)
                                .max(BigDecimal::compareTo).get();

                        index = maxBValue.compareTo(maxAValue);
                    }

                    return index;
                })
                .forEach(b -> {
                    b.getValue().entrySet()
                            .stream()
                            .sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue()))
                            .forEach(a -> {
                        System.out.printf("%s -> %s (%s)%n", a.getKey(), a.getValue(), b.getKey());
                    });
                });
    }
}
