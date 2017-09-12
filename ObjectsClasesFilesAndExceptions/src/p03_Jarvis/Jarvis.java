package p03_Jarvis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Jarvis {

    private Head head;
    private Torso torso;
    private List<Arm> arms;
    private List<Leg> legs;
    private long totalEnergy;

    public Jarvis(long totalEnergy) {
        this.totalEnergy = totalEnergy;
        this.arms = new ArrayList<>();
        this.legs = new ArrayList<>();
    }


    public void addHead(Head component) {
        if (this.head == null || this.head.getEnergy() > component.getEnergy()) {
            this.head = component;
        }
    }

    public void addTorso(Torso torso) {
        if (this.torso == null || this.torso.getEnergy() > torso.getEnergy()) {
            this.torso = torso;
        }
    }

    public void addArm(Arm arm) {
        if (this.arms.size() < 2) {
            arms.add(arm);
        } else {
            for (int i = 0; i < arms.size(); i++) {
                if (arms.get(i).getEnergy() > arm.getEnergy()) {
                    arms.remove(i);
                    arms.add(arm);
                    break;
                }
            }
        }
    }

    public void addLeg(Leg leg) {
        if (this.legs.size() < 2) {
            legs.add(leg);
        } else {
            for (int i = 0; i < legs.size(); i++) {
                if (legs.get(i).getEnergy() > leg.getEnergy()) {
                    legs.remove(i);
                    legs.add(leg);
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {

        if (this.head == null ||
                this.torso == null
                || this.arms.size() != 2
                || this.legs.size() != 2) {
            return "We need more parts!";
        }

        long sumEnergy = head.getEnergy() + torso.getEnergy() +
                legs.stream().mapToInt(Leg::getEnergy).sum() +
                arms.stream().mapToInt(Arm::getEnergy).sum();

        if (sumEnergy > totalEnergy) {
            return "We need more power!";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Jarvis:").append(System.lineSeparator());
        sb.append(this.head.toString()).append(System.lineSeparator());
        sb.append(this.torso.toString()).append(System.lineSeparator());
        sb.append(this.arms.stream().sorted((a, b) -> a.getEnergy() - b.getEnergy()).map(Arm::toString).collect(Collectors.joining(System.lineSeparator()))).append(System.lineSeparator());
        sb.append(this.legs.stream().sorted((a, b) -> a.getEnergy() - b.getEnergy()).map(Leg::toString).collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }
}
