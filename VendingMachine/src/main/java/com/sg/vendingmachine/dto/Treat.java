/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author emmastout
 */
public class Treat {
    private int treatId;
    private String name;
    private BigDecimal cost;
    private int inventory;

    public int getTreatId() {
        return treatId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInventory() {
        return inventory;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    
    public Treat(int treatId) {
        this.treatId = treatId;
    }
    
}
