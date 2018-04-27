
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
public class WarmUpLists {
    public static void main(String[] args) {
        List<Integer> array1 = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 6);
        List<Integer> array2 = Arrays.asList(1, 1, 2, 2, 7, 8, 9);
        
        List<Integer> newArray = intersect(array1, array2);
        System.out.println("New array: " + newArray);
        
        BigDecimal first = new BigDecimal("4.6");
        BigDecimal second = new BigDecimal("4.3");
        
        int answer = first.compareTo(second);
        
        System.out.println("Answer: " + answer);
        
    }
    
    //Take in 2 lists, return one list with all values that are contained in both lists
    public static List<Integer> intersect(List<Integer> a, List<Integer> b) {
        List<Integer> resultList = a.stream()
                .filter(number -> b.contains(number))
                .distinct()
                .collect(Collectors.toList());
        return resultList;
    }
    
    
    
    
}
