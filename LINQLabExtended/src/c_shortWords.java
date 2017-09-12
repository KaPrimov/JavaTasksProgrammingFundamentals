import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class c_shortWords {
    public static void main(String[] args) throws IOException {
        //.,:;()[]"'\/!?

        String separators = "[.,:;()\\[\\]\"'\\/!? ]";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = Arrays.asList(reader.readLine().split(separators));

        System.out.println(words.stream()
                .filter(w -> !w.equals(""))
                .filter(w -> w.length() < 5)
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", ")));

    }
}
