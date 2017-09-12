import java.util.ArrayList;
import java.util.Scanner;

public class d_ArrayHistogram {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        for (String word : input) {
            if (!words.contains(word)) {
                words.add(word);
                count.add(1);
            } else {
                int index = words.indexOf(word);
                count.set(index, count.get(index) + 1);
            }
        }

        boolean swapped = false;


        do {
            swapped = false;
            for (int i = 0; i < count.size() - 1; i++) {
                if (count.get(i) < count.get(i + 1)) {
                    int tempCount = count.get(i);
                    count.set(i, count.get(i + 1));
                    count.set(i + 1, tempCount);

                    String tempWord = words.get(i);
                    words.set(i, words.get(i + 1));
                    words.set(i + 1, tempWord);
                    swapped = true;
                }
            }
        } while (swapped);


        for (int i = 0; i < words.size(); i++) {
            System.out.printf("%s -> %d times (%.2f%%)%n",
                    words.get(i),
                    count.get(i),
                    ((double)count.get(i) / (double) input.length) * 100);
        }
    }
}
