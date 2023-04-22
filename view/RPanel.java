package view;

import model.MenuItem;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Contains a list of ordered items and the buttons on the right side of the main panel.
 *
 * @author Cristian Gligan
 */
public class RPanel extends JPanel {
    private final MainFrame mainFrame;
    private JList<Object> rightPanelList;

    private JButton btnOrder;

    private JButton btnViewSelectedOrder;
    private JLabel lblTitle;
    private JLabel lblCost;
    private final int width;
    private final int height;

    /**
     * RPanel constructor
     *
     * @param width the width of the panel in pixels
     * @param height the height of the panel in pixels
     * @param mainFrame reference to the {@link MainFrame} instance
     * @author Cristian Gligan
     */
    public RPanel(int width, int height, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(width, 0);
        setUp();
    }

    /**
     * Sets up the UI of the {@link RPanel}.
     *
     * @author Cristian Gligan
     */
    private void setUp() {
        lblTitle = new JLabel("CURRENT ORDER");
        lblTitle.setLocation(2, 0);
        lblTitle.setSize((width / 2) - 100, 20);
        this.add(lblTitle);

        lblCost = new JLabel("TOTAL COST: 0");
        lblCost.setLocation((width / 2) - 90, 0);
        lblCost.setSize((width / 2) - 100, 20);
        this.add(lblCost);

        rightPanelList = new JList<>();
        rightPanelList.setLocation(0, 23);
        rightPanelList.setSize(width, height - 100);
        this.add(rightPanelList);

        btnOrder = new JButton("Order");
        btnOrder.setEnabled(true);
        btnOrder.setSize(width / 5, 30);
        btnOrder.setLocation(0, height - 75);
        btnOrder.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Order));
        this.add(btnOrder);

        btnViewSelectedOrder = new JButton("View order");
        btnViewSelectedOrder.setEnabled(false);
        btnViewSelectedOrder.setSize(width / 5, 30);
        btnViewSelectedOrder.setLocation(width / 5, height - 75);
        btnViewSelectedOrder.addActionListener(l -> mainFrame.buttonPressed(ButtonType.ViewOrder));
        this.add(btnViewSelectedOrder);
    }

    /**
     * This method sets the information in the panel's list view.
     *
     * @param items An {@link ArrayList} of {@link MenuItem} where each element
     *              will be shown one line in the panel.
     * @author Cristian Gligan
     */
    protected void populateList(ArrayList<MenuItem> items) {
        rightPanelList.setListData(items.toArray());
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
     * Sets the total cost of the order in the label at the top of the {@link RPanel}.
     *
     * @param labelText the total cost value as text
     * @author Cristian Gligan
     */
    protected void setTextCostLabel(String labelText) {
        lblCost.setText(labelText);
    }

    /**
     * Returns an instance of the {@link JButton} button used to create an order.
     *
     * @return instance of the {@link JButton} button used to create an order
     * @author Cristian Gligan
     */
    protected JButton getBtnCreateOrder() {
        return btnOrder;
    }

    /**
     * Returns an instance of the {@link JButton} button used to show the selected order.
     *
     * @return instance of the {@link JButton} button used to show the selected order
     * @author Cristian Gligan
     */
    protected JButton getBtnViewSelectedOrder() {
        return btnViewSelectedOrder;
    }
}
