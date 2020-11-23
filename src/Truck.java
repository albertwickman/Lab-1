package src;

import java.awt.*;

public abstract class Truck extends Vehicle {
    protected boolean movementAllowed;

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color,
                 String modelName, int xCor, int yCor) {

        super(nrDoors, enginePower, currentSpeed, color, modelName, xCor, yCor);
    }

    public void setMovementAllowed(boolean movementAllowed) {
        this.movementAllowed = movementAllowed;
    }

    public boolean isMovementAllowed() {
        return movementAllowed;
    }
}
