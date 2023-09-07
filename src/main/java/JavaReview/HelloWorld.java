/*
 *Jeremy Chen
 *ADS - Section B
 *September 5, 2023
 * 
 * Remember how java works because it's been a while (simple methods, loops, etc.)
 */
package JavaReview;

/**
 *
 * @author jchen
 */
public class HelloWorld {
    // method that ounts to 10
    //print out the numbers as I count
    //add them up as I go and return the sum
    public static int countTo10() {
        int sum = 0; //accumulator 
        
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i+1); //print
//            sum += i+1; //add i to sum
//        }
        
        int i = 0; //index
        
        while (i < 10) {
            System.out.println(i+1); //print
            sum += i+1; //add i to sum
            i++; //increment index
        }
        
        return sum; //return sum
    }
    //this is a function that multiplies two numbers togethe rand output them
    //to the console and as the return value
    //returns an int (downcasted)
    //printt full double to console
    public static int method(int i, double d) {
        //double used because it has more precision
        //we don't care about the extra memory usage
        double realAnswer = i*d;
        int fakeAnswer = (int) realAnswer; //downcast: cast to something less specific
        
        System.out.println(i + "*" + d + " = " + realAnswer);
        return fakeAnswer;
    }
    
    //public: accessible from othe files/classes
    //void: return type
    //String[] args: parameters/arguments
    //static: one copy over all classes
    //only one main: entrypoint for the program
    public static void main(String[] args) {
        System.out.println("Hello world");
        
        //test first method
        int returnValue = method(4, 3.14);
        System.out.println(returnValue);
        //test second method
        returnValue = countTo10();
        System.out.println("sum:" + returnValue);
    }
}
