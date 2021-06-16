/**
 * Filter that uses a blurred, or "unsharp", negative image to create a mask of the original image
 * 
 */
public class Unsharp implements Filter
{
  public void filter(PixelImage pi)
  {
      Pixel[][] data = pi.getData();
      
      // Filter
      int[][] filter = {
             {-1, -2, -1},
             {-2, 28, -2},
             {-1, -2, -1}
          };
      
      // Apply scaling, if any
      int scaling = 16;

      // Run Weighted Average method from PixelImage.java
      Pixel[][] filteredImage = pi.getWeightedAverage(data, filter, scaling); 
      
      pi.setData(filteredImage);
      
    }
  }