// Week 7 Assignment - Extended
// CS 142
// 5/25/21


// This program lets the user decide the size of a 2D matrix
// and prints a matrix along with the transpose of it.

import java.util.*;

public class InputMatrix {

    public static void main(String[] args) {
          
        Scanner console = new Scanner(System.in);
        
        // Variables for the number of rows and columns
        System.out.println("How many rows?");
        int numRows = console.nextInt();
        System.out.println("How many columns?");
        int numCols = console.nextInt();
        
        // Initializes original matrix
        int[][] matrix = new int[numRows][numCols];
        
        System.out.println("Enter your numbers.");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = console.nextInt();
            }
        }
        
        // Prints the original matrix
        System.out.println("This is the original matrix.");
        printMatrix(matrix, numRows, numCols);
        
        // Saves the returned value of the transpose method to a variable
        int[][] newMatrix = transpose(matrix, numRows, numCols);
        
        // Prints the transpose of the original matrix
        System.out.println("This is the transpose of the matrix.");
        printMatrix(newMatrix, numCols, numRows);

    }
    
    // This method prints a matrix with the standard [] format
    public static void printMatrix(int[][] matrix, int numRows, int numCols) {
        for (int i = 0; i < numRows; i++) {
            System.out.print("[");
            System.out.print(matrix[i][0]);
            for (int j = 1; j < numCols; j++) {
                System.out.print(", " + matrix[i][j]);
            }
            System.out.println("]");
        }
        System.out.println();
    }
    
    // This method takes in a matrix parameter and returns the transpose of the matrix
    public static int[][] transpose(int[][] matrix, int numRows, int numCols) {
        int[][] newMatrix = new int[numCols][numRows];
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }
        return newMatrix;
    }
}
