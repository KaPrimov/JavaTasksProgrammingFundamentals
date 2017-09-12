package p04_Cannon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] characteristics = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        String regex = String.format("\\\\<<<([^<\\\\]{%d})([^<\\\\]{0,%d})", characteristics[0], characteristics[1]);

        Pattern pattern = Pattern.compile(regex);

        String field = scanner.nextLine();

        Matcher matcher = pattern.matcher(field);
        List<String> targets = new ArrayList<>();
        while (matcher.find()) {
            targets.add(matcher.group(2));
        }

        System.out.println(targets.stream().collect(Collectors.joining("/\\")));
    }
}
