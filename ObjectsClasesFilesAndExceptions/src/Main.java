import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        LinkedHashMap<String, LinkedHashMap<String, Long>> result = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!"report".equals(input))
        {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);
            if (!result.containsKey(country))
            {
                result.put(country, new LinkedHashMap<String, Long>());
            }
            if (!result.get(country).containsKey(city))
            {
                result.get(country).put(city, 0L);
            }

            result.get(country).put(city, result.get(country).get(city) + population);
            input = scanner.nextLine();
        }
        System.out.println(result.size());
        result.entrySet().stream().sorted((a, b) -> {
            long sum1 = a.getValue()
                    .values()
                    .stream()
                    .mapToLong(Long::valueOf)
                    .sum();
            long sum2 = b.getValue()
                    .values()
                    .stream()
                    .mapToLong(Long::valueOf)
                    .sum();
            return Long.compare(sum2, sum1);
        })
        .forEach((a) -> {
            System.out.printf("%s (total population: %d)%n",
                    a.getKey(), a.getValue().values().stream().collect(Collectors.summarizingLong(Long::valueOf)).getSum());

            a.getValue().entrySet().stream().sorted((c1, c2) -> Long.compare(c2.getValue(), c1.getValue())).forEach(a1 -> {
                System.out.println(a1.getKey());
                System.out.println(a1.getValue());
            });
        });
    }
}
