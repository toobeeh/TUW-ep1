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
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        return null; //Zeile kann geändert oder entfernt werden.
    }

    private static void drawLandscape(CodeDraw myDrawObj, Color[][] landscape) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    }

    private static void simWaterFlow(Color[][] landscape, int row, int col) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    }

    private static void simSpreadingFire(Color[][] landscape, int row, int col) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    }

    public static void main(String[] args) {
    	CodeDraw myDrawObj = new CodeDraw(canvasSize, canvasSize);

        int size = 100;
        Color[][] landscape = genLandscape(size);

        drawLandscape(myDrawObj, landscape);

        simWaterFlow(landscape, 0, size / 2);
        drawLandscape(myDrawObj, landscape);

        landscape[20][20] = Color.GREEN;
        simSpreadingFire(landscape, 20, 20);
        drawLandscape(myDrawObj, landscape);
    }
}
