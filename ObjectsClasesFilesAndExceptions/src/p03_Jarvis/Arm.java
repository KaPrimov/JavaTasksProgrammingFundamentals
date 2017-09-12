package p03_Jarvis;

public class Arm extends Component {

    private int reach;
    private int fingers;

    public Arm(int energy, int reach, int fingers) {
        super(energy);
        this.reach = reach;
        this.fingers = fingers;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("#Arm:").append(System.lineSeparator());
        sb.append(super.toString());
        sb.append(String.format("###Reach: %d", this.reach)).append(System.lineSeparator());
        sb.append(String.format("###Fingers: %d", this.fingers));

        return sb.toString();
    }
}
