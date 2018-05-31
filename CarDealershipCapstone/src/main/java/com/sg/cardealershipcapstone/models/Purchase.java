/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealershipcapstone.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author emmastout
 */

@Data
@Entity
public class Purchase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int purchaseId;
    private String name;
    private String phone;
    private String email;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipCode;
    private LocalDate purchaseDate;
    private String purchaseType;
    
    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;
    
    @OneToOne
    @JoinColumn(name = "VehicleId")
    private Vehicle vehicle;
    
    private BigDecimal purchasePrice;
}
