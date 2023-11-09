/* Katelin Lewellen
   September 2021

   Interface for a linked list provided to the A&DS class at EPS.
    To be implemented to create a linked list.

   Change the package name to match the package you import it into.
 */
package LinkedList;


public interface Node {
    // Method for changing what the node points to "next". 
    // Substitutes it for the passed in Node.
    // Does nothing with the dropped node
    void setNext(Node next);
    
    // Simple accessor: returns the next node
    Node getNext();
    
    // Method for retrieving the payload of the node. 
    // Allows the payload to be an arbitrary object - check instanceof and cast
    // to get it in the type you are looking for. 
    void setPayload(Object data);
    
    // Method for accessing the payload of the node. 
    // All payloads should automatically be cast to match Object. 
    Object getPayload();
}