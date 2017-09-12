import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String delimiter = scanner.nextLine();
        String condition = scanner.nextLine().toLowerCase().trim();
        int n = Integer.parseInt(scanner.nextLine());
        String message = "";
        int result = 0;
        StringBuilder sb = new StringBuilder();
        if (condition.equals("odd"))
        {
            result = 1;
        }
        for (int i = 1; i <= n; i++)
        {
           String tempString = scanner.nextLine();
            if (i % 2 == result)
            {
                sb.append(tempString + delimiter);
            }
        }

        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }
}
