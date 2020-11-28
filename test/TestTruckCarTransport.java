import org.junit.*;
import src.*;

import static org.junit.Assert.*;
import java.awt.*;
import java.io.IOException;

public class TestTruckCarTransport {

    TruckCarTransport s = new TruckCarTransport(2, 400, 0, Color.red,
            "BigAssTruck", 0,0, 6);

    @Test
    public void oneCar() {
        Saab95 saab = new Saab95(0,0);
        s.setAngle(2);
        s.loadCar(saab);
        Car[] c = s.getLoadedCars();
        assertEquals(saab, c[0]);
    }

    @Test
    public void unloadCar() {
        Saab95 saab = new Saab95(0,0);
        s.setAngle(2);
        s.loadCar(saab);
        s.loadCar(saab);
        s.unloadCar();
        Car[] c = s.getLoadedCars();
        assertNull(c[1]);
    }

    @Test
    public void carsCoordinatesUpdatesWithTransports() throws IOException {
        Volvo240 car = new Volvo240(0, 0);
        s.setAngle(2);
        s.loadCar(car);
        s.setAngle(0);
        s.setDx(2);
        s.move();
        assertEquals(0, Double.compare(s.getXcor(), car.getXcor()));
    }
}
