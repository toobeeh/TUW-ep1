/*
    Aufgabe 2) Überladen von Methoden
*/
public class Aufgabe2 {

    private static void addSequence(String text, char symbol) {
        String sequence = "";
        int textLength = text.length();
        for(int textIndex = 0; textIndex < textLength; textIndex++){
            sequence += text.charAt(textIndex);
            if(textIndex != textLength - 1)
                sequence += "" + symbol + symbol + symbol;
        }
        System.out.println(sequence);
    }

    private static void addSequence(int number, char symbol) {
        addSequence(Integer.toString(number), symbol);
    }

    private static void addSequence(String text, String symbols) {
        for(int symbolIndex = 0; symbolIndex < symbols.length(); symbolIndex++)
            addSequence(text, symbols.charAt(symbolIndex));
    }

    private static void addSequence(String text) {
        addSequence(text, '+');
    }

    public static void main(String[] args) {
        String text0 = "";
        String text1 = "TU";
        String text2 = "Hello!";
        String text3 = "-EP1-";
        String text4 = "JAVA";

        addSequence(text0, '&');
        addSequence(text1, '#');
        addSequence(text2, '-');
        addSequence(text3, '$');
        addSequence(text4, '!');
        System.out.println();

        addSequence(1, '%');
        addSequence(42, '*');
        addSequence(163, ':');
        addSequence(2048, '#');
        addSequence(42815, '(');
        System.out.println();

        addSequence(text1, "(O)");
        addSequence(text2, "*#=_");
        System.out.println();

        addSequence(text0);
        addSequence(text1);
        addSequence(text2);
    }
}
