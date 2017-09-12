package G_sentenceTheThief;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        long maxValue = Long.MIN_VALUE;
        long thiefsId = Long.MIN_VALUE;
        switch (type) {
            case "sbyte":
                maxValue = Byte.MAX_VALUE;
                break;
            case "int":
                maxValue = Integer.MAX_VALUE;
                break;
            case "long":
                maxValue = Long.MAX_VALUE;
                break;
        }

        int n = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            long value = Long.valueOf(scanner.nextLine());
            if (value <= maxValue && value > thiefsId) {
                thiefsId = value;
            }
        }

        double years = 0.0;
        String answer = "";

        DecimalFormat df = new DecimalFormat("0");
        df.setMaximumFractionDigits(15);

        if (thiefsId > 0)
        {
            years = Math.ceil((double)thiefsId / Byte.MAX_VALUE);
            answer = df.format(years) + (Math.ceil((double)thiefsId) / Byte.MAX_VALUE> 1 ? " years" : " year");
        }
        else
        {
            years = Math.ceil((double)thiefsId / Byte.MIN_VALUE);

            answer = df.format(years) + (Math.ceil((double)thiefsId / Byte.MIN_VALUE) > 1 ? " years" : " year");
        }
        System.out.printf("Prisoner with id %d is sentenced to %s",
                thiefsId, answer);
    }
}
