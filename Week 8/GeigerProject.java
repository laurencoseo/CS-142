// Lauren Coseo
// Week 8 Assignment
// CS 142
// 6/1/21


// This program processes a txt file of Geiger radiation measurements to
// determines the maximum radiation recorded and print out the date, time, and measurement
// for the max value and measurements within 5 of it.

        
// You probably went on a camping trip from 5/31/2019 - 6/2/2019. For these dates, there are between 8 and 21 instances 
// of the counts being within 5 of the max value of 38. All other days have just an abnormally high measurement
// once or twice a day, except for the period between 8/14/18 - 8/18/18 where there are 2 - 6 instances/day so this could be a 2nd trip.

// I hope they were fun trips! 

// I tried coding a solution for this, but didn't quite get there so I used Excel to count how many times a date appeared
// in the output list.



// import util package for the Scanner and ArrayList classes
// import io package for exception handling
import java.util.*;
import java.io.*;

public class GeigerProject {

    public static void main(String[] args) throws FileNotFoundException {
        
        // Scanner to read the text file
        Scanner in = new Scanner(new File("7_14_2019.txt"));
        
        // Create an ArrayList to store only the actual data lines in file
        ArrayList<RadiationSample> samples = new ArrayList<>();
        
        // Create a variable for the maximum counts per minute
        int maxCounts = 0;
        
        // While the file has another line, save the next line as a String
        while (in.hasNext()) {
            
            String line = in.nextLine();
            
            // if line matches date time format, create Scanner for line
            if (line.contains("Every Minute")) {
                Scanner scanLine = new Scanner(line);
                
                // Use a comma delimiter since the data came from a .csv file
                scanLine.useDelimiter("\\s*,\\s*");
          
                // Save the date and time stamp
                String dateTime = scanLine.next();
                
                // Throw away the "Every Minute" string
                scanLine.next();
                
                // Save the counts
                int counts = scanLine.nextInt();
                
                // Create an instance of the RadiationSample class for the data
                RadiationSample sample = new RadiationSample(dateTime, counts);
                
                // Add good lines to the samples ArrayList
                samples.add(sample);
                
                // Find max value
                if (counts > maxCounts) {
                    maxCounts = counts;
                }
            }
            
        }
        
        System.out.println("The maximum count is: " + maxCounts);
        System.out.println();
        
        // Create table for data with the counts within 5 of max value
        System.out.printf("%-20s %s\n", "Dates", "Counts Per Minute");
        
        // Loop through ArrayList and check if count is within 5 of max value
        for (int i = 0; i < samples.size(); i++) { 
            if (samples.get(i).getCountsPerMinute() >= maxCounts - 5) {
                
                // Print out the data that fits the criteria
                System.out.printf("%-20s %d\n", samples.get(i).getDateTime(), samples.get(i).getCountsPerMinute());
                
            }
        }
        
    }

}
