package src;

public class Transport implements Trailer {
    private final Scania truck;
    private final Cars[] loadedCars;

    /**
     * Type of trailer for transporting cars, extends Trailer.
     * @param truck To which truck it is connected to
     * @param maxCars Maximum capacity
     */
    public Transport (Scania truck, int maxCars) {
        this.truck = truck;
        truck.setMovementAllowed(false);
        loadedCars = new Cars[maxCars];
    }

    /**
     * Load a car to the transport.
     * @param c Car to load
     */
    public void loadCar(Cars c) {
        if (truck.isMovementAllowed() && indexEmpty(loadedCars) != -1) {
            loadedCars[indexEmpty(loadedCars)] = c;
            c.setxCor(truck.getXcor());
            c.setyCor(truck.getyCor());
        }
    }

    private int indexEmpty(Cars[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == null)
                return i;
        return -1;
    }

    private int indexLastCar(Cars[] arr) {
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
        if(index != -1 && truck.isMovementAllowed()) {
            Cars c = loadedCars[index];
            loadedCars[index] = null;
            c.setyCor(c.getyCor() + 5);
            c.setxCor(c.getXcor() + 5);
        }
    }

    /**
     * Used to update all coordinates of the cars loaded on the transport.
     */
    public void updateCarCoor() {
        for (Cars c : loadedCars) {
            if(c != null) {
                c.setxCor(truck.getXcor());
                c.setyCor(truck.getyCor());
            }
        }
    }

    public Cars[] getLoadedCars() {
        return loadedCars;
    }
    /**
     * Raise the ramp. Enables movement of the truck.
     */
    public void raiseRamp() {
        truck.setMovementAllowed(false);
    }

    /**
     * Lower the ramp. Disables movement of the truck.
     */
    public void lowerRamp() {
        truck.setMovementAllowed(true);
    }
}
