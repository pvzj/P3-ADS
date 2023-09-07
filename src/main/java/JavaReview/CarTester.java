/*
Jeremy Chen
 September 2023
 ADS Section B

 A class to test my car
 */
package JavaReview;

public class CarTester {
    public static void main(String[] args) {
        //declare cars
        Car car1 = new Car();
        Car car2 = new Car(7, "black", "make", "model", null);
        //print 
        System.out.println(car1);
        System.out.println(car2);
        //electric car
        ElectricCar ev = new ElectricCar(4, "silver");
        System.out.println(ev);
    }
}
