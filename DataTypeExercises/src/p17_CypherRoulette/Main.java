package p17_CypherRoulette;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String previousCommand = "";
        boolean reversed = false;
        String message = "";
        for (int i = 0; i < n; i++) {
            String currentString = scanner.nextLine();

            if (currentString.equals(previousCommand)) {
                message = "";
                if (currentString.equals("spin")) {
                    i--;
                }
            } else {
                if (currentString.equals("spin")) {
                    reversed = !reversed;
                    i--;

                } else {
                    if (!reversed) {
                        message += currentString;
                    } else {
                        message = currentString + message;
                    }
                }
            }
            previousCommand = currentString;
        }

        System.out.println(message);
    }
}
