package src;

public class Trailer {
    private int angle;
    private final Scania truck;
    private final int MIN_ANGLE = 0;
    private final int MAX_ANGLE = 70;
    private Transport transport;

    public int getMIN_ANGLE() {
        return MIN_ANGLE;
    }

    public int getMAX_ANGLE() {
        return MAX_ANGLE;
    }

    /**
     * Creates an instance of platform.
     * @param truck Truck to which the platform is connected to
     */
    public Trailer (Scania truck) {
        this.angle = 0;
        this.truck = truck;
        truck.setMovementAllowed(true);
    }

    public void newTransport(int maxCars) {
        transport = new Transport(truck, maxCars);
    }

    public void loadCar(Car c){
        if (transport != null)
            transport.loadCar(c);
    }

    public void unloadCar() {
        if (transport != null)
            transport.unloadCar();
    }

    public void updateCoor() {
        if (transport != null)
            transport.updateCoor();
    }

    public Car[] getLoadedCars() {
        if (transport != null)
            return transport.getLoadedCars();
        return null;
    }

    /**
     * Sets the angle of the platform
     * @param angle Angle
     */
    public void setAngle(int angle) {
        if (MIN_ANGLE <= angle && angle <= MAX_ANGLE) {
            this.angle = angle;
            truck.setMovementAllowed(angle == MIN_ANGLE);
        }
    }

    public Scania getTruck() {
        return truck;
    }
}
