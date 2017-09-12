import java.util.Arrays;
import java.util.Scanner;

public class d_DistanceBetweenPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Point point1 = new Point();
        point1.setX(firstInput[0]);
        point1.setY(firstInput[1]);

        Point point2 = new Point();
        point2.setX(secondInput[0]);
        point2.setY(secondInput[1]);

        System.out.printf("%.3f",
                Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2)));
    }
}
