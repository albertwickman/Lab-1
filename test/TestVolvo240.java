import org.junit.Test;
import src.Volvo240;
import static org.junit.Assert.*;

public class TestVolvo240 {

    private final Volvo240 testCar = new Volvo240(50, 50);

    @Test
    public void fourDoors() {
        assertEquals(0, Double.compare(testCar.getNrDoors(), 4.0));
    }

    @Test
    public void speedOnStart() {
        assertEquals(0, Double.compare(testCar.getCurrentSpeed(), 0.0));
    }

    @Test
    public void enginePowerIs100() {
        assertEquals(0, Double.compare(testCar.getEnginePower(), 100.0));
    }

}
