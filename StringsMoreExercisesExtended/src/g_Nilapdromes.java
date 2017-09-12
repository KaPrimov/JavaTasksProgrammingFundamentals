import java.util.Scanner;

public class g_Nilapdromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String word = scanner.nextLine();
            if ("end".equals(word)) {
                break;
            }
            String nilapdrome = nilapdromeIt(word);

            if (!nilapdrome.isEmpty()) {
                System.out.println(nilapdrome);
            }
        }
    }

    private static String nilapdromeIt(String word) {

        int middleIndex = word.length() / 2;
        int startIndex = 0;

        String border = "";

        for (int i = middleIndex + 1; i < word.length(); i++) {
            if (word.charAt(startIndex) == word.charAt(i)) {
                startIndex++;
                border += word.charAt(i);
            } else {
                border = "";
                startIndex = 0;
                if (word.charAt(startIndex) == word.charAt(i)) {
                    border += word.charAt(startIndex);
                    startIndex += 1;
                }
            }
        }

        if (!border.isEmpty()) {
            int rightBorderIndex = word.lastIndexOf(border);
            String middlePart = word.substring(border.length(), rightBorderIndex);
            if (!middlePart.isEmpty()) {
                return middlePart + border + middlePart;
            }
        }

        return "";
    }
}
