package Assignment1;

import java.util.Scanner;
import java.util.Arrays;

public class TempAboveAverage {

    Scanner scanner = new Scanner(System.in);
    double array[] = null;

    public TempAboveAverage(int sizeOfArray) {
        array = new double[sizeOfArray];
        System.out.println("Enter " + sizeOfArray + " temperatures: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextDouble();
        }
    }

    public double calculateAverage() {
        double average = Arrays.stream(array).sum() / array.length;
        return average;
    }

    public int countAboveAverage() {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > calculateAverage()) {
                counter++;
            }
        }
        return counter;
    }

    public String aboveAverageString() {
        if (countAboveAverage() == 1) {
            return "There is 1 temperature above average";
        }
        else {
            return "There are " + countAboveAverage() + " temperatures above average";
        }
    }




    public static void main(String[] args) {

        System.out.println();
        System.out.println("Average Temperature Calculator");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        TempAboveAverage tempArray = new TempAboveAverage(5);

        System.out.println();
        System.out.println("The average temperature is " + tempArray.calculateAverage());
        System.out.println();
        System.out.println(tempArray.aboveAverageString());

    }
}
