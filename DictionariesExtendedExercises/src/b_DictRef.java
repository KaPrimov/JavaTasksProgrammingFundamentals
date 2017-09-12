import java.util.LinkedHashMap;
        import java.util.Scanner;

public class b_DictRef {
    public static void main(String[] args) {
        LinkedHashMap<String, String> usersCredentials = new LinkedHashMap<String, String>();

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" -> ");

        while(!"login".equals(input[0]))
        {
            String username = input[0];
            String password = input[1];

            usersCredentials.put(username, password);

            input = scanner.nextLine().split(" -> ");
        }

        input = scanner.nextLine().split(" -> ");
        int failed = 0;
        while (!"end".equals(input[0]))
        {
            String username = input[0];
            String password = input[1];

            if (!usersCredentials.containsKey(username) || !usersCredentials.get(username).equals(password))
            {
                System.out.printf("%s: login failed%n", username);
                failed++;
            }
            else
            {
                System.out.printf("%s: logged in successfully%n", username);
            }

            input = scanner.nextLine().split(" -> ");
        }
        System.out.println("unsuccessful login attempts: " + failed);
    }
}
