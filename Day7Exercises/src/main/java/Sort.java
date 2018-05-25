
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author emmastout
 */
public class Sort {

    public static void main(String[] args) {
        int[] myArray = Sort.randomArr(6);
        int[] resultArray = Sort.bubbleSort(myArray);
//        int[] resultArray = Sort.sortArr(myArray);
        String resultArrString = Arrays.toString(resultArray);
        System.out.println("Result: " + resultArrString);
    }

    public static int[] randomArr(int length) {
        Random r = new Random();
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = r.nextInt(250000) - 125000;
        }
        return result;
    }

//    public static int[] sortArr(int[] arr) {
//        int[] resultArr = new int[arr.length];
//        int min = Integer.MAX_VALUE;
//
//        for (int i = 0; i < arr.length; i++) {
////            for (int j = 0; j <; j++) {
////
////            }
//            if (arr[i] < min) {
//                resultArr[0] = arr[i];
//                arr[i] = min;
//            }
//        }
//        return resultArr;
//    }

    public static int[] bubbleSort(int[] arr) {
       
        for (int i = (arr.length - 1); i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
       return arr; 
    }
    
}
