
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
public class getMatchingNumbers {
    public static void main(String[] args) {
        List<Integer> ticketNumbers = new ArrayList<>();
        
        ticketNumbers.add(1);
        ticketNumbers.add(2);
        ticketNumbers.add(3);
        ticketNumbers.add(4);
        ticketNumbers.add(5);
        
        List<Integer> powerballNumbers = new ArrayList<>();
        
        powerballNumbers.add(5);
        powerballNumbers.add(4);
        powerballNumbers.add(7);
        powerballNumbers.add(8);
        powerballNumbers.add(9);
        
        System.out.println(getMatchingNumbers.getMatchingNumbers(ticketNumbers, powerballNumbers));
        
        
    }
    
        private static int getMatchingNumbers
        (List<Integer> ticketNumbers, List<Integer> powerballNumbers) {
            int matchingNumbers = 0;
             for (int number : ticketNumbers) {
                for (int pnumber : powerballNumbers) {
                    if (number == pnumber) {
                        matchingNumbers++;
                    }
                }
            }
             return matchingNumbers;
        }
}
