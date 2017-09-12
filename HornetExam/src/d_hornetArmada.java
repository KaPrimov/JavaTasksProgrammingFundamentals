import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class d_hornetArmada {
    public static void main(String[] args) throws IOException {
        LinkedHashMap<String, HashMap<String, Long>> legionSoldiers = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> legionActivities = new LinkedHashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s=\\s|\\s->\\s|:");
            int activity = Integer.parseInt(tokens[0]);
            String legionName = tokens[1];
            String soldierType = tokens[2];
            long soldiersCount = Long.parseLong(tokens[3]);

            legionSoldiers.putIfAbsent(legionName, new LinkedHashMap<>());
            legionActivities.putIfAbsent(legionName, activity);

            if (legionActivities.get(legionName) < activity) {
                legionActivities.put(legionName, activity);
            }
            legionSoldiers.get(legionName).putIfAbsent(soldierType, 0L);
            legionSoldiers.get(legionName)
                    .put(soldierType, legionSoldiers.get(legionName).get(soldierType) + soldiersCount);
        }

        String[] conditions = reader.readLine().split("\\\\");
        StringBuilder result = new StringBuilder();
            if (conditions.length == 2) {
            int activity = Integer.parseInt(conditions[0]);
            String soldierType = conditions[1];
            legionSoldiers.entrySet().stream()
                    //.filter(e -> e.getValue().containsKey(soldierType))
                    .sorted((a, b) -> {
                        Long averageA = a.getValue().getOrDefault(soldierType, 0L);

                        Long averageB = b.getValue().getOrDefault(soldierType, 0L);

                        return Long.compare(averageB, averageA);
                    })
                    .forEach(l -> {
                        if (legionActivities.get(l.getKey()) < activity) {
                            if(legionSoldiers.get(l.getKey()).containsKey(soldierType)) {
                                result.append(l.getKey()).append(" -> ").append(l.getValue().get(soldierType)).append("\r\n");
                                //result.append(String.format("%s -> %d%n", l.getKey(), l.getValue().get(soldierType)));
                                //System.out.printf("%s -> %d%n", l.getKey(), l.getValue().get(soldierType));
                            }
                        }
                    });
        } else {
            String type = conditions[0];
            legionActivities.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(l -> {
                        if (legionSoldiers.get(l.getKey()).containsKey(type)) {
                            result.append(l.getValue()).append(" : ").append(l.getKey()).append("\r\n");
                            //result.append(String.format("%d : %s%n", l.getValue(), l.getKey()));
                            //System.out.printf("%d : %s%n", l.getValue(), l.getKey());
                        }
                    });
        }
        System.out.println(result.delete(result.length() - 2, result.length()));
    }
}
