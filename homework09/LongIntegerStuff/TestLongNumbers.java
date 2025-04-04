// Delta College - CST 283 - Klingler                  
// This application demonstrates addition of two long integer
// objects for very long numbers.

public class TestLongNumbers
{     
    public static void main(String [] args)
    {
        LongInteger number1 = new LongInteger("3648305843", true);
        LongInteger number2 = new LongInteger("92837465", true);

        LongInteger sum = number1.addTo(number2);

        System.out.print("Number 1: ");
        number1.writeToConsole();

        System.out.print("Number 2: ");
        number2.writeToConsole();

        System.out.print("Sum: ");
        sum.writeToConsole();
    }
}
