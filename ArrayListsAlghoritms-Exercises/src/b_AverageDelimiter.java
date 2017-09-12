import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class b_AverageDelimiter {
    public static void main(String[] args) {
        double sum = 0;
        long numbOfChars = 0L;
        Scanner scanner = new Scanner(System.in);
        List<Integer> ints = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            for (int character = 0; character < input[i].length(); character++) {
                sum += input[i].charAt(character);
            }
            numbOfChars+=input[i].length();
        }
        int charCode = (int)(sum / numbOfChars);
        String separator = "" + (char) charCode;

        System.out.println(ints.stream().map(Object::toString).collect(Collectors.joining(separator.toUpperCase())));
    }
}
