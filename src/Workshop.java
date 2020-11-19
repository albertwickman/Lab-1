package src;

import java.util.List;

public class Workshop<C extends Cars> {
    public List<C> cars;

    /**
     * Create a workshop of type C
     * @param car What type of
     */
    public Workshop(List<C> car) {
        this.cars = car;
    }

    /**
     * Load a car into the workshop
     * @param c Car to repair
     */
    public void load(C c) {
        cars.add(c);
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