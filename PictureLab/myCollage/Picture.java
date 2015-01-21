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
    public void zeroBlue(int startRow, int endRow, int startCol, int endCol)
    {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = startRow; row < endRow +1; row++)
        {
            for (int col = startCol; col < endCol +1; col++)
            {
                pixels[row][col].setBlue(0);
            }
        }
    }


    public void cropAndCopy(Picture fromPic,int startRow, int endRow, int startCol, int endCol, int startDestRow, int startDestCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = startRow, toRow = startDestRow;
        fromRow <= endRow &&
        toRow < toPixels.length;
        fromRow++, toRow++)
        {
            for (int fromCol = startCol, toCol = startDestCol;
            fromCol <= endCol &&
            toCol < toPixels[0].length;
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    
    
    public void fixUnderwater()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(pixelObj.getRed()*4);
            }
        }
    }

    public void grayscale(int startRow, int endRow, int startCol, int endCol)
    {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = startRow; row < endRow +1; row++)
        {
            for (int col = startCol; col < endCol +1; col++)
            {
                int average = (pixels[row][col].getRed() + pixels[row][col].getGreen() + pixels[row][col].getBlue())/3;
                pixels[row][col].setRed(average);
                pixels[row][col].setGreen(average);
                pixels[row][col].setBlue(average);
            }
        }
    }
    
    public void bluescale(int startRow, int endRow, int startCol, int endCol)
    {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = startRow; row < endRow +1; row++)
        {
            for (int col = startCol; col < endCol +1; col++)
            {
                int average = (pixels[row][col].getRed() + pixels[row][col].getGreen() + pixels[row][col].getBlue())/3;
                pixels[row][col].setRed(average);
                pixels[row][col].setGreen(average);
                pixels[row][col].setBlue(average*3);
            }
        }
    }
    
    public void redscale(int startRow, int endRow, int startCol, int endCol)
    {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = startRow; row < endRow +1; row++)
        {
            for (int col = startCol; col < endCol +1; col++)
            {
                int average = (pixels[row][col].getRed() + pixels[row][col].getGreen() + pixels[row][col].getBlue())/3;
                pixels[row][col].setRed(average*3);
                pixels[row][col].setGreen(average);
                pixels[row][col].setBlue(average);
            }
        }
    }
    
    public void greenscale(int startRow, int endRow, int startCol, int endCol)
    {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = startRow; row < endRow +1; row++)
        {
            for (int col = startCol; col < endCol +1; col++)
            {
                int average = (pixels[row][col].getRed() + pixels[row][col].getGreen() + pixels[row][col].getBlue())/3;
                pixels[row][col].setRed(average);
                pixels[row][col].setGreen(average*2);
                pixels[row][col].setBlue(average);
            }
        }
    }

    public void negate()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }

    public void keepOnlyBlue()
    {     
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    public void mirrorArms()
    {
        int mirrorPoint = 25;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();
        // loop through the rows
        for (int row = 156; row < 183; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 103; col < 171; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row+mirrorPoint][col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }

        for (int row = 175; row < 192; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 238; col < 294; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row+mirrorPoint][col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel bottomPixel = null;
        Pixel topPixel = null;
        int width = pixels[0].length;
        int min = 0;
        if (width> pixels.length)
        {
            min = pixels.length;
        }
        else
        {
            min = width;
        }
        for (int row = 0; row < min; row++)
        {
            for (int col = 0; col < min; col++)
            {
                bottomPixel = pixels[row][col];
                topPixel = pixels[col][row];
                bottomPixel.setColor(topPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length / 2; row++)
        {
            for (int col = 0; col < width; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[pixels.length - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }  
    }

    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length / 2; row++)
        {
            for (int col = 0; col < width; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[pixels.length - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }  
    }

    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple(int startRow, int endRow, int startCol, int endCol)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        int mirrorPoint = endCol-startCol + endCol + 31 + 482;
        // loop through the rows
        for (int row = startRow; row < endRow+1; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = startCol; col < endCol +1; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row][mirrorPoint - col];                       
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1,0,0);
        this.copy(flower2,100,0);
        this.copy(flower1,200,0);
        Picture flowerNoBlue = new Picture(flower2);
        //flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue,300,0);
        this.copy(flower1,400,0);
        this.copy(flower2,500,0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        //beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
