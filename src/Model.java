package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class Model implements Runnable {

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
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            checkBoundaries(vehicle);
        }
    }

    private void delay() throws InterruptedException {
        Thread.sleep(50);
    }

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

    private void checkBoundaries(Vehicle v) {
        if (isOnEdge(v))
            invertDirection(v);
    }

    private void invertDirection(Vehicle v) {
        v.setDx(-1 * v.getDx());
        v.setDy(-1 * v.getDy());
    }

    private boolean isOnEdge(Vehicle v) {
        return v.getXcor() > getWidth() - 115 || v.getXcor() < 0 || v.getyCor() < 0 || v.getyCor() > getHeight() - 90;
    }

    public void setTurboOn() {
        for (Turbo t : turbos) {
            t.setTurboOn();
        }
    }

    public void setTurboOff() {
        for (Turbo t : turbos) {
            t.setTurboOff();
        }
    }

    public void raiseRamp() {
        for (Ramp r : ramps) {
            r.setAngle(0);
        }
    }

    public void lowerRamp() {
        for (Ramp r : ramps) {
            r.setAngle(70);
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
