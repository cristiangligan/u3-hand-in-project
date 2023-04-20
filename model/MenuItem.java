package model;

public abstract class MenuItem implements IMenuItem {
    protected String name;

    protected double cost;

    @Override
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
