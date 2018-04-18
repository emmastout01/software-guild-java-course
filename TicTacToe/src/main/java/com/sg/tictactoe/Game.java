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

public class Game {

    Scanner inputReader = new Scanner(System.in);
    HumanPlayer player = new HumanPlayer();
    ComputerPlayer computer = new ComputerPlayer();
    int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    public void playGame() {
        while (!isWin()) {
            this.drawBoard();
            this.playerMove();
            this.computerMove();
        }
        this.drawBoard();
        System.out.println("Thanks for playing!");
    }

    public void playerMove() {
        int playerMove = player.selectMove(board);
        board[playerMove] = 1;
    }
    
    public void computerMove () {
        int computerMove = computer.selectMove(board);
        board[computerMove] = -1;
    }

    public boolean isWin() {
        return 
        isRowWin(0)
                || isRowWin(1)
                || isRowWin(2)
                || isColWin(0)
                || isColWin(1)
                || isColWin(2)
                || isDiagWin(0)
                || isDiagWin(2);
    }

    public boolean isRowWin(int row) {
        int rowOffset = row * 3;
        return (board[rowOffset] != 0
                && board[rowOffset] == board[rowOffset + 1]
                && board[rowOffset + 1] == board[rowOffset + 2]);
    }

    public boolean isColWin(int column) {
        return (board[column] != 0
                && board[column] == board[column + 3]
                && board[column + 3] == board[column + 6]);
    }

    public boolean isDiagWin(int diag) {
        if(diag == 0) {
            return (board[diag] != 0
                && board[diag] == board[4]
                && board[4] == board[8]);
        } else if (diag == 2) {
             return (board[diag] != 0
                && board[diag] == board[4]
                && board[4] == board[6]);
        }
        return false;
    }
    
    private void drawBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int move = board[row * 3 + col];
                if (move == 1) {
                    System.out.print("X ");
                } else if (move == -1) {
                    System.out.print("O ");
                } else if (move == 0) {
                    System.out.print("_ ");
                }
            }
            System.out.println("");
        }
    }
    
}
