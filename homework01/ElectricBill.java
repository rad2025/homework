// Delta College - CST 283 - Homework 1
// Name:
// This program is a test driver for a method that calculates a customer charge
// for electricity usage.

public class ElectricBill
{
   public static void main(String[] args)
   {
      
      System.out.println( calcElecBill(12,750) );
      System.out.println( calcElecBill(3,750) );
      System.out.println( calcElecBill(2,932) );
      System.out.println( calcElecBill(1,777) );
      System.out.println( calcElecBill(8,456) );
   }
   
   // Method calcElecBill
   // This method ...
   
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

