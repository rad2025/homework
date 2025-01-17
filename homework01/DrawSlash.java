// Delta College - CST 283 - Homework 1
// Name:  

public class DrawSlash
{
   public static void main(String[] args)
   {
      drawSlash(3,"L");
      System.out.println("------------");
      drawSlash(4,"R");
      System.out.println("------------");
      drawSlash(8,"L");
      System.out.println("------------");
      drawSlash(5,"R");
      System.out.println("------------");
      drawSlash(1,"R");
      System.out.println("------------");
      drawSlash(12,"L");
      System.out.println("------------");
      drawSlash(3,"X");
      System.out.println("------------");
   }
   
   // Method drawSlash
   public static void drawSlash(int size, String direction) {
        //Validate input parameters
        if (size < 2 || size > 10 || (!direction.equals("L") && !direction.equals("R"))) {
            System.out.println("?");
            return;
        }

        //Draw left slash, starting from the bottom left and moves upward right
        if (direction.equals("L")) {
            for (int i = 0; i < size; i++) {
                //Print spaces before the star
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }

        //Draw right slash, starts from the top-left and moves downward right
        else if (direction.equals("R")) {
            for (int i = 0; i < size; i++) {
                //Print spaces before the star
                for (int j = 0; j < size - i - 1; j++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }
    }
   




   
   
   
   
}

