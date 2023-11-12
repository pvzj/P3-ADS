/*
Jeremy Chen
ADS Final
Lewellen
11/15/23
Set of flashcard class
 */
package Final;

// import data structures
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// class that holds a set of flashcards
public class FlashcardSet {
    // set that contains all the flashcards
    public List<Flashcard> set = new ArrayList<>();
    
    // adds a flashcard to the set
    // doesn't execute if the term is already in the set
    public boolean addFlashCard(String term, String definition) {
        // checks if term is in the set
        if (isTermInSet(term)) {
            System.out.println("term already in set");
            return false;
        }
        
        // make and add the flashcard
        Flashcard card = new Flashcard(term, definition);
        set.add(card);
        return true;
    }
    
    // method that checks if the term is already used in the set
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
    
    public Flashcard getFlashcard(int index) {
        return set.get(index);
    }
    
    public int size() {
        return set.size();
    }
    
    public void removeFlashcard(int index) {
        set.remove(index);
    }
    
    // quiz the user once
    public void study() {
        // pick a random element
        Random r = new Random();
        Flashcard currentCard = 
                set.get(r.nextInt(set.size()));
        
        // print the current term
        System.out.println(currentCard.getTerm());
        
        // scanner to read user input
        // likely temporary
        Scanner inputReader = new Scanner(System.in);
        // check if response is correct
        // if so, say correct
        // if not, say wrong and print the actual answer
        if (inputReader.nextLine().equals(currentCard.getDefinition())) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect: Actual is " + 
                    currentCard.getDefinition());
        }
    }
}
