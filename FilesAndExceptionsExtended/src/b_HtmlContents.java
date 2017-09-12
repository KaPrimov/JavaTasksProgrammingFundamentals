import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class b_HtmlContents {
    public static void main(String[] args) throws FileNotFoundException {
        String outputPath = "./input.html";
        Scanner scanner = new Scanner(System.in);

        try(PrintWriter out = new PrintWriter(new FileOutputStream(outputPath))) {
            int oneByte = 0;
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");

            String[]tokens = new String[2];
            ArrayList<String[]> input  = new ArrayList<>();
            String title = "";
            while (true) {
                tokens = scanner.nextLine().split(" ");
                if (tokens[0].equals("title")) {
                    title = tokens[1];
                    continue;
                }
                if (tokens[0].equals("exit")) {
                    break;
                }
                input.add(tokens);
            }
            out.append("<title>" + title + "</title>");
            out.append("</head>");
            out.append("<body>");

            for (String[] strings : input) {
                out.append(String.format("<%s>%s</%s>", strings[0], strings[1], strings[0]));
            }

            out.append("</body>");
            out.append("</html>");

        } catch (Exception e) {
            throw e;
        }

    }
}
