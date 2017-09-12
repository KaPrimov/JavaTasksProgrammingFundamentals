import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class pointsCounter {
    public static void main(String[] args) throws IOException {
        Map<String, LinkedHashMap<String, Long>> teamsScore = new LinkedHashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\|");

        while (!"Result".equals(tokens[0])) {

            String team = tokens[0].replace("@", "").replace("%", "").replace("$", "").replace("*", "");
            String player = tokens[1].replace("@", "").replace("%", "").replace("$", "").replace("*", "");
            long point = Long.parseLong(tokens[2]);

            if (isPlayer(team)) {
                String temp = player;
                player = team;
                team = temp;
            }

            if (!teamsScore.containsKey(team)) {
                teamsScore.put(team, new LinkedHashMap<>());
            }

            teamsScore.get(team).put(player, point);
            tokens = reader.readLine().split("\\|");
        }



        teamsScore.entrySet().stream().sorted((a, b) -> {
            long firstTeamSum =  a.getValue().values().stream().mapToLong(Long::valueOf).sum();
            long secondTeamSum = b.getValue().values().stream().mapToLong(Long::valueOf).sum();

            return Long.compare(secondTeamSum, firstTeamSum);
        }).forEach(t -> {
            long sum = t.getValue().values().stream().mapToLong(Long::valueOf).sum();
            System.out.println(t.getKey() + " => " + sum);
            t.getValue().entrySet().stream()
                    .sorted((a,b) -> Long.compare(b.getValue(), a.getValue()))
                    .limit(1)
                    .forEach(pl -> System.out.println("Most points scored by " + pl.getKey()));
        });

    }

    private static boolean isPlayer(String team) {
        return Character.isLowerCase(team.charAt(1)) ;
    }
}
