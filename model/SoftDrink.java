package model;

public class SoftDrink extends Drink {
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
