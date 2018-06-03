
import java.time.LocalDate;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
public class TestCalendar {
    public static void main(String[] args) {
        int nextYear;
        LocalDate today = LocalDate.now();
        nextYear = today.getYear() + 1;
        System.out.println("next year:" + nextYear);
    }
}
