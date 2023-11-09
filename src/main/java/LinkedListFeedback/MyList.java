/*
 * Sample Student
 * Homework 01 - Linked List
 * EPS Advanced Programming (Algorithms and Datastructures)
 * Due September 29th
 * 
 * Implements a linked list interface with string objects
 * to fulfill the TestMain package provided by Ms. Lewellen
 * 
 */
package LinkedListFeedback;

/*
GOAL OF CODE REVIEW:
    Fix bugs affecting the code's functionality
    Ensure the code complies with the style guide
    For reference:
    https://eastsideprep.instructure.com/courses/3441880/pages/java-style-guide


GENERAL FEEDBACK

Before every method, there should be a comment stating:
    What the method does (you did this very well)
    What parameters it takes in
    What values it returns

Remember to add comments within your methods

Ensure that the ifs, fors, and whiles all follow the same formatting

The functionality of these methods is mostly correct, great job on that!

Make sure you check special cases, such as when newNode is null,
Or if newNode already points to something, etc.
*/

public class MyList implements LinkedList{
    
    // STYLE FEEDBACK:
    // per the style guide, comments go before instead of on the same line
    // comments also require a space before them
    
    // however, good and descriptive comment. nice job!
    
    private Node head; //Stores the first in a chain of nodes
    
    // ALL THE CONSTRUCTORS ===================================================
    
    // STYLE FEEDBACK
    // per the style guide, each statement should be on its own line
    // both constructors should be spread over multiple lines, for example
    /*
    public MyList() {
        this(null);
    }
    */
    // however, great job with the comments!
    
    // Default constructor: null head
    public MyList() { this(null); }
    
    // Non-Default constructor: takes a node to make the head
    // which potentially points others in a chain
    public MyList(Node head){ this.head = head; }
    
    // ACCESSORS ===========================================================
    
    // STYLE FEEDBACK: see line 51
    // also, the code would be more readable if 
    // there was a comment describing what the method does
    
    @Override
    public Node getHead(){ return this.head; }

    // ALL THE ADDS ===========================================================
    
    // FUNCTIONALITY FEEDBACK:
    
    // line 94: if newNode is null, then calling getNext() would throw an error
    // because newNode.getNext() can't be called if newNode is null
    
    // line 95: good job handling error case
    
    // line 97: (nitpick, optional modification)
    // put pre-conditions in the front
    // so the code body is not being nested, 
    // which can be harder to read on a larger scale
    
    // Updates the head of the list and throws an error if the node 
    // points to something other than null
    @Override
    public void addHead(Node newNode){
        if(newNode.getNext() != null) {
            throw new IllegalArgumentException("Only add single nodes");
        }
        else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
    }
    
    // STYLE FEEDBACK:
    // Great use of sub-method getTail, it makes the code a lot more readable
    // Try to be consistent with the if, else statements
    // i.e the same format as the method above
    // Both styles are good, just be consistent with which style you choose
    
    // FUNCTIONALITY FEEDBACK:
    // make sure to check that newNode isn't already pointing to anything
    
    // Updates the tail of the list and throws an error if the node 
    // points to something other than null
    @Override
    public void addTail(Node newNode){
        
        // Call out to get the tail
        Node tail = getTail();
        
        if(tail != null) {
            // If tail is not null, then we'll update the tail
            tail.setNext(newNode);
        } else {
            // If tail is null then our list is null
            this.head = newNode;
        }
        newNode.setNext(null);
    }
    
    // STYLE FEEDBACK:
    // remove the spaces in the if statement, not consistent with other methods
    // please add comments stating what each line does
    // again, nice use of sub-methods
    
    // FUNCTIONALITY FEEDBACK:
    // what if newNode or oldNode was null?
    // or if newNode is already pointing to something?
    
    // Updates an arbitrary element of the list and throws an error if the node 
    // points to something other than null
    @Override
    public void addAfter(Node newNode, Node oldNode){
          if (! findNode(oldNode)){ 
            throw new IllegalArgumentException("Node not in list");  
        }
        
        newNode.setNext(oldNode.getNext());
        oldNode.setNext(newNode);
    }

    // ALL THE REMOVES ========================================================
    
    // STYLE FEEDBACK:
    // please add comments describing what each line does
    
    // FUNCTIONALITY FEEDBACK:
    // Great job remembering to set oldHead's next after it is removed.
    
    // Remove the head and fix up the list as needed. 
    // After: old head points to null (and is returned) thing that was next is
    // the new head
    @Override
    public Node removeHead() {
        Node oldHead = this.head;
        this.head = oldHead.getNext();
        oldHead.setNext(null);
        return oldHead;
    }
    
    // FUNCTIONALITY FEEDBACK:
    // Good job using removeNode to simplify removeTail!
    
    // STYLE FEEDBACK: comments might be helpful, but it is already clear
    
    // Remove the tail and fix up the list as needed. 
    // After: old tail points to null, thing that was prior now points to null
    @Override
    public Node removeTail() {
        return removeNode(getTail());
    }
    
    // STYLE FEEDBACK:
    // Good job putting the special case in the front
    // Maybe beforeMe could have a more descriptive name
    // i.e beforeNodeToDelete or some abbreviation
    // Remember to space the if/while from the parenthesis
    // Remember to maintain consistent indenting in lines 200-203
    
    // FUNCTIONALITY FEEDBACK:
    // The method looks good!
    
    // Remove an arbitrary node and fix up the list as needed
    @Override
    public Node removeNode(Node toDelete){
        if(this.head == toDelete) {
            return removeHead();
        }
        Node beforeMe = head; 
        while(beforeMe != null && beforeMe.getNext() != toDelete){ 
                if(beforeMe.getNext() == null) {
                    break;
                }
                beforeMe = beforeMe.getNext();
        }        
        if(beforeMe != null) {
            beforeMe.setNext(toDelete.getNext());
            toDelete.setNext(null);
        } else {
            throw new IllegalArgumentException("Node to remove not in list");
        }
        
        return toDelete;
    } 
    
    // UTILITY METHODS ========================================================
    
    // STYLE FEEDBACK:
    // Remember to add header comment
    
    // FUNCTIONALITY FEEDBACK:
    // on line 231, we don't actually want to print n itself, 
    // we want the payload
    
    // also, the for loop should check if n itself is null, not n.getNext()
    // because this wouldn't print the last element in the list

    @Override
    public String toString() {
        String ret  = "";
        for(Node n = head; n.getNext() != null; n = n.getNext()) {
            ret += n + "->";
        }
        ret += "null";
        return ret;
    }
    
    // STYLE FEEDBACK:
    // remember to indent the code inside of loops

    // Find a specific node in the list (check equality, not payload equality)
    public boolean findNode(Node node){
        for(Node n = head; n != null; n = n.getNext()) {
        if(node == n) {
        return true;
        }
        }
        return false;
    }
    
    
    // STYLE FEEDBACK:
    
    // (optional) calling the pointer Node tail might be a little confusing...
    // I would prefer calling it something like tailPointer
    // remove the extra space on line 266
    
    // FUNCTIONALITY FEEDBACK:
    // make sure to check if head is null first, 
    // as you won't be able to call tail.getNext()
    
    
    // Find the tail in the list and return it
    public Node getTail() {
        Node tail = this.head;
        
        while( tail.getNext() != null) {
            tail = tail.getNext();
        }
        return tail;
    }
}
