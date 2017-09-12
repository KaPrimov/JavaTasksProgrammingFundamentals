import java.io.File;

public class d_MoveDir {
    public static void main(String[] args) {
        File folder = new File(".\\src\\04. Re-Directory\\input");

        File[] files = folder.listFiles();

        for (File file : files) {
            file.renameTo(new File(".\\src\\output\\" + file.getName()));
        }
    }
}
