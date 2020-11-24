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
    private double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Increment speed.
     *
     * @param amount the amount
     */
    @Override
    private void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    /**
     * Decrement speed.
     *
     * @param amount the amount
     */
    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    @Override
    public void gas(double amount) {

    }

}