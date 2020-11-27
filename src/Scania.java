package src;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Class describing a Scania truck. Extends Truck and implements ramp.
 */

public class Scania extends Truck implements Ramp{
    private final int MIN_ANGLE = 0;
    private final int MAX_ANGLE = 70;
    private int angle;

     /**
     * Create a new Scania truck.
     * @param nrDoors Number of doors
     * @param enginePower Engine power hp
     * @param currentSpeed Current speed
     * @param color Color of the Scania
     * @param modelName Model name
     * @param xCor x-coordinate
     * @param yCor y-coordinate
     */
    public Scania(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int xCor, int yCor) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, xCor, yCor);
        setMovementAllowed(true);
        this.angle = MIN_ANGLE;
        try {
            vehicleImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Sets angle of ramp.
     * @param angle to set ramp at angle
     */
    @Override
    public void setAngle(int angle) {
        if (getCurrentSpeed() == 0 && MIN_ANGLE <= angle && angle <= MAX_ANGLE) {
            this.angle = angle;
            setMovementAllowed(angle == MIN_ANGLE);
        }
    }

}