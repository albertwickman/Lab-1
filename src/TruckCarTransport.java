package src;

import java.awt.*;

/**
 * Class describing a car transport. Extends Truck and implements Ramp.
 */

//Inte samma bil på olika TruckCarTransport
    // Bilen ska veta att den är på en transport
public class TruckCarTransport extends Truck implements Ramp, CarTransport {
    private final Car[] loadedCars;
    private final int distanceToTransport = 5;
    private int angle;

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
    public TruckCarTransport(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int xCor, int yCor, int maxCars) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, xCor, yCor);
        loadedCars = new Car[maxCars];
    }

    @Override
    public void move() {
        super.move();
        updateCarCoor();
    }


    /**
     * Loads a car on the transport if the ramp is down and the car is on no other transport
     * @param c The car to load
     */
    @Override
    public void loadCar(Car c) {
        if (!isMovementAllowed() && !c.isOnTransport() && indexEmpty(loadedCars) != -1) {
            loadedCars[indexEmpty(loadedCars)] = c;
            c.setxCor(getXcor());
            c.setyCor(getyCor());
            c.setOnTransport(true);
        }
    }

    /**
     * Unload a car from the transport
     */
    @Override
    public void unloadCar() {
        int index = indexLastCar(loadedCars);
        if(index != -1 && !isMovementAllowed()) {
            Car c = loadedCars[index];
            loadedCars[index] = null;
            c.setyCor(c.getyCor() + distanceToTransport);
            c.setxCor(c.getXcor() + distanceToTransport);
            c.setOnTransport(false);
        }
    }

    /**
     * Update the coordinates of the cars loaded on the transport.
     */
    @Override
    public void updateCarCoor() {
        for (Car c : loadedCars) {
            if(c != null) {
                c.setxCor(getXcor());
                c.setyCor(getyCor());
            }
        }
    }

    @Override
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
     * @param angle If angle == 0 then raise, else lowered
     */
    @Override
    public void setAngle(int angle) {
        if(angle == 0) {
            this.angle = 0;
        }
        else {
            this.angle = 70;
        }
        setMovementAllowed(angle == 0);
    }

    @Override
    public int getCurrentAngle() { return this.angle; }
}
