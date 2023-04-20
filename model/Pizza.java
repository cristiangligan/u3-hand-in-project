package model;

import java.util.ArrayList;

public class Pizza extends Food {
    private final ArrayList<Topping> toppings;
    private double baseCost;

    /**
     * Constructor
     *
     * @param name     the name of the pizza
     * @param baseCost the cost of the pizza crust
     * @param toppings the list of the {@link Topping} instances used on the pizza crust
     */
    public Pizza(String name, double baseCost, ArrayList<Topping> toppings) {
        this.name = name;
        this.baseCost = baseCost;
        this.toppings = toppings;
        cost = getTotalCost();
    }

    /**
     * @return
     */
    private double getTotalCost() {
        double totalCost = baseCost;
        for (Topping topping : toppings) {
            totalCost += topping.getCost();
        }
        return totalCost;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public String toString() {
        String stringToReturn;
        stringToReturn = name + ", ";
        for (Topping t : toppings) {
            stringToReturn += t.getName() + ", ";
        }
        stringToReturn += getTotalCost() + " kr";
        return stringToReturn;
    }
}
