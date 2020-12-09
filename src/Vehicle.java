package src;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Abstract class for vehicles
 */
public abstract class Vehicle implements Movable {
    private final int nrDoors;
    private final double enginePower;
    private double currentSpeed;
    private Color color;
    private final String modelName;
    private double xCor;
    private double yCor;
    private double dx;
    private double dy;
    private boolean movementAllowed;
    private boolean onTransport;
    private boolean powerOn;
    public BufferedImage vehicleImage;

    /**
     * Instantiates a new Car.
     *
     * @param nrDoors      the nr doors
     * @param enginePower  the engine power
     * @param currentSpeed the current speed
     * @param color        the color
     * @param modelName    the model name
     */
    public Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color,
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
        this.movementAllowed = true;
        this.onTransport = false;
        this.powerOn = false;
    }

    /**
     * Moves the car one step if movement is allowed.
     */
    public void move() {
        if (isPowerOn() && isMovementAllowed() && !isOnTransport()) {
            xCor += dx;
            yCor += dy;
        }
    }

    @Override
    public void gas(double amount){
        if (isPowerOn() && !isOnTransport() && isMovementAllowed()) {
            if (0 <= amount && amount <= 1)
                incrementSpeed(amount);
            if (getDx() == 0 && getDy() >= 0)
                setDy(getCurrentSpeed());
            else if(getDx() == 0 && getDy() < 0)
                setDy(-getCurrentSpeed());
            else if(getDx() > 0 && getDy() == 0)
                setDx(getCurrentSpeed());
            else if(getDx() < 0 && getDy() == 0)
                setDx(-getCurrentSpeed());

        }
    }

    @Override
    public void brake(double amount){
        if (isPowerOn() && !isOnTransport()) {
            if (0 <= amount && amount <= 1)
                decrementSpeed(amount);
            if (getDx() == 0 && getDy() > 0)
                setDy(getCurrentSpeed());
            else if(getDx() == 0 && getDy() < 0)
                setDy(-getCurrentSpeed());
            else if(getDx() > 0 && getDy() == 0)
                setDx(getCurrentSpeed());
            else
                setDx(-getCurrentSpeed());
        }
    }

    public double speedFactor() {return getEnginePower() * 0.01; }

    private void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    private void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()  / 10));
    }

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

    /**
     * Starts engine.
     */
    public void startEngine(){
        powerOn = true;
    }

    /**
     * Stops engine.
     */
    public void stopEngine(){
        setCurrentSpeed(0);
        setDx(0);
        setDy(0);
        powerOn = false;
    }

    // ------------------- Setters and getters -------------------
    /**
     * Gets nr of doors.
     *
     * @return the nr doors
     */
    public int getNrDoors() { return nrDoors; }

    public double getXcor() { return xCor; }

    public double getyCor() { return yCor; }

    public void setxCor(double xCor) {
        this.xCor = xCor;
    }

    public void setyCor(double yCor) {
        this.yCor = yCor;
    }

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
        else if (currentSpeed < 0) {
            this.currentSpeed = 0;
        }
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

    @Override
    public void setMovementAllowed(boolean movementAllowed) {
        this.movementAllowed = movementAllowed;
    }

    @Override
    public boolean isMovementAllowed() {
        return movementAllowed;
    }

    public boolean isOnTransport() {
        return onTransport;
    }

    public void setOnTransport(boolean onTransport) {
        this.onTransport = onTransport;
    }

    public boolean isPowerOn() { return this.powerOn; }

    public void setPowerOn() { this.powerOn = true; }
}