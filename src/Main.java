package src;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Instance of this class


        // The delay (ms) corresponds to 20 updates a sec (hz)
        final int delay = 50;

        // The timer is started with an listener (see below) that executes the statements
        // each step between delays.
        final Timer timer = new Timer(delay, new CarController.TimerListener());
        CarController cc = new CarController();

        cc.frame = new CarView("CarSim 1.0", cc);
        cc.addVehicle(new Volvo240(50, 50));

        Saab95 saab = new Saab95(50, 150);
        cc.addVehicle(saab);
        cc.addTurbo(saab);

        Scania truck = new Scania(50, 250);
        cc.addVehicle(truck);
        cc.addRamp(truck);


        // Start a new view and send a reference of self


        // Start the timer
        cc.timer.start();
    }
}
