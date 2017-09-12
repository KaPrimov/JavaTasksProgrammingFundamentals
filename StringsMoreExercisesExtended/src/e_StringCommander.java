import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class e_StringCommander {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String stringToManipulate = reader.readLine();

        StringBuilder sb = new StringBuilder(stringToManipulate);

        String[] tokens = reader.readLine().split("\\s+");

        while (!tokens[0].equals("end")) {

            String command = tokens[0];

            switch (command) {
                case "Left":
                    int countLeft = Integer.parseInt(tokens[1]);
                    sb = rollItems(sb, -countLeft);
                    break;
                case "Right":
                    int countRight = Integer.parseInt(tokens[1]);
                    sb = rollItems(sb, countRight);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String string = tokens[2];
                    sb.insert(index, string);
                    break;
                case "Delete":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    sb.delete(startIndex, endIndex+1);
                    break;
            }

            tokens = reader.readLine().split("\\s+");
        }
        System.out.println(sb.toString());
    }

    private static StringBuilder rollItems(StringBuilder sb, int count) {
        char[] word = new char[sb.length()];

        for (int oldIndex = 0; oldIndex < word.length; oldIndex++) {
            int newIndex = oldIndex + count;
            newIndex %= word.length;
            if (newIndex < 0) {
                newIndex += sb.length();
            }
            word[newIndex] = sb.charAt(oldIndex);
        }
        return new StringBuilder(String.valueOf(word));

    }
}
