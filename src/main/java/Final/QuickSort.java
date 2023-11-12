/* Jeremy Chen
 * October 30, 2023
 * Class implementing QuickSort
 */
package Final;

import java.util.List;

public abstract class QuickSort {
    // main method, initiates recursion
    // takes in data to be sorted, and n, its length
    // returns nothing, sorts data in-place
    
    // returns true if a < b, false otherwise
    public abstract boolean compare(Flashcard a, Flashcard b);
    
    public void sort(List<Flashcard> data, int n) {
        // check if data is null
        if (data == null) {
            throw new NullPointerException("data is null");
        }
        
        // use the recursive method to sort data
        sortRecursively(data, n, 0);
    }
    
    // recusive method for quick sort
    // takes in data to be sorted
    // n, which is the length of the section to be sorted
    // start, which is the starting index of the section to be sorted
    // returns nothing, sorts data in-place
    private void sortRecursively(List<Flashcard> data, int n, int start) {
        // base cases:
        // if n is zero or one, then it is already sorted, so return
        if (n == 0 || n == 1) {
            return;
        }
        // if n == 2, it can be sorted by swapping the elements 
        // (if they aren't already sorted)
        
        if (n == 2) {
            if (compare(data.get(start+1), data.get(start))){
                swap(data, data.size(), start, start+1);
            }
            return;
        }
        
        // partition elements, store pivot's index
        int pivotIndex = partition(data, n, start);
        
        // sort elements before pivot
        int numOfElementsBeforePivot = pivotIndex-start;
        sortRecursively(data, numOfElementsBeforePivot, start);
        
        // check if pivot is at the end of teh section
        // if so, then omit the second step of sorting the 2nd half
        if (pivotIndex + 1 > start + n - 1) {
            return;
        }
        
        // sort 2nd half elements
        
        // get element after pivot to become new start
        int elementAfterPivot = pivotIndex + 1;
        // get pivot's index if the current section is its own array
        int relativePivotIndex = pivotIndex-start;
        // find number of elements after pivot
        int numOfElementsAfterPivot = n - relativePivotIndex - 1;
        
        // recusrively sort the second half
        sortRecursively(
                data, numOfElementsAfterPivot, elementAfterPivot);
    }
    
    // partitions the array so 
    // all elements greater than the pivot are on the right
    // and all elements less than the pivot on the left
    // selects pivot as the first element in the array
    
    // takes in data, length (n) of relevant section, start index of section
    // returns index of the pivot
    private int partition(List<Flashcard> data, int n, int start) {
        // pointers that move tot he middle of the array
        int leftPointer = start;
        int rightPointer = start+n-1;
        // keeps track of if pivot is the left pointer or the right pointer
        boolean isPivotOnLeft = true;
        
        // iterate until left pointer meets right pointer
        while (leftPointer < rightPointer) {
            // if pivot is on the left, modify the right pointer
            // otherwise modify the left pointer
            if (isPivotOnLeft) {
                // if the data on the right is greater than pivot, 
                // move the pointer down
                if (compare(data.get(leftPointer), data.get(rightPointer))) {
                    rightPointer--;
                } else {
                    // otherwise, swap the data points
                    swap(data, data.size(), 
                            leftPointer, rightPointer);
                    // update the boolean tracker
                    isPivotOnLeft = false;
                    // move leftPointer up, because 
                    // we already know it is less than the pivot
                    leftPointer++;
                }
            } else {
                // otheerwise, do the opposite as above
                // if the data on the left is less than the pivot

                // move the pointer up
                if (compare(data.get(leftPointer), data.get(rightPointer))) {
                    leftPointer++;
                } else {
                    // otherwise, swap the data pointers
                    swap(data, data.size(), 
                            leftPointer, rightPointer);
                    // update the boolean tracker
                    isPivotOnLeft = true;
                    // move rightPointer down, because
                    // we already know it is greater than the pivot
                    rightPointer--;
                }
            }
            
        }
        // return either leftPointer or rightPointer, depending the boolean
        return isPivotOnLeft ? leftPointer : rightPointer;
    }
    
    public void swap(List<Flashcard> data, int n,
                            int idxA, int idxB) {
      // check if data is null
      if (data == null) {
          throw new NullPointerException("data cannot be null");
      }
      
      // check if indices are valid
      if (idxA >= n || idxA < 0 || idxB >= n || idxB < 0) {
          throw new IllegalArgumentException("indices not valid");
      }
      
      // store temporary value so that it doesn't get erased from swap
      Flashcard temp = data.get(idxA);
      
      // perform swap 
      data.set(idxA, data.get(idxB));
      data.set(idxB, temp);
   }
}
