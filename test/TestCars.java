import org.junit.Test;
import src.Cars;
import src.Volvo240;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCars {

    Volvo240 car = new Volvo240(50, 50);

    @Test
    public void testTurnLeft() {
        car.startEngine();
        car.gas(0.5);
        car.turnLeft();
        //assertEquals(0, Double.compare());

    }
}
