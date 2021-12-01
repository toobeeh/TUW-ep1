/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printNumbersAscending(int start, int end, int divider) {
        if(start < end) printNumbersAscending(start, end - 1, divider);
        if(end % divider == 0) System.out.println(end);
    }

    private static void printNumbersDescending(int start, int end, int divider) {
        if(start < end) printNumbersDescending(start+1, end, divider);
        if(start % divider == 0) System.out.println(start);
    }

    private static int sumSquaredDigits(int number) {
        return number > 0 ? ((number%10) * (number%10)) + sumSquaredDigits(number / 10) : 0;
    }

    private static String removeMultipleChars(String text) {
        if(text.length() <= 1) return text;
        String remains = removeMultipleChars(text.substring(1));
        char first = text.charAt(0);
        char firstRemains = remains.charAt(0);
        return first == firstRemains ? remains : first + remains;
    }

    public static void main(String[] args) {
        printNumbersAscending(10, 20, 2);
        System.out.println();
        printNumbersDescending(5, 15, 3);
        System.out.println();

        System.out.println(sumSquaredDigits(1));
        System.out.println(sumSquaredDigits(102));
        System.out.println(sumSquaredDigits(1234));
        System.out.println(sumSquaredDigits(10000));
        System.out.println(sumSquaredDigits(93842));
        System.out.println(sumSquaredDigits(875943789));
        assert (sumSquaredDigits(1) == 1);
        assert (sumSquaredDigits(102) == 5);
        assert (sumSquaredDigits(1234) == 30);
        assert (sumSquaredDigits(10000) == 1);
        assert (sumSquaredDigits(93842) == 174);
        assert (sumSquaredDigits(875943789) == 438);
        System.out.println();

        System.out.println(removeMultipleChars("AA"));
        System.out.println(removeMultipleChars("ABCCDE"));
        System.out.println(removeMultipleChars("SEENDEEN"));
        System.out.println(removeMultipleChars("ABCFFFE 14448"));
        assert (removeMultipleChars("AA").equals("A"));
        assert (removeMultipleChars("ABCCDE").equals("ABCDE"));
        assert (removeMultipleChars("SEENDEEN").equals("SENDEN"));
        assert (removeMultipleChars("ABCFFFE 14448").equals("ABCFE 148"));
    }
}

