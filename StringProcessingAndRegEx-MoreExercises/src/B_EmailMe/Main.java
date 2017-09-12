package B_EmailMe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        int index = email.indexOf('@');
        String leftPart = email.substring(0,index);
        String rightPart = email.substring(index+1);
        long leftSum = 0;
        long rightSum = 0;
        for (int i = 0; i < leftPart.length(); i++) {
            leftSum += leftPart.charAt(i);
        }

        for (int i = 0; i < rightPart.length(); i++) {
            rightSum += rightPart.charAt(i);
        }

        if (leftSum - rightSum>= 0) {
            System.out.println("Call her!");
        } else {
            System.out.println("She is not the one.");
        }
    }
}
