package jarvis;

public class Component {
    private int energy;

    protected Component(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public String toString() {
        return "###Energy consumption: " + this.energy + "\n";
    }
}
