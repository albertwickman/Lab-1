package src;

import java.awt.*;

public class Scania extends Truck implements Ramp{
    private final int MIN_ANGLE = 0;
    private final int MAX_ANGLE = 70;
    private int angle;
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
        setMovementAllowed(true);
        this.angle = MIN_ANGLE;
    }

    @Override
    public void move() {
        if (isMovementAllowed()) {
            super.move();
        }
    }

    @Override
    public void setAngle(int angle) {
        if (getCurrentSpeed() == 0 && MIN_ANGLE <= angle && angle <= MAX_ANGLE) {
            this.angle = angle;
            setMovementAllowed(angle == MIN_ANGLE);
        }
    }
}