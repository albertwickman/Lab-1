package src;

import java.util.ArrayList;

public class Model implements Runnable {

    private final ArrayList<ModelObserver> modelObservers = new ArrayList<>();
    private final VehicleModel vehicleModel;
    private final TurboModel turboModel;
    private final RampModel rampModel;

    private final int width;
    private final int height;

    public Model(VehicleModel vehicleModel, TurboModel turboModel, RampModel rampModel, int width, int height) {
        this.vehicleModel = vehicleModel;
        this.turboModel = turboModel;
        this.rampModel = rampModel;
        this.width = width;
        this.height = height;

    }

    @Override
    public void run() {
        while(true) {
            try {
                delay();
                update();
            }
            catch (InterruptedException e) {
                break;
            }
        }
    }

    private void update() {
        ArrayList<Vehicle> vehicles = vehicleModel.getVehicles();
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            checkBoundaries(vehicle);
        }
        for(ModelObserver m : modelObservers) {
            m.actOnChange(vehicles);
        }
    }

    private void delay() throws InterruptedException {
        Thread.sleep(50);
    }



    private void checkBoundaries(Vehicle v) {
        if (isOnEdge(v))
            invertDirection(v);
    }

    private void invertDirection(Vehicle v) {
        v.setDx(-v.getDx());
        v.setDy(-v.getDy());
    }

    private boolean isOnEdge(Vehicle v) {
        return v.getXcor() > getWidth() - 115 || v.getXcor() < 0 || v.getyCor() < 0 || v.getyCor() > getHeight() - 90;
    }


    // ********** Getters and Setters *********

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public TurboModel getTurboModel() {
        return turboModel;
    }

    public RampModel getRampModel() {
        return rampModel;
    }


    public ArrayList<ModelObserver> getModelObservers() { return this.modelObservers;}
    public void addModelObserver(ModelObserver modelObserver) {
        this.modelObservers.add(modelObserver);
    }

    public ArrayList<Vehicle> getVehicles() { return vehicleModel.getVehicles(); }
    public void addVehicle(Vehicle vehicle) { vehicleModel.addVehicle(vehicle); }

    public ArrayList<Ramp> getRamps() { return rampModel.getRamps(); }
    public void addRamp(Ramp ramp) { rampModel.addRamp(ramp); }

    public ArrayList<Turbo> getTurbos() { return turboModel.getTurbos(); }
    public void addTurbo(Turbo turbo) { this.turboModel.addTurbo(turbo); }

    public int getHeight() { return this.height; }
    public int getWidth() { return this.width; }
}
