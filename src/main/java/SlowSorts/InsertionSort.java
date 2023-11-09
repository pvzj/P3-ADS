/* Jeremy Chen
 * October 18, 2023
 * Class implementing Insertion Sort
 */
package SlowSorts;

public class InsertionSort {
    // method to sort the array using insertion sort
    // takes in int[] data to be sorted and n, its length
    // returns nothing, sorts array in-place
    public static void sort(int[] data, int n) {
        // iterate through the unsorted part of the array
        // it can start at one 
        // because the first element is technically already sorted
        for (int lastSortedIndex = 1; lastSortedIndex < n; lastSortedIndex++) {
            // pointer to help insert the element to the correct place
            int insertionIndex = lastSortedIndex;
            
            // loop until the end is reached
            // or the current value is greater than the previous value
            // signifying the element is in the correct place
            while (insertionIndex > 0 && 
                    data[insertionIndex] < data[insertionIndex - 1]) {
                // swap the current index and the index before 
                // also decrement insertionIndex by 1 to go down the array
                SortingUtilityMethods.swap(data, n,
                        insertionIndex, --insertionIndex);
            }
        }
    }
}
