package src;

public class Platform {
    private int angle;
    private final Scania truck;
    private final int MIN_ANGLE = 0;
    private final int MAX_ANGLE = 0;

    /**
     * Creates an instance of platform.
     * @param truck Truck to which the platform is connected to
     */
    public Platform (Scania truck) {
        this.angle = 0;
        this.truck = truck;
        truck.setRaised(false);
    }

    /**
     * Sets the angle of the platform
     * @param angle Angle
     */
    public void setAngle(int angle) {
        if (MIN_ANGLE <= angle && angle <= MAX_ANGLE) {
            this.angle = angle;
            if (angle != MIN_ANGLE)
                truck.setRaised(true);
            else
                truck.setRaised(false);
        }
    }
}
