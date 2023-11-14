/*
Jeremy Chen
ADS : B Period
Lewellen
11/15/23
Class overriding the compare method to sort the set by when an element is added
to the set. Sorted newest to oldest.
 */
package Final;

public class OldestToNewestSort extends QuickSort {
    // takes in and compares two flashcards
    // if a is older than b return true
    // age is decided by id, higher id means newer
    @Override
    public boolean compare(Flashcard a, Flashcard b) {
        // return if the id is smaller
        return a.getID() < b.getID();
    }  
}
