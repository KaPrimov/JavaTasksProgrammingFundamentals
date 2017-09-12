import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class e_FlattenDictionary {
    public static void main(String[] args) {
        LinkedHashMap<String, LinkedHashMap<String, String>> map = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");


        while (!"end".equals(tokens[0])) {

            if (tokens[0].equals("flatten")) {
                String key = tokens[1];

                if (map.containsKey(key)) {
                    LinkedHashMap<String, String> tempDict = new LinkedHashMap<>();
                    for (Map.Entry<String, String> e  : map.get(key).entrySet()) {
                        String innerKey = e.getKey();
                        String innerValue = e.getValue();
                        tempDict.put(innerKey + innerValue, "flattened");
                    }

                    map.put(key, tempDict);
                }

            } else {
                String key = tokens[0];
                String innerKey = tokens[1];
                String value = tokens[2];

                map.putIfAbsent(key, new LinkedHashMap<>());
                map.get(key).put(innerKey, value);

            }

            tokens = scanner.nextLine().split(" ");
        }
        int[] index  = {1};
        int[] flatIndex = {1};
        map.entrySet()
                .stream()
                .sorted((a, b) -> {
                    return Integer.compare(b.getKey().length(), (a.getKey().length()));
                })
                .forEach(e -> {
                    index[0] = 1;
                    flatIndex[0] = 1;
                    System.out.println(e.getKey());
                    e.getValue()
                            .entrySet()
                            .stream()
                            .filter(i -> !i.getValue().equals("flattened"))
                            .sorted(Comparator.comparingInt(a -> a.getKey().length()))
                            .forEach(i -> {
                                System.out.printf("%d. %s - %s%n", index[0]++, i.getKey(), i.getValue());
                            });
                    e.getValue()
                            .entrySet()
                            .stream()
                            .filter(i -> i.getValue().equals("flattened"))
                            //.sorted(Comparator.comparingInt(a -> a.getKey().length()))
                            .forEach(i -> {
                                System.out.printf("%d. %s%n", index[0]++, i.getKey());
                            });
                });

        String debug = "";

    }
}
