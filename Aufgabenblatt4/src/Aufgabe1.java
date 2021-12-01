/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void fillArray(int[] filledArray) {
        int number = 6;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 6;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 4 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[10];
        int number = 6;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 6;
        }
        workArray = helpArray;
        printArray(workArray);
    }

    private static void printArray(int[] workArray) {
        for (int i = 0; i < workArray.length; i++) {
            System.out.print(workArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] filledArray = new int[10];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 777;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);
    }

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************

    //Frage 1:
    // Die Zählervariable in der For-Schleife muss inkrementiert werden.

    //Frage 2:
    // Der Methode wird der Pointer auf das Array übergeben. Das referenzierte Array wird dann befüllt.

    //Frage 3:
    // Die Methode arbeitet tatsächlich nicht mit einer Kopie, sondern nur einer Kopie des Pointers.
    // Daher wird eigentlich das ursprüngliche Array gefiltert.

    //Frage 4:
    // In der Methode fillArrayWithNewContent wird am Ende nicht das originale Array überschrieben, sondern nur der Array-Pointer auf das originale Array
    // im Frame der Methode überschrieben.

    // Zusatzfragen:
    // 1 - Der Index muss eine Ganzzahl sein. Das kann einerseits ein int, aber auch ein Datentyp wie char oder byte sein.
    // 2 - Wenn mit dem Array gearbeitet werden soll, schon. Allerdings muss nicht jede Position initialisiert werden, das geschieht per Defaults.
    // 3 - Es kann die Methode Arrays.copyOf verwendet werden. Param. 1 ist das Array, Param.  2 die neue Länge
    // 4 - Es wird wenn nicht anders verlangt die Mehtode System.arraycopy verwendet.
    // 5 - Ja.
    // 6 - Nur, wenn geprüft werden soll ob die Arrays die selben sind - NICHT die gleichen! (Pointer vs Inhalt)

}
