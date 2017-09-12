import java.text.Collator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class c_MixedPhones {
    public static void main(String[] args) {
        Collator collator = Collator.getInstance();
        Map<String, Long> phones = new TreeMap<>();


        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" : ");

        while (!"Over".equals(tokens[0])) {
            String name = tokens[0];
            String phone = tokens[1];

            if (isPhoneNumber(tokens[0])) {
                name = tokens[1];
                phone = tokens[0];
            }

            phones.put(name, Long.parseLong(phone));

            tokens = scanner.nextLine().split(" : ");
        }

        for (Map.Entry<String, Long> namePhoneEntry : phones.entrySet()) {
            System.out.printf("%s -> %d%n", namePhoneEntry.getKey(), namePhoneEntry.getValue());
        }

    }

    private static boolean isPhoneNumber(String string) {
        char[] chars = string.toCharArray();

        for (char aChar : chars) {
            if (Character.isLetter(aChar)) {
                return false;
            }
        }
        return true;
    }
}
