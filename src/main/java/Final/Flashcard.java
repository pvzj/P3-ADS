/*
Jeremy Chen
ADS : B Period
Lewellen
11/15/23
Class representing 1 individual flashcard
 */

package Final;

public class Flashcard {
    // each flashcard has a term and a definition
    private String term;
    private String definition;
    
    // id to keep track of when the flashcard was added to set
    // lower is earlier
    private int id;
    
    // constructor with term, definition, and id
    public Flashcard(String term, String definition, int id) {
        this.term = term;
        this.definition = definition;
        this.id = id;
    }
    
    // getters
    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }

    public int getID() {
        return id;
    }
    
    // tostring that returns the flashcard in the form term:definition
    // used for testing
    @Override
    public String toString() {
        return term + ":" + definition;
    }
}
