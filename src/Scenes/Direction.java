package Scenes;

/**
 * Direction enum for movement
 */
public enum Direction {
    north, south, east, west;

    /**
     * Converts a string to an enum, returns null if the string is not a valid direction+
     */
     public static Direction getDirection(String direction) {
         return switch (direction) {
             case "north" -> Direction.north;
             case "south" -> Direction.south;
             case "east" -> Direction.east;
             case "west" -> Direction.west;
             default -> null;
         };
    }

    /**
     * Converts the enum to a string
     */
    @Override
    public String toString() {
         return switch (this) {
             case north -> "north";
             case south -> "south";
             case east -> "east";
             case west -> "west";
         };
    }
}
