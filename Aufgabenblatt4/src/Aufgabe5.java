/*
    Aufgabe 5) Eindimensionale Arrays und File I/O
*/

import codedraw.CodeDraw;
import codedraw.textformat.HorizontalAlign;
import codedraw.textformat.TextFormat;

import java.awt.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Aufgabe5 {

    private static String[] readFileData(String fileName, int firstLine, int lastLine) {

        String[] textLines = new String[lastLine - firstLine + 1];
        int lineIndex = 0;
        String tempLine;

        try {
            Scanner inputStream = new Scanner(new FileReader("./src/" + fileName));
            //TODO: Implementieren Sie hier die Schleife für das Einlesen der Daten
            inputStream.close();
        } catch (IOException e) {
            System.out.println("File... " + System.getProperty("user.dir") + "\\src\\" + fileName + " not found!");
            System.exit(1);
        }

        return textLines;
    }

    private static void extractData(String[] dataArray, int[] resultArray, int indexColumn, int entriesPerYear) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    }

    private static void drawChart(CodeDraw myDrawObj, int[] iceDays) {

        TextFormat format = myDrawObj.getTextFormat();
        format.setFontSize(10);
        format.setHorizontalAlign(HorizontalAlign.CENTER);

        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    }

    public static void main(String[] args) {

        int width = 1300;
        int height = 525;
        CodeDraw myDrawObj = new CodeDraw(width, height);
        myDrawObj.setTitle("Ergebnis Wetterdaten - EISTAGE");

        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    }
}
