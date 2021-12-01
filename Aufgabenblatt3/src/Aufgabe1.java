/*
    Aufgabe 1) Code-Analyse, Coding-Style und Methoden
*/
public class Aufgabe1 {

    //*************************************************************************************************************
    // FOLGENDER KOMMENTIERTER CODE DIENT ALS ANGABE - BITTE NICHT ÄNDERN!
    //*************************************************************************************************************
    /*
    private static String f0(String s) {
        int n = f1(s);String ss = s;
        for (int i = 0; f2(i, n/2); i=f3(i,1)) {
            for (int j = 0; f2(j, n - i - 1); j = f3(j, 1)) {
                if (f4(ss.charAt(j), ss.charAt(j+1))) ss = f5(ss, 0, j) + ss.charAt(j + 1) + "" + ss.charAt(j) + f5(ss, j + 2, ss.length());}
            for (int j = n - i - 2; f2(i,j); j = f3(j, -1)) {
                if (f4(ss.charAt(j-1), ss.charAt(j))) {
                    ss = f5(ss, 0, j-1) + ss.charAt(j) + "" + ss.charAt(j-1) + f5(ss, j + 1, ss.length());
                }
            }
        }
        return ss;
    }

    private static int f1(String s) {
        return s.length();
    }

    private static boolean f2(int i1, int i2) { return i1 < i2; }

    private static int f3(int n1, int n2) {
        return n1 + n2;
    }

    private static boolean f4(char c1, char c2) {
        return c1 > c2;
    }

    private static String f5(String s, int n1, int n2) {
        return s.substring(n1, n2);
    }
    */
    //*************************************************************************************************************

    //*************************************************************************************************************
    //TODO: a) Funktionsweise Code - Beschreiben Sie in ein bis zwei Sätzen, was der gegebene Code macht.

    // The function f0 sorts the chars of a given string.

    // The sorting algorithm has one main loop which sets a distance from the string end/start bounds,
    // and two inner loops that each go from bottom-up and top-down in the interval set by the main loop:
    // [start + distance; end - distance]

    // The bottom-up loop moves the highest-value char to the end of the interval,
    // the top-down loop the lowest-value char to the start of the interval.

    // COMMENT: Original bottom-up loop starts *always* at 0 index -> inefficient

    // f1: returns the length of the string passed as parameter
    // f2: checks if first parameter int is smaller than second
    // f3: adds two given parameter ints
    // f4: checks if first parameter char value is bigger than second
    // f5: returns a substring of the string param 1 with start index of second parameter int to excluded end-index parameter 3

    //*************************************************************************************************************
    //TODO: b) Code-Adaptierung - Formatieren Sie den gegebenen Code und verwenden Sie sinnvolle Methoden- und Variablennamen.

    private static String f0(String s) {
        int length = StringLength(s);
        String sortString = s;
        for (int distance = 0; IsLesser(distance, length/2); distance= Add(distance,1)) {
            for (int bottomUpIndex = 0; IsLesser(bottomUpIndex, length - distance - 1); bottomUpIndex = Add(bottomUpIndex, 1)) {
                if (IsBigger(sortString.charAt(bottomUpIndex), sortString.charAt(bottomUpIndex+1)))
                    sortString = Substring(sortString, 0, bottomUpIndex) + sortString.charAt(bottomUpIndex + 1) + ""
                            + sortString.charAt(bottomUpIndex) + Substring(sortString, bottomUpIndex + 2, sortString.length());}
            for (int topDownIndex = length - distance - 2; IsLesser(distance,topDownIndex); topDownIndex = Add(topDownIndex, -1)) {
                if (IsBigger(sortString.charAt(topDownIndex-1), sortString.charAt(topDownIndex)))
                    sortString = Substring(sortString, 0, topDownIndex-1) + sortString.charAt(topDownIndex) + ""
                            + sortString.charAt(topDownIndex-1) + Substring(sortString, topDownIndex + 1, sortString.length());
            }
        }
        return sortString;
    }

    private static int StringLength(String s) {
        return s.length();
    }

    private static boolean IsLesser(int i1, int i2) { return i1 < i2; }

    private static int Add(int n1, int n2) {
        return n1 + n2;
    }

    private static boolean IsBigger(char c1, char c2) {
        return c1 > c2;
    }

    private static String Substring(String s, int n1, int n2) {
        return s.substring(n1, n2);
    }

    //*************************************************************************************************************
    //TODO: c) Vervollständigen Sie hier die Methode, die die gleiche Funktionalität wie f0 hat.

    private static String SortStringCharacters(String input) {
        int length = input.length();
        // move distance from 0 to string half index
        for (int distance = 0; distance < length/2; distance++) {
            // go from bottom distance up to top distance
            // -> moves highest value to end of range
            for (int bottomUpCompare = distance; bottomUpCompare < length - distance - 1; bottomUpCompare++) {
                if (input.charAt(bottomUpCompare) > input.charAt(bottomUpCompare+1))
                    // if earlier char > latter char, swap them in string
                    input = input.substring(0, bottomUpCompare) + input.charAt(bottomUpCompare + 1) + input.charAt(bottomUpCompare)
                            + input.substring(bottomUpCompare + 2);
            }
            // go from top distance down to start distance
            // moves lowest value to start of range
            for (int topDownCompare = length - distance - 2; distance < topDownCompare; topDownCompare--) {
                if (input.charAt(topDownCompare-1) > input.charAt(topDownCompare))
                    // if earlier char > latter char, swap them in the string
                    input = input.substring(0, topDownCompare-1) + input.charAt(topDownCompare) + "" + input.charAt(topDownCompare-1)
                            + input.substring(topDownCompare + 1);
            }
        }
        return input;
    }

    //*************************************************************************************************************

    public static void main(String args[]) {
        System.out.println(SortStringCharacters("ab"));
        System.out.println(SortStringCharacters("ba"));
        System.out.println(SortStringCharacters("aa"));
        System.out.println(SortStringCharacters("cba"));
        System.out.println(SortStringCharacters("abababab"));
        System.out.println(SortStringCharacters("abcfghed"));
        System.out.println(SortStringCharacters("abnasnasab"));
        System.out.println(SortStringCharacters("najskaghkkjsfvjhbavbdfsan"));
        System.out.println(SortStringCharacters("jgbgdsjabkjdbvbdjabkjsavbkjbdsvkjbagfgafjdbv"));

        assert (SortStringCharacters("ab").equals("ab"));
        assert (SortStringCharacters("ba").equals("ab"));
        assert (SortStringCharacters("aa").equals("aa"));
        assert (SortStringCharacters("cba").equals("abc"));
        assert (SortStringCharacters("abababab").equals("aaaabbbb"));
        assert (SortStringCharacters("abcfghed").equals("abcdefgh"));
        assert (SortStringCharacters("abnasnasab").equals("aaaabbnnss"));
        assert (SortStringCharacters("najskaghkkjsfvjhbavbdfsan").equals("aaaabbdffghhjjjkkknnsssvv"));
        assert (SortStringCharacters("jgbgdsjabkjdbvbdjabkjsavbkjbdsvkjbagfgafjdbv").equals("aaaaabbbbbbbbbdddddffggggjjjjjjjjkkkksssvvvv"));
    }
}


