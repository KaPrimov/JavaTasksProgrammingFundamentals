import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class c_Camping {
    public static void main(String[] args) {
        LinkedHashMap<String, ArrayList<String>> peopleVehicles = new LinkedHashMap<>();
        LinkedHashMap<String, Long> peopleNights = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");

        while(true)
        {
            if ("end".equals(tokens[0]))
            {
                break;
            }

            String name = tokens[0];
            String model = tokens[1];
            int nights = Integer.parseInt(tokens[2]);

            if (!peopleVehicles.containsKey(name))
            {
                peopleVehicles.put(name, new ArrayList<String>());
                peopleNights.put(name, 0L);
            }

            peopleVehicles.get(name).add(model);
            peopleNights.put(name, peopleNights.get(name) + nights);

            tokens = scanner.nextLine().split(" ");
        }

        peopleVehicles.entrySet().stream()
                .sorted((a, b) -> {
                    int index = Integer.compare(b.getValue().size(), a.getValue().size());
                    if (index == 0) {
                        index = Integer.compare(a.getKey().length(), b.getKey().length());
                    }
                    return index;
                })
                .forEach(p -> {
                    System.out.println(p.getKey() + ": " + p.getValue().size());
                    p.getValue().forEach(c -> System.out.println("***" + c));
                    System.out.println("Total stay: " + peopleNights.get(p.getKey()) + " nights");
                });
    }
}
