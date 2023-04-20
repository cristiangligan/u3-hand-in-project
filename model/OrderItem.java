package model;

public class OrderItem extends MenuItem {

    private MenuItem menuItem;
    public OrderItem(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.cost = menuItem.getCost();
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    @Override
    public String toString() {
        return name + ", " + cost + " kr";
    }
}
