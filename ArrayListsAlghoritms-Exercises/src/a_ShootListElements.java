import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class a_ShootListElements {
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int lastRemoved = 0;

        while (true) {
            String pesho = scanner.nextLine();
            if (pesho.equals("stop")) {
                if (elements.size() == 0) {
                    System.out.println("you shot them all. last one was " + lastRemoved);
                    break;
                }
                System.out.println("survivors: " + elements.stream().map(Object::toString).collect(Collectors.joining(" ")));
                break;
            } else if (pesho.equals("bang") && elements.size() == 0) {
                System.out.println("nobody left to shoot! last one was " + lastRemoved);
                break;
            }


            if (Character.isDigit(pesho.charAt(0))) {
                int numberToAdd = Integer.parseInt(pesho);
                elements.add(0, numberToAdd);
                continue;
            }
            double average = elements.stream().mapToDouble(Double::valueOf).average().getAsDouble();

            for (int i = 0; i <= elements.size(); i++) {
                if (elements.get(i) < average) {
                    lastRemoved = elements.get(i);
                    elements.remove(i);
                    System.out.println("shot " + lastRemoved);
                    break;
                } else if (elements.size()==1) {
                    lastRemoved= elements.get(0);
                    elements.remove(0);
                    System.out.println("shot " + lastRemoved);
                    break;

                }

            }

            for (int i = 0; i < elements.size(); i++) {
                elements.set(i, elements.get(i) - 1);
            }
        }

    }
}
