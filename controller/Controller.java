package controller;

//only imports what is strictly necessary from view-package

import model.*;
import view.ButtonType;
import view.CustomPizzaFrame;
import view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 * Class defining the Controller of the application
 *
 * @author Cristian Gligan
 */
public class Controller {
    private final MainFrame view;
    // for test purposes - delete if not used in final solution
    private CustomPizzaFrame newPizzaType;
    private ButtonType currentLeftMenu = ButtonType.NoChoice;
    private ArrayList<MenuItem> foodMenu;
    private ArrayList<MenuItem> drinkMenu;
    private ArrayList<MenuItem> orderList;
    private ArrayList<MenuItem> currentOrderList;
    private double costCurrentOrder = 0; // for test purposes - delete if not used in final solution

    /**
     * Controller constructor
     *
     * @author Cristian Gligan
     */
    public Controller() {
        view = new MainFrame(1000, 500, this);
        loadStringTestValues(); //for test purposes - remove when not needed more
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();

        currentOrderList = new ArrayList<>();
        orderList = new ArrayList<>();
    }

    /**
     * Loads the data used in the application.
     *
     * @author Cristian Gligan
     */
    private void loadStringTestValues() {
        foodMenu = new ArrayList<>();
        drinkMenu = new ArrayList<>();

        ArrayList<Topping> kebabPizzaToppings = new ArrayList<>();
        kebabPizzaToppings.add(Topping.KEBAB);
        kebabPizzaToppings.add(Topping.FRIES);
        kebabPizzaToppings.add(Topping.PEPPERONI);
        Pizza kebabPizza = new Pizza("Kebab Pizza", 100, kebabPizzaToppings);
        foodMenu.add(kebabPizza);

        ArrayList<Topping> hawaiiPizzaToppings = new ArrayList<>();
        hawaiiPizzaToppings.add(Topping.PINEAPPLE);
        hawaiiPizzaToppings.add(Topping.PROSCIUTTO);
        hawaiiPizzaToppings.add(Topping.CHEESE);
        Pizza hawaiiPizza = new Pizza("Hawaii Pizza", 100, hawaiiPizzaToppings);
        foodMenu.add(hawaiiPizza);

        ArrayList<Topping> veggiePizzaToppings = new ArrayList<>();
        veggiePizzaToppings.add(Topping.MUSHROOMS);
        veggiePizzaToppings.add(Topping.GREENS);
        veggiePizzaToppings.add(Topping.CHEESE);
        Pizza veggiePizza = new Pizza("Veggie Pizza", 100, veggiePizzaToppings);
        foodMenu.add(veggiePizza);

        ArrayList<Topping> margheritaPizzaToppings = new ArrayList<>();
        margheritaPizzaToppings.add(Topping.CHEESE);
        margheritaPizzaToppings.add(Topping.GREENS);
        Pizza margheritaPizza = new Pizza("Margherita Pizza", 100, margheritaPizzaToppings);
        foodMenu.add(margheritaPizza);

        ArrayList<Topping> mightyMeatPizzaToppings = new ArrayList<>();
        mightyMeatPizzaToppings.add(Topping.PEPPERONI);
        mightyMeatPizzaToppings.add(Topping.PROSCIUTTO);
        mightyMeatPizzaToppings.add(Topping.KEBAB);
        Pizza mightyMeatPizza = new Pizza("Mighty Meat Pizza", 100, mightyMeatPizzaToppings);
        foodMenu.add(mightyMeatPizza);

        Drink cocaCola = new SoftDrink("Coca Cola", 26, true);
        drinkMenu.add(cocaCola);

        Drink ginTonic = new AlcoholicDrink("Gin Tonic", 86, true, 12);
        drinkMenu.add(ginTonic);
    }

    /**
     * Handles all the button pressed events that occurred in the GUI.
     *
     * @param button is the type of the button pressed
     * @author Cristian Gligan
     */
    public void buttonPressed(ButtonType button) {

        switch (button) {
            case Add:
                addItemToOrder(view.getSelectionLeftPanel());
                break;

            case Food:
                setToFoodMenu();
                break;

            case Drinks:
                setToDrinkMenu();
                break;

            case MakePizza:
                addNewFood();
                break;

            case OrderHistory:
                setToOrderHistoryMenu();
                break;

            case Order:
                placeOrder();
                break;

            case ViewOrder:
                viewSelectedOrder(view.getSelectionLeftPanel());
                break;
        }
    }

    /**
     * Adds the selected menu item in the list of the left panel to the current open order.
     *
     * @param selectionIndex the index of the selected menu item in the list
     * @author Cristian Gligan
     */
    public void addItemToOrder(int selectionIndex) {
        if (selectionIndex != -1) {// if something is selected in the left menu list
            switch (currentLeftMenu) {
                case Food -> {
                    OrderItem orderItem = new OrderItem(foodMenu.get(selectionIndex));
                    currentOrderList.add(orderItem);
                    costCurrentOrder = costCurrentOrder + orderItem.getCost();
                }
                case Drinks -> {
                    boolean canAddDrink = true;
                    Drink drinkToAdd = (Drink) drinkMenu.get(selectionIndex);
                    if (drinkToAdd instanceof AlcoholicDrink) {
                        var selection = JOptionPane.showOptionDialog(null, "Are you over the age of 18?", null, YES_NO_OPTION, WARNING_MESSAGE, null, null, null);
                        if (selection != 0) {
                            canAddDrink = false;
                        }
                    }
                    if (canAddDrink) {
                        OrderItem orderItem = new OrderItem(drinkMenu.get(selectionIndex));
                        currentOrderList.add(orderItem);
                        costCurrentOrder = costCurrentOrder + orderItem.getCost();
                    }
                }
            }
            view.populateRightPanel(currentOrderList); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
            view.setTextCostLabelRightPanel("Total cost of order: " + costCurrentOrder); //set the text to show cost of current order
        }

    }

    /**
     * Displays, in the list of the right panel, the selected order in the left panel.
     *
     * @param selectionIndex the index of the selected order in the list
     * @author Cristian Gligan
     */
    public void viewSelectedOrder(int selectionIndex) {
        if ((selectionIndex != -1) && currentLeftMenu == ButtonType.OrderHistory) {
            Order selectedOrder = (Order) orderList.get(selectionIndex);
            view.populateRightPanel(selectedOrder.getOrderItems()); //update left panel with order details - this takes a shortcut in updating the entire information in the panel not just adds to the end
            view.setTextCostLabelRightPanel("Total cost of order: " + selectedOrder.getCost()); //set the text to show cost of current order
        }
    }

    /**
     * Populates the list of the left panel with pizza items.
     *
     * @author Cristian Gligan
     */
    public void setToFoodMenu() {
        currentLeftMenu = ButtonType.Food;
        view.populateLeftPanel(foodMenu);
        view.populateRightPanel(currentOrderList); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + costCurrentOrder); //set the text to show cost of current order
        view.enableAllButtons();
        view.disableFoodMenuButton();
        view.disableViewSelectedOrderButton();
    }

    /**
     * Populates the list of the left panel with drink items.
     *
     * @author Cristian Gligan
     */
    public void setToDrinkMenu() {
        currentLeftMenu = ButtonType.Drinks;
        view.populateLeftPanel(drinkMenu);
        view.populateRightPanel(currentOrderList); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + costCurrentOrder); //set the text to show cost of current order
        view.enableAllButtons();
        view.disableDrinksMenuButton();
        view.disableViewSelectedOrderButton();
    }

    /**
     * Populates the list of the left panel with the order history items.
     *
     * @author Cristian Gligan
     */
    public void setToOrderHistoryMenu() {
        currentLeftMenu = ButtonType.OrderHistory;
        view.clearRightPanel();
        view.populateLeftPanel(orderList);
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableOrderButton();
    }

    public void addNewFood() {
        newPizzaType = new CustomPizzaFrame(this);
        //For grade VG: Add more code to save the new Pizza type and update menu,
        view.enableAllButtons();
    }

    /**
     * Tries to close the current order and adds it to the order history.
     * The order will be closed only if it contains at least one pizza.
     * If the order doesn't contain at least one pizza, the order is not closed.
     *
     * @author Cristian Gligan
     */
    public void placeOrder() {
        if (!currentOrderList.isEmpty()) {
            boolean orderIsValid = false;
            for (MenuItem orderItem : currentOrderList) {
                if (((OrderItem) orderItem).getMenuItem() instanceof Pizza) {
                    orderIsValid = true;
                    break;
                }
            }
            if (orderIsValid) {
                Order order = new Order((orderList.size() + 1), costCurrentOrder, currentOrderList);
                orderList.add(order);
                currentOrderList.clear();
                costCurrentOrder = 0;
                view.clearRightPanel(); //Removes information from right panel in GUI
                view.clearLeftPanel();
                view.setTextCostLabelRightPanel("TOTAL COST: 0");
                view.enableAllButtons();
                view.disableAddMenuButton();
                view.disableViewSelectedOrderButton();
            } else {
                JOptionPane.showMessageDialog(null, "You have to order at least one pizza!");
            }
        }
    }
}
