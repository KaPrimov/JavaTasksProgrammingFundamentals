import java.util.Arrays;
import java.util.Scanner;

public class e_ClosestTwoPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Point[] allPoints = new Point[n];
        Point[] bestPoints = new Point[2];
        double closestDistance = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Point point = new Point();
            point.setX(coordinates[0]);
            point.setY(coordinates[1]);

            allPoints[i] = point;
        }

        for (int i = 0; i < allPoints.length; i++) {
            for (int j = i + 1; j < allPoints.length; j++) {
                double currentDistance = returnDistance(allPoints[i], allPoints[j]);
                if (currentDistance < closestDistance) {
                    closestDistance = currentDistance;
                    bestPoints[0] = allPoints[i];
                    bestPoints[1] = allPoints[j];
                }
            }

        }

        System.out.printf("%.3f%n", closestDistance);
        System.out.printf("(%d, %d)%n", bestPoints[0].getX(), bestPoints[0].getY());
        System.out.printf("(%d, %d)%n", bestPoints[1].getX(), bestPoints[1].getY());
    }

    private static double returnDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }
}
class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
