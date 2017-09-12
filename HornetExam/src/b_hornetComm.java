import java.util.Scanner;
import java.util.regex.Pattern;

public class b_hornetComm {
    public static void main(String[] args) {
        //ArrayList<String> messages = new ArrayList<>();
        //ArrayList<String> broadcasts = new ArrayList<>();
        StringBuilder messages = new StringBuilder();
        StringBuilder broadcasts = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        Pattern patternOnlyDigits = Pattern.compile("^\\d+$");
        Pattern patternOnlyDigitsAndLetters = Pattern.compile("^[A-Za-z\\d]+$");
        Pattern patternAnythingButDigits = Pattern.compile("^\\D+$");
        while (true) {
            String[] tokens = scanner.nextLine().split(" <-> ");

            if (tokens[0].equals("Hornet is Green")) {
                break;
            }

            if (tokens.length != 2) {
                continue;
            }

            String firstPart = tokens[0];
            String secondPart = tokens[1];

            if (patternOnlyDigits.matcher(firstPart).find() &&
                    patternOnlyDigitsAndLetters.matcher(secondPart).find()) {
                StringBuilder recipientCode = new StringBuilder(firstPart).reverse();

                messages.append(String.format("%s -> %s", recipientCode, secondPart)).append("\r\n");

            } else if (patternAnythingButDigits.matcher(firstPart).find() &&
                    patternOnlyDigitsAndLetters.matcher(secondPart).find()) {
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < secondPart.length(); i++) {
                    if (Character.isUpperCase(secondPart.charAt(i))) {
                        sb.append(Character.toLowerCase(secondPart.charAt(i)));
                    } else if (Character.isLowerCase(secondPart.charAt(i))) {
                        sb.append(Character.toUpperCase(secondPart.charAt(i)));
                    } else {
                        sb.append(secondPart.charAt(i));
                    }
                }

                broadcasts.append(String.format("%s -> %s", sb, firstPart)).append("\r\n");

            }
        }

        System.out.println("Broadcasts:");
        System.out.println(broadcasts.length() > 0 ?
        broadcasts.delete(broadcasts.length() - 2, broadcasts.length()) :
        "None");

        System.out.println("Messages:");
        System.out.println(messages.length() > 0 ?
                messages.delete(messages.length() - 2, messages.length()) :
                "None");
    }
}
