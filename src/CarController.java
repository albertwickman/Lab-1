package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController extends Main{
    // member fields:



    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Turbo> turbos = new ArrayList<>();
    ArrayList<Ramp> ramps = new ArrayList<>();

    //methods:

    public void addTurbo(Turbo t) {
        turbos.add(t);
    }

    public void addRamp(Ramp r) { ramps.add(r); }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        frame.drawPanel.vehicles.add(v);
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                checkBoundaries(vehicle);
                int x = (int) Math.round(vehicle.getXcor());
                int y = (int) Math.round(vehicle.getyCor());
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
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

    /*
    **BUG**
    Starts all engines even if ramp is lowered.
     */
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
        return v.getXcor() > frame.getX() - 100|| v.getXcor() < 0 || v.getyCor() < 0 || v.getyCor() > frame.getY() - 300;
    }

    public void setTurboOn() {
        for(Turbo t : turbos) {
            t.setTurboOn();
        }
    }

    public void setTurboOff() {
        for(Turbo t : turbos) {
            t.setTurboOff();
        }
    }

    public void raiseRamp() {
        for(Ramp r : ramps) {
            r.setAngle(0);
        }
    }

    public void lowerRamp() {
        for(Ramp r : ramps) {
            r.setAngle(70);
        }
    }

    public void turnRight() {
        for(Vehicle v : vehicles) {
            v.turnRight();
        }
    }

    public void turnLeft() {
        for(Vehicle v : vehicles) {
            v.turnLeft();
        }
    }
}
