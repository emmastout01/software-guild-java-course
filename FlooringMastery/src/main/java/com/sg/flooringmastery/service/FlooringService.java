/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.dao.ProductDao;
import com.sg.flooringmastery.dao.StateDao;
import com.sg.flooringmastery.models.Order;
import com.sg.flooringmastery.models.Product;
import com.sg.flooringmastery.models.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class FlooringService {

    private OrderDao orderDao;
    private ProductDao productDao;
    private StateDao stateDao;

    public FlooringService(OrderDao orderDao, ProductDao productDao, StateDao stateDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.stateDao = stateDao;
    }

    public ValidationResponse<Order> validateOrder(Order orderIn)
            throws FlooringMasteryPersistenceException {

        ValidationResponse<Order> result = getValidationResult(orderIn);
        if (!result.isSuccess()) {
            return result;
        }


        return result;

    }

    private ValidationResponse<Order> getValidationResult(Order orderIn)
            throws FlooringMasteryPersistenceException {
        ValidationResponse<Order> result = new ValidationResponse<>();

        List<Product> productList = productDao.getAllProducts();
        List<State> stateList = stateDao.getAllStates();
        String productName = orderIn.getProduct().getProductType();
        String stateName = orderIn.getState().getStateName();
        boolean isValidProduct = false;
        boolean isValidState = false;

        for (Product product : productList) {
            if (productName.equalsIgnoreCase(product.getProductType())) {
                isValidProduct = true;
            }
        }
        for (State state : stateList) {
            if (stateName.equalsIgnoreCase(state.getStateName())) {
                isValidState = true;
            }
        }
        
        if (!hasValue(orderIn.getCustomerName())) {
            result.addToMessage("Customer Name is required.");
        }
        if (!hasValue(orderIn.getProduct().getProductType())) {
            result.addToMessage("Product Type is required.");
        }
        if (!hasValue(orderIn.getState().getStateName())) {
            result.addToMessage("State Abbr is required.");
        }
        if (orderIn.getArea() == null || orderIn.getArea().compareTo(BigDecimal.ZERO) == -1) {
            result.addToMessage("Area is required and must be a positive value.");
        }

        if (!isValidProduct) {
            result.addToMessage("Product name not in our database. "
                    + "Please check spelling.");
        }

        if (!isValidState) {
            result.addToMessage("That state abbreviation is not in our database. "
                    + "Please check spelling and "
                    + "confirm our services are available in your state.");
        }

        return result;
    }

    private boolean hasValue(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public Order calculateOrderTotals(Order orderIn)
            throws FlooringMasteryPersistenceException {

        String productType = orderIn.getProduct().getProductType();
        String stateName = orderIn.getState().getStateName();

        Product orderProduct = productDao.getProduct(productType);
        State orderState = stateDao.getState(stateName);

        orderIn.setProduct(orderProduct);
        orderIn.setState(orderState);

        BigDecimal area = orderIn.getArea();

        BigDecimal materialCost = calculateMaterialCost(productType, area);
        BigDecimal laborCost = calculateLaborCost(productType, area);

        BigDecimal preTaxTotal = materialCost.add(laborCost);
        BigDecimal orderTax = calculateOrderTax(preTaxTotal, stateName);

        BigDecimal orderTotal = calculateOrderTotal(preTaxTotal, orderTax);

        orderIn.setMaterialCost(materialCost);
        orderIn.setLaborCost(laborCost);
        orderIn.setTax(orderTax);
        orderIn.setTotal(orderTotal);

        return orderIn;
    }

    public Order addOrderConfirmed(Order addedOrder)
            throws FlooringMasteryPersistenceException {
        try {
            orderDao.addOrder(LocalDate.now(), addedOrder);
        } catch (DataException ex) {
        }
        return addedOrder;
    }

    public List<Order> getAllOrders(LocalDate date)
            throws FlooringMasteryPersistenceException {
        return orderDao.getAllOrdersForDate(date);
    }

    public List<Product> getAllProducts()
            throws FlooringMasteryPersistenceException {
        return productDao.getAllProducts();
    }

    public Order getOrder(LocalDate date, int orderId)
            throws FlooringMasteryPersistenceException {
        return orderDao.getOrder(date, orderId);
    }

    public Order editOrder(LocalDate date, int orderId, Order editedOrder)
            throws FlooringMasteryPersistenceException {
        return orderDao.updateOrder(date, orderId, editedOrder);
    }

    public Order removeOrder(int orderIn, LocalDate date)
            throws FlooringMasteryPersistenceException {
        Order orderToRemove = orderDao.removeOrder(date, orderIn);
        return orderToRemove;
    }

    private BigDecimal calculateOrderTotal(BigDecimal preTaxTotal, BigDecimal orderTax)
            throws FlooringMasteryPersistenceException {
        //Add those together
        BigDecimal total = preTaxTotal.add(orderTax);

        //Return total
        return total;
    }

    private BigDecimal calculateOrderTax(BigDecimal preTaxTotal, String stateName)
            throws FlooringMasteryPersistenceException {
        //Get state for the order, and get that state's tax rate
        State state = stateDao.getState(stateName);

        BigDecimal oneHundred = new BigDecimal("100");
        BigDecimal taxRate = state.getTaxRate().divide(oneHundred);

        //Multiply the tax rate by the pre-tax total
        BigDecimal orderTax = preTaxTotal.multiply(taxRate);

        //Return orderTax
        return orderTax;
    }

    private BigDecimal calculateMaterialCost(String productType, BigDecimal area)
            throws FlooringMasteryPersistenceException {
        //Grab product from the product dao and find that product's material cost per sq foot
        Product myProduct = productDao.getProduct(productType);

        BigDecimal materialCostPerSqFoot = myProduct.getCostPerSqFoot();

        //Multiply the cost per sq foot by the area
        BigDecimal materialCost = materialCostPerSqFoot.multiply(area);

        //Return material cost
        return materialCost;
    }

    private BigDecimal calculateLaborCost(String productType, BigDecimal area)
            throws FlooringMasteryPersistenceException {
        //Grab product from the product dao and find that product's labor cost per sq foot
        Product myProduct = productDao.getProduct(productType);

        BigDecimal laborCostPerSqFoot = myProduct.getLaborCostPerSqFoot();

        //Multiply the cost per sq foot by the area
        BigDecimal laborCost = laborCostPerSqFoot.multiply(area);

        //Return material cost
        return laborCost;
    }

}
