/*
Jeremy Chen
ADS Final
Lewellen
11/15/23
Class for individual flashcard
 */
package Final;

public class Flashcard {
    // each flashcard has a term and a definition
    private String term;
    private String definition;
    private int id;
    
    // constructor with term and definition
    public Flashcard(String term, String definition, int id) {
        this.term = term;
        this.definition = definition;
        this.id = id;
    }
    
    // getters and setters
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
    @Override
    public String toString() {
        return term + ":" + definition;
    }
}
