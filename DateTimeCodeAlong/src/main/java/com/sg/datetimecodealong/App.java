/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.datetimecodealong;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author emmastout
 */
public class App {

    public static void main(String[] args) {
        //Gives you today's date:
        LocalDate myDate = LocalDate.now();
        System.out.println("date: " + myDate);

        //Parses a string and reads a date from it
        myDate = LocalDate.parse("2015-01-01");

        //Parses a string, turns it into a date that fits the pattern we want
        myDate = LocalDate.parse("02/07/2010",
                DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(myDate);

        //Convert date to string and back
        String isodate = myDate.toString();

        myDate = LocalDate.parse(isodate);

        //Print date in mm/dd/yyyy format
        //Note: You can make up your own patterns for dates but we 
        //probably won't do that much
        String formatted
                = myDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        //Gives other formatting options
        formatted = myDate.format(DateTimeFormatter.
                ofLocalizedDate(FormatStyle.FULL));
        //Output = "Sunday, February 7th, 2010"

        //Calculating Past Dates, Future Dates, Difference Between Dates
        LocalDate past = myDate.minusDays(6);
        formatted = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));

        past = myDate.minusMonths(3);

        //Period between two dates:
        Period diff = myDate.until(past);
        //The format for this is kind of weird. Output here is P - 3M
        //To clarify, we could do:
        System.out.println(diff.getDays()); //This will show difference in days

        //LocalDate Times and conversion
        //This has time: Good for timeStamps
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("RIGHT NOW: " + ldt);
        formatted = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));

        //Old way of getting dates: Date object and GregorianCalendar object
        Date legacyDate = new Date();
        GregorianCalendar legacyCalendar = new GregorianCalendar();

        //Converting old dates into LocalDate:
        //1. Turn the legacyDate into an instant
        //Then, create a ZonedDateTime object using that instant
        //An instant is a representation of an instant in time
        ZonedDateTime zdt
                = ZonedDateTime.ofInstant(legacyDate.toInstant(),
                        ZoneId.systemDefault());
        
        //Now, turn ZDT into a LocalDate
        
        myDate = zdt.toLocalDate();

        //Converting calendar:
        //Same as above, but GregorianCalendar has a method for us that will
        //convert it right to ZonedDateTime.
        zdt = legacyCalendar.toZonedDateTime();
        
        myDate = zdt.toLocalDate();
        
    }

}
