package H_Mines;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder map = new StringBuilder(scanner.nextLine());

        int bombStart = 0;
        int bombEnd = 0;
        int currentIndex = 0;

        while ((bombStart = map.indexOf("<", currentIndex))!= - 1 &&
                (bombEnd = map.indexOf(">", currentIndex))!= -1 ) {

            String bombContent = map.substring(bombStart + 1, bombEnd);
            int bombPower = getBombPower(bombContent);
            int starIndex = Math.max(0, bombStart - bombPower);
            int endIndex = Math.min(map.length() - 1, bombEnd + bombPower);

            while (starIndex <= endIndex) {
                map.setCharAt(starIndex, '_');
                starIndex++;
            }

            currentIndex =  bombEnd + 1;
        }

        System.out.println(map);
    }

    private static int getBombPower(String bombContent) {
        int sum = 0;
        sum = Math.abs(bombContent.charAt(0) - bombContent.charAt(1));
        return sum;
    }
}
