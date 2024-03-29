package src;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Class for car src.Saab95. Extends src.Cars.
 */
public class Saab95 extends Car implements Turbo {

    /**
     * Status of the turbo.
     */
    private boolean turboOn;

    /**
     * Instantiates a new Saab 95. Turbo is off on default.
     */
    public Saab95(int xCor, int yCor){
        super(2, 125, 0, Color.red, "Saab95", xCor, yCor);
        turboOn = false;
        try {
            vehicleImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Set turbo on.
     */
    @Override
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Set turbo off.
     */
    @Override
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * Gets status of turbo
     * @return boolean value of turbo
     */
    @Override
    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * Gets the speed factor. Takes the turbo into account.
     *
     * @return speed factor
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}