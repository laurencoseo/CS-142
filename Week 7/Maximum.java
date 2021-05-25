// Practice It Problem
// CS 142
// 5/25/21


// This program takes in an array and returns the max value of it.

import java.util.*;

public class Maximum {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("How many numbers do you want in your array?");
        int num = console.nextInt();
        
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            numbers[i] = console.nextInt();
        }
        
        // test
        // int[] numbers = {12, 7, -1, 25, 3, 9};
        
        int maxValue = max(numbers);
        System.out.println("The max value is: " + maxValue);

    }

    public static int max(int[] numbers) {
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
    
}
