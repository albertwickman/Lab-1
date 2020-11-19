package src;
import java.util.ArrayList;
import java.util.List;

public class Transport {
    private final Scania truck;
    private final List<Cars> cars = new ArrayList<Cars>();


    public Transport (Scania truck) {
        this.truck = truck;
        truck.setRaised(false);
    }

    public void raiseRamp() {
        truck.setRaised(true);
    }

    public void lowerRamp() {
        truck.setRaised(false);
    }
}
