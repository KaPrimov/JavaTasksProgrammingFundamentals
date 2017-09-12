package A_Censorship;

import java.util.Scanner;

public class A_Censorship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String sentence = scanner.nextLine();


        System.out.println(sentence.replaceAll(word, new String(new char[word.length()]).replace("\0", "*")));
    }
}
