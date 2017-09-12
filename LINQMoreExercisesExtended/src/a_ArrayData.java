import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class a_ArrayData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));

        String command = scanner.nextLine();
        double avg = numbers.stream().mapToDouble(Double::valueOf).average().getAsDouble();
        if (command.equals("Min")) {
            System.out.println(numbers.stream()
                    .filter(n -> n >= avg)
                    .mapToInt(Integer::valueOf)
                    .min().getAsInt());
        } else if (command.equals("Max")) {
            System.out.println(numbers.stream()
                    .filter(n -> n >= avg)
                    .mapToInt(Integer::valueOf)
                    .max().getAsInt());
        } else {
            System.out.println(numbers.stream()
                    .filter(n -> n > avg)
                    .sorted(Integer::compareTo)
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")));
        }
    }
}
