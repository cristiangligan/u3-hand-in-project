package view;

import controller.Controller;
import model.MenuItem;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Is the main window of the application with a title and a border.
 *
 * @author Cristian Gligan
 */
public class MainFrame extends JFrame {
    private final MainPanel mainPanel;
    private final Controller controller;

    /**
     * MainFrame constructor
     *
     * @param width the width of the panel in pixels
     * @param height the height of the panel in pixels
     * @param controller reference to the {@link Controller} instance
     * @author Cristian Gligan
     */
    public MainFrame(int width, int height, Controller controller) {
        super("Restaurant");
        this.controller = controller;
        this.setResizable(false);
        this.setSize(width, height);
        this.mainPanel = new MainPanel(width, height, this);
        this.setContentPane(mainPanel);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * This method sets the information in the LEFT panel of the main window.
     *
     * @param items An {@link ArrayList} of {@link MenuItem} where each element
     *              will be shown as one line in the panel.
     * @author Cristian Gligan
     */
    public void populateLeftPanel(ArrayList<MenuItem> items) {
        mainPanel.getLeftPanel().populateList(items);
    }

    /**
     * This method sets the information in the RIGHT panel of the main window.
     *
     * @param items An {@link ArrayList} of {@link MenuItem} where each element
     *              will be shown one line in the panel.
     * @author Cristian Gligan
     */
    public void populateRightPanel(ArrayList<MenuItem> items) {
        mainPanel.getRightPanel().populateList(items);
    }

    /**
     * This method removes information in the RIGHT panel of the main window.
     * @author Cristian Gligan
     */
    public void clearRightPanel() {
        mainPanel.getRightPanel().clearList();
    }

    /**
     * This method removes information in the LEFT panel of the main window.
     * @author Cristian Gligan
     */
    public void clearLeftPanel() {
        mainPanel.getLeftPanel().clearList();
    }

    /**
     * This method returns the index value as an int of the selected row
     * in the list in the left panel of the main window.
     *
     * @return the index of the selected row as an int. If no selection exists -1 is returned.
     * @author Cristian Gligan
     */
    public int getSelectionLeftPanel() {
        return mainPanel.getLeftPanel().getLeftPanelList().getSelectedIndex();
    }

    /**
     * This method sets a text that shows to the farthest right in
     * the window above the right list panel.
     *
     * @param newText the text that is shown in the GUI
     * @author Cristian Gligan
     */
    public void setTextCostLabelRightPanel(String newText) {
        mainPanel.getRightPanel().setTextCostLabel(newText);
    }

    /**
     * This method disables the possibility to press the button labeled "Food".
     *
     * @author Cristian Gligan
     */
    public void disableFoodMenuButton() {
        mainPanel.getLeftPanel().getBtnShowFood().setEnabled(false);
    }


    /**
     * This method disables the possibility to press the button labeled "Drinks".
     *
     * @author Cristian Gligan
     */
    public void disableDrinksMenuButton() {
        mainPanel.getLeftPanel().getBtnShowDrinks().setEnabled(false);
    }


    /**
     * This method disables the possibility to press the button labeled "Add".
     *
     * @author Cristian Gligan
     */
    public void disableAddMenuButton() {
        mainPanel.getLeftPanel().getBtnAddSelectionToOrder().setEnabled(false);
    }

    /**
     * This method disables the possibility to press the button labeled "Order".
     *
     * @author Cristian Gligan
     */
    public void disableOrderButton() {
        mainPanel.getRightPanel().getBtnCreateOrder().setEnabled(false);
    }

    /**
     * This method disables the possibility to press the button labeled "View order".
     *
     * @author Cristian Gligan
     */
    public void disableViewSelectedOrderButton() {
        mainPanel.getRightPanel().getBtnViewSelectedOrder().setEnabled(false);
    }

    /**
     * This method enables all buttons in the GUI to be pressed.
     *
     * @author Cristian Gligan
     */
    public void enableAllButtons() {
        mainPanel.getLeftPanel().getBtnShowFood().setEnabled(true);
        mainPanel.getLeftPanel().getBtnShowDrinks().setEnabled(true);
        mainPanel.getLeftPanel().getBtnCreateNewPizzaType().setEnabled(true);
        mainPanel.getLeftPanel().getBtnAddSelectionToOrder().setEnabled(true);
        mainPanel.getLeftPanel().getShowOrderHistory().setEnabled(true);
        mainPanel.getRightPanel().getBtnCreateOrder().setEnabled(true);
        mainPanel.getRightPanel().getBtnViewSelectedOrder().setEnabled(true);
    }

    /**
     * This method is called by other parts of the Gui when a button is pressed.
     * The method buttonPressed in class Controller is called and the type of
     * pressed button is sent as an argument.
     *
     * @param pressedButton the type of button
     * @see ButtonType
     */
    public void buttonPressed(ButtonType pressedButton) {
        controller.buttonPressed(pressedButton);
    }
}
