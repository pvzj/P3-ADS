/*
Jeremy Chen
September 11 2023
ADS Section B

A class that tests the fruit class.
 */
package JavaReview;

public class FruitTester {
    public static void main(String[] args) {
        Fruit snack = new Apple("red", 150, 3, 0);
        Fruit[] fruitBasket = new Fruit[10];

        fruitBasket[0] = snack;
        fruitBasket[1] = new Apple("green", 300, -4, 3);
        fruitBasket[2] = new Grapes("red", 500, 8, 2);
        
        fruitBasket[3] = new Strawberry("red", 25, 7, 0);
        
        for (int i = 0; i < 4; i++) {
            if (fruitBasket[i] == null) {
                continue;
            }
            
            fruitBasket[i].slice();
            fruitBasket[i].eat();
            
            if (fruitBasket[i] instanceof Apple) {
                System.out.println("apple");
                ((Apple) fruitBasket[i]).pluckStem();
            }
        }
    }
}
