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
    
    // constructor with term and definition
    public Flashcard(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }
    
    // getters and setters
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
    
    // tostring that returns the flashcard in the form term:definition
    @Override
    public String toString() {
        return term + ":" + definition;
    }
}
