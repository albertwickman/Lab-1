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
        truck.setMovementAllowed(false);
        loadedCars = new Car[maxCars];
    }

    /**
     * Load a car to the transport.
     * @param c Car to load
     */
    public void loadCar(Car c) {
        if (!truck.isMovementAllowed() && indexEmpty(loadedCars) != -1) {
            loadedCars[indexEmpty(loadedCars)] = c;
            c.setxCor(truck.getXcor());
            c.setyCor(truck.getyCor());
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
        if(index != -1 && !truck.isMovementAllowed()) {
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
                c.setxCor(truck.getXcor());
                c.setyCor(truck.getyCor());
            }
        }
    }

    public Car[] getLoadedCars() {
        return loadedCars;
    }
    /**
     * Raise the ramp. Enables movement of the truck.
     */
    public void raiseRamp() {
        setAngle(getMIN_ANGLE());
    }

    /**
     * Lower the ramp. Disables movement of the truck.
     */
    public void lowerRamp() {
        setAngle(getMAX_ANGLE());
    }
}
