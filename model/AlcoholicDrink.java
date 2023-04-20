package model;

/**
 *
 * @author Cristian Gligan
 */
public class AlcoholicDrink extends Drink {

    private double alcoholPercentage;

    /**
     *
     * @param name
     * @param cost
     * @param carbonated
     * @param alcoholPercentage
     * @author Cristian Gligan
     */
    public AlcoholicDrink(String name, double cost, boolean carbonated, double alcoholPercentage) {
        this.name = name;
        this.cost = cost;
        this.carbonated = carbonated;
        this.alcoholPercentage = alcoholPercentage;
    }

    /**
     *
     * @return
     * @author Cristian Gligan
     */
    public String toString() {
        String stringToReturn;
        stringToReturn = name + ", ";
        stringToReturn += alcoholPercentage + "%, ";
        if (carbonated) {
            stringToReturn += "carbonated, ";
        }
        stringToReturn += cost + " kr";
        return stringToReturn;
    }
}
