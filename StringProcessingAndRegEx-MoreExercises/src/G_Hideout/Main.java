package G_Hideout;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String map = scanner.nextLine();
        boolean isFound = false;
        while (!isFound) {
            String[] tokens = scanner.nextLine().split(" ");
            String  regex = String.format("(\\%s{%s,})", tokens[0], tokens[1]);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(map);

            if (matcher.find()) {
                isFound = true;
                String minimumSearched = new String(new char[Integer.valueOf(tokens[1])]).replace("\0", tokens[0]);
                System.out.printf("Hideout found at index %d and it is with size %d!",
                        map.indexOf(minimumSearched),
                        matcher.group(1).length());
            }
        }
    }
}
