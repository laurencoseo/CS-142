// Lauren Coseo
// CS 142
// Week 9 Assignment
// 6/15/21


// My Short Report
/*
 * Hi Chris!
 * 
 * As you know, this project was something else for me. But I made it!
 * 
 * Extra filters:
 * I added an additional filter for a 5 x 5 Gaussian blur. My method in PixelImage.java
 * can receive input from 3x3, 5x5, 7x7, etc.
 * I also added an Emboss filter that works ok.
 * 
 * What works and what doesn't:
 * The non-destructive ones (Negative, FlipVertical, and Flip Horizontal) all work.
 * The 3x3 transformations Laplacian, Gaussian, Unsharp Masking, and Edgy all work!
 * My 5 x 5 filter works, too.
 * Hopefully, nothing doesn't work.
 * 
 * Surprises and Problems: Oh boy did I have them. 
 * My biggest problem was that my original image array's RGB values were changing when I didn't want them to.
 * I learned that instead of individually assigning the new RGB values, I needed to create a new Pixel.
 * But in the struggle/fun of debugging, I was able to really simplify my code, surprising myself at how
 * over-coded it was to begin with.
 * 
 * Thank you for a great quarter.
 * 
 * Lauren
 */




/**
 * A class to configure the SnapShop application
 *
 * @author Lauren Coseo
 * @version 6/10/21
 */
public class SnapShopConfiguration
{
  /**
   * Method to configure the SnapShop.  Call methods like addFilter
   * and setDefaultFilename here.
   * @param theShop A pointer to the application
   */
  public static void configure(SnapShop theShop)
  {

    // theShop.setDefaultFilename("c:/Users/Lauren/Pictures/billg.jpg");
    theShop.setDefaultFilename("c:/users/cd/desktop/jpegs/billg.jpg");
    theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
    theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
    theShop.addFilter(new Negative(), "Negative");
    theShop.addFilter(new Gaussian(), "Guassian blur");
    theShop.addFilter(new Laplacian(), "Laplacian");
    theShop.addFilter(new Unsharp(), "Unsharp masking");
    theShop.addFilter(new Edgy(), "Edgy");
    // Additional filters
    theShop.addFilter(new FiveByFive(), "5x5 Gaussian");
    theShop.addFilter(new Emboss(), "Emboss");


  }
}
