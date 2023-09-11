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
public class Apple extends Fruit implements Lunchbox{
    public Apple(String color, double weight, int sweetness, int ripeness) {
        super(color, weight, sweetness, ripeness);
    }

    public void eat() {
        System.out.println("eat");
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
    
    public void pluckStem() {
        System.out.println("pluck stem");
    }

    
    public void packInLunch() {
        
    }
    
    public void eatFromLunch() {
        
    }
    
    public void abandonFromLunch() {
        
    }
}
