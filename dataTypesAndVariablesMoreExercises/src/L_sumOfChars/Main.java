package L_sumOfChars;

        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine());
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            String letter = scanner.nextLine();
            sum += letter.charAt(0);
        }
        System.out.println("The sum equals: " + sum);
    }
}
