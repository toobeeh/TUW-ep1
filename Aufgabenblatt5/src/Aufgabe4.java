/*
    Aufgabe 4) Rekursion + Zweidimensionale Arrays - primitive Landschaftssimulation
*/

import codedraw.CodeDraw;

import java.awt.*;
import java.util.Random;

public class Aufgabe4 {

    private static final int canvasSize = 500;
    private static Random myRand = new Random(2021L);

    private static Color[][] genLandscape(int size) {
        Color[][] landscape = new Color[size][size];
        for(int y = 0; y < size; y++){
            for(int x = 0; x < size; x++){
                landscape[y][x] = myRand.nextDouble() < 0.2 ? Color.GRAY : Color.GREEN;
            }
        }
        return landscape;
    }

    private static void drawLandscape(CodeDraw myDrawObj, Color[][] landscape) {
        int size = landscape.length;
        double pixelPerField = canvasSize / size;
        for(int y = 0; y < size; y++){
            for(int x = 0; x < size; x++){
                myDrawObj.setColor(landscape[y][x]);
                myDrawObj.fillSquare(x * pixelPerField, y * pixelPerField, pixelPerField);
            }
        }
    }

    private static void simWaterFlow(Color[][] landscape, int row, int col) {
        // return if out of bounds
        if(row >= landscape.length || col >= landscape[0].length || row < 0 || col < 0) return;
        // is this field a rock? split stream
        if(landscape[row][col] == Color.GRAY){
            landscape[row][col] = Color.DARK_GRAY;
            simWaterFlow(landscape, row, col - 1);
            simWaterFlow(landscape, row, col + 1);
        }
        else if(landscape[row][col] == Color.GREEN || landscape[row][col] == Color.BLUE) {
            // draw current field
            int direction = myRand.nextDouble() < 0.5 ? 1 : -1;
            landscape[row][col] = Color.BLUE;
            simWaterFlow(landscape, row+1, col + direction);
        }
    }

    private static void simSpreadingFire(Color[][] landscape, int row, int col) {
        // exit conditions: out of bounds, field is not grass
        if(row >= landscape.length || col >= landscape[0].length
                || row < 0 || col < 0
                || landscape[row][col] != Color.GREEN) return;
        //spread fire N-E-S-W
        landscape[row][col] = Color.RED;
        if(myRand.nextDouble() >= 0.3) simSpreadingFire(landscape, row-1,col);
        if(myRand.nextDouble() >= 0.3) simSpreadingFire(landscape, row,col+1);
        if(myRand.nextDouble() >= 0.3) simSpreadingFire(landscape, row+1,col);
        if(myRand.nextDouble() >= 0.3) simSpreadingFire(landscape, row,col-1);
    }

    public static void main(String[] args) {
    	CodeDraw myDrawObj = new CodeDraw(canvasSize, canvasSize);

        int size = 100;
        Color[][] landscape = genLandscape(size);

        //drawLandscape(myDrawObj, landscape);
        //myDrawObj.show();

        simWaterFlow(landscape, 0, size / 2);
        //drawLandscape(myDrawObj, landscape);
        //myDrawObj.show();

        landscape[20][20] = Color.GREEN;
        simSpreadingFire(landscape, 20, 20);
        drawLandscape(myDrawObj, landscape);
        myDrawObj.show();
    }
}
