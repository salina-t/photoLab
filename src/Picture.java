import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pix = this.getPixels2D();
        // iterate through the entire image with row major, meaning it moves from left to right, making its way down the image
        for (Pixel[] row : pix) {
            for (Pixel p : row) {
                //this filter will drain all he blue values in each pixel
                p.setBlue(0);
            }
        }
    }
    public void allRed() {
        Pixel[][] pix = this.getPixels2D();
        // iterate through the entire image with row major, meaning it moves from left to right, making its way down the image
        for (Pixel[] row: pix) {
            for (Pixel p : row) {
                //this filter will keep the red RGB value in each pixel and drain the blue and green RGB values, creating a vibrant red tint on the photo
                p.setBlue(0);
                p.setGreen(0);

            }
        }

    }

    public void negate() {
        Pixel[][] pix = this.getPixels2D();
        // iterate through the entire image with row major, meaning it moves from left to right, making its way down the image
        for (Pixel[] row : pix) {
           for(Pixel p : row) {
               //this filter will essentially invert the colors of the picture by taking the max RGB value and subtracting its current RGB values
               p.setRed(255 - p.getRed());
               p.setGreen(255 - p.getGreen());
               p.setBlue(255 - p.getBlue());
           }
        }
    }

    public void grayScale() {
        Pixel[][] pix = this.getPixels2D();
        // iterate through the entire image with row major, meaning it moves from left to right, making its way down the image
        for (Pixel[] row: pix) {
            for(Pixel p: row) {
                //finds the average of all RGB values in the singular pixel and resets the value to the average
                //essentially, it makes the image have a black, white, and gray color scheme
                int average = ((p.getRed() + p.getGreen() + p.getBlue()) / 3);
                p.setRed(average);
                p.setGreen(average);
                p.setBlue(average);

            }
        }
    }

    public void mirrorHorizontal() {
        Pixel[][] pix = this.getPixels2D();
        // iterate through the entire image with row major, meaning it moves from left to right, making its way down the image, however it will stop at the middle of the image horizontally.
        // upon iterating through the image, it will copy the RGB values and it will paste those values on the bottom half of the image, creating a mirror/water-like refleciton.
        for (int r = 0; r < pix.length / 2; r++) {
            for (int c = 0; c < pix[r].length; c++) {
                pix[pix.length/2 + r][c].setRed(pix[pix.length/2-r][c].getRed());
                pix[pix.length/2 + r][c].setGreen(pix[pix.length/2-r][c].getGreen());
                pix[pix.length/2 + r][c].setBlue(pix[pix.length/2-r][c].getBlue());

            }
        }
    }

    public void mirrorHorizontalBotToTop() {
        Pixel[][] pix = this.getPixels2D();
        // iterate through the entire image with row major, meaning it moves from left to right, making its way down the image, however it will stop at the middle of the image horizontally.
        // upon iterating through the image, it will set the RGB values at the top half of the image to the values on the bottom half of the image, creating a mirror/water-like reflection of the bottom half
        // of the picture.
        for (int r = 0; r < pix.length / 2; r++) {
            for (int c = 0; c < pix[r].length; c++) {
                pix[r][c].setRed(pix[pix.length-1-r][c].getRed());
                pix[r][c].setGreen(pix[pix.length-1-r][c].getGreen());
                pix[r][c].setBlue(pix[pix.length-1-r][c].getBlue());

            }
        }
    }

    public void mirrorVerticalRightToLeft() {
        Pixel[][] pix = this.getPixels2D();
        // iterate through the entire image, meaning it moves from left to right, making its way down the image, however it will stop at the middle of the image vertically.
        // upon iterating through the image, it will copy the RGB values and will paste those values on the other side of the image, creating a mirror.
        for (int r = 0; r < pix.length; r++) {
            for (int c = 0; c <= pix[r].length/2 + 1; c++) {
                pix[r][c].setRed(pix[r][pix[r].length-1-c].getRed());
                pix[r][c].setGreen(pix[r][pix[r].length-1-c].getGreen());
                pix[r][c].setBlue(pix[r][pix[r].length-1-c].getBlue());
            }
        }
    }

    public void colorReplacement() {
        Pixel[][] pix = this.getPixels2D();
        // iterate through the entire image with row major, meaning it moves from left to right, making its way down the image
        for (int r = 0; r < pix.length; r++) {
            for (int c = 0; c < pix[r].length; c++) {
                // if the value of blue in a pixel is greater than the red and green values, it will swap the blue and green values, making green the more dominant color
                if (pix[r][c].getBlue() > pix[r][c].getRed() && pix[r][c].getBlue() > pix[r][c].getGreen()) {
                    int temp = pix[r][c].getGreen();
                    pix[r][c].setGreen(pix[r][c].getBlue());
                    pix[r][c].setBlue(temp);
                }
            }
        }
    }

    public void redColorPop() {
        Pixel[][] pix = this.getPixels2D();
        for (int r = 0; r < pix.length; r++) {
            for (int c = 0; c < pix[r].length; c++) {
                //if (pix[r][c].getGreen() >= pix[r][c].getRed() - 140 && pix[r][c].getBlue() >= pix[r][c].getRed() - 140) {
                if (pix[r][c].getRed() - pix[r][c].getGreen() < 80 || pix[r][c].getRed() - pix[r][c].getBlue() < 80) {
                        int avg = ((pix[r][c].getRed() + pix[r][c].getGreen() + pix[r][c].getBlue()) / 3);
                        pix[r][c].setRed(avg);
                        pix[r][c].setGreen(avg);
                        pix[r][c].setBlue(avg);
                }
            }
        }
    }

    public void mirrorDiagonal() {
        Pixel[][] pix = this.getPixels2D();
        //both capped at the length of the rows because to mirror it diagonally, you need to make a square.
        //run through the entire picture with right to left, up to down. the code will copy the RGP values starting freom the bottom left and pasting it to the top right
        // slowly getting closer together to fold/mirror diagonally.
        for (int c = 0; c < pix.length; c++) {
            for (int r = 0; r < pix.length; r++) {
                pix[c][pix.length - 1 - r].setRed(pix[pix.length - 1 - r][c].getRed());
                pix[c][pix.length - 1 - r].setGreen(pix[pix.length - 1 - r][c].getGreen());
                pix[c][pix.length - 1 - r].setBlue(pix[pix.length - 1 - r][c].getBlue());
            }
        }
    }

    public void ownFilter() {
        Pixel[][] pix = this.getPixels2D();
        int border = 30;
        // iterate through the entire image with row major, meaning it moves from left to right, making its way down the image
        for (int r = 0; r < pix.length; r++) {
            for (int c = 0; c < pix[r].length; c++) {
                int avg = ((pix[r][c].getRed() + pix[r][c].getGreen() + pix[r][c].getBlue()) / 3);
                //change the colors that are primarily red to a navy blue and teal color (I like the splash of teal in the top left!)
                if (pix[r][c].getRed() - pix[r][c].getGreen() > 100 || pix[r][c].getRed() - pix[r][c].getBlue() > 100) {
                    int temp = pix[r][c].getRed();
                    pix[r][c].setRed(pix[r][c].getBlue());
                    pix[r][c].setBlue(temp);
                }

                    //create a gray border around the image
                if (c <= border || c >= pix[r].length - border || r <= border || r >= pix.length - border) {
                    pix[r][c].setRed(avg);
                    pix[r][c].setGreen(avg);
                    pix[r][c].setBlue(avg);
                }
                //create another border around the image, this time a smaller one
                if ((c > border * 2 && c <= border * 3) || (r > border * 2 && r <= border * 3)  || (r < pix.length - border * 2 && r >= pix.length - border * 3)){
                    pix[r][c].setRed(avg);
                    pix[r][c].setGreen(avg);
                    pix[r][c].setBlue(avg);
                }

            }
        }
    }

    public void pixelate() {
        Pixel[][] pix = this.getPixels2D();
        int counter = 0;
        int red = 0;
        int green = 0;
        int blue = 0;

        //loop through entire image with row major
        for (int r = 0; r < pix.length; r++) {
            for (int c = 0; c < pix[r].length; c++) {
                //saving the values of RGB to create seemly bigger pixels; grouping 10 pixels into 1
                if (r % 10 == 0) {
                    if (counter == 0) {
                        red = pix[r][c].getRed();
                        green =  pix[r][c].getGreen();
                        blue = pix[r][c].getBlue();
                    }
                    // after 10 long pixels, the counter for pixels restart
                    if (counter == 11) {
                        counter = 0;
                    // setting the other pixels to the saved values above
                    } else {
                        pix[r][c].setRed(red);
                        pix[r][c].setGreen(green);
                        pix[r][c].setBlue(blue);
                        counter++;
                    }
                // if the row value is not a number divisible by 10, set the RGB values to the same RGB values in the row above it
                } else {
                        pix[r][c].setRed(pix[r-1][c].getRed());
                        pix[r][c].setGreen(pix[r-1][c].getGreen());
                        pix[r][c].setBlue(pix[r-1][c].getBlue());
                }

            }
        }
    }

    public void fadeBorder() {
       Pixel[][] pix = this.getPixels2D();
       int count = 0;
       //create the fade at the top of the image. start from row 100 and go to 0 because
        // the white slowly becomes more prominent bottom to top
       for (int r = 100; r >= 0; r--) {
           for (int c = 0; c < pix[r].length; c++) {
                   pix[r][c].setRed(pix[r][c].getRed() + count);
                   pix[r][c].setGreen(pix[r][c].getGreen() + count);
                   pix[r][c].setBlue(pix[r][c].getBlue() + count);
           }
           count += 3;
       }
       count = 0;
       //create the fade at the bottom of the image. start 100 from the bottom of the imagee to the bottom
       //of the image because the white slowly becomes more prominent top to bottom
        for (int r = pix.length - 101; r < pix.length; r++) {
            for (int c = 0; c < pix[r].length; c++) {
                pix[r][c].setRed(pix[r][c].getRed() + count);
                pix[r][c].setGreen(pix[r][c].getGreen() + count);
                pix[r][c].setBlue(pix[r][c].getBlue() + count);
            }
            count += 3;
        }
        count = 0;
        //create the fade border on the left side of the image. start at column 100 moving to 0
        //because white gradually becomes more prominent from right to left.
        for (int c = 100; c >= 0 ; c-- ){
            for (int r = 0; r < pix.length; r++) {
                pix[r][c].setRed(pix[r][c].getRed() + count);
                pix[r][c].setGreen(pix[r][c].getGreen() + count);
                pix[r][c].setBlue(pix[r][c].getBlue() + count);
            }
            count += 3;
        }
        count = 0;
        ///create the fade border on the right side of the image. start from 100 columns from the right end of the image
        //moving towards the right because the white fade border gradually becomes more prominent from the left to right
        for (int c = pix[0].length - 100; c < pix[0].length; c++) {
            for (int r = 0; r < pix.length; r++) {
                pix[r][c].setRed(pix[r][c].getRed() + count);
                pix[r][c].setGreen(pix[r][c].getGreen() + count);
                pix[r][c].setBlue(pix[r][c].getBlue() + count);
            }
            count += 3;
        }
    }

} // this } is the end of class Picture, put all new methods before this
