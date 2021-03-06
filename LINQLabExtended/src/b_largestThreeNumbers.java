import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class b_largestThreeNumbers {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = Arrays.stream(reader.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));

        System.out.println(numbers
                .stream()
                .sorted((a,b) -> b-a)
                .limit(3)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
