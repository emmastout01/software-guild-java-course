/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.models.Order;
import com.sg.flooringmastery.models.Product;
import com.sg.flooringmastery.models.State;
import com.sg.flooringmastery.service.DataException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author emmastout
 */
public class OrderDaoFileImpl implements OrderDao {

    private final String DELIMITER = "::";
    private final Map<Integer, Order> orderList = new HashMap<>();

    @Override
    public List<Order> getAllOrdersForDate(LocalDate date)
            throws FlooringMasteryPersistenceException {
        loadOrders(date);
        return orderList.values().stream()
                .filter(o -> o.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public Order addOrder(LocalDate date, Order order)
            throws FlooringMasteryPersistenceException,
            DataException {

        int orderId;

        List<Order> orders = getAllOrdersForDate(date);

        if (orders.size() > 0) {
            int maxIdForDate = orders.stream()
                    .mapToInt(o -> o.getOrderId())
                    .max()
                    .getAsInt();
            orderId = maxIdForDate + 1;
        } else {
            orderId = 1;
        }

        order.setOrderId(orderId);
        order.setDate(date);

        orderList.put(orderId, order);
        writeOrders(orderList.values(), date);
        return order;
    }

    @Override
    public Order getOrder(LocalDate date, int orderId) throws FlooringMasteryPersistenceException {
        loadOrders(date);
        Order myOrder = orderList.get(orderId);
        return myOrder;
    }

    @Override
    public Order updateOrder(LocalDate date, int orderId, Order order)
            throws FlooringMasteryPersistenceException {
        loadOrders(date);
        orderList.put(orderId, order);
        writeOrders(orderList.values(), date);
        return order;
    }

    @Override
    public Order removeOrder(LocalDate date, int orderId)
            throws FlooringMasteryPersistenceException {
        loadOrders(date);
        Order removedOrder = orderList.remove(orderId);
        writeOrders(orderList.values(), date);
        return removedOrder;
    }

    private void loadOrders(LocalDate date) throws FlooringMasteryPersistenceException {
        Scanner scanner;

        String fileName = getFileName(date);
        File file = new File(fileName);

        if (!file.exists()) {
            return;
        }

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(fileName)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "Could not load order into file.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            int orderId = Integer.parseInt(currentTokens[0]);

            Order currentOrder = new Order(orderId);

            LocalDate myDate = LocalDate.parse(currentTokens[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            currentOrder.setDate(myDate);

            currentOrder.setCustomerName(currentTokens[2]);

            State stateInOrder = new State(currentTokens[3]);

            BigDecimal taxRate = new BigDecimal(currentTokens[4]);
            stateInOrder.setTaxRate(taxRate);

            currentOrder.setState(stateInOrder);

            Product productInOrder = new Product(currentTokens[5]);
            BigDecimal costPerSqFoot = new BigDecimal(currentTokens[7]);
            productInOrder.setCostPerSqFoot(costPerSqFoot);
            BigDecimal laborCostPerSqFoot = new BigDecimal(currentTokens[8]);
            productInOrder.setLaborCostPerSqFoot(laborCostPerSqFoot);

            currentOrder.setProduct(productInOrder);

            BigDecimal area = new BigDecimal(currentTokens[6]);
            currentOrder.setArea(area);

            BigDecimal materialCost = new BigDecimal(currentTokens[9]);
            currentOrder.setMaterialCost(materialCost);

            BigDecimal laborCost = new BigDecimal(currentTokens[10]);
            currentOrder.setLaborCost(laborCost);

            BigDecimal tax = new BigDecimal(currentTokens[11]);
            currentOrder.setTax(tax);

            BigDecimal total = new BigDecimal(currentTokens[12]);
            currentOrder.setTotal(total);

            orderList.put(currentOrder.getOrderId(), currentOrder);
        }
        scanner.close();
    }

    private void writeOrders(Collection<Order> orderList, LocalDate date) throws
            FlooringMasteryPersistenceException {

        String fileName = getFileName(date);

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(fileName));
            //I don't think this is the right exception here...
        } catch (IOException e) {
            throw new FlooringMasteryPersistenceException("Could not save order data.", e);
        }

        for (Order currentOrder : orderList) {

            //If the order date matches the date argument, add the order to the file
            if (date.equals(currentOrder.getDate())) {
                State currentOrderState = currentOrder.getState();
                Product currentOrderProduct = currentOrder.getProduct();

                out.println(currentOrder.getOrderId() + DELIMITER
                        + currentOrder.getDate() + DELIMITER
                        + currentOrder.getCustomerName() + DELIMITER
                        + currentOrderState.getStateName() + DELIMITER
                        + currentOrderState.getTaxRate() + DELIMITER
                        + currentOrderProduct.getProductType() + DELIMITER
                        + currentOrder.getArea() + DELIMITER
                        + currentOrderProduct.getCostPerSqFoot() + DELIMITER
                        + currentOrderProduct.getLaborCostPerSqFoot() + DELIMITER
                        + currentOrder.getMaterialCost() + DELIMITER
                        + currentOrder.getLaborCost() + DELIMITER
                        + currentOrder.getTax() + DELIMITER
                        + currentOrder.getTotal());
                out.flush();
            }

        }
        out.close();
    }

    private String getFileName(LocalDate date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        String dateParsedIntoString = date.format(formatter);
        String fileName = "ORDER_" + dateParsedIntoString;

        return fileName;
    }

}
