package model;

import java.util.ArrayList;

/**
 * Class defining pizzas.
 *
 * @author Cristian Gligan
 */
public class Pizza extends Food {
    private final ArrayList<Topping> toppings;
    private double baseCost;

    /**
     * Pizza constructor
     *
     * @param name the name of the pizza
     * @param baseCost the cost of the pizza crust
     * @param toppings the list of the {@link Topping} instances used on the pizza crust
     * @author Cristian Gligan
     */
    public Pizza(String name, double baseCost, ArrayList<Topping> toppings) {
        this.name = name;
        this.baseCost = baseCost;
        this.toppings = toppings;
        cost = getTotalCost();
    }

    /**
     * Gets the total cost of the pizza.
     *
     * @return the total cost of the pizza as {@link Double}
     * @author Cristian Gligan
     */
    protected double getTotalCost() {
        double totalCost = baseCost;
        for (Topping topping : toppings) {
            totalCost += topping.getCost();
        }
        return totalCost;
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
