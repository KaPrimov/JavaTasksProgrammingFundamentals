import java.util.ArrayList;
import java.util.Scanner;

public class c_hornetAssault {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ArrayList<Long> hives = Arrays.stream(scanner.nextLine().split(" ")).map(Long::valueOf).collect(Collectors.toCollection(ArrayList::new));
        //ArrayList<Long> hornets = Arrays.stream(scanner.nextLine().split(" ")).map(Long::valueOf).collect(Collectors.toCollection(ArrayList::new));

        String[] hivesInput = scanner.nextLine().split(" ");
        ArrayList<Long> hives = new ArrayList<>();
        for (String s : hivesInput) {
            hives.add(Long.valueOf(s));
        }
        String[] hornetsInput = scanner.nextLine().split(" ");
        ArrayList<Long> hornets = new ArrayList<>();
        for (String s : hornetsInput) {
            hornets.add(Long.valueOf(s));
        }

        for (int i = 0; i < hives.size(); i++) {

            if (hives.get(i) < findHornetSum(hornets)) {
                hives.remove(i);
                i--;
            } else  {
                hives.set(i,  (hives.get(i) - findHornetSum(hornets)));
                if (hives.get(i) <= 0) {
                    hives.remove(i);
                    i--;
                }
                hornets.remove(0);
                if(hornets.size() == 0 || hives.size() == 0) {
                    break;
                }
            }
        }

        //hives = hives.stream().filter(h -> h > 0).collect(Collectors.toCollection(ArrayList::new));

        if (hives.size() > 0) {
            System.out.println(hives.toString().replace("[", "").replace("]", "").replace(",", ""));
        } else {
            System.out.println(hornets.toString().replace("[", "").replace("]", "").replace(",", ""));
        }
    }
    private static long findHornetSum(ArrayList<Long> hornets) {
        long sum = 0L;

        for (Long hornet : hornets) {
            sum+= hornet;
        }

        return sum;
    }
}
