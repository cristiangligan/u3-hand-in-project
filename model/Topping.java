package model;

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

    Topping(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
