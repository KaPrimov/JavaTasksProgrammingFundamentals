package playCatch;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        while (true) {

            String[] tokens = scanner.nextLine().split(" ");

            switch (tokens[0]) {
                case "Replace":
                    try {
                        int index = Integer.valueOf(tokens[1]);
                        int element = Integer.valueOf(tokens[2]);
                        try {
                            array[index] = element;
                        } catch (IndexOutOfBoundsException ioobe) {
                            System.out.println("The index does not exist!");
                            count++;
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("The variable is not in the correct format!");
                        count++;
                    }
                    break;
                case "Print":
                    try {
                        int startIndex = Integer.valueOf(tokens[1]);
                        int endIndex = Integer.valueOf(tokens[2]);
                        try {
                                StringBuilder sb = new StringBuilder();
                            for (int i = startIndex; i <= endIndex ; i++) {
                                sb.append(array[i]).append(", ");
                            }

                            System.out.println(sb.delete(sb.length()-2, sb.length()));

                        } catch (IndexOutOfBoundsException ioobe) {
                            System.out.println("The index does not exist!");
                            count++;
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("The variable is not in the correct format!");
                        count++;
                    }
                    break;
                case "Show":
                    try {
                        int index = Integer.valueOf(tokens[1]);
                        if (index < 0 || index >= array.length) {
                            System.out.println("The index does not exist!");
                            count++;
                        } else {
                            System.out.println(array[index]);
                        }
                        break;
                    } catch (NumberFormatException nfe) {
                        System.out.println("The variable is not in the correct format!");
                        count++;
                    }
            }
            if (count == 3) {
                break;
            }
        }
        System.out.println(Arrays.toString(array).replace("[", "").replace("]", ""));
    }
}
