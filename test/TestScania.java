import org.junit.Test;
import src.Platform;
import src.Scania;
import src.Transport;

import java.awt.*;

import static org.junit.Assert.*;

public class TestScania {

    Scania truck = new Scania(2, 100, 0, Color.BLACK,
            "Trucko", 10, 10);

    @Test
    public void equipTransport() {
        truck.connectPlatform();
        truck.connectTransport(10);
        assertEquals(truck.getTrailer(), );
    }

    @Test
    public void platformIsRaised() {
        truck.connectPlatform();
    }
}
