/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Final;

/**
 *
 * @author jchen
 */
public class LengthSort extends QuickSort{
    @Override
    public boolean compare(Flashcard a, Flashcard b) {
        int aLength = a.getTerm().length();
        int bLength = b.getTerm().length();
        
        if (aLength != bLength) {
            return aLength < bLength;
        } else {
            AlphabeticalSort as = new AlphabeticalSort();
            return as.compare(a, b);
        }
    }
    
}
