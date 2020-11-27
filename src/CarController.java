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

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) throws IOException {
        // Instance of this class
        CarController cc = new CarController();
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.addVehicle(new Volvo240(50, 50));

        cc.addVehicle(new Saab95(50, 150));

        cc.addVehicle(new Scania(2, 100, 0, Color.BLACK, "Truck", 50, 250));

        // Start a new view and send a reference of self


        // Start the timer
        cc.timer.start();
    }

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

    public void startEngines() {
        for (Vehicle v : vehicles)
            v.startEngine();
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
        for(Vehicle v : vehicles) {
            if(v instanceof Saab95) {
                //v.setTurboOn();
            }
        }
    }

}
