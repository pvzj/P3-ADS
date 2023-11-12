/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Final;

/**
 *
 * @author jchen
 */
public class OldestToNewestSort extends QuickSort {
    @Override
    public boolean compare(Flashcard a, Flashcard b) {
        return a.getID() < b.getID();
    }
    
}
