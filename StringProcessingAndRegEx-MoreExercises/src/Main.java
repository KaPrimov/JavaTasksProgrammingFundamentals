import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> phonebook = new TreeMap<String, String>();

        String input = reader.readLine();

        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "A":

                    phonebook.put(tokens[1], tokens[2]);
                    break;
                case "S":
                    if (phonebook.containsKey(tokens[1])) {
                        System.out.println(tokens[1] + " -> " + phonebook.get(tokens[1]));
                    } else {
                        System.out.printf("Contact %s does not exist.%n", tokens[1]);
                    }
                    break;
                case "ListAll":
                    for (Map.Entry<String, String> stringStringEntry : phonebook.entrySet()) {
                        System.out.println(stringStringEntry.getKey() + " -> " + stringStringEntry.getValue());
                    }
                    break;
            }

            input = reader.readLine();
        }



    }
}
