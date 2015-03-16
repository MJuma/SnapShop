/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 3 - SnapShop
 * October 20, 2012
 */

package snapshop.filters;

import java.awt.Color;

import snapshop.image.PixelImage;

/**
 * Filter that converts the image to negative.
 *
 * @author Mohammad Juma
 * @version 1.0
 */
public class NegativeFilter extends AbstractFilter
{ 
  /**
   * The RGB range limit to subtract from.
   */
  private static final int RGB_LIMIT = 255;
  
  /**
   * Constructs a new negative filter.
   */
  public NegativeFilter()
  {
    super("Negative");
  }

  /**
   * Filters the specified image.
   *
   * @param the_image The image.
   */
  public void filter(final PixelImage the_image)
  {
    final int image_width = the_image.getWidth(null);
    final int image_hieght = the_image.getHeight(null);
    
    for (int x = 0; x < image_width; x++)
    {
      for (int y = 0; y < image_hieght; y++)
      {
        final int rgba = the_image.getRGB(x, y);
        Color col = new Color(rgba, true);
        col = new Color(RGB_LIMIT - col.getRed(), RGB_LIMIT - col.getGreen(),
                        RGB_LIMIT - col.getBlue());
        the_image.setRGB(x, y, col.getRGB());
      }
    }
  }
}
