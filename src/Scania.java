package src;

import java.awt.*;

public class Scania extends Truck {
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
        setMovementAllowed(true);
        connectTrailer();
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
        if (isMovementAllowed()) {
            super.move();
            if (trailer instanceof Transport)
                ((Transport) trailer).updateCarCoor();
        }
    }

    // -------------- Delegation of methods for trailer with transporter --------------
    /**
     * Connect a trailer with car transport capabilities to the truck.
     * @param maxCars Maximum capacity of the trailer
     */
    public void connectTransport(int maxCars) {
        trailer.newTransport(maxCars);
    }

    public void loadCar(Car c) {
        trailer.loadCar(c);
    }

    public void unloadCar() {
        trailer.unloadCar();
    }

    public Car[] getLoadedCars() {
        return trailer.getLoadedCars();
    }
    // -------------- Delegation of methods for trailer with platform --------------
    /**
     *  Connect a trailer with a platform to the truck.
     */
    public void connectTrailer() {
        trailer = new Trailer(this);
    }

    public void setAngle(int angle) {
        trailer.setAngle(angle);
    }


}