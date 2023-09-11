/*
Jeremy Chen
September 11 2023
ADS Section B

A class that defines the abstract idea of a fruit
 */
package JavaReview;

public abstract class Fruit {
    public String color;
    public double weight; //grams
    public int sweetness; //-10 to 10, sour
    public int ripeness; //0 is perfectly ripe, 10 is moldy

    public Fruit(String color, double weight, int sweetness, int ripeness) {
        this.color = color;
        this.weight = weight;
        this.sweetness = sweetness;
        this.ripeness = ripeness;
    }
    
    public abstract void eat();
    
    public abstract void pick();
    
    public abstract void slice();
    
    public abstract void compost();
}
