package Scenes;

/**
 * class to store the position of an object in the map
 */
public class Position {
    /**
     * The x coordinates of the position
     */
    private int x;
    /**
     * The y coordinates of the position
     */
    private int y;

    /**
     * Constructor of the Position class
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns true if the current position and the given position are within a range
     * Example: if current position is (0, 0) and the given position is (1, 1) and the range is 1, then the function returns true
     */
    public boolean isInContact(Position position, int range) {
        return Math.abs(position.x - x) <= range && Math.abs(position.y - y) <= range;
    }
    /**
     * Returns true if the current position and the given position are equal to a range
     * Example: if current position is (0, 0) and the given position is (2, 2) and the range is 2, then the function returns true
     * Example: if current position is (0, 0) and the given position is (1, 1) and the range is 2, then the function returns false
     */
    public boolean IsInExactContact(Position position, int range) {
        return Math.abs(position.x - x) == range && Math.abs(position.y - y) == range;
    }

    /**
     * Returns a new position with the same coordinates
     */
    public Position Clone() {
        return new Position(x, y);
    }

    /**
     * Sets the position to the new position
     */
    public void set(Position newPosition) {
        this.x = newPosition.x;
        this.y = newPosition.y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean isEqual(Position position) {
        return position.getX() == x && position.getY() == y;
    }
}
