/*
Jeremy Chen
ADS Final
Lewellen
11/15/23
Class to test flashcard
 */
package Final;

public class Tester {
    public static void main(String[] args) {
        // create set
        FlashcardSet set = new FlashcardSet();
        
        // add elements
        set.addFlashCard("a", "A");
        // test case of existing term
        set.addFlashCard("a", "B");
        set.addFlashCard("c", "C");
        set.addFlashCard("d", "D");
        set.addFlashCard("e", "E");
        
//        System.out.println(set.set);
        
        // infinitely study the set
        while (true) {
            set.study();
        }
        
    }
}
