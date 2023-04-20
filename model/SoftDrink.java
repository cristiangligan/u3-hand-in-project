package model;

/**
 *
 * @author Cristian Gligan
 */
public class SoftDrink extends Drink {
    /**
     *
     * @param name
     * @param cost
     * @param carbonated
     * @author Cristian Gligan
     */
    public SoftDrink(String name, double cost, boolean carbonated) {
        this.name = name;
        this.cost = cost;
        this.carbonated = carbonated;
    }

    /**
     *
     * @return
     * @author Cristian Gligan
     */
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
