package p02_VehicleCatalog;

public abstract class Vehicle {

    private String model;
    private String color;
    private int horsepowers;

    public Vehicle(String model, String color, int horsepowers) {
        this.model = model;
        this.color = color;
        this.horsepowers = horsepowers;
    }

    @Override
    public String toString() {
        return "Type: " + this.getClass().getSimpleName() + "\n" +
                "Model: " + this.model + "\n" +
                "Color: " + this.color + "\n" +
                "Horsepower: " + this.horsepowers;
    }

    public int getHorsepowers() {
        return horsepowers;
    }
}
