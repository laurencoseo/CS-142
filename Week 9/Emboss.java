/**
 * Filter that detects and highlights edges
 * 
 */
// import java.util.*;

public class Emboss implements Filter
{
  public void filter(PixelImage pi)
  {
    Pixel[][] data = pi.getData();
    
    // Filter
    int[][] filter = {
           {0, 1, 0},
           {0, 0, 0},
           {0, -1, 0}
        };

    // Run Weighted Average method from PixelImage.java
    Pixel[][] filteredImage = pi.emboss(data, filter); 
    
    pi.setData(filteredImage);
    
    
  }
}
