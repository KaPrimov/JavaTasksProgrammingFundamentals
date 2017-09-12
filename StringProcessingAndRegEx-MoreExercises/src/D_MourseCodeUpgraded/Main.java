package D_MourseCodeUpgraded;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] letters = scanner.nextLine().split("\\|");
        String message = "";
        char previousChar = 'a';
        int bonusSum = 1;
        for (String letter : letters) {
            int sum = 0;
            for (int i = 0; i < letter.length(); i++) {
                char currentChar = letter.charAt(i);
                if (currentChar == '1') {
                    sum += 5;
                } else if (currentChar == '0') {
                    sum += 3;
                }

                if (previousChar == currentChar) {
                    bonusSum++;
                } else {
                    if (bonusSum != 1) {
                        sum += bonusSum;
                    }
                    bonusSum = 1;
                }

                previousChar = currentChar;
            }
            if (bonusSum != 1) {
                sum += bonusSum;
            }
            message += (char) sum;
            previousChar = 'a';
            bonusSum = 1;
        }
        System.out.println(message);
    }
}
