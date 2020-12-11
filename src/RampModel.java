package src;

import java.util.ArrayList;

public class RampModel {

    private final ArrayList<Ramp> ramps = new ArrayList<>();

    public void raiseRamp() {
        for (Ramp r : ramps) {
            r.setAngle(0);
        }
    }

    public void lowerRamp() {
        for (Ramp r : ramps) {
            r.setAngle(70);
        }
    }

    public ArrayList<Ramp> getRamps() { return ramps; }
    public void addRamp(Ramp ramp) { this.ramps.add(ramp); }
}
