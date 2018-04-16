/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tictactoe;

/**
 *
 * @author emmastout
 */

import java.util.Scanner;

public class HumanPlayer {
    Scanner inputReader = new Scanner(System.in);
      
   public int selectMove(int[] board) {
        boolean isValid = false;
        int nextMove = 0;
        while(!isValid) {
             System.out.println("What's your next move?");
            nextMove = inputReader.nextInt();
            if (nextMove >= 0 && nextMove <= 8) {
                if(board[nextMove] == 0) {
                    isValid = true;
                }
            }
        }
    return nextMove;
   }
    
   
    
}
