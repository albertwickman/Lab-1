import org.junit.*;
import src.*;

import static org.junit.Assert.*;
import java.awt.*;

public class TestTransport {

    Scania s = new Scania(2, 400, 0, Color.red,
            "BigAssTruck", 0,0);

    @Test
    public void oneCar() {
        s.connectTransport(6);
        Saab95 saab = new Saab95(0,0);
        s.loadCar(saab);
        Car[] c = s.getLoadedCars();
        assertEquals(saab, c[0]);
    }

    @Test
    public void unloadCar() {
        s.connectTransport(6);
        Saab95 saab = new Saab95(0,0);
        s.loadCar(saab);
        s.loadCar(saab);
        s.unloadCar();
        Car[] c = s.getLoadedCars();
        assertNull(c[1]);
    }

    @Test
    public void carsCoordinatesUpdatesWithTransports() {
        Volvo240 car = new Volvo240(0, 0);
        s.connectTransport(10);
        s.loadCar(car);
        s.setDx(2);
        s.move();
        assertEquals(0, Double.compare(s.getXcor(), car.getXcor()));
    }
}
