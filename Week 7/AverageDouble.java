// Lauren Coseo
// Practice It Problem 7.11
// CS 142
// 5/25/21


// This program takes in an array and returns the average value of it
// in the form of a double.


import java.util.*;

public class AverageDouble {

    public static void main(String[] args) {
        
        Scanner console = new Scanner(System.in);
        System.out.println("How many numbers do you want in your array?");
        int num = console.nextInt();
        
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            numbers[i] = console.nextInt();
        }
        
        
        // test
        // int[] numbers = {1, -2, 4, -4, 9, -6, 16, -8, 25, -10};
        
        double average = average(numbers);
        System.out.println("The average value is: " + average);

    }

    public static double average(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum+= numbers[i];
        }
        double avg = (double)sum/numbers.length;
        return avg;
    }
    
}

