package src;

public interface CarTransport {

    void loadCar(Car c);

    void unloadCar();

    void updateCarCoor();

    Car[] getLoadedCars();
}
