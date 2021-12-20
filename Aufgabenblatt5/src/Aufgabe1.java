/*
    Aufgabe 1) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static int[][] genFilledArray(int n) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return null; //Zeile kann geändert oder entfernt werden.
    }

    private static void shiftLinesInArray(int[][] workArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
    }

    private static int[][] extendArray(int[][] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return null; //Zeile kann geändert oder entfernt werden.
    }

    private static long[] reformatArray(int[][] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return null; //Zeile kann geändert oder entfernt werden.
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                for (int j = 0; j < inputArray[i].length; j++) {
                    System.out.print(inputArray[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                System.out.print(inputArray[i] + "\t");
            }
            System.out.println();
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(long[] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                System.out.print(inputArray[i] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] array = genFilledArray(2);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{2, 4}, {4, 2}}));
        System.out.println();

        array = genFilledArray(4);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{2, 4, 6, 8}, {4, 6, 8, 6}, {6, 8, 6, 4}, {8, 6, 4, 2}}));
        System.out.println();

        array = genFilledArray(5);
        printArray(array);
        System.out.println();


        int[][] array1 = new int[][]{{1, 3, 5}, {6, 2, 1}, {0, 7, 9}};
        shiftLinesInArray(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{6, 2, 1}, {0, 7, 9}, {1, 3, 5}}));
        printArray(array1);
        System.out.println();

        array1 = new int[][]{{1, 5, 6, 7}, {1, 9, 3}, {4}, {6, 3, 0, 6, 2}, {6, 3, 0}};
        shiftLinesInArray(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{1, 9, 3}, {4}, {6, 3, 0, 6, 2}, {6, 3, 0}, {1, 5, 6, 7}}));
        printArray(array1);
        System.out.println();


        int[][] array2 = new int[][]{{4}, {1, 2, 3}, {5, 6}, {7, 8, 9, 1}};
        int[][] array2new1 = extendArray(array2);
        printArray(array2new1);
        assert (Arrays.deepEquals(array2new1, new int[][]{{1, 1, 1, 4}, {1, 1, 2, 3}, {1, 1, 5, 6}, {7, 8, 9, 1}}));
        System.out.println();

        array2 = new int[][]{{2, 0, 4, 7, 0, 9, 1, 0}, {0, 4, 2, 3, 1, 5}, {6, 8}, {3, 2, 0, 6}, {7, 9, 0, 1}, {9}, {1}};
        int[][] array2new2 = extendArray(array2);
        printArray(array2new2);
        assert (Arrays.deepEquals(array2new2, new int[][]{{2, 0, 4, 7, 0, 9, 1, 0}, {1, 1, 0, 4, 2, 3, 1, 5}, {1, 1, 1, 1, 1, 1, 6, 8}, {1, 1, 1, 1, 3, 2, 0, 6}, {1, 1, 1, 1, 7, 9, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 9}, {1, 1, 1, 1, 1, 1, 1, 1}}));
        System.out.println();

        array2 = new int[][]{{1, 3, 2}, {5, 1}, {6, 8, 5, 4}, {9, 4, 1, 9, 2}, {1, 8, 7, 5, 3, 2, 5}, {3}};
        int[][] array2new3 = extendArray(array2);
        printArray(array2new3);
        assert (Arrays.deepEquals(array2new3, new int[][]{{1, 1, 1, 1, 1, 3, 2}, {1, 1, 1, 1, 1, 5, 1}, {1, 1, 1, 6, 8, 5, 4}, {1, 1, 9, 4, 1, 9, 2}, {1, 8, 7, 5, 3, 2, 5}, {1, 1, 1, 1, 1, 1, 3}}));
        System.out.println();


        int[][] array3 = new int[][]{{1}, {0, 2, 0}, {1, 0, 2, 5, 0, 0, 0}, {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}};
        long[] array3new = reformatArray(array3);
        printArray(array3new);
        assert (Arrays.equals(array3new, new long[]{1, 20, 1025000, 987654321010000000L, 1}));
        System.out.println();
    }
}

