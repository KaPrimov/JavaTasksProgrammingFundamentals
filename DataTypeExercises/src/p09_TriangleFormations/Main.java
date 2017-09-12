package p09_TriangleFormations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        if ((a + b > c) && (a + c > b) && (b + c > a)) {
            System.out.println("Triangle is valid.");
            if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                System.out.println("Triangle has a right angle between sides a and b");
            } else  if (Math.pow(c, 2) + Math.pow(b, 2) == Math.pow(a, 2)) {
                System.out.println("Triangle has a right angle between sides b and c");
            } else  if (Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2)) {
                System.out.println("Triangle has a right angle between sides a and c");
            } else {
                System.out.println("Triangle has no right angles");
            }
        } else {
            System.out.println("Invalid Triangle.");
        }
    }
}
