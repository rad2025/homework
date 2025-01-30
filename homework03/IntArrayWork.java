//Delta College - CST 183 - Homework 3
// Name: Richard Arbury

import java.util.Scanner;
import java.io.*;

public class IntArrayWork {
    public static void main(String args[]) {
        final String inputfilename = "C:/Users/Richie/Downloads/intdata.txt";
        final int ARRAY_SIZE = 50;
        int[] data = new int[ARRAY_SIZE]; 
        int numElems = 0; 
        // part one for try-catch
        try {
            File inputfile = new File(inputfilename);
            if (!inputfile.exists()) {
                System.out.println("ERROR - File not found.");
                return;
            }

            Scanner inputFileScanner = new Scanner(inputfile);
            int i = 0;
            while (inputFileScanner.hasNext() && i < ARRAY_SIZE) {
                data[i] = inputFileScanner.nextInt();
                i++;
            }
            numElems = i;
            inputFileScanner.close();
           //check if empty and then throw error if so
            if (numElems == 0) {
                System.out.println("ERROR - Empty file");
                return;
            }

            //print the initial array
            printArray(data, numElems);

            //for summing every other element, just go up by 2
            int sum = 0;
            for (int j = 0; j < numElems; j += 2) {
                sum += data[j];
            }
            System.out.println("Sum of every other element: " + sum);

            // Print odd numbers in reverse order
            printOddNumbersReverse(data, numElems);

            // Swap first and last elements and print
            swapFirstLast(data, numElems);
            printArray(data, numElems);

            // Set all elements to the max of the first two elements
            setArrayToMaxFirstTwo(data, numElems);
            printArray(data, numElems);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    //function to iterate through and print
    private static void printArray(int[] data, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    //for revesere, we start at the size -1, then print down until we hit zero
    //very similar to what we did in class
    private static void printOddNumbersReverse(int[] data, int size) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i] % 2 != 0) { //check if odd
                System.out.print(data[i] + " ");
            }
        }
        System.out.println();
    }
    //simple swap
    private static void swapFirstLast(int[] data, int size) {
        if (size > 1) {
            int temp = data[0]; //use a temp node
            data[0] = data[size - 1]; //replace first element with last
            data[size - 1] = temp; // replace last with first
        }
    }

    private static void setArrayToMaxFirstTwo(int[] data, int size) {
        if (size > 1) {
            int max = Math.max(data[0], data[1]); //greatest between first two
            for (int i = 0; i < size; i++) {
                data[i] = max; //chnange all to the greatest
            }
        }
    }
}
