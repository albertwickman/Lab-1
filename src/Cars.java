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

    private double xCor;

    private double yCor;

    private double dx;

    private double dy;

    /**
     * Instantiates a new Car.
     *
     * @param nrDoors      the nr doors
     * @param enginePower  the engine power
     * @param currentSpeed the current speed
     * @param color        the color
     * @param modelName    the model name
     */
    public Cars(int nrDoors, double enginePower, double currentSpeed, Color color,
                String modelName, int xCor, int yCor) {

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.xCor = xCor;
        this.yCor = yCor;
        this.dx = currentSpeed;
        this.dy = currentSpeed;
    }

    /**
     * Moves the car one step.
     */

    @Override
    public void move() {
        xCor = dx;
        yCor = dy;
    }

    /**
     * Gets nr of doors.
     *
     * @return the nr doors
     */
    public int getNrDoors() { return nrDoors; }

    /**
     * Gets engine power.
     *
     * @return the engine power
     */
    public double getEnginePower() { return enginePower; }

    /**
     * Gets current speed.
     *
     * @return the current speed
     */
    public double getCurrentSpeed() { return currentSpeed; }

    /**
     *  Sets current speed.
     *
     * @param currentSpeed set speed
     */
    protected void setCurrentSpeed(double currentSpeed) {
        if(0 <= currentSpeed && currentSpeed <= getEnginePower())
            this.currentSpeed = currentSpeed;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() { return color; }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(Color color) { this.color = color; }

    /**
     * Gets model name.
     *
     * @return the model name
     */
    public String getModelName() { return modelName; }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * Starts engine.
     */
    public void startEngine(){ setCurrentSpeed(0.1); }

    /**
     * Stops engine.
     */
    public void stopEngine(){ setCurrentSpeed(0); }

    @Override
    public void turnLeft() {
        if(dx < 0) {                    // if movement along the x-axis is negative, set x-movement to 0 and y-movement to the current speed
            dx = 0;
            dy = getCurrentSpeed();
        }
        else if(dx > 0) {         // same but the opposite, x-movement is still 0
            dx = 0;
            dy = -getCurrentSpeed();
        }
        else if (dy < 0) {                 // if movement along the y-axis is negative, set y-movement to 0 and x-movement to the negative current speed
            dx = -getCurrentSpeed();
            dy = 0;
        }
        else if(dy > 0) {                   // same but the opposite, y-movement is still 0
            dx = getCurrentSpeed();
            dy = 0;
        }
    }

    @Override
    public void turnRight() {           // if movement along the x-axis is negative, set x-movement to 0 and y-movement to the negative current speed
        if(dx < 0) {
            dx = 0;
            dy = -getCurrentSpeed();
        }
        else if(dx > 0) {               // same but opposite, x-movement is still 0
            dx = 0;
            dy = getCurrentSpeed();
        }
        else if (dy < 0) {              // if movement along the y-axis is negative, set y-movement to 0 and x-movement to the current speed
            dx = getCurrentSpeed();
            dy = 0;
        }
        else if(dy > 0) {               // same but opposite, y-movement is still 0
            dx = -getCurrentSpeed();
            dy = 0;
        }
    }
}