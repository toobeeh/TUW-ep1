/*
    Aufgabe 2) Zweidimensionale Arrays - Sortieren und Filtern
*/
public class Aufgabe2 {

    private static double[][] genMeanFilter(int rows, int cols) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
		
        return null; //Zeile kann geändert oder entfernt werden.
    }

    private static double[][] applyFilter(double[][] workArray, double[][] filterArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        
        return null; //Zeile kann geändert oder entfernt werden.
    }

    private static void print(double[][] workArray) {
        if (workArray != null) {
            for (int y = 0; y < workArray.length; y++) {
                for (int x = 0; x < workArray[y].length; x++) {
                    System.out.printf("%.2f", workArray[y][x]);
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] myResultArray;

        double[][] myFilter1 = genMeanFilter(3, 3);
        print(myFilter1);
        double[][] myFilter2 = genMeanFilter(1, 5);
        print(myFilter2);

        assert (genMeanFilter(2, 2) == null);
        assert (genMeanFilter(0, -1) == null);

        double[][] myArray1 = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}, {5, 5, 5, 5}};
        print(myArray1);

        myResultArray = applyFilter(myArray1, myFilter1);
        print(myResultArray);
        myResultArray = applyFilter(myArray1, myFilter2);
        print(myResultArray);

        //Beispiel aus Aufgabenblatt
        double[][] myArray3 = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        double[][] myFilter3 = {{1, 0, 0}, {1, 2, 0}, {0, 0, 3}};
        print(myArray3);
        myResultArray = applyFilter(myArray3, myFilter3);
        print(myResultArray);

        double[][] myArray4 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        print(myArray4);

        //TODO: Erstellen Sie den im Aufgabenblatt angegebenen Filter, wenden Sie ihn auf myArray4 an und geben Sie das Ergebnis mittels print() aus
    }


}