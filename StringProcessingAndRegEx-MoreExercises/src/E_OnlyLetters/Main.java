package E_OnlyLetters;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("(\\d+)([A-Za-z])");

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String numMatch = matcher.group(1);
            text = text.replace(numMatch, matcher.group(2));
        }

        System.out.println(text);
    }
}
