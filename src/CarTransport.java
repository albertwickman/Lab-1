package src;

import java.awt.*;

/**
 * Class describing a car transport. Extends Truck and implements Ramp.
 */
public class CarTransport extends Truck implements Ramp {
    private final Car[] loadedCars;
    private final int distanceToTransport = 5;

    /**
     * Create a new car transport
     * @param nrDoors Number of doors
     * @param enginePower Engine power hp
     * @param currentSpeed Current speed
     * @param color Color of the transport
     * @param modelName Model name
     * @param xCor x-coordinate
     * @param yCor y-coordinate
     * @param maxCars Max capacity of the transport
     */
    public CarTransport(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int xCor, int yCor, int maxCars) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, xCor, yCor);
        loadedCars = new Car[maxCars];
    }

    @Override
    public void move() {
        if (isMovementAllowed()) {
            super.move();
            updateCarCoor();
        }
    }

    /**
     * Loads a car on the transport
     * @param c The car to load
     */
    public void loadCar(Car c) {
        if (!movementAllowed && indexEmpty(loadedCars) != -1) {
            loadedCars[indexEmpty(loadedCars)] = c;
            c.setxCor(getXcor());
            c.setyCor(getyCor());
        }
    }

    /**
     * Unload a car from the transport
     */
    public void unloadCar() {
        int index = indexLastCar(loadedCars);
        if(index != -1 && !movementAllowed) {
            Car c = loadedCars[index];
            loadedCars[index] = null;
            c.setyCor(c.getyCor() + distanceToTransport);
            c.setxCor(c.getXcor() + distanceToTransport);
        }
    }

    /**
     * Update the coordinates of the cars loaded on the transport.
     */
    public void updateCarCoor() {
        for (Car c : loadedCars) {
            if(c != null) {
                c.setxCor(getXcor());
                c.setyCor(getyCor());
            }
        }
    }

    public Car[] getLoadedCars() { return loadedCars; }

    private int indexEmpty(Car[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == null)
                return i;
        return -1;
    }

    private int indexLastCar(Car[] arr) {
        for (int i = arr.length -1; i >= 0; i--)
            if (arr[i] != null)
                return i;
        return -1;
    }

    /**
     * Raise/lower the ramp
     * @param angle If angle == 0 then lower, else raise
     */
    @Override
    public void setAngle(int angle) {
        if (angle == 0)
            movementAllowed = true;
        else
            movementAllowed = false;

    }

    @Override
    public void gas(double amount) {

    }

    @Override
    public void brake(double amount) {

    }
}
