import org.junit.Test;
import src.Saab95;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCars {

    @Test
    public void testMove() {
        Saab95 saab = new Saab95(50, 50);
        saab.setDx(5);                    // we set dx to 5 and dy to 10 and call the move method
        saab.setDy(10);                   // we then want to see if the x and y coordinates differ by 5
        saab.move();
        assertEquals(0, Double.compare(saab.getXcor(), saab.getyCor()-5));
    }

    @Test
    public void testSetDy() {
        Saab95 saab = new Saab95(50, 50);
        saab.setDy(1);                          // we set dy to 1 and we'll see if getdy returns 1
        assertEquals(0, Double.compare(1, saab.getDy()));
    }

    @Test
    public void testSetDx() {
        Saab95 saab = new Saab95(50, 50);
        saab.setDx(1);
        assertEquals(0, Double.compare(1, saab.getDx()));
    }

    @Test
    public void testTurnLeft() {
        Saab95 saab = new Saab95(50, 50);
        saab.startEngine();
        saab.gas(0.5);
        saab.setDx(1);
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(0, Double.compare(saab.getDy(), -saab.getCurrentSpeed()));    // full spin for full line coverage
    }

    @Test
    public void testTurnRight() {
        Saab95 saab = new Saab95(50, 50);
        saab.startEngine();
        saab.gas(0.5);
        saab.setDy(-1);
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertEquals(0, Double.compare(saab.getDx(), saab.getCurrentSpeed()));
    }

    @Test
    public void modelName() {
        Saab95 saab = new Saab95(0,0);
        assertEquals("Saab95", saab.getModelName());
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
