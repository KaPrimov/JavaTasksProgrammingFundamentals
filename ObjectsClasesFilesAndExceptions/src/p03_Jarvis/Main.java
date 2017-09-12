package p03_Jarvis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Jarvis jarvis = new Jarvis(Long.valueOf(reader.readLine()));

        while (true) {
            String[] tokens = reader.readLine().split(" ");

            if (tokens[0].equals("Assemble!")) {
                break;
            }

            switch (tokens[0].toLowerCase()) {
                case "head":
                    jarvis.addHead(new Head(Integer.valueOf(tokens[1]),
                            Integer.valueOf(tokens[2]),
                            tokens[3]));
                    break;
                case "torso":
                    jarvis.addTorso(new Torso(Integer.valueOf(tokens[1]),
                            Double.valueOf(tokens[2]),
                            tokens[3]));
                    break;
                case "leg":
                    jarvis.addLeg(new Leg(Integer.valueOf(tokens[1]),
                            Integer.valueOf(tokens[2]),
                            Integer.valueOf(tokens[3])));
                    break;
                case "arm":
                    jarvis.addArm(new Arm(Integer.valueOf(tokens[1]),
                            Integer.valueOf(tokens[2]),
                            Integer.valueOf(tokens[3])));
                    break;
            }
        }

        System.out.println(jarvis);
    }
}
