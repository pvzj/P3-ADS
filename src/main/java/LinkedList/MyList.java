/*
  Jeremy Chen
  September 2023
    
  My implementation of LinkedList
*/
package LinkedList;

public class MyList implements LinkedList {
    // attribute, head of list
    MyNode head;
    
    // constructors
    MyList() { // defaults
        this(null);
    }
    
    // sets newNode parameter as head
    MyList(Node newNode) { 
        this.head = (MyNode) newNode;   
    }
    
    // returns head
    @Override
    public Node getHead() {
        return head;
    }
    
    // sets newNode to the head, shifts everything to the right by one, 
    // with newNode's next pointing to the old head
    // parameter: newNode
    @Override
    public void addHead(Node newNode) {
        // checks if newNode is null
        if (newNode == null) { 
            throw new NullPointerException("newNode is null");
        }
        
        // checks if newNode is pointing to something
        if (newNode.getNext() != null) { 
            throw new IllegalArgumentException("node pointing to something");
        }
        
        // if the list is empty, just set it to the head
        if (head == null) { 
            head = (MyNode) newNode;
            return;
        }
        // set the newNode's next to head
        newNode.setNext(head); 
        
        // update the head attribute
        head = (MyNode) newNode;  
    }
    
    // adds newNode to the end of the list
    // parameters: newNode 
    @Override
    public void addTail(Node newNode) {
        // checks if newNode is null
        if (newNode == null) { 
            throw new NullPointerException("newNode is null");
        }
        
        // checks if newNode is already pointing to something
        if (newNode.getNext() != null) { 
            throw new IllegalArgumentException("node pointing to something");
        }
        // if the list is empty, just set it to the head
        if (head == null) {
            head = (MyNode) newNode;
            return;
        }
        
        // original code:
//         Node pointer = head; // pointer to parse through the list
//         
//         while (pointer.getNext() != null) { // iterate until the last element
//             pointer = pointer.getNext();
//         }
//         
//         pointer.setNext(newNode); // set the last element's next to newNode
        

        // cleaner code based on expansion method: 
        addAllToTail(new MyList(newNode));
    }
    
    
    // adds newNode after oldNode in the list
    // parameters: newNode, oldNode
    @Override
    public void addAfter(Node newNode, Node oldNode) {
        // checks if either of the inputted nodes are null
        if (newNode == null) {
            throw new NullPointerException("newNode is null");
        } else if (oldNode == null) {
            throw new NullPointerException("oldNode is null");
        }
        
        // checks if newNode is already pointing to something
        if (newNode.getNext() != null) { 
            throw new IllegalArgumentException("node pointing to something");
        }
        
        // if oldNode is at the end of the list, just add newNode to the end
        if (oldNode.getNext() == null) {
            oldNode.setNext(newNode);
        } else {// otherwise insert newNode in between oldNode and followingNode
            Node followingNode = oldNode.getNext();
            oldNode.setNext(newNode);
            newNode.setNext(followingNode);
        }
    }
    
    // remove the head of the list, shift everything left by 1
    // returns the head that was removed
    @Override
    public Node removeHead() {
        // check if head is null
        if (head == null) {
            throw new NullPointerException("head is null");
        }
        // get the head to return
        MyNode removedNode = head; 
        
        // set head to the next value in the list
        head = (MyNode) head.getNext(); 
        
        // return the old head
        return removedNode; 
    }
    
    // remove the tail of the list
    // returns the old tail, the node that was just removed
    @Override
    public Node removeTail() {
        // if the list is empty, return null
        if (head == null) { 
            throw new NullPointerException("head is null");
        }
        
        // set pointers
        Node currentPointer = head; 
        Node nextPointer = head.getNext();
        
        // check if list is one node long
        // if so, remove head
        if (nextPointer == null) { 
            return removeHead();
        }
        
        // iterate to end
        while (nextPointer.getNext() != null) { 
            currentPointer = currentPointer.getNext();
            nextPointer = nextPointer.getNext();
        }
        // set the end node to null
        currentPointer.setNext(null); 
        
        // return deleted node
        return nextPointer; 
    }
    
    // removes node toDelete from the list
    // parameters: node that will be deleted
    // returns the node that was deleted
    @Override
    public Node removeNode(Node toDelete) {
        // pointers
        Node currentPointer = head; 
        Node nextPointer = head.next;
        
        // if head is toDelete remove head
        if (currentPointer == toDelete) { 
            return removeHead();
        }
        
        // iterate through the list until you find toDelete
        while (nextPointer != toDelete) { 
            currentPointer = currentPointer.getNext();
            nextPointer = nextPointer.getNext();
        }
        
        // if toDelete is at the end
        // otherwise set tail's next to the next node in the list
        if (nextPointer.getNext() == null) { 
            // set tail's next to null
            currentPointer.setNext(null); 
        } else { 
            currentPointer.setNext(nextPointer.getNext());
        }
        
        return nextPointer; // return deleted node
    }
    
    // returns string with list in payload->payload->...->null format
    @Override
    public String toString() {
        // pointer to parse through the list
        Node pointer = head; 
        
        // resulting string
        String res = ""; 
        
        // until it reaches the end
        while (pointer != null) { 
            // add payload + -> to the string
            res += pointer.getPayload() + "->"; 
            
            // move the pointer forward
            pointer = pointer.getNext(); 
        }
        
        // add ending null
        res += "null"; 
        
        // return the string
        return res; 
    }
    
    
    // expansion methods
    
    // returns size of the list
    public int size() {
        // pointer to parse through the list
        Node pointer = head; 
        
        // index to keep track of how many nodes there are
        int count = 0; 
        
        // until it reaches the end
        while (pointer != null) { 
            // move the pointer forward
            pointer = pointer.getNext(); 
            
            // increase count by 1
            count++; 
        }
        
        // return count
        return count; 
    }
    
    // adds contents from other onto this list
    // parameter: other, which is a list to be added to the end
    public void addAllToTail(MyList other) {
        // check if other is null
        if (other == null) {
            throw new NullPointerException("input is null");
        }
        // if this list's head is null, set this head to other's head
        if (head == null) {
            head = (MyNode) other.getHead();
            return;
        }
        
        // pointer to parse through the list
        Node pointer = head; 
        
        // iterate until the last element
        while (pointer.getNext() != null) { 
            pointer = pointer.getNext();
        }
        // set the last element to other's head
        pointer.setNext(other.getHead()); 
    }
}
