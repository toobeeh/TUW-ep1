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
            while(inputStream.hasNextLine()){
                tempLine = inputStream.nextLine();
                // treat firstline as zero-based index -> -1
                if(lineIndex >= (firstLine - 1) && lineIndex - (firstLine - 1) < textLines.length) {
                    textLines[lineIndex - (firstLine - 1)] = tempLine;
                }
                lineIndex++;
            }
            inputStream.close();
        } catch (IOException e) {
            System.out.println("File... " + System.getProperty("user.dir") + "\\src\\" + fileName + " not found!");
            System.exit(1);
        }

        return textLines;
    }

    private static void extractData(String[] dataArray, int[] resultArray, int indexColumn, int entriesPerYear) {
        // fill result array as long as index is in bound of result & data is available
        for(int yearIndex = 0; yearIndex < resultArray.length && yearIndex * entriesPerYear < dataArray.length; yearIndex++){
            // get sum of values
            int sum = 0;
            for(int entryOfYearIndex = 0; entryOfYearIndex < entriesPerYear; entryOfYearIndex++){
                // get columns of line at index of that years entry
                String[] entry = dataArray[yearIndex * entriesPerYear + entryOfYearIndex].split(";");
                // add value at specified column to sum
                if(entry.length > indexColumn) sum += Integer.parseInt((entry[indexColumn]));
            }
            // add year sum to result array
            resultArray[yearIndex] = sum;
        }
    }

    private static void drawChart(CodeDraw myDrawObj, int[] iceDays) {
        // text config
        TextFormat format = myDrawObj.getTextFormat();
        format.setFontSize(10);
        format.setHorizontalAlign(HorizontalAlign.CENTER);

        // calculate sum
        int sum = 0;
        for(int count : iceDays) sum += count;

        // draw graph
        for(int year = 0; year < iceDays.length; year++){
            // calculate coordinates
            int left = 15 + year * 20 + year * 5;
            int top = myDrawObj.getHeight() - iceDays[year] * 10;
            int height = iceDays[year] * 10;

            // draw bar
            myDrawObj.setColor(iceDays[year] >= sum / iceDays.length ? Color.BLUE : Color.CYAN);
            myDrawObj.fillRectangle(left, top, 20, height);

            // write date etxt
            myDrawObj.setColor(iceDays[year] >= sum / iceDays.length ? Color.WHITE : Color.BLACK);
            myDrawObj.drawText(left + 10, myDrawObj.getHeight() - 10, String.valueOf(1970 + year).substring(2));

            // write value of icedays text
            myDrawObj.setColor(Color.BLACK);
            myDrawObj.drawText(left + 10, top - 10, iceDays[year] + "");
        }

        // show meeeeeeeeeeeeee :)))))
        myDrawObj.show();
    }

    public static void main(String[] args) {

        int width = 1300;
        int height = 525;
        CodeDraw myDrawObj = new CodeDraw(width, height);
        myDrawObj.setTitle("Ergebnis Wetterdaten - EISTAGE");

        int[] iceDaysPerYear = new int[51]; // icedays per year for 51 years
        String[] csvLines = readFileData("weather_data.csv", 182,793);
        extractData(csvLines, iceDaysPerYear,12,12);
        drawChart(myDrawObj, iceDaysPerYear);
    }
}
