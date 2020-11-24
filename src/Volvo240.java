package src;

import java.awt.*;

/**
 * Class for Volvo 240. Extends src.Cars.
 */
public class Volvo240 extends Car {
    /**
     *  Final private trim factor
     */
    private final static double trimFactor = 1.25;

    /**
     * Instantiates a new Volvo 240.
     */
    public Volvo240(int xCor, int yCor){
        super(4, 100, 0, Color.black, "Volvo240", xCor, yCor);
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