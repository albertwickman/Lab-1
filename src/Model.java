package src;

import java.util.ArrayList;
import java.util.Set;

public class Model {

    private Set<ModelObserver> modelObservers;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Ramp> ramps;
    private ArrayList<Turbo> turbos;


    public Set<ModelObserver> getModelObservers() { return this.modelObservers;}
    public void addModelObserver(ModelObserver modelObserver) {
        this.modelObservers.add(modelObserver);
    }

    public ArrayList<Vehicle> getVehicles() { return vehicles; }
    public void addVehicles(Vehicle vehicle) { this.vehicles.add(vehicle); }

    public ArrayList<Ramp> getRamps() { return ramps; }
    public void addRamp(Ramp ramp) { this.ramps.add(ramp); }

    public ArrayList<Turbo> getTurbos() { return turbos; }
    public void addTurbo(Turbo turbo) { this.turbos.add(turbo); }

}
