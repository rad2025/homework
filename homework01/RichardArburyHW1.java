// Delta College - CST 283 - Homework 1
// Name: Richard Arbury

import java.io.*;
import java.util.Scanner;

public class BillSummary
{
    static final String FILENAME = "energy.txt";

    public static void main(String[] args)
    {

        // Start file processing
        try
        {
            String filename = FILENAME;
            File dataFileRef = new File(filename);

            // Check for file existence.  If not found, display error and crash
            if (!dataFileRef.exists())
            {
                System.out.println("File not found");
                System.exit(0);
            }

            Scanner inputFile = new Scanner(dataFileRef);

            // File processing loop.
            System.out.printf("%-10s %-10s %-10s%n", "Month", "kWh", "Charge");
            System.out.println("--------------------------------"); // for header

            double totalcharge = 0.0;

            while (inputFile.hasNext()) {
                // read the proper columns
                String line = inputFile.nextLine().trim();
                // now we need to split by the ','
                String[] parts = line.split(",");

                //from the parts we need to extarct the data we want
                int monthcode=Integer.parseInt(parts[0]);
                int kWh=Integer.parseInt(parts[2]);

                double charge=calcElecBill(monthcode,kWh);

                //and display data
                System.out.printf("%-10d %-10d $%-10.2f%n", monthcode, kWh, charge);
                totalcharge += charge; //for aggreagated charges
            }

            //we still need to close the file
            inputFile.close();

            //finally display total charge

            System.out.println("--------------------------------");
            System.out.printf("Total Charge: $%.2f%n", totalcharge);












        }
        catch (IOException e)    // If file error, display message and crash
        {
            System.out.println("File error");
            System.exit(0);
        }

    }

    public static double calcElecBill(int monthcode, int kWh) {
        //Constants for billing charges as specified
        final double BASE_CHARGE = 8.34;
        final double WINTER_RATE_LOW = 0.223;
        final double WINTER_RATE_HIGH = 0.315;
        final int WINTER_THRESHOLD = 800;
        final double NON_WINTER_RATE_LOW = 0.184;
        final double NON_WINTER_RATE_HIGH = 0.293;
        final int NON_WINTER_THRESHOLD = 700;

        double usageCharge = 0.0;

        // using boolean logic to determine the month
        boolean isWinter = (monthcode == 12 || monthcode == 1 || monthcode == 2);

        if (isWinter) {
            // for winter billing calculation
            if (kWh <= WINTER_THRESHOLD) {
                usageCharge = kWh * WINTER_RATE_LOW;
            } else {
                usageCharge = (WINTER_THRESHOLD * WINTER_RATE_LOW) +
                        ((kWh - WINTER_THRESHOLD) * WINTER_RATE_HIGH);
            }
        } else {
            // Non-winter billing calculation
            if (kWh <= NON_WINTER_THRESHOLD) {
                usageCharge = kWh * NON_WINTER_RATE_LOW;
            } else {
                usageCharge = (NON_WINTER_THRESHOLD * NON_WINTER_RATE_LOW) +
                        ((kWh - NON_WINTER_THRESHOLD) * NON_WINTER_RATE_HIGH);
            }
        }

        // Add the base charge
        double totalcharge = usageCharge + BASE_CHARGE;

        // Round to two decimal places and return
        return Math.round(totalcharge * 100.0) / 100.0;
    }
}

