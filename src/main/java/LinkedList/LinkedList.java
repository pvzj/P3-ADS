/* Katelin Lewellen
   September 2021

   Interface for a linked list provided to the A&DS class at EPS.
    To be implemented to create a linked list.

   Change the package name to match the package you import it into.
 */
package LinkedList;


public interface LinkedList {
    // Should return the head of the list, simple accessor
    // Returns null if there are no heads present
    Node getHead();
    
    // Addition methods: adds to the head, tail, or after a specified node
    // Should check that the node is not pointing to anything in next before
    // adding it. Throw an IllegalArgumentException if someone tries to add 
    // a list to another node, or if you try to add after a node that does
    // not exist in the list.
    void addHead(Node newNode);
    void addTail(Node newNode);
    void addAfter(Node newNode, Node oldNode);

    // Removal methods: removes the head (updating it), the tail, or a specified
    // node. Should throw an IllegalArgumentException is someone tries to 
    // remove a node that does not exist in the list. 
    // All methods return the node which was removed, in case you need to do
    // further processing on it. Ignore the return if no processing is needed
    Node removeHead();
    Node removeTail();
    Node removeNode(Node toDelete);
    
    // Override the toString method, to print the linked list in a nice format:
    // example: yellow->red->blue->green->null 
    // where "yellow" is the payload for the head and "green" is the payload for
    // the tail. Should always point to null at the end. 
    @Override
    String toString();
}
