import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> refDictionary = new LinkedHashMap<>();

        String[] inputTokens = scanner.nextLine().split(" = ");

        while (!"end".equals(inputTokens[0])) {

            if (!refDictionary.containsKey(inputTokens[0])) {
                refDictionary.put(inputTokens[0], "");
            }
            refDictionary.put(inputTokens[0], inputTokens[1]);

            if (refDictionary.containsKey(inputTokens[1])) {
                refDictionary.put(inputTokens[0], refDictionary.get(inputTokens[1]));
            }
            inputTokens = scanner.nextLine().split(" = ");
        }

        for (Map.Entry<String, String> entry : refDictionary.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.printf("%s === %s\n", key, value
                    .replace("[", "").replace("]", ""));
        }
    }
}
