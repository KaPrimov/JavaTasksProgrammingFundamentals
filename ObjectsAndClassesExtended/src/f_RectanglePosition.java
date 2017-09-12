import java.util.Arrays;
import java.util.Scanner;

public class f_RectanglePosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstRectangleData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondRectangleData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Rectangle firstRectangle = new Rectangle();
        firstRectangle.left = firstRectangleData[0];
        firstRectangle.top = firstRectangleData[1];
        firstRectangle.width = firstRectangleData[2];
        firstRectangle.height = firstRectangleData[3];
        firstRectangle.right = firstRectangle.left + firstRectangle.width;
        firstRectangle.bottom = firstRectangle.top + firstRectangle.height;

        Rectangle secondRectangle = new Rectangle();
        secondRectangle.left = secondRectangleData[0];
        secondRectangle.top = secondRectangleData[1];
        secondRectangle.width = secondRectangleData[2];
        secondRectangle.height = secondRectangleData[3];
        secondRectangle.right = secondRectangle.left + secondRectangle.width;
        secondRectangle.bottom = secondRectangle.top + secondRectangle.height;

        if (firstRectangle.isInside(secondRectangle)) {
            System.out.println("Inside");
        } else {
            System.out.println("Not inside");
        }
    }

}

class Rectangle {

    public int left;
    public int top;
    public int width;
    public int height;
    public int right;
    public int bottom;

    public boolean isInside(Rectangle other) {
        return left >= other.left && top >= other.top
                && right <= other.right && bottom <= other.bottom;
    }

}