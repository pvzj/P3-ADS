/*
Jeremy Chen
ADS Final
Lewellen
11/15/23
Class to test flashcard
 */
package Final;

import javax.swing.SwingUtilities;

public class Tester {
    public static void main(String[] args) {
        // infinitely study the set
        GUI gui = new GUI();
        SwingUtilities.invokeLater(() -> gui.init()); //create GUI
//        while (true) {
//            set.study();
//        }
    }
}
