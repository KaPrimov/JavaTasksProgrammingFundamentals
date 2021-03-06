import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class a_sumMinMaxAvg {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));
        }

        long sum = numbers.stream().mapToInt(Integer::valueOf).sum();
        long min = numbers.stream().min(Integer::compareTo).get();
        long max = numbers.stream().max(Integer::compareTo).get();
        double avg = numbers.stream().mapToInt(Integer::valueOf).average().getAsDouble();

        System.out.println("Sum = " + sum);
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
        System.out.println("Average = " + avg);

    }
}
