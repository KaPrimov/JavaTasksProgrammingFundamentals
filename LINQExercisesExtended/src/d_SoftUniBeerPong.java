import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class d_SoftUniBeerPong {
    public static void main(String[] args) {
        Map<String, LinkedHashMap<String, Long>> results = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!"stop the game".equals(line)) {

            String[] tokens = line.split("\\|");
            String playerName = tokens[0];
            String team = tokens[1];
            Long points = Long.parseLong(tokens[2]);

            results.putIfAbsent(team, new LinkedHashMap<>());

            if (results.get(team).size() < 3) {
                results.get(team).put(playerName, points);
            }

            line = scanner.nextLine();
        }
        int[] position = {1};
        results.entrySet().stream()
                .filter(a -> a.getValue().size() == 3 )
                .sorted((a, b) -> Long.compare(
                        b.getValue().values().stream().mapToLong(Long::valueOf).sum(),
                        a.getValue().values().stream().mapToLong(Long::valueOf).sum())
                )
                .forEach(a -> {
                    System.out.printf("%d. %s; Players:%n", position[0], a.getKey());
                    position[0]++;
                    a.getValue().entrySet().stream().sorted((p1, p2)-> Long.compare(p2.getValue(), p1.getValue()))
                            .forEach(p -> System.out.println("###" + p.getKey() + ": " + p.getValue()));
                });
    }
}
