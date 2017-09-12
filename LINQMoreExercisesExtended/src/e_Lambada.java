import java.util.LinkedHashMap;
import java.util.Scanner;

public class e_Lambada {
    public static void main(String[] args) {
        LinkedHashMap<String, String> lambadas = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" => ");
        while (!"lambada".equals(tokens[0])) {

            if (tokens[0].equals("dance")) {
                for (String lambdaKey : lambadas.keySet()) {
                    lambadas.put(lambdaKey, lambdaKey + "." + lambadas.get(lambdaKey));

                }
                tokens = scanner.nextLine().split(" => ");
                continue;
            }

            lambadas.put(tokens[0], tokens[1]);
            tokens = scanner.nextLine().split(" => ");
        }

        lambadas.entrySet().forEach(l -> {
            System.out.println(l.getKey() + " => " + l.getValue());
        });
    }
}
