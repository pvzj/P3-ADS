/* Katelin Lewellen
 * October 7, 2021
 * Methods to aid in implementing sorting algorithms
 * particularly: bogosort, bubblesort, selectionsort, and insertionsort
 * 
 * TODO: some methods are left unfilled. You need to implement:
 *  - swap
 *  - fillSorted 
 *  - fillRevSorted
 * yourself, but please leave the call to log in the swap method. 
 * log is implemented in my version of this file, to aid in the pretty
 * garphical test visualization.
 */

package FastSorts;

import FastSorts.*;
import java.util.*;
import java.io.*;

public class SortingUtilityMethodsQuickSort {

   // Fills in an array as "sorted" by storing integers 0..n
   // in the respective spots. We will use this, and pre-shuffle to
   // set up test cases for for sorting arrays.  
   public static void fillSorted(int[] data, int n){
      // checks if data is null
      checkNull(data);
      
      // loops through each element in the array and assigns it to its index
      for (int i = 0; i < n; i++) {
          data[i] = i;
      }
   }

   // Fills in an array as "reverse sorted" by storing integers 0..n
   // in the exact opposit spots. We will use this as a worst case test
   public static void fillRevSorted(int[] data, int n){
      // checks if data is null
      checkNull(data);
      
      // loops through each element in the array
      // assigns it to the a decreasing index to get the last available number
      for (int i = 0; i < n; i++) {
          data[i] = n - i;
      }
   }
   
   // checks if data is null
   // takes in data array
   // throws exception if the data is null
   public static void checkNull(int[] data) {
       if (data == null) {
           throw new NullPointerException("data cannot be null");
       }
   }
   
   // Shuffles an array of integers by performing n random swaps
   public static void shuffle(int[] data, int n) {
      Random r = new Random();
      int a, b;
      for(int i=0; i < n; i++) {
         a = r.nextInt(n);
         b = r.nextInt(n);
         swap(data, n, a, b); 
      }
   }
   
   // Swaps the data at index a (idxA) and index b (idxB) in an array
   public static void swap(int[] data, int n,
                            int idxA, int idxB) {
      // check if data is null
      checkNull(data);
      
      // check if indices are valid
      if (idxA >= n || idxA < 0 || idxB >= n || idxB < 0) {
          throw new IllegalArgumentException("indices not valid");
      }
      
      // store temporary value so that it doesn't get erased from swap
      int temp = data[idxA];
      
      // perform swap 
      data[idxA] = data[idxB];
      data[idxB] = temp;

      // Leave this call to log here!
      log(1, idxA, idxB);
   }
   
   // Logs compares and swaps to be visualized later. 
   // Ms. Lewellen will implement, do not provide your own copy
   public static void log(int i, int idxA, int idxB) {}   
   
   public static void main(String[] args) {
        int n = 10;
        int[] data = new int[n];

//        fillSorted(data,n);
//        System.out.println(Arrays.toString(data));
//
//        shuffle(data,n);
//        System.out.println(Arrays.toString(data));

        // test cases, stores unsorted lists
        List<int[]> testCases = new ArrayList<>();
        // expected results for each of the test cases
        // the same indexes in both lists represent the same array
        List<int[]> expectedResults = new ArrayList<>();
        
        int numOfCases = 3;
        
        // add test cases
        testCases.add(new int[] {-1, 1000,1003,1044,5000});
        expectedResults.add(new int[] {-1, 1000,1003,1044,5000});
        
        testCases.add(new int[] 
        {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12});
        
        expectedResults.add(new int[] 
        {-12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1});
        
        testCases.add(new int[] {1, 5, 3, 2, 6, -1, 3, 3, 3, 4});
        expectedResults.add(new int[] {-1, 1, 2, 3, 3, 3, 3, 4, 5, 6});
        
        //loop through each of the number of cases
        for (int i = 0; i < numOfCases; i++) {
            // sort the array using each of the algorithms
            performSort(testCases.get(i), expectedResults.get(i));
        }
   }
   
   // tries sorting the array using each of the algorithms
   public static void performSort(int[] original, int[] expected) {
       // store n
       int n = original.length;
       
       // for each of the sorting algorithms
       // create a copy of the original so that it doesn't get erased
       // perform the sort
       // print whether it matches the expected result
       QuickSort.sort(original, n);
       System.out.println("QUICKSORT PASSED?: " + 
               Arrays.equals(original, expected));
   }

}