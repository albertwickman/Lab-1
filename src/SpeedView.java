package src;

import java.util.ArrayList;

public class SpeedView implements ModelObserver {
    @Override
    public void actOnChange(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles)
            System.out.println(vehicle.getModelName() + ": " + vehicle.getCurrentSpeed());
    }
}