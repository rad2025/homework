// Delta College - CST 283 - Homework 1
// Name:  

import java.io.*;
import java.util.Scanner;

public class EnergySort
{
    static final String FILENAME = "energy.txt";
    static final int NUMBER_MONTHS = 36;

    public static void main(String[] args) 
    {
        int month[]   =  new int[NUMBER_MONTHS];
        int year[]    =  new int[NUMBER_MONTHS];
        int energy[]  =  new int[NUMBER_MONTHS];

        try   // Capture file
        {
            String filename = FILENAME;
            File dataFileRef = new File(filename);
            String oneLine = "";

            // Check for file existence.  If not found, display error and crash
            if (!dataFileRef.exists()) 
            {
                System.out.println("File not found");
                System.exit(0);
            }

            int i = 0;

            Scanner inputFile = new Scanner(dataFileRef);
            while (inputFile.hasNext()) {
                // File processing loop.
                oneLine = inputFile.nextLine();

                String dataLine[] = oneLine.split(",");

                month[i]  = Integer.parseInt(dataLine[0]);
                year[i]   = Integer.parseInt(dataLine[1]);
                energy[i] = Integer.parseInt(dataLine[2]);

                i++;
            }
        } 
        catch (IOException e)    // If file error, display message and crash
        {
            System.out.println("File error");
            System.exit(0);
        }

        displayArrays(month,year,energy);           // Display initial lists

        sortChronologically(month,year,energy);     // Sort by time
        displayArrays(month,year,energy);           // Display

        sortByDescendingEnergy(month,year,energy);  // Sort energy usage - descending
        displayArrays(month,year,energy);           // Display

    }

    // Method displays parallel arrays in current order
    public static void displayArrays(int month[], int year[], int energy[])
    {
        System.out.println("\n");
        for (int i = 0; i < NUMBER_MONTHS; i++ )
        {
            System.out.println(String.format("%2d-%4d ==> %5d", month[i],year[i],energy[i]));
        }
        System.out.println("\n");
    }

    // Sort arrays ascending chronologically
    public static void sortChronologically(int month[], int year[], int energy[])
    { //here we use i to ensure multiple passes while j compares adjacent elements
        for (int i = 0; i < NUMBER_MONTHS - 1; i++) {
            for (int j = 0; j < NUMBER_MONTHS - 1 - i; j++) {
                if (year[j] > year[j + 1] || (year[j] == year[j + 1] && month[j] > month[j + 1])) {
                    swap(month, j, j + 1); //if current year is greater, swap, same for months on current years
                    swap(year, j, j + 1); //oh and we use the swap fucntion to actually swap (defined below)
                    swap(energy, j, j + 1);
                }
            }
        }

    }

    // Sort arrays descending by energy usage
    public static void sortByDescendingEnergy(int month[], int year[], int energy[])
    {
        for (int i = 0; i < NUMBER_MONTHS - 1; i++) {
            for (int j = 0; j < NUMBER_MONTHS - 1 - i; j++) { //same logic as before but just for energy
                if (energy[j] < energy[j + 1]) {
                    swap(month, j, j + 1); //again using the swap helper
                    swap(year, j, j + 1);
                    swap(energy, j, j + 1);
                }
            }
        }
    }
    //swap helper function, similar to what was used in an earlier part of the homework
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; //makes a temp for the current node
        arr[i] = arr[j]; //swaps nodes
        arr[j] = temp; //sets latter mode to the temp
    }
}
 

