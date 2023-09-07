/*
 Jeremy Chen
 September 2023
 ADS Section B

 A class to define what a car is and demonsrate basic uses
 */
package JavaReview;

public class Car {
    //fields, class variables, object variables, etc.
    int wheelCount;
    String color;
    //want to be visible but immutable
    private String make;
    private String model;
//    
//    int maxSpeed;
//    boolean isElectric;
    
    private String[] serviceHistory;
    
    private static int numCars = 0;
    
    //methods
    
    //getters
    
    //setters

    public int getWheelCount() {
        return wheelCount;
    }
    
    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }
    
    //etc. 

    public static int getNumCars() {
        return numCars;
    }
    
    //constructors
    public Car() {
        this.wheelCount = 4;
        this.color = "white";
        this.make = "";
        this.model = "";
        
        this.serviceHistory = new String[100];
        
        numCars++;
    }
    
    public Car(int wheelCount, String color) {
        this.wheelCount = wheelCount;
        this.color = color;
        this.make = "";
        this.model = "";
        
        this.serviceHistory = new String[100];
        
        numCars++;
    }
    
    public Car(int wheelCount, String color, String make, String model, String[] serviceHistory) {
        this.wheelCount = wheelCount;
        this.color = color;
        this.make = make;
        this.model = model;
        this.serviceHistory = serviceHistory;
        numCars++;
    }
    
    //other methods
    public void drive() {
        
    }
    
    public void honk() {
        
    }
    
    public void stop() {
        
    }
    
    public String toString() {
        String returnValue = "This is a car with ";
        returnValue += wheelCount + " wheels";
        returnValue += " and is the color " + color;
        return returnValue;
    }
}
