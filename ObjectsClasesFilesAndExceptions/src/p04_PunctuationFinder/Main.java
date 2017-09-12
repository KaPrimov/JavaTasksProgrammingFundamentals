package p04_PunctuationFinder;//package puctuationFinder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "E:\\Programming\\JavaTasksProgrammingFundamentals\\ObjectsClasesFilesAndExceptions\\src\\p04_PunctuationFinder\\sample_text.txt";
        String outputPath = "E:\\Programming\\JavaTasksProgrammingFundamentals\\ObjectsClasesFilesAndExceptions\\src\\p04_PunctuationFinder\\output.txt";
        List<Character> pucktuations =  new ArrayList<>(Arrays.asList('.', ',', '!', '?', ':'));
        try (BufferedReader in = new BufferedReader(new FileReader(path));
             BufferedWriter out = new BufferedWriter(new FileWriter(outputPath))) {
            String line = in.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (!pucktuations.contains(line.charAt(i))) {
                        out.write(line.charAt(i));
                    }
                }
                out.append("\r\n");
                line = in.readLine();
            }

        }
        StringBuilder sb = new StringBuilder();

    }
}
