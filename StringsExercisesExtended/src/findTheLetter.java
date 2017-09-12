import java.util.Scanner;

public class findTheLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        String[] dataArr = scanner.nextLine().split(" ");
        char letter = dataArr[0].charAt(0);
        int count = Integer.parseInt(dataArr[1]);

        int index = -1;
        while ((index = sentence.indexOf(letter, index + 1)) != -1) {
            count--;
            if (count == 0) {
                System.out.println(index);
                break;
            }
        }

        if (count != 0) {
            System.out.println("Find the letter yourself!");
        }
    }
}
