import org.junit.*;
import src.Cars;
import src.Saab95;
import src.Scania;
import src.Transport;

import static org.junit.Assert.*;
import java.awt.*;
import java.util.Arrays;

public class TestTransport {
    @Test
    public void isTransport(){
        Scania s = new Scania(2, 400, 0, Color.red, "BigAssTruck", 0,0);
        s.connectTransport(6);
        //assertTrue();
    }

    @Test
    public void oneCar() {
        Scania s = new Scania(2, 400, 0, Color.red, "BigAssTruck", 0,0);
        s.connectTransport(6);
        Saab95 saab = new Saab95(0,0);
        s.lowerRamp();
        s.loadCar(saab);
        Cars[] c = s.getLoadedCars();
        assertEquals(saab, c[0]);
    }

    @Test
    public void unloadCar() {
        Scania s = new Scania(2, 400, 0, Color.red, "BigAssTruck", 0,0);
        s.connectTransport(6);
        Saab95 saab = new Saab95(0,0);
        s.lowerRamp();
        s.loadCar(saab);
        s.loadCar(saab);
        s.unloadCar();
        Cars[] c = s.getLoadedCars();
        assertNull(c[1]);
    }
}
