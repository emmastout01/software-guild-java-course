/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.dao.OrderDaoStubImpl;
import com.sg.flooringmastery.dao.ProductDao;
import com.sg.flooringmastery.dao.ProductDaoStubImpl;
import com.sg.flooringmastery.dao.StateDao;
import com.sg.flooringmastery.dao.StateDaoStubImpl;
import com.sg.flooringmastery.models.Order;
import com.sg.flooringmastery.models.Product;
import com.sg.flooringmastery.models.State;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author emmastout
 */
public class FlooringServiceTest {

    OrderDao odao = new OrderDaoStubImpl();
    ProductDao pdao = new ProductDaoStubImpl();
    StateDao sdao = new StateDaoStubImpl();

    FlooringService service = new FlooringService(odao, pdao, sdao);

    Product validProduct = new Product("Wood");
    Product invalidProduct = new Product("Concrete");

    State validState = new State("MN");
    State invalidState = new State("ZZ");

    BigDecimal validArea = new BigDecimal("400");
    BigDecimal invalidArea = new BigDecimal("-1");

    /**
     * Test of validateOrder method, of class FlooringService.
     */
    @Test
    public void testValidateOrderWithValidOrder() throws Exception {
        Order myOrder = new Order();
        myOrder.setCustomerName("New Customer");
        myOrder.setProduct(validProduct);
        myOrder.setState(validState);
        myOrder.setArea(validArea);

        assertEquals("",
                service.validateOrder(myOrder).getMessage());
    }

    /**
     * Test of validateOrder method, of class FlooringService.
     */
    @Test
    public void testValidateOrderNoCustomerName() throws Exception {
        Order myOrder = new Order();
        myOrder.setProduct(validProduct);
        myOrder.setState(validState);
        myOrder.setArea(validArea);

        assertEquals("Customer Name is required." + "\n",
                service.validateOrder(myOrder).getMessage());
    }

    /**
     * Test of validateOrder method, of class FlooringService.
     */
    @Test
    public void testValidateOrderInvalidProduct() throws Exception {
        Order myOrder = new Order();
        myOrder.setCustomerName("New Customer");
        myOrder.setProduct(invalidProduct);
        myOrder.setState(validState);
        myOrder.setArea(validArea);

        assertEquals("Product name not in our database. "
                + "Please check spelling." + "\n",
                service.validateOrder(myOrder).getMessage());
    }

    /**
     * Test of validateOrder method, of class FlooringService.
     */
    @Test
    public void testValidateOrderInvalidState() throws Exception {
        Order myOrder = new Order();
        myOrder.setCustomerName("New Customer");
        myOrder.setProduct(validProduct);
        myOrder.setState(invalidState);
        myOrder.setArea(validArea);

        assertEquals("That state abbreviation is not in our database. "
                + "Please check spelling and "
                + "confirm our services are available in your state." + "\n",
                service.validateOrder(myOrder).getMessage());
    }

    /**
     * Test of validateOrder method, of class FlooringService.
     */
    @Test
    public void testValidateOrderNegativeArea() throws Exception {

        Order myOrder = new Order();
        myOrder.setCustomerName("New Customer");
        myOrder.setProduct(validProduct);
        myOrder.setState(validState);
        myOrder.setArea(invalidArea);

        assertEquals("Area is required and must be a positive value." + "\n",
                service.validateOrder(myOrder).getMessage());
    }

    /**
     * Test of validateOrder method, of class FlooringService.
     */
    @Test
    public void testValidateOrderNoArea() throws Exception {
        Order myOrder = new Order();
        myOrder.setCustomerName("New Customer");
        myOrder.setProduct(validProduct);
        myOrder.setState(validState);

        assertEquals("Area is required and must be a positive value." + "\n",
                service.validateOrder(myOrder).getMessage());

    }

    /**
     * Test of validateOrder method, of class FlooringService.
     */
    @Test
    public void testValidateOrderAllInvalidData() throws Exception {
        Order myOrder = new Order();
        myOrder.setState(invalidState);
        myOrder.setProduct(new Product(""));
        myOrder.setArea(invalidArea);

        assertEquals(
                "Customer Name is required." + "\n"
                + "Product Type is required." + "\n"
                + "Area is required and must be a positive value." + "\n"
                + "Product name not in our database. "
                + "Please check spelling." + "\n"
                + "That state abbreviation is not in our database. "
                + "Please check spelling and "
                + "confirm our services are available in your state." + "\n",
                service.validateOrder(myOrder).getMessage());

    }

    /**
     * Test of validateOrder method, of class FlooringService.
     */
    @Test
    public void testValidateOrderNoAreaAndInvalidState() throws Exception {
        Order myOrder = new Order();
        myOrder.setCustomerName("New Customer");
        myOrder.setProduct(validProduct);
        myOrder.setState(invalidState);

        assertEquals("Area is required and must be a positive value." + "\n"
                + "That state abbreviation is not in our database. "
                + "Please check spelling and "
                + "confirm our services are available in your state." + "\n",
                service.validateOrder(myOrder).getMessage());

    }

    /**
     * Test of calculateOrderTotals method, of class FlooringService.
     */
    @Test
    public void testCalculateOrderTotals() throws Exception {
        Order myOrder = new Order();
        myOrder.setCustomerName("New Customer");
        myOrder.setProduct(validProduct);
        myOrder.setState(validState);
        myOrder.setArea(validArea);
        
        service.calculateOrderTotals(myOrder);
        
        BigDecimal expectedMaterialCost = new BigDecimal("800.00");
        BigDecimal expectedLaborCost = new BigDecimal("1200.00");
        BigDecimal expectedTax = new BigDecimal("100.00");
        BigDecimal expectedTotal = new BigDecimal("2100.00");
        
        assertEquals(expectedMaterialCost, myOrder.getMaterialCost());
        assertEquals(expectedLaborCost, myOrder.getLaborCost());
        assertEquals(expectedTax, myOrder.getTax());
        assertEquals(expectedTotal, myOrder.getTotal());

    }

    /**
     * Test of addOrderConfirmed method, of class FlooringService.
     */
    @Test
    public void testAddOrderConfirmed() throws Exception {
        Order myOrder = new Order();
        myOrder.setCustomerName("New Customer");
        myOrder.setProduct(validProduct);
        myOrder.setState(validState);
        myOrder.setArea(validArea);
        
        service.calculateOrderTotals(myOrder);
        
        assertEquals("", service.addOrderConfirmed(myOrder).getMessage());
    }

}
