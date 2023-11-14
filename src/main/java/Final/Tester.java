/*
Jeremy Chen
ADS : B Period
Lewellen
11/15/23
Class that runs the GUI
 */
package Final;

import javax.swing.SwingUtilities;

public class Tester {
    public static void main(String[] args) {
        // create an instance of the GUI
        GUI gui = new GUI();
        // initialize the GUI
        SwingUtilities.invokeLater(() -> gui.init());
    }
}
