package src;

import java.util.ArrayList;

public class VehicleModel {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();


    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    public void startEngines() {
        for (Vehicle v : vehicles) {
            v.startEngine();
        }
    }

    public void stopEngines() {
        for (Vehicle v : vehicles) {
            v.stopEngine();
        }
    }

    public void turnRight() {
        for (Vehicle v : vehicles) {
            v.turnRight();
        }
    }

    public void turnLeft() {
        for (Vehicle v : vehicles) {
            v.turnLeft();
        }
    }

    public ArrayList<Vehicle> getVehicles() { return vehicles; }
    public void addVehicle(Vehicle vehicle) { this.vehicles.add(vehicle); }
}
