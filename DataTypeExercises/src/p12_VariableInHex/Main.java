package p12_VariableInHex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hex = scanner.nextLine();
        int decimal = Integer.parseInt(hex.substring(2), 16);
        System.out.println(decimal);
    }
}
