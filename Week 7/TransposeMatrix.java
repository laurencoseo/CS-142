// Week 7 Assignment
// CS 142
// 5/25/21


// This program prints a matrix and prints the transpose of it.


public class TransposeMatrix {

    public static void main(String[] args) {
        // Initializes original matrix
        int [][] matrix = new int[][] {{  1,  2,  3,  4,  5},
                                       {  6,  7,  8,  9, 10},
                                       { 11, 12, 13, 14, 15},
                                       { 16, 17, 18, 19, 20},
                                       { 21, 22, 23, 24, 25}};

        // Variables for the number of rows and columns                               
        int numRows = matrix[0].length;
        int numCols = matrix.length; 
        
        // Prints the original matrix
        System.out.println("This is the original matrix.");
        printMatrix(matrix, numRows, numCols);
        
        // Saves the returned value of the transpose method to a variable
        int[][] newMatrix = transpose(matrix, numRows, numCols);
        
        // Prints the transpose of the original matrix
        System.out.println("This is the transpose of the matrix.");
        printMatrix(newMatrix, numRows, numCols);

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
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }
        return newMatrix;
    }
}
