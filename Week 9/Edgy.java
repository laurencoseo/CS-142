/**
 * Filter that adds the Laplacian weighted average to the original pixel, which sharpens the edges in the image. 
 * 
 */
// import java.util.*;

public class Edgy implements Filter
{
  public void filter(PixelImage pi)
  {
      Pixel[][] data = pi.getData();
          
      // Filter
      int[][] filter = {
             {-1, -1, -1},
             {-1, 9, -1},
             {-1, -1, -1}
          };
      
      // Apply scaling, if any
      int scaling = 1;
      
      // Run Weighted Average method from PixelImage.java
      Pixel[][] filteredImage = pi.getWeightedAverage(data, filter, scaling);
      
      pi.setData(filteredImage);
      
      
    }
  }
