/*
    Aufgabe 3) Eindimensionale Arrays und Methoden
*/

import java.util.Arrays;

public class Aufgabe3 {

    private static int[] genRandomArray(int length, int maxNumber) {
        int[] randomArray = new int[length];
        for(int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int)(Math.random() * maxNumber);
        }
        return randomArray;
    }

    private static void replaceValuesLowerAverage(int[] workArray) {
        // get sum
        int sum = 0;
        for(int entry: workArray) sum += entry;
        // replace below avg
        int avg = sum / workArray.length;
        for(int i = 0; i < workArray.length; i++) {
            if(workArray[i] < avg) workArray[i] = avg;
        }
    }

    private static int[] combineArrays(int[] workArray1, int[] workArray2) {
        int[] combined = new int[workArray1.length + workArray2.length];
        //if arrays are not equal length
        if(workArray1.length != workArray2.length){
            // find bigger array
            int[] bigger = workArray1.length > workArray2.length ? workArray1 : workArray2;
            // set other array by comparing pointer of bigger array (more dynamic than detecting smaller..)
            int[] other = bigger == workArray1 ? workArray2 : workArray1;
            for(int i = 0; i < bigger.length; i++){
                combined[i] = bigger[i];
                if(other.length > i) combined[i + bigger.length] = other[i];
            }
        }
        // both arrays are of equal length
        else {
            // fill combined alternating
            for(int i = 0; i < workArray1.length; i++){
                combined[i * 2] = workArray1[i];
                combined[i * 2 + 1] = workArray2[i];
            }
        }
        return combined;
    }

    public static void main(String[] args) {
        int[] array1 = genRandomArray(20, 50);
        System.out.println(Arrays.toString(array1));
        System.out.println();

        int[] array2 = new int[]{17, 3, 15, 21, 34, 12, 5, 8, 25, 30};
        replaceValuesLowerAverage(array2);
        System.out.println(Arrays.toString(array2));
        assert (Arrays.equals(array2, new int[]{17, 17, 17, 21, 34, 17, 17, 17, 25, 30}));

        int[] array3 = new int[]{21, 14, 17, 12};
        replaceValuesLowerAverage(array3);
        System.out.println(Arrays.toString(array3));
        assert (Arrays.equals(array3, new int[]{21, 16, 17, 16}));

        int[] array4 = new int[]{3, 4, 6, 7};
        replaceValuesLowerAverage(array4);
        System.out.println(Arrays.toString(array4));
        assert (Arrays.equals(array4, new int[]{5, 5, 6, 7}));

        int[] array5 = new int[]{7, 7};
        replaceValuesLowerAverage(array5);
        System.out.println(Arrays.toString(array5));
        assert (Arrays.equals(array5, new int[]{7, 7}));

        int[] array6 = new int[]{3, 2, 1};
        replaceValuesLowerAverage(array6);
        System.out.println(Arrays.toString(array6));
        assert (Arrays.equals(array6, new int[]{3, 2, 2}));
        System.out.println();

        int[] array7 = combineArrays(array2, array3);
        System.out.println(Arrays.toString(array7));
        assert (Arrays.equals(array7, new int[]{17, 17, 17, 21, 34, 17, 17, 17, 25, 30, 21, 16, 17, 16}));

        int[] array8 = combineArrays(array6, array4);
        System.out.println(Arrays.toString(array8));
        assert (Arrays.equals(array8, new int[]{5, 5, 6, 7, 3, 2, 2}));

        int[] array9 = combineArrays(array3, array4);
        System.out.println(Arrays.toString(array9));
        assert (Arrays.equals(array9, new int[]{21, 5, 16, 5, 17, 6, 16, 7}));

        int[] array10 = combineArrays(array6, new int[]{});
        System.out.println(Arrays.toString(array10));
        assert (Arrays.equals(array10, new int[]{3, 2, 2}));
    }
}
