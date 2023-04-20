package model;

public class AlcoholicDrink extends Drink {
    private double alcoholPercentage;

    public AlcoholicDrink(String name, double cost, boolean carbonated, double alcoholPercentage) {
        this.name = name;
        this.cost = cost;
        this.carbonated = carbonated;
        this.alcoholPercentage = alcoholPercentage;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
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
