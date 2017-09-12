package p04_PunctuationFinder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class punctuationFinder {
    public static void main(String[] args) throws IOException {
        String path = "E:\\Programming\\JavaTasksProgrammingFundamentals\\ObjectsClasesFilesAndExceptions\\src\\p04_PunctuationFinder\\sample_text.txt";
        String outputPath = "E:\\Programming\\JavaTasksProgrammingFundamentals\\ObjectsClasesFilesAndExceptions\\src\\p04_PunctuationFinder\\output.txt";
        List<Character> pucktuations =  new ArrayList<>(Arrays.asList('.', ',', '!', '?', ':'));
        List<Character> toPrint = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line = in.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (pucktuations.contains(line.charAt(i))) {
                        toPrint.add(line.charAt(i));
                    }
                }
                line = in.readLine();
            }

        }
        System.out.println(toPrint.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }
}
