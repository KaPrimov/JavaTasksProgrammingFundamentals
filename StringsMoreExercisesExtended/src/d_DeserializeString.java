import java.util.*;
import java.util.stream.Collectors;

public class d_DeserializeString {
    public static void main(String[] args) {
        LinkedHashMap<Character, int[]> indices = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] tokens = scanner.nextLine().split(":");

            if("end".equals(tokens[0])) {
                break;
            }

            Character letter = tokens[0].charAt(0);
            int[] letterIndices = Arrays.stream(tokens[1].split("/")).mapToInt(Integer::parseInt).toArray();

            indices.put(letter, letterIndices);
        }

        TreeMap<Integer, Character> finalOrder = new TreeMap<>();

        for (Map.Entry<Character, int[]> characterEntry : indices.entrySet()) {
            for (int index : characterEntry.getValue()) {
                finalOrder.put(index, characterEntry.getKey());
            }
        }

        System.out.println(finalOrder.values()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining("")));
    }
}
