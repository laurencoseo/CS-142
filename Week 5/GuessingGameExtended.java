// Week 5 Assignment (Extended)
// CS 142
// 5/11/21


// This program creates a guessing game where the user needs to
// guess what the random number is until they get it right!
// And I extended it to ask the user if they want to play again
// and provide them stats based on their guesses per game


// import util package for the Scanner class
import java.util.*;

public class GuessingGameExtended {

    public static void main(String[] args) {
        
        giveIntro();
        
        // variable for random number
        int answer = getRandomNumber();
        
        // variable for user's guess
        int guess = getGuess();
        
        // count guesses
        int totalGuesses = playGame(guess, answer);

        // count number of games played
        int timesPlayed = 1;
        
        // repeat game if player wants to
        while (playAgain()) {
            timesPlayed++;              // increment times played
            answer = getRandomNumber(); // new random number
            System.out.println("New game! New number!");
            // variable for user's guess
            guess = getGuess();
            int guesses = playGame(guess, answer);
            totalGuesses += guesses;    // keep track of total guesses
        }
        
        // average numbers of guesses for x number of games
        double avg = (double)totalGuesses/(double)timesPlayed;
  
        // Print out stats if they play more than once!
        getStats(timesPlayed, avg);
    }
    
    // Guessing Game Introduction
    public static void giveIntro() {
        System.out.println("The computer picked a number between"
                + " 1 and 100. Guess the number and win!");
    }
    
    // This method returns a random number between 1 and 100.
    public static int getRandomNumber() {
        int randomNumber = (int)(Math.random()*100) + 1;
        return randomNumber;
    }

    // This method returns the user's guess
    public static int getGuess() {
        Scanner console = new Scanner(System.in);
        
        // Prompt for user input
        System.out.print("Type in your guess:");
        
        // Save user input
        int guess = console.nextInt();
        
        // Start a new line
        System.out.println();
        
        // return user's guess
        return guess;
    }
    
    // The Game!
    public static int playGame(int guess, int answer) {
     // variable for number of guesses
        int count = 1;
        
        while (guess != answer) {
            System.out.print("Not quite! ");
            
            // check if the guess is above or below the random number
            if (guess < answer) {
                System.out.println("Your guess was too low. Guess again.");
            } else {
                System.out.println("Your guess was too high. Guess again.");
            }
            System.out.println();
            guess = getGuess();     // get another guess
            count++;                // keep track of number of guesses
        }
        
        if (count == 1) {
            System.out.println("You made 1 guess, and you guessed right! What luck!");
        } else {
            System.out.println("You guessed the number! It took you " + count + " guesses!"); 
        }
        
        return count;
    }
    
    // Ask the user if they want to play again
    public static boolean playAgain() {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to play again? (y/n)");
        String input = in.next();
        if (input.equals("y")) {
            return true;
        } else if (input.equals("n")) {
            return false;
        } else {
            return false;
        }
    }
    
    // Print out stats if they play more than once!
    public static void getStats(int timesPlayed, double avg) {
        if (timesPlayed > 1) {
            System.out.println("You played " + timesPlayed + " times!");
            System.out.println("Your average number of guesses: " + avg);
        }
    }
}
