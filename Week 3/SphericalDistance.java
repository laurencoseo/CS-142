// Week 3 Assignment
// CS 142
// 4/25/21

// This program computes the spherical distance between two points
// on the surface of the Earth, given latitude and longitude

// import java util package which includes the Scanner class
import java.util.*;

public class SphericalDistance {

    // Establish class constant for Earth's radius (km)
    public static final double EARTH_RADIUS = 6372.795;
    
    public static void main(String[] args) {
	    Scanner console = new Scanner(System.in);
	    
	    // User prompts and Scanner inputs for latitude and longitude
	    // Inputs converted from degrees to radians
	    System.out.println("Input the 1st city's latitude:");
	    double lat1 = Math.toRadians(console.nextDouble());
	    
	    System.out.println("Input the 1st city's longitude:");
	    double long1 = Math.toRadians(console.nextDouble());
	    
	    System.out.println("Input the 2nd city's latitude:");
	    double lat2 = Math.toRadians(console.nextDouble());
	    
	    System.out.println("Input the 2nd city's longitude:");
        double long2 = Math.toRadians(console.nextDouble());
        
        // saves result from calcDeltaSigma method with
        // latitude and longitude inputs
        double deltaSigma = calcDeltaSigma(lat1, long1, lat2, long2);
        
        // saves results from calcDistance with deltaSigma parameter and
        // casts it to an integer
        int distance = (int)calcDistance(deltaSigma);
        
        // prints out statement with distance result
	    System.out.println("The distance between these cities is " + distance + " km.");
	    
	    // closes the Scanner
	    console.close();
    }
    
    
    // This method calculates the delta sigma (angular difference/distance)
    public static double calcDeltaSigma(double lat1, double long1, double lat2, double long2) {
        double deltaSigma;
        // Equation from Building Java Programs 4th ed.
        deltaSigma = Math.acos(Math.sin(lat1)*Math.sin(lat2) +
                         Math.cos(lat1)*Math.cos(lat2)*Math.cos(long2-long1));
        return deltaSigma;
    }
    
    // This method calculates the spherical distance (km)
    public static double calcDistance(double deltaSig) {
        return EARTH_RADIUS * deltaSig;
    }

}
