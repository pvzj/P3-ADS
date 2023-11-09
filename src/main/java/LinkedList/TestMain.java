/* Katelin Lewellen
   September 2021

   Interface for a linked list provided to the A&DS class at EPS.
    To be implemented to create a linked list.

   Change the package name to match the package you import it into.
 */
package LinkedList;


public class TestMain {
    
    // Tests several different constructors for MyNode objects:
    // 1) an empty constructor that uses null for all fields
    // 2) a MyNode(String payload) constructor
    // 3) a MyNode(String payload, Node nextNode) constructor 
    // Also tests the accessors getPayload and getNext, to check constructors
    public static void testNodeConstructors() {
        int passCount = 0;
        int totalCount = 0;
        



        System.out.print("\tnode 1a/b:");
        MyNode yellowNode = new MyNode();
        if(yellowNode.getPayload() == null) {
            passCount++;
            System.out.print("PASS/");
        } else {
            System.out.print("FAIL/");
        }
        totalCount++;
        if(yellowNode.getNext() == null) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++;
        
        
        System.out.println("\tnode 2a/b: - OMITTED");


        System.out.print("\tnode 3a/b:");
        MyNode blueNode = new MyNode("blue", yellowNode);
        if(blueNode.getPayload().equals("blue")) {
            passCount++;
            System.out.print("PASS/");
        } else {
            System.out.print("FAIL/");
        }
        totalCount++;
        if(blueNode.getNext() == yellowNode) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++;

        System.out.print("\tnode 4a/b:");
        MyNode greenNode = new MyNode("green");
        if(greenNode.getPayload().equals("green")) {
            passCount++;
            System.out.print("PASS/");
        } else {
            System.out.print("FAIL/");
        }
        totalCount++;
        if(greenNode.getNext() == null) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++;
        
        System.out.print("Constructors and accesssors: ");
        System.out.println(passCount + "/"+ totalCount);
    }
    
    
    // Tests payload setting for MyNode objects:
    public static void testNodePayloads() {
        int passCount = 0;
        int totalCount = 0;

        MyNode yellowNode = new MyNode();
        MyNode redNode = new MyNode("red");
        MyNode blueNode = new MyNode("blue", redNode);
        MyNode greenNode = new MyNode("green");
        
        System.out.print("\tPayload 1:");
        yellowNode.setPayload("one");
        if(yellowNode.getPayload().equals("one")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++;        
                
        System.out.print("\tPayload 2:");
        redNode.setPayload("two");
        if(redNode.getPayload().equals("two")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++;        

        System.out.println("\tPayload 3: - OMITTED");        

        System.out.print("\tPayload 4:");
        try{
            greenNode.setPayload(null);
            System.out.println("FAIL");
        } catch (IllegalArgumentException e) { 
            passCount++;
            System.out.println("PASS");       
        }
        totalCount++;       
        
        System.out.print("Payload mutators and accesssors: ");
        System.out.println(passCount + "/"+ totalCount);
    }
    
    
    // Tests nextNode setting methods
    public static void testNodeNext() {
        int passCount = 0;
        int totalCount = 0;

        MyNode yellowNode = new MyNode();
        MyNode redNode = new MyNode("red");
        MyNode blueNode = new MyNode("blue", redNode);
        
        System.out.print("\tNodeNext 1:");
        yellowNode.setNext(redNode);
        if(yellowNode.getNext() == redNode) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++;        
        
        System.out.println("\tNodeNext 2: - OMITTED");
       

        System.out.print("\tNodeNext 3:");
        blueNode.setNext(null);
        if(blueNode.getNext() == null) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++;            
        
        System.out.print("Next mutators and accesssors: ");
        System.out.println(passCount + "/"+ totalCount);
    }
    
    // Tests several different constructors for MyList objects:
    // 1) an empty constructor that uses null for the head
    // 2) a non-empty cosntructor that uses existing node as head
    // Also tests the toString, to check constructors
    public static void testListConstructors () {
        int passCount = 0;
        int totalCount = 0;
                
        MyNode yellow = new MyNode("yellow");
        MyNode green = new MyNode("green", yellow);
        MyNode blue = new MyNode("blue", green);
        MyNode red = new MyNode("red", blue);
        
        MyNode purple = new MyNode("purple");
        
        
        System.out.print("\tMakeList 1:");
        MyList testList  = new MyList();
        if(testList.toString().equals("null")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++; 
        
        System.out.print("\tMakeList 2:");
        testList  = new MyList(purple);
        if(testList.toString().equals("purple->null")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++; 
        
        System.out.println("\tMakeList 3: - OMITTED"); 
        
        System.out.print("\tMakeList 4:");
        testList  = new MyList(red);
        if(testList.toString().equals("red->blue->green->yellow->null")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++; 
        
                
        System.out.print("List Constructors: ");
        System.out.println(passCount + "/"+ totalCount);
    }
    
    // Tests list-adding methods for linked list
    public static void testListAdds() {
        int passCount = 0;
        int totalCount = 0;
        
        MyNode yellow = new MyNode("yellow");
        MyNode green = new MyNode("green", yellow);
        MyNode blue = new MyNode("blue", green);
        MyNode red = new MyNode("red", blue);
        
        MyNode purple = new MyNode("purple");
        MyNode orange = new MyNode("orange");
        MyNode pink = new MyNode("pink");
        
        
        System.out.print("\tadd 1:");
        MyList testList  = new MyList();
        testList.addHead(orange);
        if(testList.toString().equals("orange->null")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++; 
        
        System.out.print("\tadd 2:");
        testList = new MyList();
        testList.addTail(orange);
        if(testList.toString().equals("orange->null")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++; 

        System.out.print("\tadd 3:");
        testList = new MyList(purple);
        testList.addHead(orange);
        if(testList.toString().equals("orange->purple->null")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++; 
        purple.setNext(null);
        orange.setNext(null);
        
        System.out.print("\tadd 4:");
        testList = new MyList(purple);
        testList.addTail(orange);
        if(testList.toString().equals("purple->orange->null")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++; 
        purple.setNext(null);
        orange.setNext(null);

        System.out.println("\tadd 5: - OMITTED");

        
        System.out.print("\tadd 6:");        
        testList = new MyList(red);
        testList.addHead(orange);
        if(testList.toString().equals("orange->red->blue->green->yellow->null")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++; 
        
        System.out.print("\tadd 7:");
        testList.addTail(purple);
        if(testList.toString().equals("orange->red->blue->green->yellow->purple->null")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++; 
        
        System.out.print("\tadd 8:");
        testList.addAfter(pink, blue);
        if(testList.toString().equals("orange->red->blue->pink->green->yellow->purple->null")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++;
        
        System.out.print("\tadd 9:");
        try {
            testList = new MyList();
            testList.addAfter(orange, purple);
            System.out.println("FAIL");

        } catch (IllegalArgumentException e) {
            passCount++;
            System.out.println("PASS");
        }
        totalCount++;
        
        System.out.println("\tadd 10: - OMITTED");

        System.out.print("\tadd 11:");
        try {
            testList = new MyList(purple);
            testList.addTail(red);
            System.out.println("FAIL");

        } catch (IllegalArgumentException e) {
            passCount++;
            System.out.println("PASS");
        }
        totalCount++;   
        
        System.out.print("\tadd 12:");
        try {
            testList = new MyList(purple);
            testList.addAfter(red, purple);
            System.out.println("FAIL");

        } catch (IllegalArgumentException e) {
            passCount++;
            System.out.println("PASS");
        }
        totalCount++;   
        
                
        System.out.print("List additions: ");
        System.out.println(passCount + "/"+ totalCount);
        
    }
    
    // Tests list-removing methods for linked list
    public static void testListRemoves() {
        int passCount = 0;
        int totalCount = 0;
        MyNode yellow = new MyNode("yellow");
        MyNode green = new MyNode("green", yellow);
        MyNode blue = new MyNode("blue", green);
        MyNode red = new MyNode("red", blue);
        MyNode purple = new MyNode("purple", red);
        
        MyNode orange = new MyNode("orange");
        MyNode pink = new MyNode("pink");
        
        Node ret;
        
        System.out.print("\tremove 1:");
        MyList testList = new MyList(purple);
        ret = testList.removeHead();
        if(testList.toString().equals("red->blue->green->yellow->null") 
                && ret.getPayload().equals("purple")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++; 

        System.out.print("\tremove 2:");
        ret = testList.removeTail();
        if(testList.toString().equals("red->blue->green->null")
                && ret.getPayload().equals("yellow")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++; 
        
        System.out.print("\tremove 3:");
        ret = testList.removeNode(blue);
        if(testList.toString().equals("red->green->null")
                && ret.getPayload().equals("blue")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        totalCount++; 

        System.out.print("\tremove 4:");
        ret = testList.removeNode(red);
        if(testList.toString().equals("green->null")
                && ret.getPayload().equals("red")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.print("FAIL");
        }
        totalCount++;  
        
        
        System.out.print("\tremove 5:");
        testList = new MyList(orange);
        ret = testList.removeHead();
        if(testList.toString().equals("null")
                && ret.getPayload().equals("orange")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.print("FAIL");
        }
        totalCount++;  
        
        System.out.println("\tremove 6: - OMITTED");

        
        System.out.print("\tremove 7:");
        testList = new MyList(orange);
        ret = testList.removeTail();
        if(testList.toString().equals("null")
                && ret.getPayload().equals("orange")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.print("FAIL");
        }
        totalCount++;  
        
        System.out.print("\tremove 8:");
        testList = new MyList(orange);
        ret = testList.removeNode(orange);
        if(testList.toString().equals("null")
                && ret.getPayload().equals("orange")) {
            passCount++;
            System.out.println("PASS");
        } else {
            System.out.print("FAIL");
        }
        totalCount++;  
        
        
        System.out.print("List removals: ");
        System.out.println(passCount + "/"+ totalCount);
        
    }
    
    public static void main(String[] args) {
        System.out.println("===== NODE TESTS =====");
        testNodeConstructors();
        testNodePayloads();
        testNodeNext();
        
        System.out.println();
        
                System.out.println("===== LIST TESTS =====");        
        testListConstructors();
        testListAdds();
        testListRemoves();
        
    }
    
}
