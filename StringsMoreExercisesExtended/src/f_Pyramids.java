import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class f_Pyramids {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            lines.add(scanner.nextLine());
        }

        ArrayList<String> pyramids = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            for (int j = 0; j < currentLine.length(); j++) {
                char currentChar = currentLine.charAt(j);

                String pyramid = findPyramid(currentChar, lines, i);

                pyramids.add(pyramid);
            }
        }

        Optional<String> stringOptional = pyramids.stream()
                .sorted((a, b) -> Integer.compare(b.length(), a.length()))
                .findFirst();

        if (stringOptional.isPresent()) {
            System.out.println(stringOptional.get());
        }
    }

    private static String findPyramid(char currentChar, ArrayList<String> lines, int currentLine) {

        int count = 1;
        String pyramid = "";
        for (int i = currentLine; i < lines.size(); i++) {
            String toMatch = new String(new char[count]).replace("\0", "" + currentChar);

            if (lines.get(i).contains(toMatch)) {
                pyramid += toMatch + System.lineSeparator();
            } else {
                break;
            }
            count += 2;
        }

        return pyramid;
    }
}
