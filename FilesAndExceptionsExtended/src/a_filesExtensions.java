import java.io.File;
import java.util.Scanner;

public class a_filesExtensions {
    public static void main(String[] args) {
        File folder = new File("./src/input");

        File[] files = folder.listFiles();

        Scanner scanner = new Scanner(System.in);
        String ending = scanner.nextLine();

        for (File file : files) {
            if (file.getName().endsWith(ending)) {
                System.out.println(file.getName());
            }
        }
    }
}
