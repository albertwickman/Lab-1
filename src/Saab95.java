import java.awt.*;

/**
 * Class for car Saab95. Extends Cars.
 */
public abstract class Saab95 extends Cars{

    /**
     * Status of the turbo.
     */
    public boolean turboOn;

    /**
     * Instantiates a new Saab 95. Turbo is off on default.
     */
    public Saab95(){
        super(2, 125, 0, Color.red, "Saab95");
	    turboOn = false;
        stopEngine();
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
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /**
     * Increment speed.
     *
     * @param amount amount of acceleration
     */
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Decrement speed.
     *
     * @param amount amount of deceleration
     */
    public void decrementSpeed(double amount){
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
}

