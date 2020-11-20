package src;

public class Transport extends Trailer {
    private final Car[] loadedCars;
    private final int distanceToTransport = 5;

    /**
     * Type of trailer for transporting cars, extends Trailer.
     * @param truck To which truck it is connected to
     * @param maxCars Maximum capacity
     */
    public Transport (Scania truck, int maxCars) {
        super(truck);
        loadedCars = new Car[maxCars];
    }

    /**
     * Load a car to the transport.
     * @param c Car to load
     */
    @Override
    public void loadCar(Car c) {
        if (!getTruck().isMovementAllowed() && indexEmpty(loadedCars) != -1) {
            loadedCars[indexEmpty(loadedCars)] = c;
            c.setxCor(getTruck().getXcor());
            c.setyCor(getTruck().getyCor());
        }
    }

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
     * Unload a car from the transport.
     */
    public void unloadCar() {
        int index = indexLastCar(loadedCars);
        if(index != -1 && !getTruck().isMovementAllowed()) {
            Car c = loadedCars[index];
            loadedCars[index] = null;
            c.setyCor(c.getyCor() + distanceToTransport);
            c.setxCor(c.getXcor() + distanceToTransport);
        }
    }

    /**
     * Used to update all coordinates of the cars loaded on the transport.
     */
    public void updateCarCoor() {
        for (Car c : loadedCars) {
            if(c != null) {
                c.setxCor(getTruck().getXcor());
                c.setyCor(getTruck().getyCor());
            }
        }
    }
    @Override
    public void setAngle(int angle) {
        if (angle == getMIN_ANGLE())
            super.setAngle(getMIN_ANGLE());
        else
            super.setAngle(getMAX_ANGLE());
    }

    public Car[] getLoadedCars() { return loadedCars; }
}
