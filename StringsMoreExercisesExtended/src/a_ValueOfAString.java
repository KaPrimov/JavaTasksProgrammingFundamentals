import java.util.Scanner;

public class a_ValueOfAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        long sum = 0;

        String condition = scanner.nextLine();



        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                if (condition.equals("UPPERCASE")) {
                    if (Character.isUpperCase(line.charAt(i))) {
                        sum += line.charAt(i);
                    }
                } else {
                    if (Character.isLowerCase(line.charAt(i))) {
                        sum += line.charAt(i);
                    }
                }
            }
        }
        System.out.println("The total sum is: " + sum);
    }
}
