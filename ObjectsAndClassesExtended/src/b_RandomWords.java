import java.util.Arrays;
        import java.util.Random;
        import java.util.Scanner;

public class b_RandomWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Random rnd = new Random();

        for (int i = 0; i < words.length; i++) {
            int index = rnd.nextInt(words.length);

            String temp = words[i];
            words[i] = words[index];
            words[index] = temp;
        }
        Arrays.stream(words).forEach(System.out::println);
    }
}
