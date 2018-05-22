/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.jewishholidayslist.models;

import java.time.LocalDate;

/**
 *
 * @author emmastout
 */
public class Holiday {
    private String holidayName;
    private String startDate;
    private String endDate;
    private String description;

    public Holiday(String holidayName, String startDate, String endDate, String description) {
        this.holidayName = holidayName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
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
