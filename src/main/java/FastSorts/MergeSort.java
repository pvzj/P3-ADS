/* Jeremy Chen
 * October 30, 2023
 * Class implementing MergeSort
 */
package FastSorts;

public class MergeSort {
    // main method, initiates recursion
    // takes in data to be sorted, and n, its length
    // returns nothing, sorts data in-place
    public static void sort(int[] data, int n) {
       // checks if data is null or has no elements
        if (data == null) {
            throw new NullPointerException("data is null");
        }
        
        if (n == 0) {
            return;
        }
         // calls recusrive sort with the starting index of 0
        sortRecursively(data, n, 0);
    }
    
    // recusive method for merge sort
    // takes in data to be sorted
    // n, which is the length of the section to be sorted
    // start, which is the starting index of the section to be sorted
    // returns nothing, sorts data in-place
    private static void sortRecursively(int[] data, int n, int start) {
        // base case: if the section to be sorted is one element, 
        // it's already sorted
        if (n == 1) {
            return;
        }
        
        // array that containing the front half of the array
        int[] frontSection = split(data, n, start);
        int frontSectionLength = frontSection.length;
        // sort the front array using front array and its length
        sortRecursively(frontSection, frontSectionLength, 0);
        
        // sort the back array using data
        // back section length is either equal or one more than the front length
        // starts at the index after the front
        int backSectionLength = frontSectionLength + n % 2;
        sortRecursively(data, backSectionLength, start + frontSectionLength); 
        
        // merge frontSection into data
        merge(data, n, start, frontSection, frontSectionLength);
    }
    
    // method that puts the front half the current section into a new array
    // takes in data to take from, n as the length of the section
    // start is start index of this section
    // returns the front section of the array
    private static int[] split(int[] data, int n, int start) {
        // create array to be filled
        int frontLength = n / 2;
        int[] frontSection = new int[frontLength];
        
        // loop through elements, fill frontSection array
        for (int i = 0; i < frontLength; i++) {
            frontSection[i] = data[i + start];
        }
        
        // return this array
        return frontSection;
    }
    
    // merges elements from frontLength into data, keeping the elements sorted
    // takes in data, length (n) and start index of relevant section
    // also takes in front array and its length
    // returns nothing, merges data in-place
    private static void merge(
            int[] data, int n, int start, int[] frontSection, int frontLength) {
        // initialize indices
        
        // tracks iteration in frontSection
        int frontIndex = 0;
        // tracks iteration taking elements from data
        int backIndex = start+frontLength;
        // tracks iteration filling elements into data
        int toBeFilled = start;
        
        // loop until frontIndex or backIndex go through every element
        while (frontIndex < frontLength && backIndex < start + n) {
            // get elements where the pointers are
            int frontElement = frontSection[frontIndex];
            int backElement = data[backIndex];
            
            // fill in the element of whichever is less
            // update the respective index
            if (frontElement < backElement) {
                data[toBeFilled] = frontElement;
                frontIndex++;
            } else {
                data[toBeFilled] = backElement;
                backIndex++;
            } 
            // update the filling pointer
            toBeFilled++;
        }
        // if there are still elements to be filled in from frontIndex
        // loop through the rest of them, fill them into data
        
        // this step is not necessary for back index 
        // because the elements are already in place
        if (frontIndex != frontLength) {
            for (; frontIndex < frontLength; frontIndex++) {
                data[toBeFilled] = frontSection[frontIndex];
                toBeFilled++;
            }
        }
    }
}
