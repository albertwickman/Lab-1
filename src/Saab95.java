package src;

import java.awt.*;

/**
 * Class for car src.Saab95. Extends src.Cars.
 */
public class Saab95 extends Cars{

    /**
     * Status of the turbo.
     */
    private boolean turboOn;

    /**
     * Instantiates a new Saab 95. Turbo is off on default.
     */
    public Saab95(int xCor, int yCor){
        super(2, 125, 0, Color.red, "src.Saab95", xCor, yCor);
	    turboOn = false;
    }

    /**
     * Set turbo on.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Set turbo off.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Gets the speed factor. Takes the turbo into account.
     *
     * @return speed factor
     */
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /**
     * Increment speed.
     *
     * @param amount amount of acceleration
     */
    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Decrement speed.
     *
     * @param amount amount of deceleration
     */
    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Accelerate
     *
     * @param amount accelerate by amount
     */
// TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    /**
     * Brake.
     *
     * @param amount brake by amount
     */
// TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }
}

