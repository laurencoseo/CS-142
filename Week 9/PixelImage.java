import java.awt.image.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Provides an interface to a picture as an array of Pixels
 */
public class PixelImage
{
  private BufferedImage myImage;
  private int width;
  private int height;

  /**
   * Map this PixelImage to a real image
   * @param bi The image
   */
  public PixelImage(BufferedImage bi)
  {
    // initialise instance variables
    this.myImage = bi;
    this.width = bi.getWidth();
    this.height = bi.getHeight();
  }

  /**
   * Return the width of the image
   */
  public int getWidth()
  {
    return this.width;
  }

  /**
   * Return the height of the image
   */
  public int getHeight()
  {
    return this.height;
  }

  /**
   * Return the BufferedImage of this PixelImage
   */
  public BufferedImage getImage()
  {
    return this.myImage;
  }

  /**
   * Return the image's pixel data as an array of Pixels.  The
   * first coordinate is the x-coordinate, so the size of the
   * array is [width][height], where width and height are the
   * dimensions of the array
   * @return The array of pixels
   */
  public Pixel[][] getData()
  {
    Raster r = this.myImage.getRaster();
    Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
    int[] samples = new int[3];

    for (int row = 0; row < r.getHeight(); row++)
    {
      for (int col = 0; col < r.getWidth(); col++)
      {
        samples = r.getPixel(col, row, samples);
        Pixel newPixel = new Pixel(samples[0], samples[1], samples[2]);
        data[row][col] = newPixel;
      }
    }

    return data;
  }

  /**
   * Set the image's pixel data from an array.  This array matches
   * that returned by getData().  It is an error to pass in an
   * array that does not match the image's dimensions or that
   * has pixels with invalid values (not 0-255)
   * @param data The array to pull from
   */
  public void setData(Pixel[][] data)
  {
    int[] pixelValues = new int[3];     // a temporary array to hold r,g,b values
    WritableRaster wr = this.myImage.getRaster();

    if (data.length != wr.getHeight())
    {
      throw new IllegalArgumentException("Array size does not match");
    }
    else if (data[0].length != wr.getWidth())
    {
      throw new IllegalArgumentException("Array size does not match");
    }

    for (int row = 0; row < wr.getHeight(); row++)
    {
      for (int col = 0; col < wr.getWidth(); col++)
      {
    	pixelValues[0] = data[row][col].red;
        pixelValues[1] = data[row][col].green;
        pixelValues[2] = data[row][col].blue;
        wr.setPixel(col, row, pixelValues);
      }
    }
  }
  
 //My Weighted Average Method
 public Pixel[][] getWeightedAverage(Pixel[][] data, int[][] filter, int scaling) {
     
     // Determine size of filter
     int filterHeight = filter.length;
     int filterWidth = filter[0].length;
     
     // Create new array to apply the filter to and clone the image array to it
     Pixel[][] filteredImage = new Pixel[data.length][data[0].length];
     
     for(int i = 0; i < data.length; i++) {       
         filteredImage[i] = data[i].clone();
     }
     
     // Loop through original data array
     for (int row = filterHeight/2; row < data.length - filterHeight/2; row++)
     {
       for (int col = filterWidth/2; col < data[0].length - filterWidth/2; col++)
       {
           
           // Variables to store weighted sums
           int sumRed = 0;
           int sumGreen = 0;
           int sumBlue = 0;
           
           // Loop through filter
           for (int i = 0; i < filterHeight; i++) {
               for (int j = 0; j < filterWidth; j++) {

                   sumRed += data[row + i - filterHeight/2][col + j - filterWidth/2].red * filter[i][j];
                   sumGreen += data[row + i - filterHeight/2][col + j - filterWidth/2].green * filter[i][j];
                   sumBlue += data[row + i - filterHeight/2][col + j - filterWidth/2].blue * filter[i][j];
               }
           }

           // Keep sum between 0 and 255, inclusive
           sumRed = (int)Math.min(Math.max(0, sumRed/scaling), 255);
           sumGreen = (int)Math.min(Math.max(0, sumGreen/scaling), 255);
           sumBlue = (int)Math.min(Math.max(0, sumBlue/scaling), 255);
           
           // Create a Pixel for the filtered image
           Pixel weightedPixel = new Pixel(sumRed, sumGreen, sumBlue);
       
           filteredImage[row][col] = weightedPixel;
           
         }
     }
     return filteredImage;
 }
 
 // Duplicated Method from above but added bias for brightness
 // For the Emboss Filter
 public Pixel[][] emboss(Pixel[][] data, int[][] filter) {
    
    // Determine size of filter
    int filterHeight = filter.length;
    int filterWidth = filter[0].length;
    
    // Create new array to apply the filter to and clone the image array to it
    Pixel[][] filteredImage = new Pixel[data.length][data[0].length];
    
    for(int i = 0; i < data.length; i++) {       
        filteredImage[i] = data[i].clone();
    }
    
    // Loop through original data array
    for (int row = filterHeight/2; row < data.length - filterHeight/2; row++)
    {
      for (int col = filterWidth/2; col < data[0].length - filterWidth/2; col++)
      {
          
          // Variables to store weighted sums
          int sumRed = 0;
          int sumGreen = 0;
          int sumBlue = 0;
          
          // Loop through filter
          for (int i = 0; i < filterHeight; i++) {
              for (int j = 0; j < filterWidth; j++) {

                  sumRed += data[row + i - filterHeight/2][col + j - filterWidth/2].red * filter[i][j];
                  sumGreen += data[row + i - filterHeight/2][col + j - filterWidth/2].green * filter[i][j];
                  sumBlue += data[row + i - filterHeight/2][col + j - filterWidth/2].blue * filter[i][j];
              }
          }

          // Keep sum between 0 and 255, inclusive
          sumRed = (int)Math.min(Math.max(0, sumRed + 128), 255);
          sumGreen = (int)Math.min(Math.max(0, sumGreen + 128), 255);
          sumBlue = (int)Math.min(Math.max(0, sumBlue + 128), 255);
          
          // Create a Pixel for the filtered image
          Pixel weightedPixel = new Pixel(sumRed, sumGreen, sumBlue);
      
          filteredImage[row][col] = weightedPixel;
          
        }
    }
    return filteredImage;
}

  
}
