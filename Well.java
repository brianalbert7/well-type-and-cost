package well;

/**
 *
 * @author Brian Albert
 */
public class Well {

    private char wellType;
    private int wellDepth;

    /**
     * Constructor
     *
     * @param newWellType The value to store in wellType
     * @param newWellDepth The value to store in wellDepth
     */
    public Well(char newWellType, int newWellDepth) {
        wellType = newWellType;
        wellDepth = newWellDepth;
    }

    /**
     * getWellType method returns the well type
     *
     * @return The value in the wellType field
     */
    public char getWellType() {
        return wellType;
    }

    /**
     * getWellDepth method returns the well depth
     *
     * @return The value in the wellDepth field
     */
    public int getWellDepth() {
        return wellDepth;
    }

    /**
     * setWellType method stores a value in the wellType field
     *
     * @param newWellType The value to store in wellType
     */
    public void setWellType(char newWellType) {
        wellType = newWellType;
    }

    /**
     * setWellDepth method stores a value in the wellDepth field
     *
     * @param newWellDepth The value to store in wellDepth
     */
    public void setWellDepth(int newWellDepth) {
        wellDepth = newWellDepth;
    }

    /**
     * cost method calculates the cost from the given well type
     *
     * @return The value in the cost field
     */
    public double cost() {
        double costToReturn;

        if (wellType == 'W' || wellType == 'w') {
            costToReturn = 14.99 * wellDepth;
        } else if (wellType == 'O' || wellType == 'o') {
            if (wellDepth <= 10000) {
                costToReturn = 19.99 * wellDepth;
            } else {
                costToReturn = 19.99 * 10000 + (wellDepth - 10000) * 34.99;
            }
        } else {
            costToReturn = 0;
        }

        return costToReturn;
    }

    /**
     * toString method used to return a String representing this well
     *
     * @return a string representing the well
     */
    @Override
    public String toString() {
        String wellDepthReturn = String.format("%,d", wellDepth);
        String costReturn = String.format("%,.2f", cost());
        if (wellType == 'W' || wellType == 'w')
            return "Water Well - Depth: " + wellDepthReturn + " Cost: $" + costReturn;
        else if (wellType == 'O' || wellType == 'o')
            return "Oil Well - Depth: " + wellDepthReturn + " Cost: $" + costReturn;
        else
            return "Unknown Well: " + wellType + " Well Depth: " + wellDepthReturn + " Cost: $" + costReturn;
    }
}
