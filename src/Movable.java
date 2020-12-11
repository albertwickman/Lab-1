package src;

/**
 * The interface Movable.
 */
public interface Movable {
    /**
     * Move.
     */
    void move();

    void setMovementAllowed(boolean movementAllowed);

    boolean isMovementAllowed();
}