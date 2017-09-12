package jarvis;

public class Leg extends Component {

    private int strength;
    private int speed;

    public Leg(int energy, int strength, int speed) {
        super(energy);
        this.strength = strength;
        this.speed = speed;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("#Leg:").append(System.lineSeparator());
        sb.append(super.toString());
        sb.append(String.format("###Strength: %d", this.strength)).append(System.lineSeparator());
        sb.append(String.format("###Speed: %d", this.speed));

        return sb.toString();
    }
}
