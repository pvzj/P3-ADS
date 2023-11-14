/*
Jeremy Chen
ADS : B Period
Lewellen
11/15/23
Class overriding the compare method to sort the set alphabetically
 */

package Final;

public class AlphabeticalSort extends QuickSort {
    // takes in and compares two flashcards
    // if a comes before b alphabetically return true
    // otherwise return 
    @Override
    public boolean compare(Flashcard a, Flashcard b) {
        // get terms of two compared flashcards
        String termA = a.getTerm();
        String termB = b.getTerm();
        
        // set strings to lower case 
        // to ensure capital letters don't get priority
        // for example, without it, B would go before a
        String lowerCaseA = termA.toLowerCase();
        String lowerCaseB = termB.toLowerCase();
        
        // use string.compareTo to see which comes first
        // string.compareTo < 0 means that a comes before b
        // don't have to worry about two cards with the same terms
        // because that is already checked for
        return lowerCaseA.compareTo(lowerCaseB) < 0;
    }
}
