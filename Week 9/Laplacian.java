/**
 * Filter that detects and highlights edges
 * 
 */
// import java.util.*;

public class Laplacian implements Filter
{
  public void filter(PixelImage pi)
  {
    Pixel[][] data = pi.getData();
    
    // Filter
    int[][] filter = {
           {-1, -1, -1},
           {-1, 8, -1},
           {-1, -1, -1}
        };
    
    // Apply scaling, if any
    int scaling = 1;

    // Run Weighted Average method from PixelImage.java
    Pixel[][] filteredImage = pi.getWeightedAverage(data, filter, scaling); 
    
    pi.setData(filteredImage);
    
    
  }
}
