package src;

public class Platform extends Trailer{
    private int angle;
    private final Scania truck;

    public Platform (Scania truck) {
        this.angle = 0;
        this.truck = truck;

    }

    public void raisePlatform(int angle) {
        if (0 <= angle && angle <= 70)
            this.angle = angle;
    }

    public void lowerPlatform(int angle) {
        if (0)
    }
}
