/*
    Aufgabe 1) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static int[][] genFilledArray(int n) {
        int[][] numbers = new int[n][n];
        // loop through positions in matrix
        for(int outerIndex = 0; outerIndex < n; outerIndex++){
            for(int innerIndex = 0; innerIndex < n; innerIndex++){
                // calculate value
                int value = (innerIndex + 1 + outerIndex) * 2;
                // if value exceeds limit (n*2), value is the difference to that
                if(value > n*2) value = n*2 - (value - n * 2);
                numbers[outerIndex][innerIndex] = value;
            }
        }
        return numbers;
    }

    private static void shiftLinesInArray(int[][] workArray) {
        // save shifted out element on the edge
        int[] edge = workArray[0];
        for(int line = 1; line < workArray.length; line++){
            workArray[line - 1] = workArray[line];
        }
        // restore shifted out element at other edge of array
        workArray[workArray.length-1] = edge;
    }

    private static int[][] extendArray(int[][] inputArray) {
        // find size
        int size = 0;
        for(int[] line : inputArray) size = Math.max(line.length, size);

        // init and loop through extended array
        int[][] extended = new int[inputArray.length][size];
        for(int line = 0; line < extended.length; line++){
            // reverse loop through line with dynamic index from end (to match different lengths: distance instead index)
            for(int endDistance = 0; endDistance < size; endDistance++){
                // if index does not exist in input array, fill with 1
                if(endDistance > inputArray[line].length - 1) extended[line][size - 1 - endDistance] = 1;
                else extended[line][size - 1 - endDistance] = inputArray[line][inputArray[line].length - 1 - endDistance];
            }
        }
        return extended;
    }

    private static long[] reformatArray(int[][] inputArray) {
        long[] reformatted = new long[inputArray.length];
        // loop through lines
        for(int line = 0; line < reformatted.length; line++){
            long sum = 0;
            // loop through decimal places
            for(int exp = 0; exp < inputArray[line].length; exp++){
                // calculate value and add to sum
                sum += inputArray[line][exp] * Math.pow(10, inputArray[line].length - 1 - exp);
            }
            reformatted[line] = sum;
        }
        return reformatted;
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

