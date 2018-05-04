/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.models;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author emmastout
 */
public class Product {
    private String productType;
    private BigDecimal costPerSqFoot;
    private BigDecimal laborCostPerSqFoot;

    public String getProductType() {
        return productType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.productType);
        hash = 89 * hash + Objects.hashCode(this.costPerSqFoot);
        hash = 89 * hash + Objects.hashCode(this.laborCostPerSqFoot);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.costPerSqFoot, other.costPerSqFoot)) {
            return false;
        }
        if (!Objects.equals(this.laborCostPerSqFoot, other.laborCostPerSqFoot)) {
            return false;
        }
        return true;
    }

    public BigDecimal getCostPerSqFoot() {
        return costPerSqFoot;
    }

    public Product(String productType) {
        this.productType = productType;
    }

    public void setCostPerSqFoot(BigDecimal costPerSqFoot) {
        this.costPerSqFoot = costPerSqFoot;
    }

    public void setLaborCostPerSqFoot(BigDecimal laborCostPerSqFoot) {
        this.laborCostPerSqFoot = laborCostPerSqFoot;
    }

    public BigDecimal getLaborCostPerSqFoot() {
        return laborCostPerSqFoot;
    }
}
