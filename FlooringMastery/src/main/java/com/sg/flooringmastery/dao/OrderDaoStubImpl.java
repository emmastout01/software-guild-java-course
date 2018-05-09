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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emmastout
 */
public class OrderDaoStubImpl implements OrderDao {

    Order order1;
    private LocalDate myDate = LocalDate.of(2017, Month.MARCH, 31);
    List<Order> orderList = new ArrayList<>();

    public OrderDaoStubImpl() {
        BigDecimal area1 = new BigDecimal("50");
        BigDecimal materialCost1 = new BigDecimal("34.50");
        BigDecimal laborCost1 = new BigDecimal("20.47");
        BigDecimal tax1 = new BigDecimal("2.76");
        BigDecimal total1 = new BigDecimal("100.83");

        BigDecimal costPerSqFoot1 = new BigDecimal("3.50");
        BigDecimal laborCostPerSqFoot1 = new BigDecimal("5.00");

        order1 = new Order();

        State order1State = new State("Minnesota");
        order1State.setTaxRate(BigDecimal.TEN);

        Product order1Product = new Product("Wood floor");
        order1Product.setCostPerSqFoot(costPerSqFoot1);
        order1Product.setLaborCostPerSqFoot(laborCostPerSqFoot1);

        order1.setDate(myDate);
        order1.setCustomerName("Beth Jacob");
        order1.setState(order1State);
        order1.setProduct(order1Product);
        order1.setArea(area1);
        order1.setMaterialCost(materialCost1);
        order1.setLaborCost(laborCost1);
        order1.setTax(tax1);
        order1.setTotal(total1);

        orderList.add(order1);
    }

    @Override
    public List<Order> getAllOrdersForDate(LocalDate date) throws FlooringMasteryPersistenceException {
       return orderList;     
    }

    @Override
    public Order addOrder(LocalDate date, Order order) throws FlooringMasteryPersistenceException, DataException {
//        if (date == myDate && order.getOrderId() == order1.getOrderId()) {
//            return order1;
//        } else {
//            return null;
//        }
    }

    @Override
    public Order updateOrder(LocalDate date, int orderId, Order order) throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order removeOrder(LocalDate date, int orderId) throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getOrder(LocalDate date, int orderId) throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
