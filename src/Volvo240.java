package src;

import java.awt.*;

/**
 * Class for Volvo 240. Extends src.Cars.
 */
public class Volvo240 extends Cars{
    /**
     *  Final private trim factor
     */
    private final static double trimFactor = 1.25;

    /**
     * Instantiates a new Volvo 240.
     */
    public Volvo240(int xCor, int yCor){
        super(4, 100, 0, Color.black, "src.Volvo240", xCor, yCor);
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
    private void incrementSpeed(double amount){
	    setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    /**
     * Decrement speed.
     *
     * @param amount the amount
     */
    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    /**
     * Accelerate.
     *
     * @param amount accelerate by amount
     */
// TODO fix this method according to lab pm
    public void gas(double amount){
        if (0 <= amount && amount <= 1)
            incrementSpeed(amount);
    }

    /**
     * Brake.
     *
     * @param amount decelerate by amount
     */
// TODO fix this method according to lab pm
    public void brake(double amount){
        if (0 <= amount && amount <= 1)
            decrementSpeed(amount);
    }

}
