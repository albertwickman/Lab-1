package src;

import java.awt.*;

public class CarTransport extends Truck implements Ramp {
    private final Car[] loadedCars;
    private final int distanceToTransport = 5;

    public CarTransport(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int xCor, int yCor, int maxCars) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, xCor, yCor);
        loadedCars = new Car[maxCars];
    }

    public void loadCar(Car c) {
        if (!movementAllowed && indexEmpty(loadedCars) != -1) {
            loadedCars[indexEmpty(loadedCars)] = c;
            c.setxCor(getXcor());
            c.setyCor(getyCor());
        }
    }

    public void unloadCar() {
        int index = indexLastCar(loadedCars);
        if(index != -1 && !movementAllowed) {
            Car c = loadedCars[index];
            loadedCars[index] = null;
            c.setyCor(c.getyCor() + distanceToTransport);
            c.setxCor(c.getXcor() + distanceToTransport);
        }
    }

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
    @Override
    public void setAngle(int angle) {
        if (angle == 0)
            movementAllowed = true;
        else
            movementAllowed = false;

    }
}
