package model;

/**
 *
 * @author Cristian Gligan
 */
public class OrderItem extends MenuItem {

    private final MenuItem menuItem;

    /**
     *
     * @param menuItem
     * @author Cristian Gligan
     */
    public OrderItem(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.cost = menuItem.getCost();
        this.menuItem = menuItem;
    }

    /**
     *
     * @return
     * @author Cristian Gligan
     */
    public MenuItem getMenuItem() {
        return menuItem;
    }

    /**
     *
     * @return
     * @author Cristian Gligan
     */
    @Override
    public String toString() {
        return name + ", " + cost + " kr";
    }
}
