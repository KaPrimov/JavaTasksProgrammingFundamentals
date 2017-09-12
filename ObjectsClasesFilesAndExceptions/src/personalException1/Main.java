package personalException1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int number = scanner.nextInt();
            if (number < 0) {
                try {
                    throw new PersonalException();
                } catch (PersonalException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
