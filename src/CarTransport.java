package src;

import java.awt.*;

public class CarTransport extends Truck implements Ramp {
    public CarTransport(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int xCor, int yCor) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, xCor, yCor);
    }

    @Override
    public void setAngle() {

    }
}
