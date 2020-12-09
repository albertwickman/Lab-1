package src;

import java.util.ArrayList;

public interface ModelObserver {
    void actOnChange(ArrayList<Vehicle> vehicles);
}
