package jarvis;

public class Head extends Component {
    private int iq;
    private String skin;

    public Head(int energy, int iq, String skin) {
        super(energy);
        this.iq = iq;
        this.skin = skin;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("#Head:").append(System.lineSeparator());
        sb.append(super.toString());
        sb.append(String.format("###IQ: %s", this.iq)).append(System.lineSeparator());
        sb.append(String.format("###Skin material: %s", this.skin));

        return sb.toString();
    }
}
