package src;

import java.awt.*;

public class Scania extends Vehicle {
    private boolean movementAllowed;
    public Trailer trailer;

    /**
     * Instantiates a new Car.
     *
     * @param nrDoors      the nr doors
     * @param enginePower  the engine power
     * @param currentSpeed the current speed
     * @param color        the color
     * @param modelName    the model name
     */
    public Scania(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int xCor, int yCor) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, xCor, yCor);
    }

    /**
     * Determines whether movement is restricted due to the platform/ramp.
     * @param movementAllowed Enable movement
     */
    public void setMovementAllowed(boolean movementAllowed) {
        if (getCurrentSpeed() == 0)
            this.movementAllowed = movementAllowed;
    }

    public boolean isMovementAllowed() {
        return movementAllowed;
    }

    @Override
    public void move() {
        if (!isMovementAllowed()) {
            super.move();
            if (trailer instanceof Transport)
                ((Transport) trailer).updateCarCoor();
        }
    }

    // -------------- Methods for trailer with transporter --------------
    /**
     * Connect a trailer with car transport capabilities to the truck.
     * @param maxCars Maximum capacity of the trailer
     */
    public void connectTransport(int maxCars) {
        trailer = new Transport(this, maxCars);
    }

    public void loadCar(Cars c) {
        if (trailer instanceof Transport)
            ((Transport) trailer).loadCar(c);
    }

    public void unloadCar() {
        if (trailer instanceof Transport)
            ((Transport) trailer).unloadCar();
    }

    public Cars[] getLoadedCars() {
        if (trailer instanceof Transport)
            return ((Transport) trailer).getLoadedCars();
        return null;
    }

    public void raiseRamp() {
        if (trailer instanceof Transport)
            ((Transport) trailer).raiseRamp();
    }

    public void lowerRamp() {
        if (trailer instanceof Transport)
            ((Transport) trailer).lowerRamp();
    }
    // -------------- Methods for trailer with platform --------------
    /**
     *  Connect a trailer with a platform to the truck.
     */
    public void connectPlatform() {
        trailer = new Platform(this);
    }

    public void setAngle(int angle) {
        if (trailer instanceof Platform)
            ((Platform) trailer).setAngle(angle);
    }


}