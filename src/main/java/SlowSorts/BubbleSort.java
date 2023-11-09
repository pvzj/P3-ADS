/* Jeremy Chen
 * October 18, 2023
 * Class implementing Bubble Sort
 * 
 * Optimizations: 
 * Stops early if the array is already sorted
 * Only bubbles up in the non-sorted portion
 */
package SlowSorts;

public class BubbleSort {
    // method to sort the array using bubblesort
    // takes in int[] data to be sorted and int n, the length of the array
    // returns nothing, sorts array in-place
    public static void sort(int[] data, int n) {
        // check if the data is null
        SortingUtilityMethods.checkNull(data);
        
        // for each element in the array bubble up one element
        for (int i = 0; i < n; i++) {
            // check if the last bubbleup didn't swap anything
            // if it didn't, stop the sorting
            if (singleBubbleUp(data, n, i) == 0) {
                return;
            }
        }
    }
    
    // method to perform one single bubble up
    // takes in the array, its length, 
    // and the number of bubbles ups that have already been done
    // so that you don't have to check the sorted part
    // returns the number of swaps that this bubble up has performed so far
    private static int singleBubbleUp(int[] data, int n, int numOfBubbleUps) {
        // counter for number of bubble ups so far
        int numOfSwaps = 0;
        
        // for each element in the unsorted part, loop
        for (int i = 0; i < n-numOfBubbleUps-1; i++) {
            // if for two pieces of data, they are out of order, swap them
            if (data[i] > data[i+1]) {
                // swap
                SortingUtilityMethods.swap(data, n, i, i+1);
                // increment the counter
                numOfSwaps++;
            }
        }
        // return the number of swaps
        return numOfSwaps;
    }
}
