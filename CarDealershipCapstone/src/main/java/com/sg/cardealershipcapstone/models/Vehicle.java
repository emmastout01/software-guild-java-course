/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealershipcapstone.models;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author emmastout
 */
@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;
    private String vin;
    private String make;
    private String model;
    private String color;
    private String type;
    private String bodyStyle;
    private String transmission;
    private String interior;
    private int year;
    private BigDecimal msrp;
    private BigDecimal salePrice;
    private int mileage;
    private String description;
    private String photo;
    private boolean featured;
}
