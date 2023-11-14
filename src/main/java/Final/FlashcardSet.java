/*
Jeremy Chen
ADS : B Period
Lewellen
11/15/23
Set of flashcard class
 */

package Final;

// import data structures
import java.util.ArrayList;
import java.util.List;

// class that holds a set of flashcards
public class FlashcardSet {
    // list that contains all the flashcards
    private List<Flashcard> set = new ArrayList<>();
    
    // int that keeps track of the number of flashcards added
    // use this to generate ids for cards
    private static int totalFlashcardsAdded = 0;
    
    // adds a flashcard to the set
    // doesn't execute if the term is already in the set
    // takes in the term and definition, returns if the card was added or not
    public boolean addFlashCard(String term, String definition) {
        // checks if term is in the set
        if (isTermInSet(term)) {
            System.out.println("term already in set");
            return false;
        }
        
        // make and add the flashcard
        Flashcard card = 
                new Flashcard(term, definition, totalFlashcardsAdded);
        set.add(card);
        
        // update trackers
        totalFlashcardsAdded++;
        
        // return true to signify a successful add
        return true;
    }
    
    // method that checks if the inputted term is already used in the set
    // returns true or false if it is in the set
    private boolean isTermInSet(String term) {
        // loop through each element in the set
        for (Flashcard f : set) {
            // if it is found, return true
            if (f.getTerm().equals(term)) {
                return true;
            }
        }
        
        // otherwise, return false
        return false;
    }
    
    // getters
    public Flashcard getFlashcard(int index) {
        return set.get(index);
    }
    
    public void removeFlashcard(int index) {
        set.remove(index);
    }
    
    public int size() {
        return set.size();
    }
    
    public List<Flashcard> getSet() {
        return set;
    }
}
