// Delta College - CST 183 - Klingler & Gaddis Text                          
// This program demonstrates search and sort-related algorithms recursively.

public class SortSearchRecurse 
{
    public static void main(String args[]) 
    {
        // Test arrays
        int test1[] = {5, 12, 27, 33, 39, 50, 61, 75, 88, 96};  // Sorted ASC
        int test2[] = {5, 12, 27, 33, 50, 39, 61, 75, 88, 96};  // ASC - not sorted
        int test3[] = {92, 85, 77, 64, 52, 49, 33, 20, 14, 2};  // Sorted DESC
        int test4[] = {92, 85, 77, 64, 52, 33, 49, 20, 14, 2};  // DESC - not sorted

        // Search ascending array for a value
        System.out.println(binarySearch(test1, 0, test1.length - 1, 39));

        // Verify array in ascending order
        System.out.println(isSorted(0, test1));
        
        // Verify array in ascending order
        System.out.println(isSorted(0, test2));

        // Search descending array for a value
        System.out.println(binarySearchDesc(test3, 0, test3.length - 1, 14));

        // Verify array in descending order
        System.out.println(isSortedDesc(0, test3));

        // Verify array in descending order
        System.out.println(isSortedDesc(0, test4));
    }  

    //***************************************************************
    // Binary search recursively - PRE: Array is sorted ASCENDING
    // Parameters:  array, firstIndex, lastIndex, searchTarget
    
    public static int binarySearch(int array[], int first, int last, int value) 
    {
        int middle;     

        if (first > last)
            return -1;
        
        middle = (first + last) / 2;
        
        if (array[middle] == value)
            return middle;

        if (array[middle] < value)
            return binarySearch(array, middle + 1, last, value);
        else
            return binarySearch(array, first, middle - 1, value);
    }
    
    //***************************************************************
    // Method validates that an array is correctly sorted ASCENDING
    // Parameters: firstIndex, array
    // Precondition:  Array is full of valid data
    
    public static boolean isSorted (int index, int array[])
    {
        if (index < array.length - 1) {
            if (array[index] > array[index + 1])
                return false;
            else
                return isSorted(index + 1, array);
        } else
            return true;
    }

    //***************************************************************

    public static int binarySearchDesc(int array[], int first, int last, int value)
    {
        int middle;


        //base case
        if (first > last)
            return -1;
        
        //need the middle index 
        middle = (first + last) / 2;
        
        //case for if the middle matches
        if (array[middle] == value)
            return middle;
   
        if (array[middle] > value)  //while descending, search right for smaller values
            return binarySearchDesc(array, middle + 1, last, value);
        else //otherwise, search the left half
            return binarySearchDesc(array, first, middle - 1, value);
    }

    //***************************************************************
    public static boolean isSortedDesc (int index, int array[])
    {
        if (index < array.length - 1) {
            if (array[index] < array[index + 1])  //descending order checker
                return false;
            else
                return isSortedDesc(index + 1, array);
        } else
            return true;
    }
}
