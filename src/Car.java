package src;

import java.awt.*;

public abstract class Car extends Vehicle {
    /**
     * Abstract class representing a car extending Vehicle
     * @param nrDoors Number of doors
     * @param enginePower Horsepower
     * @param currentSpeed Current speed in km/h
     * @param color Color of the car
     * @param modelName Model name
     * @param xCor x-coordinate
     * @param yCor y-coordinate
     */
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color,
               String modelName, int xCor, int yCor){
        super(nrDoors, enginePower, currentSpeed, color,
                 modelName, xCor, yCor);
    }
}
