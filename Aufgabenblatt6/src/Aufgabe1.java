/*
    Aufgabe 1) Zweidimensionale Arrays und Gameplay - Mastermind
*/

import codedraw.CodeDraw;
import codedraw.Palette;
import codedraw.textformat.HorizontalAlign;
import codedraw.textformat.TextFormat;
import codedraw.textformat.VerticalAlign;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Aufgabe1 {
    // global constants
    private static final int NUMBER_OF_TURNS = 10;
    private static final int CODE_LENGTH = 4;
    private static final int NUMBER_OF_COLUMNS = CODE_LENGTH * 2 + 1;
    private static final Color[] COLORS = new Color[]{Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.DARK_GRAY, Color.RED, Color.PINK, Color.YELLOW};

    // global variables
    private static int[][] playField = null;
    private static int[][] tips = null;
    private static int turn = 0;
    private static int pin = 0;
    private static int[] solution = null;

    // initializes all global variables for the game
    private static void initGame() {
        playField = new int[NUMBER_OF_TURNS][CODE_LENGTH];
        tips = new int[NUMBER_OF_TURNS][CODE_LENGTH]; // 1 == red; 2 == white
        turn = 0;
        pin = 0;
        solution = generateCode();
    }

    // generates array with length CODE_LENGTH and random numbers from 1 to COLORS.length
    private static int[] generateCode() {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return null;
    }

    // calculates red and white tip pins
    private static void updateTips() {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
    }

    // draws game to screen
    private static void drawGame(CodeDraw myDrawObj) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
    }


    private static void processGameStep(CodeDraw myDrawObj, MouseEvent me) {
        int[] clickPos = new int[2];
        clickPos[0] = me.getX();
        clickPos[1] = me.getY();

        int width = myDrawObj.getWidth();
        int height = myDrawObj.getHeight();

        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        drawGame(myDrawObj);
    }
	
	// clears game board
    private static void clearBoard(CodeDraw myDrawObj) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
    }

    public static void main(String[] args) {

        int height = 800;
        int width = height + height / (COLORS.length + 1);

        CodeDraw myDrawObj = new CodeDraw(width, height);
        myDrawObj.setTitle("MasterMind Game");

        initGame();

        //for testing to print the solution
        System.out.println(Arrays.toString(solution));

        drawGame(myDrawObj);

        myDrawObj.onMouseClick(Aufgabe1::processGameStep);
    }
}



