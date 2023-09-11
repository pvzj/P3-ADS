/*
Class that defines stawberries
 */
package JavaReview;

public class Strawberry extends Fruit implements Lunchbox {
    public Strawberry(String color, double weight, int sweetness, int ripeness) {
        super(color, weight, sweetness, ripeness);
    }
    
    public void eat() {
        System.out.println("eat it");
    }
    
    public void pick() {
        System.out.println("pick it");
    }

    
    public void slice() {
        System.out.println("slice it ");
    }

    
    public void compost() {
        System.out.println("throw it away");
    }
    
    public void packInLunch() {
        System.out.println("put in tupperware");
    }

    
    public void eatFromLunch() {
        System.out.println("take it out from tupperware");
    }

    
    public void abandonFromLunch() {
        System.out.println("take it out");
    }
    
    public void removeLeavesOnTop() {
        System.out.println("pull them off");
    }
}
