package view;

import model.MenuItem;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Contains a list of items on the menu, the order history and the buttons
 * on the left side of the main panel.
 *
 * @author Cristian Gligan
 */
public class LPanel extends JPanel {
    private JList<Object> leftPanelList;
    private JButton btnShowDrinks;
    private JButton btnShowFood;
    private JButton btnShowOrderHistory;
    private JButton btnCreateNewPizzaType;
    private JButton btnAddSelectionToOrder;
    private JLabel titleLeftPanel;

    private final int width;
    private final int height;

    private final MainFrame mainFrame;

    /**
     * LPanel constructor
     *
     * @param width the width of the panel in pixels
     * @param height the height of the panel in pixels
     * @param mainFrame reference to the {@link MainFrame} instance
     * @author Cristian Gligan
     */
    public LPanel(int width, int height, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(0, 0);
        setUp();
    }

    /**
     * Sets up the UI of the {@link LPanel}.
     *
     * @author Cristian Gligan
     */
    private void setUp() {
        titleLeftPanel = new JLabel("Make menu choice with buttons");
        titleLeftPanel.setLocation(20, 0);
        titleLeftPanel.setSize(width / 2, 20);
        this.add(titleLeftPanel);

        leftPanelList = new JList<>();
        leftPanelList.setLocation(0, 23);
        leftPanelList.setSize(width, height - 100);
        this.add(leftPanelList);

        btnShowFood = new JButton("Food");
        btnShowFood.setEnabled(true);
        btnShowFood.setSize(width / 5, 30);
        btnShowFood.setLocation(0, height - 75);
        btnShowFood.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Food));
        this.add(btnShowFood);

        btnShowDrinks = new JButton("Drinks");
        btnShowDrinks.setEnabled(true);
        btnShowDrinks.setSize(width / 5, 30);
        btnShowDrinks.setLocation(width / 5, height - 75);
        btnShowDrinks.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Drinks));
        this.add(btnShowDrinks);

        btnCreateNewPizzaType = new JButton("Make Pizza");
        btnCreateNewPizzaType.setEnabled(true);
        btnCreateNewPizzaType.setSize(width / 5, 30);
        btnCreateNewPizzaType.setLocation((width / 5) * 2, height - 75);
        btnCreateNewPizzaType.addActionListener(l -> {
            mainFrame.buttonPressed(ButtonType.MakePizza); //fog grade VG: what happens if this button is pressed ultiple times?
        });
        this.add(btnCreateNewPizzaType);

        btnAddSelectionToOrder = new JButton("Add");
        btnAddSelectionToOrder.setEnabled(true);
        btnAddSelectionToOrder.setSize(width / 5, 30);
        btnAddSelectionToOrder.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Add));
        btnAddSelectionToOrder.setLocation((width / 5) * 3, height - 75);
        this.add(btnAddSelectionToOrder);

        btnShowOrderHistory = new JButton("Order history");
        btnShowOrderHistory.setEnabled(true);
        btnShowOrderHistory.setSize(width / 5, 30);
        btnShowOrderHistory.setLocation((width / 5) * 4, height - 75);
        btnShowOrderHistory.addActionListener(l -> mainFrame.buttonPressed(ButtonType.OrderHistory));
        this.add(btnShowOrderHistory);
    }

    /**
     * Returns an instance of the panel's list
     *
     * @return instance of the panel's list
     * @author Cristian Gligan
     */
    protected JList<Object> getLeftPanelList() {
        return leftPanelList;
    }

    /**
     * This method removes information in the panels list.
     *
     * @author Cristian Gligan
     */
    protected void clearList() {
        ArrayList<MenuItem> emptyList = new ArrayList<>();
        populateList(emptyList);
    }

    /**
     * Returns an instance of the "Order history" {@link JButton}.
     *
     * @return instance of the "Order history" {@link JButton}
     * @author Cristian Gligan
     */
    protected JButton getShowOrderHistory() {
        return btnShowOrderHistory;
    }

    /**
     * Returns an instance of the "Drinks" {@link JButton}.
     *
     * @return instance of the "Drinks" {@link JButton}
     * @author Cristian Gligan
     */
    protected JButton getBtnShowDrinks() {
        return btnShowDrinks;
    }

    /**
     * Returns an instance of the "Food" {@link JButton}.
     *
     * @return instance of the "Food" {@link JButton}
     * @author Cristian Gligan
     */
    protected JButton getBtnShowFood() {
        return btnShowFood;
    }

    /**
     * Returns an instance of the "Add" {@link JButton}.
     *
     * @return instance of the "Add" {@link JButton}
     * @author Cristian Gligan
     */
    protected JButton getBtnAddSelectionToOrder() {
        return btnAddSelectionToOrder;
    }

    /**
     * Returns an instance of the "Make Pizza" {@link JButton}.
     *
     * @return instance of the "Make Pizza" {@link JButton}
     * @author Cristian Gligan
     */
    protected JButton getBtnCreateNewPizzaType() {
        return btnCreateNewPizzaType;
    }


    /**
     * This method sets the information in the panel's list view.
     *
     * @param items An {@link ArrayList} of {@link MenuItem} where each element
     *              will be shown one line in the panel.
     * @author Cristian Gligan
     */
    public void populateList(ArrayList<MenuItem> items) {
        leftPanelList.setListData(items.toArray());
    }

}
