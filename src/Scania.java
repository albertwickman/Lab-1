package src;

import java.awt.*;

public class Scania extends Vehicle {
    private int raised;
    /**
     * Instantiates a new Car.
     *
     * @param nrDoors      the nr doors
     * @param enginePower  the engine power
     * @param currentSpeed the current speed
     * @param color        the color
     * @param modelName    the model name
     */
    public Scania(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int xCor, int yCor) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, xCor, yCor);
    }

    public boolean setRaised(boolean smack) {
        return raised > 0;
    }

    public void unstationary(){
        if (setRaised(false)) {
            setCurrentSpeed(getCurrentSpeed());
        }
    }
}