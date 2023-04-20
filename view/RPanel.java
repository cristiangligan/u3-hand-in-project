package view;

import model.MenuItem;

import javax.swing.*;
import java.util.ArrayList;

public class RPanel extends JPanel {
    private final MainFrame mainFrame;
    private JList<Object> rightPanelList;

    private JButton btnOrder;

    private JButton btnViewSelectedOrder;
    private JLabel lblTitle;
    private JLabel lblCost;
    private final int width;
    private final int height;

    public RPanel(int width, int height, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(width, 0);
        setUp();
    }

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
     * @param items An array of String where each element will be shown
     *              one line in the panel.
     */
    protected void populateList(ArrayList<MenuItem> items) {
        rightPanelList.setListData(items.toArray());
    }

    /**
     * This method removes information in the panels list.
     * There are some problems with this in this code and "ghost items" might
     * appear in the list view at the top of the list after use of this method.
     * This might throw selected indexes of synchronization if this is used.
     * <p>
     * This is a "hack" and not a perfect solution - GUIs are annoying to work with!
     * <p>
     * Several solutions have been tested but none worked to satisfaction.
     * Please notify teachers if you might come across a solution that actually works well.
     */
    protected void clearList() {
        ArrayList<MenuItem> emptyList = new ArrayList<>();
        populateList(emptyList);
    }

    protected void setTextTitleLabel(String labelText) {
        lblTitle.setText(labelText);
    }

    protected void setTextCostLabel(String labelText) {
        lblCost.setText(labelText);
    }

    protected JButton getBtnCreateOrder() {
        return btnOrder;
    }

    protected JButton getBtnViewSelectedOrder() {
        return btnViewSelectedOrder;
    }
}
