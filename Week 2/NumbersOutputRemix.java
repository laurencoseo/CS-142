// Week 2 Assignment
// CS 142
// 4/19/21

public class OutputConstantRemix {
	// Declare class constants
	public static final int REPETITION = 3;
	public static final int RANGE = 5;
	
	// Main Method
	public static void main(String[] args) {
		// Loop through range for the number of REPETITION
		loopBar();
		
		// Start a new line
		System.out.println();
		
		loopNum();
	}
	
	public static void loopBar() {
		for (int i = 1; i <= REPETITION; i++) {			
			for (int j = 1; j <= RANGE; j++) {
				// Print the number of spaces equal to the range
				System.out.print(" ");
			}
			// Print vertical bar after number of spaces is printed
			System.out.print("|");
		}
	}
	
	public static void loopNum() {
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
