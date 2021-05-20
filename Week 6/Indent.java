// Week 6 Assignment
// CS 142
// 5/18/21


// This program reads a java file from the user and properly
// indents the file, by increasing the indent after a { and
// decreasing the indent after a }.


// import util package for the Scanner class
import java.util.*;
import java.io.*;

public class Indent {

    // Class constant for number of spaces for each indent
    public static final int SPACES = 4;
    
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This program will properly indent a java file.");
        System.out.println();
        
        // Scanner for user input
        Scanner console = new Scanner(System.in);
        // Scanner for file
        Scanner input = getInput(console);
        
        // Output to a text file in the current directory
        PrintStream output = new PrintStream(new File("results.txt"));
        
        indentFile(input, output);
        
    }
    
    // This method returns the Scanner of the user's file they input
    public static Scanner getInput(Scanner console) throws FileNotFoundException {
        System.out.println("What is the file you want to indent?");
        File fileName = new File(console.nextLine());
        
        // Check if file name can be read and ask for new file if it can't
        while (!fileName.canRead()) {
            System.out.println("File not found. Try again.");
            System.out.println("Input file name:");
            fileName = new File(console.nextLine());
        }
        return new Scanner(fileName);
    }
    
    // This method prints the indent and the file line to a new file
    public static void indentFile(Scanner input, PrintStream output) {
        int count = 0;
        
        while(input.hasNextLine()) {
            String fileLine = input.nextLine();
            for (int i = 0; i < (SPACES * count); i++) {
                output.print(" ");
            }
            output.println(fileLine);
            count = updateCount(fileLine, count); // update count
        }
    }
    
    // This method increases or decreases the number of indents based on
    // the presence of a { or }
    public static int updateCount(String line, int count) {
        // Scans the String for characters { or }
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '{') {
                count++;    // increase indent
            } else if (line.charAt(i) == '}') {
                count--;    // decrease indent
            }
        }
        return count;
    }
}
