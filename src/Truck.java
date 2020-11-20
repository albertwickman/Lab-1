package src;

import java.awt.*;

public abstract class Truck extends Vehicle {

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color,
                 String modelName, int xCor, int yCor) {

        super(nrDoors, enginePower, currentSpeed, color, modelName, xCor, yCor);
    }
}
