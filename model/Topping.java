package model;

/**
 * Enum for all available {@link Pizza} toppings.
 *
 * @author Cristian Gligan
 */
public enum Topping {
    PEPPERONI("pepperoni", 10),
    CHEESE("cheese", 10),
    MUSHROOMS("mushrooms", 10),
    KEBAB("kebab", 10),
    PINEAPPLE("pineapple", 10),
    GREENS("greens", 10),
    PROSCIUTTO("prosciutto", 10),
    FRIES("fries", 10);

    private final String name;
    private final double cost;

    /**
     * Topping constructor
     *
     * @param name the name of the topping
     * @param cost the cost of the topping
     * @author Cristian Gligan
     */
    Topping(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     * Gets the name of the topping.
     *
     * @return the name of the topping as {@link String}
     * @author Cristian Gligan
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the cost of the topping.
     *
     * @return the cost of the topping as {@link Double}
     * @author Cristian Gligan
     */
    public double getCost() {
        return cost;
    }
}
