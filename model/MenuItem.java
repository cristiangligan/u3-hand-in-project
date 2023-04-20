package model;

/**
 *
 * @author Cristian Gligan
 */
public abstract class MenuItem implements IMenuItem {
    protected String name;

    protected double cost;

    /**
     *
     * @return
     * @author Cristian Gligan
     */
    @Override
    public double getCost() {
        return cost;
    }

    /**
     *
     * @return
     * @author Cristian Gligan
     */
    @Override
    public String getName() {
        return name;
    }
}
