package model;

/**
 * Base class defining the properties and implementing the behavior of a generic menu item.
 *
 * @author Cristian Gligan
 */
public abstract class MenuItem implements IMenuItem {
    protected String name;

    protected double cost;

    /**
     * Gets the total cost of this menu item.
     *
     * @return the total cost of this menu item as {@link Double}
     * @author Cristian Gligan
     */
    @Override
    public double getCost() {
        return cost;
    }

    /**
     * Gets the name of this menu item.
     *
     * @return the name of this menu item as {@link String}
     * @author Cristian Gligan
     */
    @Override
    public String getName() {
        return name;
    }
}
