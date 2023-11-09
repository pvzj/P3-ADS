/* Jeremy Chen
 * October 18, 2023
 * Class implementing Bogosort
 */
package SlowSorts;

public class BogoSort {
    // number of shuffles to perform before stopping
    public static final int SORT_THRESHOLD = 100;
    
    // method to use Bogosort to sort array
    // takes in int[] data to be sorted and int n, its length
    // returns nothing, sorts array in-place
    public static void sort(int[] data, int n) {
        // check if the array is null
        SortingUtilityMethods.checkNull(data);
        
        // shuffle SORTH_THRESHOLD times
        for (int i = 0; i < SORT_THRESHOLD; i++) {
            // call util method shuffle
            SortingUtilityMethods.shuffle(data, n);
            
            // check if the data is sorted
            if (isSorted(data)) {
                // if so, return and leave the method
                return;
            }
        }
        // if the array hasn't been sorted in time, tell the user
        System.out.println("Array not sorted within sort threshold");
    }
    
    // method that checks if the array in its current state is sorted
    // takes in the data array to be checked
    // returns boolean saying if the array is sorted
    private static boolean isSorted(int[] data) {
        // previous value of array
        // always make sure the current value is greater than the previous
        int prev = Integer.MIN_VALUE;
        
        // loop through each element in the array
        for (int dataValue : data) {
            // if the current value is less, then the array is not sorted
            if (dataValue < prev) {
                return false;
            }
            
            // set previous to the current to prepare for the next value
            prev = dataValue;
        }
        
        // if the loop has executed without stopping,
        // this means the array is sorted
        return true;
    }
}
