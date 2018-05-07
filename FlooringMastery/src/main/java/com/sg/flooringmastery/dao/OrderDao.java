/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.models.Order;
import com.sg.flooringmastery.service.DataException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author emmastout
 */
public interface OrderDao {
    public List<Order> getAllOrdersForDate(LocalDate date)
            throws FlooringMasteryPersistenceException;

    public Order addOrder(LocalDate date, Order order)
            throws FlooringMasteryPersistenceException, DataException;

    public Order updateOrder(LocalDate date, int orderId, Order order)
            throws FlooringMasteryPersistenceException;

    public Order removeOrder(LocalDate date, int orderId)
            throws FlooringMasteryPersistenceException;
    
    public Order getOrder(LocalDate date, int orderId) 
            throws FlooringMasteryPersistenceException;
}
