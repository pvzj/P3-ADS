/*
Jeremy Chen
ADS : B Period
Lewellen
11/15/23
Class overriding the compare method to sort the set by length, least to greatest
 */
package Final;

public class LengthSort extends QuickSort{
    // takes in and compares two flashcards
    // if a's term length is less than b return true
    @Override
    public boolean compare(Flashcard a, Flashcard b) {
        // get length of terms
        int aLength = a.getTerm().length();
        int bLength = b.getTerm().length();
        
        // if they're not equal, return whichever one is less
        if (aLength != bLength) {
            return aLength < bLength;
        } else {
            // if they are equal, sort them alphabetically
            AlphabeticalSort as = new AlphabeticalSort();
            return as.compare(a, b);
        }
    }
}
