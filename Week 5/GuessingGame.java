// Lauren Coseo
// Week 5 Assignment
// CS 142
// 5/11/21


// This program creates a guessing game where the user needs to
// guess what the random number is until they get it right!


// import util package for the Scanner class
import java.util.*;

public class GuessingGame {

    public static void main(String[] args) {
        
        giveIntro();
        
        // variable for random number
        int answer = getRandomNumber();
        
        // variable for user's guess
        int guess = getGuess();
        
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
        
        if (guess == answer) {
            if (count == 1) {
                System.out.println("You made 1 guess, and you guessed right! What luck!");
            } else {
                System.out.println("You guessed the number! It took you " + count + " guesses!"); 
            }
        }
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
}
