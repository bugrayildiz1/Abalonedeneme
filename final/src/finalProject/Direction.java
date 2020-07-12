package finalProject;


/**
 * this enum class shows the all directions that marbles can move.
 */
public enum Direction {
    
    /** The northwest. */
    NW,
    
    /** The northeast. */
    NE,
    
    /** The east. */
    EE,
    
    /** The southEast. */
    SE,
    
    /** The southWest. */
    SW,
    
    /** The west. */
    WW;

    /**
     * It shows the opposite direction of the move. For example, opposite 
     * direction of the east is west or opposite direction of north east is south west. 
     * This method is used at move class to move more than one marbles.
     * @return the opposite direction of the direction that have been specified.
     */
    public Direction DirectionOther() {
        Direction result = null;
        if (this == Direction.EE) {
            result = Direction.WW;
        }
        if (this == Direction.NE) {
            result = Direction.SW;
        }
        if (this == Direction.WW) {
            result = Direction.EE;
        }
        if (this == Direction.NW) {
            result = Direction.SE;
        }
        if (this == Direction.SE) {
            result = Direction.NW;
        }
        if (this == Direction.SW) {
            result = Direction.NE;
        }
        return result;
    }
}
