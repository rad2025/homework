// Delta College - CST 283 - Homework 1
// Name:  

public class ValidSerial
{
   public static void main(String[] args)
   {
      
      System.out.println( isSerialValid("AB127") );
      System.out.println( isSerialValid("Ax125") );
      System.out.println( isSerialValid("$X724") );
      System.out.println( isSerialValid("AB12") );
      System.out.println( isSerialValid("ABC1234") );
      System.out.println( isSerialValid("BA123") );
      System.out.println( isSerialValid("BA12X") );
      System.out.println( isSerialValid("BA124") );
      
   }
   
   // Method isSerialValid
   
   public static boolean isSerialValid(String serialNum) {
    //Check if the string is exactly length = 5
    if (serialNum.length() != 5) {
        return false;
    }

    //Check if the 1st and 2nd characters are uppercase and adjacent 
    char firstChar = serialNum.charAt(0);
    char secondChar = serialNum.charAt(1);

    if (!Character.isUpperCase(firstChar) || !Character.isUpperCase(secondChar)) {
        return false;
    }
    if (Math.abs(firstChar - secondChar) != 1) {
        return false;
    }

    //Check if the 3rd, 4th, 5th characters are digits
    char thirdChar = serialNum.charAt(2);
    char fourthChar = serialNum.charAt(3);
    char fifthChar = serialNum.charAt(4);

    if (!Character.isDigit(thirdChar) || !Character.isDigit(fourthChar) || !Character.isDigit(fifthChar)) {
        return false;
    }

    //calculate the sum of the numerical digits
    int digitSum = Character.getNumericValue(thirdChar) +
                   Character.getNumericValue(fourthChar) +
                   Character.getNumericValue(fifthChar);

    //Check if the sum of the digits is divisible by 3
    if (digitSum % 3 == 0) {
        return false;
    }

    //When all conditions are met, return true
    return true;
} }


