/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static String arrayJoin(int[] array, String separator){
        String line = "";
        for(int i = 0; i < array.length; i++) {
            line += (i == 0 ? "" : separator) + array[i];
        }
        return line;
    }

    public static void main(String[] args) {
        // a
        int[] numbers = {2, 14, 5, 9, 3, 8, 4, 7, 6, 10};
        System.out.println(arrayJoin(numbers, ","));

        // b
        numbers = new int[20];
        int start = 12;
        for(int i = 0; i < numbers.length; i++){
            int value = start + i * 4;
            numbers[i] = value % 6 == 0 ? 0 : value;
        }
        System.out.println(arrayJoin(numbers, " "));

        // c
        numbers = new int[] {5, 2, 3, 5, 5, 4, 6, 7, 8, 5};
        int fiveCount = 0;
        // count fives in numbers array
        for (int number : numbers) {
            if(number == 5) fiveCount++;
        }
        // create result array with space for extra number per five
        int[] result = new int[numbers.length + fiveCount];
        // index variables for both arrays
        int numbersIndex = 0, resultIndex = 0;
        // loop through numbers array
        while(numbersIndex < numbers.length){
            result[resultIndex] = numbers[numbersIndex];
            // if number is five, insert additional number and increment index of result
            if(result[resultIndex] == 5) result[++resultIndex] = -1;
            resultIndex++;
            numbersIndex++;
        }
        System.out.println(arrayJoin(result, " "));

        // d
        numbers = new int[15];
        // fill numbers with 1-15
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = i+1;
        }
        // print content reverse with while
        numbersIndex = numbers.length-1;
        System.out.print("\nwhile-schleife:");
        while(numbersIndex >= 0) {
            System.out.print(" " + numbers[numbersIndex--]);
        }
        // print content reverse with for
        System.out.print("\nfor-schleife:");
        for(int i = numbers.length-1; i >= 0; i--) {
            System.out.print(" "+ numbers[i]);
        }

        // e
        numbers = new int[] {54, 14, 18, 9, 5, 32, 41, 71, 1, 46, 76, 6, 45, 89, 18};
        int min = 0, max = 0;
        double sum = 0;
        // find sum, min and max
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] < min) min = numbers[i];
            if(numbers[i] > max) max = numbers[i];
            sum += numbers[i];
        }
        // init array containing min, avg and max
        int[] stats = {min, (int)Math.round(sum / numbers.length), max};
        System.out.println("\n" + arrayJoin(numbers, " "));
        System.out.println(arrayJoin(stats, " "));
    }
}

