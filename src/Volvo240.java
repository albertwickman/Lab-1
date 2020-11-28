package src;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Class for Volvo 240. Extends src.Cars.
 */
public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;

    /**
     * Instantiates a new Volvo 240.
     */
    public Volvo240(int xCor, int yCor) throws IOException {
        super(4, 100, 0, Color.black, "Volvo240", xCor, yCor);
        try {
            vehicleImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Gets the speed factor.
     *
     * @return speed factor
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}