// Week 2 Assignment
// CS 142
// 4/19/21

public class NumbersOutput {
  
	// Declare class constants
	public static final int REPETITION = 6;
	public static final int RANGE = 10;
	
	// Main Method
	public static void main(String[] args) {
    
		// Loop through range for the number of REPETITION
		for (int i = 1; i <= REPETITION; i++) {			
			for (int j = 1; j <= RANGE; j++) {
				// Print the number of spaces equal to the range
				System.out.print(" ");
			}
			// Print vertical bar after number of spaces is printed
			System.out.print("|");
		}
		
		// Start a new line
		System.out.println();
		
		// Loop through range for the number of REPETITION
		for (int i = 1; i <= REPETITION; i++) {			
			for (int j = 1; j <= RANGE; j++) {
				// Print the one's place for each number in the range
				System.out.print(j%10);
			}
			// Print 0 after all numbers in range are printed
			System.out.print(0);
		}
	}

}
