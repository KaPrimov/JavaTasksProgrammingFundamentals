import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> wordCount = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        String[] wordsInput = scanner.nextLine().toLowerCase().split(" ");

        for (int i = 0; i < wordsInput.length; i++) {
            if (!wordCount.containsKey(wordsInput[i])) {
                wordCount.put(wordsInput[i], 0);
            }
            wordCount.put(wordsInput[i], wordCount.get(wordsInput[i]) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        //for (Map.Entry<String, Integer> word : wordCount.entrySet()) {
        //    if (word.getValue() % 2 == 1){
        //        result.add(word.getKey());
        //    }
        //}

        System.out.println(result.stream().map(Object::toString)
                .collect(Collectors.joining("***")));




    }
}
