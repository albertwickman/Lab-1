package src;

/**
 * The interface Movable.
 */
public interface Movable {
    /**
     * Move.
     */
    void move();
    /**
     * Turn left.
     */
    void turnLeft();

    /**
     * Turn right.
     */
    void turnRight();

    void gas(double amount);

    void brake(double amount);
}