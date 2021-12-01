/*
    Aufgabe 5) Muster mit Quadraten => Rekursiv vs. Iterativ
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;

public class Aufgabe5 {
    private static int ct = 0;
    private static void drawPatternRecursively(CodeDraw myDrawObj, int x, int y, int s, boolean c) {
        if(s>4){
            drawPatternRecursively(myDrawObj, x - s/2, y - s/2, s/2, !c );
            drawPatternRecursively(myDrawObj, x + s/2, y - s/2, s/2, !c );
            drawPatternRecursively(myDrawObj, x - s/2, y + s/2, s/2, !c );
            drawPatternRecursively(myDrawObj, x + s/2, y + s/2, s/2, !c );
        }
        int topY = y - s/2;
        int leftX = x - s/2;
        myDrawObj.setColor(c ? Palette.ORANGE : Palette.BLUE);
        myDrawObj.fillSquare(leftX, topY, s);
    }

    private static void drawPatternIteratively(CodeDraw myDrawObj, int width) {
        boolean c = true;
        int size = 4;
        while(size <= width){
            myDrawObj.setColor(c ? Palette.ORANGE : Palette.BLUE);
            for(int topX = size/2; topX + size < width; topX += 2*size){ // horizontal iteration
                for(int topY = size/2; topY + size < width; topY += 2*size){ // vertical iteration
                    myDrawObj.fillSquare(topX, topY, size);
                }
            }
            c = !c;
            size *= 2;
        }
    }

    public static void main(String[] args) {
        CodeDraw draw = new CodeDraw(800,800);
        //drawPatternRecursively(draw, 256,256,256, true);
        drawPatternIteratively(draw, 800);
        draw.show();

        // ZUSATZFRAGEN
        //
        // 1 - Summe[n = 0 -> n = lb(512/4) -1] 4^n:
        //          Anzahl der Ebenen n: 4 * 2^n = 512 => n = 7; da letzte Ebene keine Aufrufe mehr hat: n=6
        //          Jeder Ebene n hat 4^n Aufrufe => Summe aller Aufrufe aller Ebene ist Gesamtzahl
        // 2 - Quadrate pro Länge: 512 / 8 = 64 => Anzahl = 64*64
        // 3 - Die Rekursive Methode muss ohne des Aufrufs für den -y und +x Offset implementiert werden

    }
}


