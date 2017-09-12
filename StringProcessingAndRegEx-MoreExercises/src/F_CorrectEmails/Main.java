package F_CorrectEmails;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "^([A-Za-z]{5,})@([a-z]{3,}\\.(com|bg|org))$";
        Pattern pattern = Pattern.compile(regex);
        Map<String, Set<String>> emails = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String email = scanner.nextLine();
            if (email.matches(regex)) {
                Matcher matcher = pattern.matcher(email);
                if(matcher.find()) {
                    emails.putIfAbsent(matcher.group(2), new LinkedHashSet<>());
                    emails.get(matcher.group(2)).add(matcher.group(1));
                }
            }
        }

        emails.keySet()
                .stream()
                .sorted((a, b) -> Integer.compare(emails.get(b).size(), emails.get(a).size()))
                .forEach(d -> {
                    System.out.println(d + ":");
                    emails.get(d).forEach(u -> {
                        System.out.println("### " + u );
                    });
                });
    }

}
