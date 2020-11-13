import org.junit.Test;
import src.Saab95;

import static org.junit.Assert.*;

public class TestSaab95 {

    @Test
    public void twoDoors() {
        assertEquals(0, Double.compare(2.0, new Saab95(0, 0).getNrDoors()));
    }

    @Test
    public void speedOnStart() {
        assertEquals(0, Double.compare(new Saab95(0,0).getCurrentSpeed(), 0.0));
    }

    @Test
    public void gasNoTurbo() {
        Saab95 saab = new Saab95(0,0);
        saab.gas(0.5);
        assertEquals(0, Double.compare(saab.getCurrentSpeed(), 0.625));
    }

    @Test
    public void gasTurbo() {
        Saab95 saab = new Saab95(0,0);
        saab.setTurboOn();
        saab.gas(0.5);
        assertEquals(0, Double.compare(saab.getCurrentSpeed(), 0.8125));
    }

    @Test
    public void turbo() {
        Saab95 saab = new Saab95(0,0);
        saab.setTurboOn();
        saab.setTurboOff();
        assertFalse(saab.isTurboOn());
    }

    @Test
    public void brakeTest() {
        Saab95 saab = new Saab95(0,0);
        saab.gas(0.5);
        saab.brake(0.25);
        assertEquals(0, Double.compare(saab.getCurrentSpeed(), 0.3125));
    }

    @Test
    public void  dx() {
        Saab95 saab = new Saab95(0,0);
        saab.gas(0.5);
        saab.turnLeft();
        saab.gas(0.5);
        assertEquals(0, Double.compare(saab.getCurrentSpeed(), 1.25));
    }

    @Test
    public void  dy() {
        Saab95 saab = new Saab95(0,0);
        saab.gas(0.5);
        saab.turnLeft();
        saab.brake(0.25);
        assertEquals(0, Double.compare(saab.getCurrentSpeed(), 0.3125));
    }

}
