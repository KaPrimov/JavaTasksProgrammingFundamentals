package p01_orderByAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Person> people = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] tokens = reader.readLine().split(" ");
            if (tokens[0].equals("End")) {
                break;
            }
            String name = tokens[0];
            String id = tokens[1];
            int age = Integer.valueOf(tokens[2]);
            people.add(new Person(name, id, age));
        }
        people.stream().sorted(Comparator.comparingInt(a -> a.age)).forEach(System.out::println);
    }
}
