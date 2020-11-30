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
     * @param xCor x-coordinate
     * @param yCor y-coordinate
     */
    public Scania(int xCor, int yCor) {
        super(2, 100, 0, Color.RED, "Scania", xCor, yCor);
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
            System.out.println(this.angle);
            setMovementAllowed(angle == MIN_ANGLE);
            System.out.println(isMovementAllowed());
        }
    }

    @Override
    public int getCurrentAngle() { return this.angle; }

    @Override
    public void startEngine() {
        setMovementAllowed(this.angle == 0);
    }
}