package src;

import java.util.ArrayList;
import java.util.Set;

public class Model {

    private Set<ModelObserver> modelObservers;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Ramp> ramps;
    private ArrayList<Turbo> turbos;
    private final int width;
    private final int height;

    public Model(int width, int height) {
        this.width = width;
        this.height = height;

    }

    public Set<ModelObserver> getModelObservers() { return this.modelObservers;}
    public void addModelObserver(ModelObserver modelObserver) {
        this.modelObservers.add(modelObserver);
    }

    public ArrayList<Vehicle> getVehicles() { return vehicles; }
    public void addVehicle(Vehicle vehicle) { this.vehicles.add(vehicle); }

    public ArrayList<Ramp> getRamps() { return ramps; }
    public void addRamp(Ramp ramp) { this.ramps.add(ramp); }

    public ArrayList<Turbo> getTurbos() { return turbos; }
    public void addTurbo(Turbo turbo) { this.turbos.add(turbo); }

    public int getHeight() { return this.height; }
    public int getWidth() { return this.width; }
}
