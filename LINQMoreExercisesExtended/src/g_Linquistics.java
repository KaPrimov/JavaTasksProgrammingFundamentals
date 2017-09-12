import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class g_Linquistics {
    public static void main(String[] args) throws IOException {
        Map<String, LinkedHashSet<String>> collections = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = reader.readLine();

            if (input.equals("exit")) {
                break;
            }

            String[] tokens = input.split("\\.");
            if (tokens.length > 1) {
                collections.putIfAbsent(tokens[0], new LinkedHashSet<>());

                addElements(collections,tokens[0], Arrays.copyOfRange(tokens, 1, tokens.length));
            } else if (input.equals("exit")) {
                break;
            } else if (Character.isDigit(input.charAt(0))) {
                int n = Integer.parseInt("" + input.charAt(0));
                collections
                        .entrySet()
                        .stream()
                        .sorted((a,b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                        .limit(1)
                        .forEach(c -> {
                            c
                                    .getValue()
                                    .stream()
                                    .sorted((a,b) -> Integer.compare(a.length(), b.length()))
                                    .limit(n)
                                    .forEach(m -> {
                                        System.out.println("* " + m);
                                    });
                        });
            } else {
                if (collections.containsKey(input)) {
                    collections.get(input).stream().sorted((a, b) -> {
                        int index = Integer.compare(b.length(), a.length());
                        if (index == 0) {
                            index = countUniqueCharacters(b) - countUniqueCharacters(a);
                        }
                       return index;
                    })
                    .forEach(m -> System.out.printf("* %s%n",m));
                }
            }
         }
        String[] lastLine = reader.readLine().split("\\s+");

        String methodToSearch = lastLine[0];
        String selectionToSearch = lastLine[1];

        collections
                .entrySet()
                .stream()
                .filter(a -> a.getValue().contains(methodToSearch))
                .sorted((a, b) -> {
                    int index = Integer.compare(b.getValue().size(), a.getValue().size());
                    if (index == 0) {
                        String firstValue = b.getValue().stream().min(Comparator.comparingInt(String::length)).get();
                        String secondValue = a.getValue().stream().min(Comparator.comparingInt(String::length)).get();

                        index = Integer.compare(firstValue.length(), secondValue.length());
                    }

                    return index;
                })
                .forEach(c -> {
                    System.out.println(c.getKey());
                    if (selectionToSearch.equals("all")) {
                        c.getValue().stream()
                                .sorted((m1, m2) -> {
                            return Integer.compare(m2.length(), m1.length());
                                })
                                .forEach(m -> System.out.println("* " + m));
                    }
                });

                //for (String key : collections.keySet()) {
                //    System.out.println(key + " --> " + collections.get(key));
                //}

    }

    private static void addElements(Map<String, LinkedHashSet<String>> collections, String key, String[] methods) {
        for (String method : methods) {
            collections.get(key).add(method.replace("(", "").replace(")", ""));
        }
    }
    private static int countUniqueCharacters(String input)
    {
        String unique = input.replaceAll("(.)(?=.*?\\1)", "");
        return unique.length();
    }
}
