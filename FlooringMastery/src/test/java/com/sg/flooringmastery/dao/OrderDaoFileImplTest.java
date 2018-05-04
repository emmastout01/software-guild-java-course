/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.models.Order;
import com.sg.flooringmastery.models.Product;
import com.sg.flooringmastery.models.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author emmastout
 */
public class OrderDaoFileImplTest {
    
    private OrderDao dao = new OrderDaoFileImpl();
    private LocalDate myDate = LocalDate.of(2017, Month.MARCH, 31);

    @Before
    public void setUp() throws Exception {

        List<Order> orderList = dao.getAllOrdersForDate(myDate);
       
        //Empty the file
        for(Order order : orderList) {
            dao.removeOrder(myDate, order.getOrderId());
        }
    }

    /**
     * Test of getAllOrdersForDate method, of class OrderDaoFileImpl.
     */
    @Test
    public void testGetAllOrdersForDate() throws Exception {
        addFakeOrder1();
        addFakeOrder2();
        
        assertEquals(2, dao.getAllOrdersForDate(myDate).size());
        
    }

    /**
     * Test of addOrder method, of class OrderDaoFileImpl.
     */
    @Test
    public void testAddGetOrder() throws Exception {
       
        Order myOrder = addFakeOrder1();
        Order daoOrder = dao.getOrder(myDate, 1);
        
        assertEquals(myOrder, daoOrder);
        
        myOrder = addFakeOrder2();
        daoOrder = dao.getOrder(myDate, 2);
        
        assertEquals(myOrder, daoOrder);
        
    }

    /**
     * Test of updateOrder method, of class OrderDaoFileImpl.
     */
    @Test
    public void testUpdateOrder() throws Exception {
        Order myOrder = addFakeOrder1();
        
        myOrder.setCustomerName("This is a test name");
        
        dao.updateOrder(myDate, myOrder.getOrderId(), myOrder);
        
        assertEquals("This is a test name", myOrder.getCustomerName());
        
    }

    /**
     * Test of removeOrder method, of class OrderDaoFileImpl.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        addFakeOrder1();
        addFakeOrder2();
        
        dao.removeOrder(myDate, 1);
        
        assertEquals(1, dao.getAllOrdersForDate(myDate).size());
        assertNull(dao.getOrder(myDate, 1));
        
        dao.removeOrder(myDate, 2);
        
        assertEquals(0, dao.getAllOrdersForDate(myDate).size());
        assertNull(dao.getOrder(myDate, 2));
    }
    
    
      private Order addFakeOrder1() throws Exception {
        BigDecimal area1 = new BigDecimal("50");
        BigDecimal materialCost1 = new BigDecimal("34.50");
        BigDecimal laborCost1 = new BigDecimal("20.47");
        BigDecimal tax1 = new BigDecimal("2.76");
        BigDecimal total1 = new BigDecimal("100.83");
        
        BigDecimal costPerSqFoot1 = new BigDecimal("3.50");
        BigDecimal laborCostPerSqFoot1 = new BigDecimal("5.00");
        
        Order order1 = new Order();
        
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
        
        dao.addOrder(myDate, order1);
        
        return order1;
        
    }
      
    private Order addFakeOrder2() throws Exception {
        BigDecimal area2 = new BigDecimal("300");
        BigDecimal materialCost2 = new BigDecimal("274.30");
        BigDecimal laborCost2 = new BigDecimal("107.48");
        BigDecimal tax2 = new BigDecimal("12.25");
        BigDecimal total2 = new BigDecimal("453.20");
        
        BigDecimal costPerSqFoot2 = new BigDecimal("2.50");
        BigDecimal laborCostPerSqFoot2 = new BigDecimal("4.00");
        
        Order order2 = new Order();
        
        State order2State = new State("Oregon");
        order2State.setTaxRate(BigDecimal.TEN);
        
        
        Product order2Product = new Product("Carpet");
        order2Product.setCostPerSqFoot(costPerSqFoot2);
        order2Product.setLaborCostPerSqFoot(laborCostPerSqFoot2);
        
        order2.setDate(myDate);
        order2.setCustomerName("Shir Tikvah");
        order2.setState(order2State);
        order2.setProduct(order2Product);
        order2.setArea(area2);
        order2.setMaterialCost(materialCost2);
        order2.setLaborCost(laborCost2);
        order2.setTax(tax2);
        order2.setTotal(total2);
        
        dao.addOrder(myDate, order2);
        
        return order2;
    }
      
      
}
