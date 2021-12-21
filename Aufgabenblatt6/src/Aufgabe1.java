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
    private static final int FIELD_SIZE = 60;
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
    private static boolean gameReady = false;

    // initializes all global variables for the game
    private static void initGame() {
        playField = new int[NUMBER_OF_TURNS][CODE_LENGTH];
        tips = new int[NUMBER_OF_TURNS][CODE_LENGTH]; // 1 == red; 2 == white
        turn = 0;
        pin = 0;
        solution = generateCode();

        //for testing to print the solution
        System.out.println(Arrays.toString(solution));
    }

    // generates array with length CODE_LENGTH and random numbers from 1 to COLORS.length
    private static int[] generateCode() {
        int[] code = new int[CODE_LENGTH];
        for(int i = 0; i < code.length; i++){
            int random = 0;
            do{
                // math.random * 7: from 0 to 6.999 -> +1: 1 to 7.999 -> cast: truncate
                random = (int)(Math.random()*7 + 1);
            }
            while(findIndex(code, random) != -1);
            code[i] = random;
        }
        return code;
    }

    // calculates red and white tip pins
    private static void updateTips() {
        // also precondition: guess and solution colors are unique in their array
        int red = 0;
        int white = 0;
        for(int fieldIndex = 0; fieldIndex < playField[turn].length; fieldIndex++){
            int solutionIndex = findIndex(solution, playField[turn][fieldIndex]);
            if(solutionIndex >= 0){
                if(solutionIndex == fieldIndex) red++;
                else white++;
            }
        }

        // fill tip array ordered by colors so there's no information about right guess order
        int tipIndex = 0;
        while(red > 0){
            tips[turn][tipIndex] = 1;
            tipIndex++;
            red--;
        }
        while(white > 0){
            tips[turn][tipIndex] = 2;
            tipIndex++;
            white--;
        }
    }

    // draws game to screen
    private static void drawGame(CodeDraw myDrawObj) {
        // draw grey background
        myDrawObj.setColor(Color.LIGHT_GRAY);
        myDrawObj.fillRectangle(0,0, myDrawObj.getWidth(), myDrawObj.getHeight());

        // draw playfield and tips matrix
        for(int turn = 0; turn < playField.length; turn++){
            for(int codePos = 0; codePos < CODE_LENGTH; codePos++){
                // playfield matrix
                myDrawObj.setColor(Color.BLACK);
                myDrawObj.setLineWidth(FIELD_SIZE / 30);

                // get coordinates
                int x = codePos * FIELD_SIZE + FIELD_SIZE / 2;
                int y = myDrawObj.getHeight() - (turn * FIELD_SIZE + FIELD_SIZE / 2);
                double radius = FIELD_SIZE * 0.4;

                // draw outline
                myDrawObj.drawCircle(x, y, radius);

                // draw fill depending on field value
                if(playField[turn][codePos] > 0) myDrawObj.setColor(COLORS[playField[turn][codePos] - 1]);
                else myDrawObj.setColor(Color.WHITE);
                myDrawObj.fillCircle(x, y, radius);

                // turn-tip matrix
                int tip = tips[turn][codePos];
                if(tip > 0){
                    myDrawObj.setColor(tip == 2 ? Color.WHITE : Color.RED);
                    int xTip = CODE_LENGTH * FIELD_SIZE + x;
                    myDrawObj.fillCircle(xTip, y, radius / 3);
                }
            }
        }

        // draw color fields and back-button
        int rowCount = COLORS.length + 1;

        // calc height of a column (double division)
        double rowHeight = myDrawObj.getHeight() / (double)rowCount;

        for(int row = 0; row < rowCount; row++){
            double y = myDrawObj.getHeight() - (row + 1) * rowHeight;
            int x = 2 * CODE_LENGTH * FIELD_SIZE;

            // bottommost column is back-button
            if(row == 0){
                myDrawObj.drawImage(x, y, FIELD_SIZE, rowHeight, "src/back_button.png");
            }

            // other columns are color fields
            else{
                myDrawObj.setColor(COLORS[row-1]);
                myDrawObj.fillRectangle(x, y, FIELD_SIZE, rowHeight);
            }
        }

        myDrawObj.show();
    }


    private static void processGameStep(CodeDraw myDrawObj, MouseEvent me) {
        if(!gameReady) return;

        // get next empty color slot of current turn
        int firstZeroIndex = findIndex(playField[turn], 0);

        // if none found, illegal state!
        if(firstZeroIndex < 0 || firstZeroIndex >= CODE_LENGTH) return;

        int[] clickPos = new int[2];
        clickPos[0] = me.getX();
        clickPos[1] = me.getY();

        int height = myDrawObj.getHeight();

        // actions only on color/back column: ignore other x
        if(clickPos[0] >= 2*CODE_LENGTH*FIELD_SIZE) {
            double rowHeight = height / (COLORS.length + 1.0);
            // if click was on backbutton
            if(clickPos[1] >= height - rowHeight){
                // there must be a "last color" this turn
                if(firstZeroIndex > 0){
                    playField[turn][firstZeroIndex-1] = 0;
                }
            }
            // if click was on one on the colors
            else{
                // calc color index
                int colorIndex = (int)(COLORS.length - clickPos[1] / rowHeight) + 1;
                // if color index is in bounds and not already contained in this turn
                if(colorIndex > 0 && colorIndex <= COLORS.length && findIndex(playField[turn], colorIndex) < 0){
                    playField[turn][firstZeroIndex] = colorIndex;
                    // if all slots are set, next turn
                    if(firstZeroIndex == CODE_LENGTH-1){
                        updateTips();
                        turn++;
                    }
                }
            }
            drawGame(myDrawObj);

            // if current turn exceeds max count of turns
            if(turn >= NUMBER_OF_TURNS){
                // loseeeee
                System.out.println("lose");
                endGame(false, myDrawObj);
            }

            // else if last tips finished the game
            else if(turn > 0 && countValue(tips[turn-1], 1) == CODE_LENGTH) {
                // winnnnnnn
                System.out.println("win");
                endGame(true, myDrawObj);
            }
        }
    }

    private static void endGame(boolean win, CodeDraw draw){
        gameReady = false;

        // show message and clear afterwards
        showBoardMessage(draw, win ? Color.GREEN : Color.RED, win ? "You won :] <3" : "U lose :((", 5000);
        drawGame(draw);

        // clear animation, then reset game
        clearBoard(draw);
        initGame();

        // show new game message, clear and unblock game
        showBoardMessage(draw, Color.BLACK, "New Game", 2500);
        drawGame(draw);
        gameReady = true;
    }
	
	// clears game board
    private static void clearBoard(CodeDraw myDrawObj) {
        // loop through history and clear where not empty
        for(int pastTurn = NUMBER_OF_TURNS - 1; pastTurn >= 0; pastTurn--){
            if(playField[pastTurn][0] > 0){
                for(int codePos = 0; codePos < CODE_LENGTH; codePos++){
                    // get coordinates
                    int x = codePos * FIELD_SIZE + FIELD_SIZE / 2;
                    int y = myDrawObj.getHeight() - (pastTurn * FIELD_SIZE + FIELD_SIZE / 2);
                    double radius = FIELD_SIZE * 0.4;

                    // draw outline
                    myDrawObj.setColor(Color.BLACK);
                    myDrawObj.drawCircle(x, y, radius);

                    // draw fill
                    myDrawObj.setColor(Color.WHITE);
                    myDrawObj.fillCircle(x, y, radius);

                    // clear tips
                    myDrawObj.setColor(Color.LIGHT_GRAY);
                    myDrawObj.fillRectangle(
                            CODE_LENGTH * FIELD_SIZE,
                            myDrawObj.getHeight() - (pastTurn * FIELD_SIZE + FIELD_SIZE),
                            CODE_LENGTH * FIELD_SIZE,
                            FIELD_SIZE
                    );
                }
                // show with timeout
                myDrawObj.show(500);
            }
        }
    }

    private static void showBoardMessage(CodeDraw draw, Color fontColor, String message, int timeout){
        final int width = draw.getWidth() / 4;
        final int height = draw.getHeight() / 9;

        double x = (draw.getWidth() - width) / 2;
        double y = (draw.getHeight() - height) / 2;

        draw.setColor(Color.LIGHT_GRAY);
        draw.fillRectangle(x, y, width, height);
        draw.setColor(Color.BLACK);
        draw.drawRectangle(x, y, width, height);

        draw.setColor(fontColor);
        TextFormat tft = new TextFormat();
        tft.setHorizontalAlign(HorizontalAlign.CENTER);
        tft.setVerticalAlign(VerticalAlign.MIDDLE);
        draw.setTextFormat(tft);
        draw.drawText(draw.getWidth() / 2, draw.getHeight() / 2, message);

        draw.show(timeout);
    }

    public static int findIndex(int[] source, int value){
        int index = -1;
        for(int i = 0; i < source.length; i++){
            if(source[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int countValue(int[] source, int value){
        int occ = 0;
        for(int v : source) if(v == value) occ++;
        return occ;
    }

    public static void main(String[] args) {
        int height = NUMBER_OF_TURNS * FIELD_SIZE;
        int width = CODE_LENGTH * FIELD_SIZE * 2 + FIELD_SIZE;

        CodeDraw myDrawObj = new CodeDraw(width, height);
        myDrawObj.setTitle("MasterMind Game");
        initGame();

        drawGame(myDrawObj);
        myDrawObj.onMouseClick(Aufgabe1::processGameStep);
        gameReady = true;
    }
}



