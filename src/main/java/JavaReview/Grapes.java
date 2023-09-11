/*
Jeremy Chen
September 11 2023
ADS Section B

A class that defines an apple.
 */
package JavaReview;

/**
 *
 * @author jchen
 */
public class Grapes extends Fruit {
    public Grapes(String color, double weight, int sweetness, int ripeness) {
        super(color, weight, sweetness, ripeness);
    }
    
    
    public void eat() {
        System.out.println("pluck a grape form the bunch");
    }

    
    public void pick() {
        System.out.println("grab");
    }

    
    public void slice() {
        System.out.println("slice");
    }   

    
    public void compost() {
        System.out.println("compost");
    }
    
}
