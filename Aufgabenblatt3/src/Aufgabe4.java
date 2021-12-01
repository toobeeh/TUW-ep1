/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static boolean isStringPalindrome(String text) {
        return text.length() <= 1
                || text.charAt(0) == text.charAt(text.length()-1)
                && isStringPalindrome(text.substring(1, text.length()-1));
    }

    private static String shiftTs(String text) {
        if(text.length() > 1) {
            char lastChar = text.charAt(text.length()-1);
            String begin = text.substring(0, text.length() - 1);
            if(lastChar == 'T') text = 'T' + shiftTs(begin);
            else text = shiftTs(begin) + lastChar;
        }
        return text;
    }

    public static void main(String[] args) {
        System.out.println(isStringPalindrome("lagerregal"));
        System.out.println(isStringPalindrome("otto"));
        System.out.println(isStringPalindrome("rentner"));
        System.out.println(isStringPalindrome("abcba"));
        System.out.println(isStringPalindrome("test"));
        System.out.println(isStringPalindrome("teppichstaubsauger"));
        System.out.println();

        System.out.println(shiftTs(""));
        System.out.println(shiftTs("T"));
        System.out.println(shiftTs("BT"));
        System.out.println(shiftTs("TBT"));
        System.out.println(shiftTs("TBCTDFTTGHTTT"));
        System.out.println(shiftTs("TTHVVGWTTBSJTTT"));
        System.out.println(shiftTs("ZMNGFBTTTTTTTTT"));

        assert (isStringPalindrome("lagerregal"));
        assert (isStringPalindrome("otto"));
        assert (isStringPalindrome("rentner"));
        assert (isStringPalindrome("abcba"));
        assert (!isStringPalindrome("test"));
        assert (!isStringPalindrome("teppich"));

        assert (shiftTs("").equals(""));
        assert (shiftTs("T").equals("T"));
        assert (shiftTs("BT").equals("TB"));
        assert (shiftTs("TBT").equals("TTB"));
        assert (shiftTs("TBCTDFTTGHTTT").equals("TTTTTTTBCDFGH"));
        assert (shiftTs("TTHVVGWTTBSJTTT").equals("TTTTTTTHVVGWBSJ"));
        assert (shiftTs("ZMNGFBTTTTTTTTT").equals("TTTTTTTTTZMNGFB"));
    }
}
