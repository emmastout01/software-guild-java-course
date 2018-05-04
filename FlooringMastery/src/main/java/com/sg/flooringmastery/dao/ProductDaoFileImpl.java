/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.models.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author emmastout
 */
public class ProductDaoFileImpl implements ProductDao {
    
    public static final String DELIMITER = "::";
    public static final String PRODUCT_LIST = "products.txt";
    private Map<String, Product> productList = new HashMap<>();

    @Override
    public List<Product> getAllProducts() 
            throws FlooringMasteryPersistenceException {
        loadProducts();
        return new ArrayList<>(productList.values());
    }

    @Override
    public Product getProduct(String productType) 
            throws FlooringMasteryPersistenceException {
        loadProducts();
        return productList.get(productType);
    }
    
    
    private void loadProducts() throws FlooringMasteryPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCT_LIST)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "Could not load product list.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Product currentProduct = new Product(currentTokens[0]);
            
            BigDecimal costPerSqFoot = new BigDecimal(currentTokens[1]);
            BigDecimal laborCostPerSqFoot = new BigDecimal(currentTokens[2]);
            
            currentProduct.setCostPerSqFoot(costPerSqFoot);
            currentProduct.setLaborCostPerSqFoot(laborCostPerSqFoot);
            
            productList.put(currentProduct.getProductType(), currentProduct);
        }
        scanner.close();
    }
}
