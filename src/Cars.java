package src;

import java.awt.*;

/**
 * Abstract class for src.Cars
 */
public abstract class Cars implements Movable {
    /**
     * The Nr doors.
     */
    private final int nrDoors; // Number of doors on the car
    /**
     * The Engine power.
     */
    private final double enginePower; // Engine power of the car
    /**
     * The Current speed.
     */
    private double currentSpeed; // The current speed of the car

    /**
     * The Color.
     */
    private Color color; // Color of the car
    /**
     * The Model name.
     */
    private final String modelName; // The car model name

    /**
     * Instantiates a new Car.
     *
     * @param nrDoors      the nr doors
     * @param enginePower  the engine power
     * @param currentSpeed the current speed
     * @param color        the color
     * @param modelName    the model name
     */
    public Cars(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }

    /**
     * Moves the car one step.
     */

    public void move() {

    }

    /**
     * Gets nr of doors.
     *
     * @return the nr doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Gets engine power.
     *
     * @return the engine power
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Gets current speed.
     *
     * @return the current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     *  Sets current speed.
     *
     * @param currentSpeed set speed
     */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets model name.
     *
     * @return the model name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Starts engine.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stops engine.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }
}
