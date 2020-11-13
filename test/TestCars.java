import org.junit.Test;
import src.Cars;
import src.Saab95;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCars {
    @Test
    public void modelName() {
        Saab95 saab = new Saab95(0,0);
        assertEquals("src.Saab95", saab.getModelName());
    }

    @Test
    public void startEngine() {
        Saab95 saab = new Saab95(0,0);
        saab.startEngine();
        assertEquals(0, Double.compare(0.1, saab.getCurrentSpeed()));
    }

    @Test
    public void stopEngine() {
        Saab95 saab = new Saab95(0,0);
        saab.gas(0.5);
        saab.stopEngine();
        assertEquals(0, Double.compare(saab.getCurrentSpeed(), 0));
    }

    @Test
    public void setColor() {
        Saab95 saab = new Saab95(0, 0);
        saab.setColor(Color.blue);
        assertEquals(Color.blue, saab.getColor());
    }


}
