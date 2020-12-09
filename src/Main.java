package src;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Instance of this class

        Model model = new Model(800, 400);
        // The delay (ms) corresponds to 20 updates a sec (hz)
        CarView frame = new CarView("CarSim 1.0");

        CarController cc = new CarController(model, 800, 250);

        model.addVehicle(new Volvo240(50, 50));

        Saab95 saab = new Saab95(50, 150);
        model.addVehicle(saab);
        model.addTurbo(saab);

        Scania truck = new Scania(50, 250);
        model.addVehicle(truck);
        model.addRamp(truck);

        // Start a new view and send a reference of self
        
        // Start the timer
        cc.timer.start();
    }
}
