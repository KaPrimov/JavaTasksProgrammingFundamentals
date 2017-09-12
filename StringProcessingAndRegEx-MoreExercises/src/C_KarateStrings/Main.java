package C_KarateStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder path = new StringBuilder(reader.readLine());
        int index = 0;
        boolean isFound = false;
        for (;index <= path.length(); index++) {
            isFound = false;
            if (path.charAt(index) == '>' ) {
                int strength = Integer.parseInt("" + path.charAt(++index));
                while (strength> 0 && index < path.length()) {
                    if (path.charAt(index) == '>') {
                        strength += Integer.parseInt("" + path.charAt(++index));
                    }
                    path.replace(index, index+1, "@");
                    strength--;
                    index++;
                    isFound = true;
                }
            }
            if (isFound) {
                index--;
            }
        }
        System.out.println(path.toString().replace("@", ""));

    }
}
