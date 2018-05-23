/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.jewishholidayslist.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author emmastout
 */
public class Holiday {
    
    private int id;
    @NotNull
    @Size(min=1, message="Holiday name is required.")
    private String holidayName;
    
    @NotNull
    @Size(min=1, message="Holiday start date is required.")
    private String startDate;
    private String endDate;
    
    @NotNull
    @Size(max=100, message="Description maximum is 100 characters.")
    private String description;

//    public Holiday(String holidayName, String startDate, String endDate, String description) {
//        this.holidayName = holidayName;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.description = description;
//    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
