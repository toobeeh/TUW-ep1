/*
    Aufgabe 2) Zweidimensionale Arrays - Sortieren und Filtern
*/
public class Aufgabe2 {

    private static double[][] genMeanFilter(int rows, int cols) {
        // check conditions
        if(rows % 2 == 0 || cols % 2 == 0 || rows < 1 || cols < 1) return null;
        // init filter array
        double[][] filter = new double[rows][cols];
        double mean = 1d/(rows * cols);

        // fill filter array
        for(int row = 0; row < filter.length; row++){
            for(int col = 0; col < filter[row].length; col++){
                filter[row][col] = mean;
            }
        }
        return filter;
    }

    private static double[][] applyFilter(double[][] workArray, double[][] filterArray) {
        // init filtered and reusable values
        double[][] filtered = new double[workArray.length][workArray[0].length];
        int filterRowMiddle = filterArray.length / 2;
        int filterColMiddle = filterArray[0].length / 2;

        // loop through result/work positions
        for(int row = 0; row < filtered.length; row++){
            for(int col = 0; col < filtered[0].length; col++){
                double sum = 0;
                // loop through filter for position
                for(int filterRow = 0; filterRow < filterArray.length; filterRow++){
                    // if filter row is in bounds
                    if(row - filterRowMiddle + filterRow >= 0 && row - filterRowMiddle + filterRow < filtered.length){
                        for(int filterCol = 0; filterCol < filterArray[0].length; filterCol++){
                            // if filter col is in bounds
                            if(col - filterColMiddle + filterCol >= 0 && col - filterColMiddle  + filterCol < filtered[0].length) {
                                sum += workArray[row - filterRowMiddle + filterRow][col - filterColMiddle + filterCol]
                                        * filterArray[filterRow][filterCol];
                            }
                        }
                    }
                }
                filtered[row][col] = sum;
            }
        }
        return filtered;
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
        print(myFilter3);
        myResultArray = applyFilter(myArray3, myFilter3);
        print(myResultArray);

        double[][] myArray4 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        double[][] myFilter4 = {{1, 0, 0}};
        myResultArray = applyFilter(myArray4, myFilter4);
        print(myResultArray);
    }


}