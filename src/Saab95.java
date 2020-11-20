package src;

import java.awt.*;

/**
 * Class for car src.Saab95. Extends src.Cars.
 */
public class Saab95 extends Car {

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
     * Gets status of turbo
     * @return boolean value of turbo
     */
    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * Gets the speed factor. Takes the turbo into account.
     *
     * @return speed factor
     */
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /**
     * Increment speed.
     *
     * @param amount amount of acceleration
     */
    private void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    /**
     * Decrement speed.
     *
     * @param amount amount of deceleration
     */
    private void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    /**
     * Accelerate
     *
     * @param amount accelerate by amount
     */
    public void gas(double amount){
        if (0 <= amount && amount <= 1)
            incrementSpeed(amount);
        if (getDx() == 0)
            setDy(getCurrentSpeed());
        else
            setDx(getCurrentSpeed());
    }

    /**
     * Brake.
     *
     * @param amount brake by amount
     */
    public void brake(double amount){
        if (0 <= amount && amount <= 1)
            decrementSpeed(amount);
        if (getDx() == 0)
            setDy(-getCurrentSpeed());
        else
            setDx(getCurrentSpeed());
    }

}