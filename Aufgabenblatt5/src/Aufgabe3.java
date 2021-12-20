/*
    Aufgabe 3) Zweidimensionale Arrays und CodeDraw - "Schwärzen ähnlicher Bildbereiche"
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Aufgabe3 {

    // converts BufferedImage object to a grayscale array
    private static int[][] convertImg2Array(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] imgArray = new int[height][width];
        Color tempColor;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tempColor = new Color(img.getRGB(col, row));
                imgArray[row][col] = (int) (tempColor.getRed() * 0.3 + tempColor.getGreen() * 0.59 + tempColor.getBlue() * 0.11);
            }

        }
        return imgArray;
    }

    //draws the image array to the canvas
    private static void drawImage(int[][] imgArray) {
        CodeDraw cd = new CodeDraw(Math.max(imgArray[0].length, 150), Math.max(imgArray.length, 150));

        for (int y = 0; y < imgArray.length; y++) {
            for (int x = 0; x < imgArray[y].length; x++) {
                cd.setColor(Palette.fromGrayscale(imgArray[y][x]));
                cd.drawPixel(x, y);
            }
        }
        cd.show();
    }

    private static int[][] blackenSimilarRegions(int[][] imgArray, int rowStart, int rowEnd, int colStart, int colEnd, double threshold) {
        // get re-usable values - will use same algorithm with center point to skip no possible matches
        // (-> threshold could match region even if fragment is out of bounds - here "out of bounds" are specified as 255 mismatch)
        int rowSpan = rowEnd - rowStart;
        int colSpan = colEnd - colStart;
        int outOfBoundsMismatch = 255;

        // init result array and copy values, also init and get region array
        int[][] blackened = new int[imgArray.length][imgArray[0].length];
        int[][] region = new int[rowSpan + 1][colSpan + 1];
        for(int row = 0; row < imgArray.length; row++){
            for(int col = 0; col < imgArray[0].length; col++){
                blackened[row][col] = imgArray[row][col];
                if(row >= rowStart && row <= rowEnd && col >= colStart && col <= colEnd){
                    region[row - rowStart][col - colStart] = imgArray[row][col];
                }
            }
        }

        // loop through each pixel and calculate SSD
        for(int row = 0; row < imgArray.length; row++){
            for(int col = 0; col < imgArray[0].length; col++){
                // get the current SSD
                int ssd = 0;
                for(int regionRow = 0; regionRow < region.length; regionRow++){
                    int targetRow = row - rowSpan/2 + regionRow;
                    for(int regionCol = 0; regionCol < region[0].length;  regionCol++){
                        int targetCol = col - colSpan/2 + regionCol;
                        // if target col and row are in bounds, calc SSD
                        if(targetCol >= 0 && targetCol < imgArray[0].length && targetRow >= 0 && targetRow < imgArray.length){
                            ssd += Math.pow(imgArray[targetRow][targetCol] - region[regionRow][regionCol],2);
                        }
                        // else count as absolute mismatch (difference specified above)
                        else {
                            ssd += Math.pow(outOfBoundsMismatch, 2);
                        }
                    }
                }
                // if ssd below threshold, blacken area in result
                if(ssd < threshold){
                    for(int regionRow = 0; regionRow < region.length; regionRow++){
                        int targetRow = row - rowSpan/2 + regionRow;
                        for(int regionCol = 0; regionCol < region[0].length;  regionCol++){
                            int targetCol = col - colSpan/2 + regionCol;
                            // if target col and row are in bounds, blacken in result
                            if(targetCol >= 0 && targetCol < imgArray[0].length && targetRow >= 0 && targetRow < imgArray.length){
                                blackened[targetRow][targetCol] = 0;
                            }
                        }
                    }
                }
            }
        }

        return blackened;
    }

    public static void main(String[] args) {

        String fileName = "./src/page4.png";
        BufferedImage img = null;
        // try to open image file
        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int[][] imgArray = convertImg2Array(img);

        //blacken the "g"
        //int[][] resultImg = blackenSimilarRegions(imgArray, 148, 158, 321, 328, 1e5);

        //blacken the "while"
        //int[][] resultImg = blackenSimilarRegions(imgArray, 214, 230, 233, 270, 1e6);

        //binarize by comparing to a single black pixel region
        int[][] resultImg = blackenSimilarRegions(imgArray, 150, 150, 95, 95, 220 * 220);

        drawImage(imgArray);
        if (resultImg != null) {
            drawImage(resultImg);
        }
    }
}
