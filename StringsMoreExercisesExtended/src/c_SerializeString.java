import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class c_SerializeString {
    public static void main(String[] args) {
        LinkedHashMap<Character, ArrayList<Integer>> charIndices = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        for (int i = 0; i < str.length(); i++) {
            charIndices.putIfAbsent(str.charAt(i), new ArrayList<>());
            charIndices.get(str.charAt(i)).add(i);
        }

        for (Map.Entry<Character, ArrayList<Integer>> characterValues : charIndices.entrySet()) {
            System.out.printf("%s:%s%n", characterValues.getKey(), characterValues.getValue().toString().replace("[", "").replace("]", "").replace(", ", "/"));
        }
    }
}
