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
import java.util.Random;

public class ComputerPlayer {

    Random rando = new Random();

    public int selectMove(int[] board) {
        boolean isValid = false;
int computerPlayer = 0;
        while (!isValid) {
             computerPlayer = rando.nextInt(8);
            if (computerPlayer >= 0 && computerPlayer <= 8) {
                if (board[computerPlayer] == 0) {
                    isValid = true;

                }
            }
        }
        return computerPlayer;
    }
}
