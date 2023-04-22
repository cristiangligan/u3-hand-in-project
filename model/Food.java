package model;

/**
 * Base class defining the behavior of a generic food item.
 *
 * @author Cristian Gligan
 */
public abstract class Food extends MenuItem {
    /**
     * Gets the total cost of this food item.
     *
     * @return the total cost of this food item as {@link Double}
     * @author Cristian Gligan
     */
    protected abstract double getTotalCost();
}
