package model;

import java.util.ArrayList;

/**
 * Class defining a customer's order.
 *
 * @author Cristian Gligan
 */
public class Order extends MenuItem {
    private final int id;
    private final ArrayList<MenuItem> orderItems;

    /**
     * Order constructor
     *
     * @param id the order ID
     * @param cost the total cost of the order
     * @param orderItems list of all ordered items in this order
     */
    public Order(int id, double cost, ArrayList<MenuItem> orderItems) {
        this.id = id;
        name = Integer.toString(this.id);
        this.cost = cost;
        this.orderItems = new ArrayList<>();
        this.orderItems.addAll(orderItems);
    }

    @Override
    public String toString() {
        return "Order " + name + ", " + cost + " kr";
    }

    /**
     * Gets the list of all ordered items in this Order.
     *
     * @return the list of all ordered items as {@link ArrayList} of {@link MenuItem}
     * @author Cristian Gligan
     */
    public ArrayList<MenuItem> getOrderItems() {
        return orderItems;
    }
}
