package model;

/**
 * Class defining soft (non-alcoholic) drinks.
 *
 * @author Cristian Gligan
 */
public class SoftDrink extends Drink {
    /**
     * SoftDrink constructor
     *
     * @param name the name of the soft drink
     * @param cost the cost of the soft drink
     * @param carbonated the carbonation of the soft drink
     * @author Cristian Gligan
     */
    public SoftDrink(String name, double cost, boolean carbonated) {
        this.name = name;
        this.cost = cost;
        this.carbonated = carbonated;
    }

    public String toString() {
        String stringToReturn;
        stringToReturn = name + ", ";
        if (carbonated) {
            stringToReturn += "carbonated, ";
        }
        stringToReturn += cost + " kr";
        return stringToReturn;
    }
}
