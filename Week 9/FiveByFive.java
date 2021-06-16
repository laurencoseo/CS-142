/**
 * Filter that performs a 5 x 5 Gaussian Blur
 * 
 */
// import java.util.*;

public class FiveByFive implements Filter
{
  public void filter(PixelImage pi)
  {
    Pixel[][] data = pi.getData();
    
    // Filter
    int[][] filter = {
           {1, 4, 6, 4, 1},
           {4, 16, 24, 16, 4},
           {6, 24, 36, 24, 6},
           {4, 16, 24, 16, 4},
           {1, 4, 6, 4, 1}
        };
    
    // Apply scaling, if any
    int scaling = 256;

    // Run Weighted Average method from PixelImage.java
    Pixel[][] filteredImage = pi.getWeightedAverage(data, filter, scaling); 
    
    pi.setData(filteredImage);
    
    
  }
}
