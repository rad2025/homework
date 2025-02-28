// CST 283 Homework 6
public class RecurseLoopCounting
{
    public static void main(String[] args)
    {
        System.out.println(sumEvenNumbers(1000));       // for the iterative method
        System.out.println(sumEvenNumbersRecurse(1000)); // for the recursive method
    }

    //Sums evens iteravily using loops
    public static int sumEvenNumbers(int n)
    {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) //evens start at 2, going up to and including n, and adding 2
        {
            sum += i;
        }
        return sum;
    }

    //sums all even numbers > 0, going up and including n, recursively
    public static int sumEvenNumbersRecurse(int n)
    {
        if (n == 2) //the base case
            return 2;
        return n + sumEvenNumbersRecurse(n - 2); //the recursive case
    }
}
