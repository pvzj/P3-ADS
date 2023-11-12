/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Final;

/**
 *
 * @author jchen
 */
public class AlphabeticalSort extends QuickSort {
    @Override
    public boolean compare(Flashcard a, Flashcard b) {
        String termA = a.getTerm();
        String termB = b.getTerm();
        
        return termA.compareTo(termB) < 0;
    }
    
}
