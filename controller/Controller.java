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
 * @author Cristian Gligan
 */
public class Controller {
    private final MainFrame view;
    private final int nbrOfOrders = 0; // for test purposes - delete if not used in final solution
    private CustomPizzaFrame newPizzaType;
    private ButtonType currentLeftMenu = ButtonType.NoChoice;
    private ArrayList<MenuItem> foodMenu;
    private ArrayList<MenuItem> drinkMenu;
    private ArrayList<MenuItem> orderList;
    private String[] orderHistoryMenuString; // for test purposes - delete if not used in final solution
    private String[] order1Simulation; // for test purposes - delete if not used in final solution
    private ArrayList<MenuItem> currentOrderList;
    private double costCurrentOrder = 0; // for test purposes - delete if not used in final solution

    /**
     *
     * @author Cristian Gligan
     */
    public Controller() {
        view = new MainFrame(1000, 500, this);
        loadStringTestValues(); //for test purposes - remove when not needed more
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }

    /**
     *
     * @author Cristian Gligan
     */
    private void loadStringTestValues() {
        foodMenu = new ArrayList<>();
        drinkMenu = new ArrayList<>();
        currentOrderList = new ArrayList<>();
        orderList = new ArrayList<>();
        orderHistoryMenuString = new String[10];
        order1Simulation = new String[10];

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

        orderHistoryMenuString[0] = "order1: kostnad:100";
        orderHistoryMenuString[1] = "order2: kostand:200";

        order1Simulation[0] = "Order 1";
        order1Simulation[1] = "mat1 pris1";
        order1Simulation[2] = "mat2 pris2";
        order1Simulation[3] = "dryck1 pris3";

    }

    /**
     *
     * @param button
     * @author Cristian Gligan
     */
    //This method is called by class MinFrame when a button in teh GUI is pressed
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
     *
     * @param selectionIndex
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
     *
     * @param selectionIndex
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

    /**
     *
     * @author Cristian Gligan
     */
    public void addNewFood() {
        newPizzaType = new CustomPizzaFrame(this);
        //For grade VG: Add more code to save the new Pizza type and update menu,
        view.enableAllButtons();
    }

    /**
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
