// Week 4 Assignment
// CS 142
// 4/29/21


// This program lists out the numbers between 100 and 999 that are equal
// to the sum of the cubes of their digits


public class SumOfCubes {

    public static void main(String[] args) {
        
        // loop through numbers 100 to 999
        for (int i = 100; i < 1000; i++) {
            
            // Assign each digit to a variable
            int one = i / 100 % 10; // 1st digit
            int two = i / 10 % 10;  // 2nd digit
            int three = i % 10;     // 3rd digit
            
            // Calculates the sum of the cubes
            double sum = Math.pow(one, 3) + Math.pow(two,  3) + Math.pow(three,  3);
            
            // Test if the number equals the sum of the cubes and
            // print the result showing the sum
            if (sum == i) {
                System.out.println(i + " = " + one + "^3 + " + two + "^3 + " + three + "^3");
            }
        }
    }
}
