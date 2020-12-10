package src;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Model model = new Model(800, 400);
        // The delay (ms) corresponds to 20 updates a sec (hz)
        CarView frame = new CarView("Grand Turismo");
        SpeedView fastAsLightning = new SpeedView();
        model.addModelObserver(frame);
        model.addModelObserver(fastAsLightning);

        model.addVehicle(new Volvo240(50, 50));

        Saab95 saab = new Saab95(50, 150);
        model.addVehicle(saab);
        model.addTurbo(saab);

        Scania truck = new Scania(50, 250);
        model.addVehicle(truck);
        model.addRamp(truck);

        new CarController(model, 800, 250);
        new Thread(model).start();
    }
}
