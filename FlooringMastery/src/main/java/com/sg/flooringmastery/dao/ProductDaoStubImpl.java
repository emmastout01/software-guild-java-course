/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.models.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author emmastout
 */
public class ProductDaoStubImpl implements ProductDao {

    private Map<String, Product> productList = new HashMap<>();
    
    public ProductDaoStubImpl() {
        
        BigDecimal cost = new BigDecimal("2");
        BigDecimal laborCost = new BigDecimal("3");
        
        Product product1 = new Product("Wood");
        Product product2 = new Product("Laminate");
       
        product1.setCostPerSqFoot(cost);
        product1.setLaborCostPerSqFoot(laborCost);
        
        product2.setCostPerSqFoot(cost);
        product2.setLaborCostPerSqFoot(laborCost);
        
        productList.put(product1.getProductType(), product1);
        productList.put(product2.getProductType(), product2);
    }
    
    @Override
    public List<Product> getAllProducts() throws FlooringMasteryPersistenceException {
      return new ArrayList<>(productList.values());
    }

    @Override
    public Product getProduct(String productType) throws FlooringMasteryPersistenceException {
      return productList.get(productType);
    }
    
}
