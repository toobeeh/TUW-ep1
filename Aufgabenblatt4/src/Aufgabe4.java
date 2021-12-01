/*
    Aufgabe 4) Rekursion mit eindimensionalen Arrays
*/

import java.util.Arrays;

public class Aufgabe4 {

    private static int getHighestTripleSum(int[] workArray, int start, int end) {
        int thisSum = 0;
        int otherHighest = 0;
        // if end is not out of bounds and at least one item between start and end items
        if(workArray.length > end && end - start > 1){
            // get current triple sum
            thisSum = workArray[start + 0] + workArray[start + 1] + workArray[start + 2];
            // get highest triple sum of remainings
            otherHighest = getHighestTripleSum(workArray, ++start, end);
        }
        return thisSum > otherHighest ? thisSum : otherHighest;
    }

    private static int getHighestDifferenceWithLastValue(int[] workArray, int index) {
        int thisDifference = 0, otherDifference = 0;
        // if index is in range
        if(workArray.length > index) {
            // get this abs difference
            thisDifference = Math.abs(workArray[workArray.length-1] - workArray[index]);
            // get other biggest abs difference
            otherDifference = getHighestDifferenceWithLastValue(workArray, ++index);
        }
        return thisDifference > otherDifference ? thisDifference : otherDifference;
    }

    private static int[] replaceAllMoreDigitValues(int[] workArray, int index) {
        int[] workClone = workArray.clone();
        // if index is in range
        if(workArray.length > index) {
            // replace remaining digitvalues
            workClone = replaceAllMoreDigitValues(workClone, index + 1);
            // replace this digitvalue
            if(workClone[index] > 9) workClone[index] = -1;
        }
        return workClone;
    }

    private static boolean containsValue(int[] workArray, int value) {
        boolean contains = false;
        // if array can be split
        if(workArray.length >= 2){
            // check if first or second half copies contain value
            contains = containsValue(Arrays.copyOfRange(workArray, 0, workArray.length / 2 ), value)
                    || containsValue(Arrays.copyOfRange(workArray, workArray.length / 2, workArray.length), value);
        } else if ( workArray.length == 1) contains = workArray[0] == value; // else just check the only value
        return contains;
    }

    public static void main(String[] args) {
        int[] array1 = {2, 13, 3, 16, 12, 4, 9, 14};
        System.out.println(getHighestTripleSum(array1, 0, array1.length - 1));
        System.out.println(getHighestTripleSum(array1, 4, array1.length - 1));
        System.out.println(getHighestTripleSum(array1, 2, 5));
        System.out.println(getHighestTripleSum(array1, 0, 1));
        System.out.println();

        int[] array2 = {33, 23, 53, 29, 12, 34, 41, 44, 28, 13};
        System.out.println(getHighestDifferenceWithLastValue(array2, 1));
        System.out.println(getHighestDifferenceWithLastValue(array2, 4));
        System.out.println(getHighestDifferenceWithLastValue(array2, 6));
        System.out.println(getHighestDifferenceWithLastValue(array2, 8));
        System.out.println();

        int[] array3 = {12, 6, 21, 2, 5, 15, 26, 3, 10, 28};
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(replaceAllMoreDigitValues(array3, 0)));
        System.out.println(Arrays.toString(replaceAllMoreDigitValues(array3, 3)));
        System.out.println(Arrays.toString(replaceAllMoreDigitValues(array3, 6)));
        System.out.println(Arrays.toString(replaceAllMoreDigitValues(array3, 8)));
        System.out.println();

        int[] array4 = {3, 9, 17, 11, -7, 8, 0, 9, 24, -3, 17, 4};
        System.out.println(containsValue(array4, 11));
        System.out.println(containsValue(array4, 2));
        System.out.println(containsValue(array4, -7));
        System.out.println(containsValue(array4, 0));
        System.out.println(containsValue(array4, 9));
        System.out.println(containsValue(array4, 16));


        assert (getHighestTripleSum(array1, 0, array1.length - 1) == 32);
        assert (getHighestTripleSum(array1, 4, array1.length - 1) == 27);
        assert (getHighestTripleSum(array1, 2, 5) == 32);
        assert (getHighestTripleSum(array1, 0, 1) == 0);

        assert (getHighestDifferenceWithLastValue(array2, 1) == 40);
        assert (getHighestDifferenceWithLastValue(array2, 4) == 31);
        assert (getHighestDifferenceWithLastValue(array2, 6) == 31);
        assert (getHighestDifferenceWithLastValue(array2, 8) == 15);

        assert (Arrays.equals(replaceAllMoreDigitValues(array3, 0), new int[]{-1, 6, -1, 2, 5, -1, -1, 3, -1, -1}));
        assert (Arrays.equals(replaceAllMoreDigitValues(array3, 3), new int[]{12, 6, 21, 2, 5, -1, -1, 3, -1, -1}));
        assert (Arrays.equals(replaceAllMoreDigitValues(array3, 6), new int[]{12, 6, 21, 2, 5, 15, -1, 3, -1, -1}));
        assert (Arrays.equals(replaceAllMoreDigitValues(array3, 8), new int[]{12, 6, 21, 2, 5, 15, 26, 3, -1, -1}));

        assert (containsValue(array4, 11));
        assert (!containsValue(array4, 2));
        assert (containsValue(array4, -7));
        assert (containsValue(array4, 0));
        assert (containsValue(array4, 9));
        assert (!containsValue(array4, 16));
    }
}

