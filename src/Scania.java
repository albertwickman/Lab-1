package src;

import java.awt.*;

public class Scania extends Vehicle {
    private boolean raised;
    private Trailer trailer;

    /**
     * Instantiates a new Car.
     *
     * @param nrDoors      the nr doors
     * @param enginePower  the engine power
     * @param currentSpeed the current speed
     * @param color        the color
     * @param modelName    the model name
     */
    public Scania(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int xCor, int yCor, Trailer trailer) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, xCor, yCor);
        this.trailer = trailer;
    }

    /**
     * Change the trailer to a transport.
     * @param maxCars Maximum capacity of the trailer
     */
    public void convertToTransport(int maxCars) {
        trailer = new Transport(this, maxCars);
    }

    /**
     * Change the trailer to a platform.
     */
    public void convertToPlatform() {
        trailer = new Platform(this);
    }

    public void setRaised(boolean raised) {
        this.raised = raised;
    }

    public boolean isRaised() {
        return raised;
    }

    @Override
    public void move() {
        if (!isRaised()) {
            super.move();
            if (trailer instanceof Transport)
                ((Transport) trailer).updateCarCoor();
        }
    }
}