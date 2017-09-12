import java.util.LinkedHashMap;
import java.util.Scanner;

public class b_DefaultValues {
    public static void main(String[] args) {
        LinkedHashMap<String, String> values = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" -> ");
        while (!"end".equals(tokens[0])) {

            String key = tokens[0];
            String value = tokens[1];

            values.put(key, value);

            tokens = scanner.nextLine().split(" -> ");
        }

        String defaultValue = scanner.nextLine();

        values.entrySet()
                .stream()
                .filter(a -> !a.getValue().equals("null"))
                .sorted((a, b) -> Integer.compare(b.getValue().length(), a.getValue().length()))
                .forEach(kvp -> {
                    System.out.println(kvp.getKey() + " <-> " + kvp.getValue());
                });

        values.entrySet()
                .stream()
                .filter(a -> a.getValue().equals("null"))
                .forEach(kvp -> {
                    System.out.println(kvp.getKey() + " <-> " + defaultValue);
                });

    }
}
