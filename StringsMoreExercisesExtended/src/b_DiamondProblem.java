import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class b_DiamondProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        int startIndex = -1;
        int endIndex = 0;
        boolean isFound = false;

        while ((startIndex = line.indexOf('<', startIndex + 1)) != -1 &&
                (endIndex = line.indexOf('>', startIndex + 1)) != -1) {

            String diamond = line.substring(startIndex + 1, endIndex);
            long diamondValue = findDiamondValue(diamond);

            System.out.printf("Found %d carat diamond%n", diamondValue);
            isFound = true;
        }

        if(!isFound) {
            System.out.println("Better luck next time");
        }

    }
    private static long findDiamondValue(String diamond) {
        long value = 0L;

        for (char el : diamond.toCharArray()) {
            if (Character.isDigit(el)) {
                value += Integer.parseInt("" + el);
            }
        }

        return value;
    }
}
