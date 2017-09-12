package personalException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NegativeNumberException {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                long num = Long.parseLong(scanner.nextLine());

                if (num < 0) {
                    throw new NegativeNumberException();
                } else {
                    System.out.println(num);
                }
            }
        } catch (NegativeNumberException nne) {
            System.out.println(nne.getMessage());
        }

    }
}
