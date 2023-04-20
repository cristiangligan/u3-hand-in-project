package model;

import java.util.ArrayList;

public class Order extends MenuItem{
    private int id;
    private ArrayList<MenuItem> orderItems;

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

    public ArrayList<MenuItem> getOrderItems() {
        return orderItems;
    }
}
