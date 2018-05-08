/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.models.Order;
import com.sg.flooringmastery.models.Product;
import com.sg.flooringmastery.models.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class FlooringView {

    private ConsoleIO io;

    public FlooringView(ConsoleIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {

        io.print("FLOORING EMPORIUM");
        io.print("==================");

        io.print("1. Display orders");
        io.print("2. Add an order");
        io.print("3. Edit an order");
        io.print("4. Remove an order");
        io.print("5. Exit program");

        int userChoice = io.readInt("Please choose an action: ", 1, 5);

        return userChoice;

    }

    public LocalDate getOrderDate() {

        int month = io.readInt("Month number: ", 1, 12);
        int day = io.readInt("Day: ", 1, 31);
        int year = io.readInt("Year: ", 1950, 2100);

        LocalDate userDate = LocalDate.of(year, month, day);
        return userDate;
    }

    public void displayOrdersBanner() {
        io.print("Please enter the date"
                + " for which you would like to view orders.");
        io.print("=================");
    }

    public void displayOrders(String date, List<Order> orderList) {
        io.print("===============");
        io.printf("Orders for %s: ", date);
        io.print("");

        for (Order order : orderList) {
            io.print("ORDER " + order.getOrderId() + ": ");
            io.print("====================");
            io.print("Customer Name: " + order.getCustomerName());
            io.print("State: " + order.getState().getStateName());
            io.print("Tax Rate: " + order.getState().getTaxRate());
            io.print("Product type: " + order.getProduct().getProductType());
            io.print("Area: " + order.getArea());
            io.print("Cost per square foot: " + order.getProduct().getCostPerSqFoot());
            io.print("Labor cost per square foot: " + order.getProduct().getLaborCostPerSqFoot());
            io.print("Total material cost: " + order.getMaterialCost());
            io.print("Total labor cost: " + order.getLaborCost());
            io.print("Total tax: " + order.getTax());
            io.print("Grand total: " + order.getTotal() + "\n");
        }

    }

    public Order getOrderInfo() {
        Order myOrder = new Order();

        String CustomerName = io.readString("Customer Name: ");
        String stateName = io.readString("Your state abbreviation "
                + "(ie MN for Minnesota): ");
        String productType = io.readString("Product name (see above list for options): ");
        BigDecimal area = io.readBigDecimalFromString("Area of the floor, in square feet: ");
        io.print("");

        myOrder.setCustomerName(CustomerName);
        myOrder.setProduct(new Product(productType));
        myOrder.setState(new State(stateName));
        myOrder.setArea(area);

        return myOrder;
    }

    public String displayAddOrderConfirmation(Order addedOrder) {
        io.print("\n Please check your order information and confirm it is correct: ");
        io.print("===========================");
        io.print("Customer name: " + addedOrder.getCustomerName());
        io.print("State: " + addedOrder.getState().getStateName());
        io.print("Product name: " + addedOrder.getProduct().getProductType());
        io.print("Area: " + addedOrder.getArea() + " sq. feet");
        io.print("==============");
        io.print("From this, we calculated: ");
        io.print("==============");
        io.print("Total material cost: $" + addedOrder.getMaterialCost());
        io.print("+ Total labor cost: $" + addedOrder.getLaborCost());
        io.print("+ Tax: $" + addedOrder.getTax());
        io.print("-------------------------");
        io.print("= Grand total: $" + addedOrder.getTotal());
        io.print("=================");
        String userResponse = io.readString("Is the above information correct? (Y/N)");

        return userResponse;

    }

    public void displayProductNames(List<Product> productList) {
        io.print("\n Here are your product options: \n \n");
        for (Product product : productList) {
            io.print(product.getProductType());
        }
        io.print("");
        io.print("");

    }

    public void displayAddOrderSuccess() {
        io.print("Your order has been saved. Thank you!");
    }

    public void displayDiscardedInformation() {
        io.print("Your order information has been discarded. Thank you!");
    }
    
     public void displayEditBanner() {
        io.print("Please enter the date"
                + " for which you would like to edit an order.");
        io.print("=================");
    }

    public Order getEditedOrder(Order currentOrder) {

        String currentCustomerName = currentOrder.getCustomerName();
        String currentStateName = currentOrder.getState().getStateName();
        String currentProductType = currentOrder.getProduct().getProductType();
        String currentAreaAsString = currentOrder.getArea().toString();
        BigDecimal currentArea = currentOrder.getArea();

        String customerName = io.readStringOrDefault("Customer name (%s): ", 
                currentCustomerName, currentCustomerName);
        String stateName = io.readStringOrDefault("State (%s): ", 
                currentStateName, currentStateName);
        String productType = io.readStringOrDefault("Product name (%s): ", 
                currentProductType, currentProductType);
        String areaAsString = io.readStringOrDefault("Area (%s): ", 
                currentAreaAsString, currentAreaAsString);
        BigDecimal area = io.validateBigDecimal(areaAsString);

        
        currentOrder.setCustomerName(customerName);
        currentOrder.setState(new State(stateName));
        currentOrder.setProduct(new Product(productType));
        currentOrder.setArea(area);
        
        return currentOrder;
    }
    
    
     public void displayEditOrderSuccess() {
        io.print("Your order has been successfully edited.");
    }

    public void displayErrorMessage(String errorMessage) {
        io.print(errorMessage);
    }

    public void displayGoodbyeMessage() {
        io.print("Thank you for shopping with "
                + "Flooring Emporium! Goodbye.");
    }

    public void displayRemoveBanner() {
        io.print("Please enter the date"
                + " for which you would like to remove an order.");
        io.print("=================");
    }

    public int getOrderId() {
        int orderId = io.readInt("Please enter the order id: ");
        return orderId;
    }

    public String displayOrderToRemoveAndGetConfirmation(Order orderToRemove) {
        io.print("\n Order to be removed: ");
        io.print("===========================");
        io.print("Customer name: " + orderToRemove.getCustomerName());
        io.print("State: " + orderToRemove.getState().getStateName());
        io.print("Product name: " + orderToRemove.getProduct().getProductType());
        io.print("Area: " + orderToRemove.getArea() + " sq. feet");

        io.print("=================");
        String userResponse = io.readString("Are you sure you would like to "
                + "permanently delete this order? (Y/N)");

        return userResponse;

    }

    public void displayRemoveOrderSuccess() {
        io.print("This order has been successfully removed from our database.");
    }

    public void displayRemoveOrderDiscarded() {
        io.print("Order changes have been discarded. "
                + "Your order was not removed from our database.");
    }

}
