package model;

/**
 * Class defining alcoholic drinks.
 *
 * @author Cristian Gligan
 */
public class AlcoholicDrink extends Drink {

    private double alcoholPercentage;

    /**
     * AlcoholicDrink constructor
     *
     * @param name the name of the alcoholic drink
     * @param cost the cost of the alcoholic drink
     * @param carbonated the carbonation of the alcoholic drink
     * @param alcoholPercentage the percentage of the alcohol in the alcoholic drink
     * @author Cristian Gligan
     */
    public AlcoholicDrink(String name, double cost, boolean carbonated, double alcoholPercentage) {
        this.name = name;
        this.cost = cost;
        this.carbonated = carbonated;
        this.alcoholPercentage = alcoholPercentage;
    }

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
