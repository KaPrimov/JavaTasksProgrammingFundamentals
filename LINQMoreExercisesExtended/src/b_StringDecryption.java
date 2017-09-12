import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class b_StringDecryption {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] allElements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(Arrays.stream(allElements)
                .filter(e -> e >= 65 && e <= 90)
                .skip(data[0])
                .limit(data[1])
                .mapToObj(e -> (char) e)
                .map(Object::toString)
                .collect(Collectors.joining("")));
    }
}
