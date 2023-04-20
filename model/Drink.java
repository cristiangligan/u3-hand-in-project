package model;

public class Drink extends MenuItem {

    protected boolean carbonated;

    public boolean isCarbonated() {
        return this.carbonated;
    }

    public void setCarbonated(boolean carbonated) {
        this.carbonated = carbonated;
    }
}
