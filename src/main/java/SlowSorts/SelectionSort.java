/* Jeremy Chen
 * October 18, 2023
 * Class implementing Selection Sort
 */
package SlowSorts;

public class SelectionSort {
    // method to sort the array using selection sort
    // takes in int[] data to be sorted and n, its length
    // returns nothing, sorts array in-place
    public static void sort(int[] data, int n) {
        // pointer to mark sorted portion
        int lastUnsortedIndex = n-1;
        
        // put the max element at the end for each element
        // only need to do this n-1 times 
        // because if all but one element is sorted, the array is sorted
        for (int i = 0; i < n-1; i++) {
            // index with the maximum value out of the unsorted part
            int maxIndex = 0;
            
            // iterate through the unsorted part
            for (int j = 1; j <= lastUnsortedIndex; j++) {
                // if an element's value is greater than maxIndex
                // update maxIndex
                if (data[j] > data[maxIndex]) {
                    maxIndex = j;
                }
            }
            
            // swap the last element with the maximumValue
            SortingUtilityMethods.swap(data, n, 
                    maxIndex, lastUnsortedIndex);
            
            // move the pointer for the unsorted index over
            lastUnsortedIndex--;
        }
    }
}
