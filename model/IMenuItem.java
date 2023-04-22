package model;

/**
 * Interface defining the behavior of a generic menu item.
 *
 * @author Cristian Gligan
 */
public interface IMenuItem {
    /**
     * Gets the total cost of this menu item.
     *
     * @return the total cost of this menu item as {@link Double}
     * @author Cristian Gligan
     */
    String getName();

    /**
     * Gets the name of this menu item.
     *
     * @return the name of this menu item as {@link String}
     * @author Cristian Gligan
     */
    double getCost();
}
