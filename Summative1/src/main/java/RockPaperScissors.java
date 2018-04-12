/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        Random rand = new Random();
        int currentRound;
        int totalRounds;
        int ties = 0;
        int compWins = 0;
        int userWins = 0;
        String userChoiceString = "";
        int userChoice = 0;
        int compChoice;
        String gameWinner = "";
        String playAgain = "";
        
        
        System.out.println("ROCK, PAPER, SCISSORS");
        System.out.println("---------------------");
        
        do{
        currentRound = 1;
        ties = 0;
        compWins = 0;
        userWins = 0;
        //Get number of rounds from user
        System.out.println("How many rounds would you like to play? "
                + "Choose a number between 1 and 10.");
        totalRounds = inputReader.nextInt();
        inputReader.nextLine();
        
        //If user enters an invalid round number, exit the program.
        if(totalRounds < 1 || totalRounds > 10) {
            System.out.println("ERROR: Number of rounds must be between 1 and 10.");
            break;
        }
        
        //Loop through rounds; while current round < totalRounds, keep going.
        while(currentRound <= totalRounds) {
            //Ask user: Rock, paper scissors? and assign userChoice
            System.out.println("Rock, Paper, Scissors?");
            userChoiceString = inputReader.nextLine();
 
            //Convert user choice to an integer (1, 2 or 3)
            if(userChoiceString.equals("Rock") || 
                    userChoiceString.equals("rock")) {
                userChoice = 1;
            } else if(userChoiceString.equals("Paper") || 
                    userChoiceString.equals("paper")) {
                userChoice = 2;
            } else if(userChoiceString.equals("Scissors") || 
                    userChoiceString.equals("scissors")) {
                userChoice = 3;
            } else {
                System.out.println("Hey, you didn't enter Rock, Paper or Scissors!");
                break;
            }
            
            //Randomly choose Rock, paper or scissors and assign compChoice
            compChoice = rand.nextInt(3) + 1;
        
            //Compare userChoice and compChoice; determine round winner
            //Print round winner to console
            
            if (compChoice == userChoice) {
                ties ++;
                System.out.println("It's a tie!");
            } else if (compChoice > userChoice || 
                    compChoice == 1 && userChoice == 3) {
                compWins ++;
                System.out.println("Computer wins this round!");
            } else if (userChoice > compChoice || 
                    userChoice == 1 && compChoice == 3) {
                userWins ++;
                System.out.println("You win this round!");
            }
            
            //Increase currentRound
            currentRound++;
        }
        
        //Exit loop
        
        //Determine game winner
        if(compWins > userWins) {
            gameWinner = "Computer";
        } else if (userWins > compWins) {
            gameWinner = "You!";
        } else if (compWins == userWins) {
            gameWinner = "It's a tie!";
        }
        
        
        //Print total scores to console and declare a game winner
        System.out.println("GAME RECAP");
        System.out.println("-----------");
        System.out.println("Game winner: " + gameWinner);
        System.out.println("Ties: " + ties);
        System.out.println("Computer wins: " + compWins);
        System.out.println("User wins: " + userWins);
        
        //Ask user: play again?
        System.out.println("Play again? Y/N");
        playAgain = inputReader.next();
        
            if(playAgain.equals("Y") || playAgain.equals("y")) {
            continue;
            } else if (playAgain.equals("N") || playAgain.equals("n")) {
                System.out.println("Thanks for playing!");
                break;
            }
        } while(true);
        
        
        
    }
    
    

}


