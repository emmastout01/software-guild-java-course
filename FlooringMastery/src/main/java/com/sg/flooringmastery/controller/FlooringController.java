/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.models.Order;
import com.sg.flooringmastery.models.Product;
import com.sg.flooringmastery.service.FlooringService;
import com.sg.flooringmastery.service.ValidationResponse;
import com.sg.flooringmastery.ui.FlooringView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class FlooringController {

    private FlooringView view;
    private FlooringService service;

    public FlooringController(FlooringView view, FlooringService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        boolean isRunning = true;
        try {
            while (isRunning) {

                int menuChoice = view.printMenuAndGetSelection();

                switch (menuChoice) {
                    case 1:
                        displayOrders();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        isRunning = false;
                }
            }
            view.displayGoodbyeMessage();
        } catch (FlooringMasteryPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void displayOrders()
            throws FlooringMasteryPersistenceException {
        //Display banner
        view.displayOrdersBanner();
        //Ask the user for a date
        LocalDate userDate = view.getOrderDate();
        //Get all orders for that date
        List<Order> orderList = service.getAllOrders(userDate);
        //Display those orders to the user
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String userDateAsString = userDate.format(formatter);
        view.displayOrders(userDateAsString, orderList);
    }

    private void addOrder() throws FlooringMasteryPersistenceException {

        List<Product> productList = service.getAllProducts();
        view.displayProductNames(productList);

        //Ask the user to enter information about the order
        //Get the order info from the view. Send that to the service to validate
        Order orderIn = view.getOrderInfo();
        ValidationResponse<Order> response
                = service.validateOrder(orderIn);

        if (!response.isSuccess()) {
            view.displayErrorMessage(response.getMessage());
            return;
        }

        //After the order has been validated, calculate the order totals
        Order addedOrder = service.calculateOrderTotals(orderIn);

        //Display full order for user; ask user to confirm
        String userResponse = view.displayAddOrderConfirmation(addedOrder).toLowerCase();
        //If user confirms, add order to file via service/dao
        if (userResponse.equals("y") || userResponse.equals("yes")) {
            service.addOrderConfirmed(addedOrder);
            view.displayAddOrderSuccess();
        } else {
            //If user does not confirm, discard info and display 'info discarded' message
            view.displayDiscardedInformation();
        }

    }

    private void editOrder() throws FlooringMasteryPersistenceException {
        //Display edit banner 
        view.displayEditBanner();
        //Ask user for date
        LocalDate date = view.getOrderDate();
        //Ask user for order id
        int orderId = view.getOrderId();
        //Get the order in question
        Order orderToEdit = service.getOrder(date, orderId);
        //Get edited order from user
        if (orderToEdit == null) {
            System.out.println("No such order");
            return;
        }
        Order editedOrder = view.getEditedOrder(orderToEdit);
        //Calculate new order totals in service
        ValidationResponse<Order> response
                = service.validateOrder(editedOrder);

        if (!response.isSuccess()) {
            view.displayErrorMessage(response.getMessage());
            return;
        }

        //After the order has been validated, calculate the order totals
        editedOrder = service.calculateOrderTotals(editedOrder);
        //Save the edited information
        service.editOrder(date, orderId, editedOrder);

        //Display success message
        view.displayEditOrderSuccess();

    }

    private void removeOrder() throws FlooringMasteryPersistenceException {

        //Display banner
        view.displayRemoveBanner();
        //Ask user for date
        LocalDate date = view.getOrderDate();
        //Ask user for orderID 
        int orderId = view.getOrderId();
        //Get the order in question
        Order orderToRemove = service.getOrder(date, orderId);
        //Display information for the order with that date/Id. Ask user, are you sure?
        String userResponse = view.displayOrderToRemoveAndGetConfirmation(orderToRemove);

        //If user confirms, remove order from file via service/dao
        if (userResponse.equals("y") || userResponse.equals("yes")) {
            service.removeOrder(orderId, date);
            view.displayRemoveOrderSuccess();
        } else {
            //If user does not confirm, discard changes and display 'your order is safe' message
            view.displayRemoveOrderDiscarded();
        }

    }

}
