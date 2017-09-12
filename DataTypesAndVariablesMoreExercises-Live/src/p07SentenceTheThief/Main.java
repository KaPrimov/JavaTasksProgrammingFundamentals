package p07SentenceTheThief;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        long maxValue = 0L;
        if (type.equals("sbyte")) {
            maxValue = Byte.MAX_VALUE;
        } else if (type.equals("int")) {
            maxValue = Integer.MAX_VALUE;
        } else {
            maxValue = Long.MAX_VALUE;
        }
        int n = Integer.parseInt(scanner.nextLine());
        double thiefsID = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            long tempId = Long.parseLong(scanner.nextLine());
            if (tempId > thiefsID && tempId <= maxValue) {
                thiefsID = tempId;
            }
        }
        double years = 0.0;
        if (thiefsID < 0) {
            years = Math.ceil(thiefsID / Byte.MIN_VALUE);
        } else {
            years = Math.ceil(thiefsID / Byte.MAX_VALUE);
        }
        System.out.printf("Prisoner with id %d is sentenced to %d %s",
                (long)thiefsID,
                (long)years,
                years > 1 ? "years" : "year");
    }
}
