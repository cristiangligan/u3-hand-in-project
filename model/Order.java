package model;

import java.util.ArrayList;

/**
 *
 * @author Cristian Gligan
 */
public class Order extends MenuItem {
    private final int id;
    private final ArrayList<MenuItem> orderItems;

    /**
     *
     * @param id
     * @param cost
     * @param orderItems
     */
    public Order(int id, double cost, ArrayList<MenuItem> orderItems) {
        this.id = id;
        name = Integer.toString(this.id);
        this.cost = cost;
        this.orderItems = new ArrayList<>();
        this.orderItems.addAll(orderItems);
    }

    /**
     *
     * @return
     * @author Cristian Gligan
     */
    @Override
    public String toString() {
        return "Order " + name + ", " + cost + " kr";
    }

    /**
     *
     * @return
     * @author Cristian Gligan
     */
    public ArrayList<MenuItem> getOrderItems() {
        return orderItems;
    }
}
