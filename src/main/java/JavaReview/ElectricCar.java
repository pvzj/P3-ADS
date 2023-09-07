/*
Jeremy Chen
 September 2023
 ADS Section B

 electric car, a subclass of car with a slightly different tostring
 */
package JavaReview;

/**
 *
 * @author jchen
 */
public class ElectricCar extends Car{
    //constructor
    public ElectricCar(int wheelCount, String color) {
        super(wheelCount, color);
    }
    
    //overrided tostring
    @Override
    public String toString() {
        String toBePrinted = super.toString();
        toBePrinted += " (Electric)";
        return toBePrinted;
    }
}
