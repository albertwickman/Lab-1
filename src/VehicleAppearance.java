package src;

import java.awt.*;

public class VehicleAppearance {

    private final int nrDoors;
    private Color color;

    public VehicleAppearance(int nrDoors, Color color) {
        this.nrDoors = nrDoors;
        this.color = color;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
