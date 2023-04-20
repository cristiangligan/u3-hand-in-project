package model;

/**
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
     *
     * @param name
     * @param cost
     * @author Cristian Gligan
     */
    Topping(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     *
     * @return
     * @author Cristian Gligan
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     * @author Cristian Gligan
     */
    public double getCost() {
        return cost;
    }
}
