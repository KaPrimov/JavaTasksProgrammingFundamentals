package jarvis;

public class Torso extends Component {
    private double size;
    private String corpus;

    public Torso(int energy, double size, String corpus) {
        super(energy);
        this.size = size;
        this.corpus = corpus;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("#Torso:").append(System.lineSeparator());
        sb.append(super.toString());
        sb.append(String.format("###Processor size: %s", this.size)).append(System.lineSeparator());
        sb.append(String.format("###Corpus material: %s", this.corpus));

        return sb.toString();
    }
}
