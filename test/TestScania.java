import org.junit.Test;
import src.Scania;
import static org.junit.Assert.*;
import java.awt.*;

public class TestScania {
    @Test
    public void noMovementWhenRaised() {
        Scania s = new Scania(2, 400);
        s.setAngle(40);
        s.move();
        assertFalse(s.isMovementAllowed());
    }

}
