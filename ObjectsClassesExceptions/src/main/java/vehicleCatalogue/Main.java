//package vehicleCatalogue;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        Map<String, Vehicle> cars = new HashMap<>();
//        Map<String, Vehicle> trucks = new HashMap<>();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        while (true) {
//            String[] tokens = reader.readLine().split(" ");
//
//            if (tokens[0].equals("End")) {
//                break;
//            }
//
//            switch (tokens[0].toLowerCase()) {
//                case "car":
//                    cars.putIfAbsent(tokens[1],
//                            new Car(tokens[1], tokens[2], Integer.valueOf(tokens[3])));
//                    break;
//                case "truck":
//                    trucks.putIfAbsent(tokens[1],
//                            new Truck(tokens[1], tokens[2], Integer.valueOf(tokens[3])));
//                    break;
//            }
//        }
//
//        while (true) {
//            String modelToPrint = reader.readLine();
//
//            if (modelToPrint.equals("Close the Catalogue")) {
//                break;
//            }
//
//            if (cars.containsKey(modelToPrint)) {
//                System.out.println(cars.get(modelToPrint));
//            } else if (trucks.containsKey(modelToPrint)) {
//                System.out.println(trucks.get(modelToPrint));
//            }
//        }
//
//        double sumCars = cars.values().stream().mapToInt(Vehicle::getHorsepowers).sum();
//        double sumTrucks = trucks.values().stream().mapToInt(Vehicle::getHorsepowers).sum();
//
//        double avgCars = sumCars / cars.size();
//        double avgTrucks = sumTrucks / trucks.size();
//
//        System.out.printf("Cars have average horsepower of: %.2f.%n",
//                Double.isNaN(avgCars) ? 0 : avgCars);
//
//        System.out.printf("Trucks have average horsepower of: %.2f.%n",
//                Double.isNaN(avgTrucks) ? 0 : avgTrucks);
//    }
//}
