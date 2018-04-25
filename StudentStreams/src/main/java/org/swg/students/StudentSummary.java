/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.swg.students;

/**
 *
 * @author emmastout
 */
public class StudentSummary {
    private String country;
    private String major;
    private double IQ;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getIQ() {
        return IQ;
    }

    public void setIQ(double IQ) {
        this.IQ = IQ;
    }
    
    StudentSummary(Student student) {
        this.IQ = student.getIq();
        this.country = student.getCountry();
        this.major = student.getMajor();
    }

    @Override
    public String toString() {
        return "StudentSummary{" + "country=" + country + ", major=" + major + ", IQ=" + IQ + '}';
    }
    
    
}
