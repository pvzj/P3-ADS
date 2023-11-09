/*
  Jeremy Chen
  September 2023
    
  My implementation of Node to be used for MyList.java
*/
package LinkedListFeedback;

//import LinkedList.*;

public class MyNode implements Node{
    // attributes
    String payload;
    MyNode next;
    
    // constructors
    MyNode(String payload, MyNode next){
        this.payload = payload;
        this.next = next;
    }
    // constructor with one parameters 
    MyNode(String payload) {
        this(payload, null);
    }
    // no parameters
    MyNode() {
        this(null, null);
    }
    
    // sets this node's next to the inputted node
    @Override
    public void setNext(Node next) {        
        this.next = (MyNode) next;
    }
    
    // returns this node's next node
    @Override
    public Node getNext() {
        return this.next;
    }
    
    // sets the payload of this node, checks if the input is a string
    @Override
    public void setPayload(Object data) {
        // check if data is a string
        if (!(data instanceof String)) { 
            throw new IllegalArgumentException("Not a string type");
        }
        
        // sets payload
        payload = (String) data; 
    }
    
    // return the payload of this node
    @Override
    public Object getPayload() {
        return payload;
    }
}
