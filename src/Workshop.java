package src;

import java.util.List;

public class Workshop<C extends Car> {
    public List<C> cars;
    private final int maxCars;

    /**
     * Create a workshop of type C
     * @param car What type of
     */
    public Workshop(List<C> car, int maxCars) {
        this.cars = car;
        this.maxCars = maxCars;
    }

    /**
     * Load a car into the workshop
     * @param car Car to repair
     */
    public void load(C car) {
        if (cars.size() < maxCars)
            cars.add(car);
    }

    /**
     * Retrieve a specified car from the workshop
     * @param car What car to retrieve
     * @return The retrieved car
     */
    public C retrieve(C car) {
        if (cars.contains(car)){
            C returnCar = cars.get(cars.indexOf(car));
            cars.remove(returnCar);
            return returnCar;
        }
        return null;
    }
}