package model;

/**
 * Class defining order items.
 *
 * @author Cristian Gligan
 */
public class OrderItem extends MenuItem {

    private final MenuItem menuItem;

    /**
     * OrderItem constructor
     *
     * @param menuItem reference to an instance of {@link OrderItem}
     * @author Cristian Gligan
     */
    public OrderItem(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.cost = menuItem.getCost();
        this.menuItem = menuItem;
    }

    /**
     * Gets the instance of the {@link MenuItem} attached to this order item.
     *
     * @return the instance of the {@link MenuItem}
     * @author Cristian Gligan
     */
    public MenuItem getMenuItem() {
        return menuItem;
    }

    @Override
    public String toString() {
        return name + ", " + cost + " kr";
    }
}
