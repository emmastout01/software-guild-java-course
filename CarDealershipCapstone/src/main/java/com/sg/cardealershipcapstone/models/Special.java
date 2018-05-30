/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealershipcapstone.models;

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
public class Special {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specialId;
    private String title;
    private String description;
}
