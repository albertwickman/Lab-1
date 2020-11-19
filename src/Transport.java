package src;
import java.util.ArrayList;
import java.util.List;

public class Transport extends Trailer {
    private final Scania truck;
    private final List<? super Cars> cars = new ArrayList<Cars>();
    private final int MAX_CARS_LOADED;

    public Transport (Scania truck, int maxCars) {
        this.truck = truck;
        truck.setRaised(false);
        this.MAX_CARS_LOADED = maxCars;
    }

    public void loadCar(Cars c) {
        if (cars.size() < MAX_CARS_LOADED && truck.isRaised()) {
            cars.add(c);
            c.setxCor(truck.getXcor());
            c.setyCor(truck.getyCor());
        }
    }

    public void unloadCar() {
        if(cars.size() > 0 && truck.isRaised()) {
            Object c = cars.get(cars.size() - 1);

        }
    }

    public void raiseRamp() {
        truck.setRaised(true);
    }

    public void lowerRamp() {
        truck.setRaised(false);
    }
}
